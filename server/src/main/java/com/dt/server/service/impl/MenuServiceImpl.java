package com.dt.server.service.impl;

import com.dt.bdf.util.JsonFileUtil;
import com.dt.dto.MenuNodeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class MenuServiceImpl {

    /**
     * 用户静态资源文件路径.
     */
    private static final String STATIC_MENU_PATH = "templates/pages/v1/";

    @Value("classpath:menu.json")
    private Resource resource;

    /**
     * cache urls.
     */
    private Map<Integer, String> cacheMap = new HashMap<Integer, String>();
    /**
     * the html text.
     */
    private String html;

    public String getHtml() {
        return html;
    }

    public String getUrl(Integer mid) {

        return cacheMap.get(mid);
    }

    private void cacheMenu(List<MenuNodeDTO> tree) {

        if (CollectionUtils.isEmpty(tree)) {
            return;
        }
        for (MenuNodeDTO dto : tree) {
            cacheMap.put(dto.getMenuId(),dto.getMenuUrl());
        }
    }

    /**
     * 真正生成文件方法.
     */
    @PostConstruct
    private void createFile() throws IOException {

        List<MenuNodeDTO> tree = JsonFileUtil.readList(resource.getInputStream(), MenuNodeDTO.class);
        MenuNodeDTO root = null;

        cacheMenu(tree);

        try {
            root = buildTree(tree, -1);
        } catch (Exception e) {
            log.error("fail to build the menu tree：", e);
            return;
        }
        String html = toHtml("", root);
        String projectRealPath = getProjectRealPath();
        try {
            createFile(projectRealPath, html);
        } catch (Exception e) {
            log.error("fail to create the menu file：", e);
        }
    }



    private String getProjectRealPath() throws FileNotFoundException {

        // useless when you run doe in the jar way, so comment these code.
//        String path = ResourceUtils.getURL("classpath:").getPath();
        String path = "/app/doe/";
        path = path + STATIC_MENU_PATH;
        return path;
    }

    private void createFile(String projectRealPath, String html) throws Exception {

        // 创建目录
        File path = new File(projectRealPath);
        if (!path.exists()) {
            path.mkdirs();
        }

        // 删除旧文件
        File file = new File(path, "menu.html");
        if (file.exists()) {
            file.delete();
        }

        // 写入权限菜单
        PrintWriter out = new PrintWriter(file);
        String content = ""
//                + "<div th:fragment=\"lefter\" xmlns:th=\"http://www.thymeleaf.org\">"
                + "\n<div class=\"sidebar\" id=\"sidebar\" >                                                                                        \n"
                + "\n    <script type=\"text/javascript\">                                                                                         \n"
                + "\n        try{ace.settings.check('sidebar' , 'fixed')}catch(e){}                                                                \n"
                + "\n    </script>                                                                                                                 \n"
                + "\n    <div id=\"NoraMenuTree\">                                                                                                 \n"
                + html
                + "\n    </div>                                                                                                                    \n"
                + "\n                                                                                                                              \n"
                + "\n    <div class=\"sidebar-collapse\" id=\"sidebar-collapse\">                                                                  \n"
                + "\n        <i class=\"icon-double-angle-left\" data-icon1=\"icon-double-angle-left\" data-icon2=\"icon-double-angle-right\"></i> \n"
                + "\n    </div>                                                                                                                    \n"
                + "\n                                                                                                                              \n"
                + "\n    <script type=\"text/javascript\">                                                                                         \n"
                + "\n        try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}                                                            \n"
                + "\n    </script>                                                                                                                 \n"
//                + "\n</div>"
                + "</div>";

        this.html = content;
        out.append(content);
        out.flush();
        out.close();

    }

    private MenuNodeDTO buildTree(List<MenuNodeDTO> menuList, int pMenuId) {
        MenuNodeDTO result = new MenuNodeDTO();
        MenuNodeDTO temp = new MenuNodeDTO();
        for (int i = 0; i < menuList.size(); i++) {
            if (menuList.get(i).getParentMenuId() == pMenuId) {
                result.getChildren().add(menuList.get(i));
                temp = buildTree(menuList, menuList.get(i).getMenuId());
                if (temp.getChildren().size() > 0) {
                    menuList.get(i).setChildren(temp.getChildren());
                }
            }
        }
        return result;
    }

    private String toHtml(String elementId, MenuNodeDTO root) {

        StringBuilder sb = new StringBuilder();
        boolean useCache = true; // 判断是否使用缓存

        for (MenuNodeDTO item : root.getChildren()) {

            if (null != item && item.getChildren().size() > 0) {
                if (item.getParentMenuId() == -1) {
                    String html = "\n<ul id=\"{0}\" class=\"nav nav-list\">\n";
                    html = MessageFormat.format(html, item.getMenuId().toString());
                    sb.append(html);
                    sb.append(toHtml(null, item));
                    sb.append("</ul>");
                } else {

                    String html = "\n"
                            + "<li id=\"f{0}\" class=\"nr-pmenu\">                 \n"
                            + "    <a href=\"#\" class=\"dropdown-toggle\">    \n"
                            + "    <i class=\"{1}\"></i>                       \n"
                            + "    <span class=\"menu-text\"> {2} </span>      \n"
                            + "    <b class=\"arrow icon-angle-down\"></b>     \n"
                            + "    </a>                                        \n"
                            + "    <ul id=\"{0}\" class=\"submenu\">           \n"
                            + "\n";
                    html = MessageFormat.format(html, item.getMenuId().toString(), item.getMenuStyle(), item.getMenuName());

                    sb.append(html);
                    sb.append(toHtml(null, item));
                    sb.append("</ul></li>");
                }
            } else {
                String html = "\n"
                        + "<li id=\"f{0}\">        \n"
                        + "<a href=\"{4}?mid=f{0}\" data-url=\"{1}\">        \n"
                        + "<i class=\"{2}\"></i>   \n"
                        + "{3}                     \n"
                        + "</a>                    \n"
                        + "</li>                   \n"
                        + "\n";
                if (useCache) {
                    html = MessageFormat.format(html, item.getMenuId().toString(), item.getMenuUrl(), item.getMenuStyle(), item.getMenuName(), "main");
                } else {
                    html = MessageFormat.format(html, item.getMenuId().toString(), item.getMenuUrl(), item.getMenuStyle(), item.getMenuName(), item.getMenuUrl());
                }
                sb.append(html);
            }
        }

        return sb.toString();
    }
}
