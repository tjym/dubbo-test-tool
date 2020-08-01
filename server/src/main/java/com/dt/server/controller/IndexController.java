package com.dt.server.controller;

import com.dt.server.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dt/home")
public class IndexController {

    @Autowired
    private MenuServiceImpl menuService;

    @RequestMapping("/index")
    public String index(Model model) {
        return index("f0101", model);
    }

    @RequestMapping("/main")
    public String index(String mid, Model model) {
        Integer menuId = Integer.valueOf(mid.substring(1));
        String path = menuService.getUrl(menuId);
        String menuHtml = menuService.getHtml();

        model.addAttribute("mid", mid);
        model.addAttribute("menuHtml", menuHtml);

        return path;

    }


    @RequestMapping("/zk")
    public String openNormalPage() {

        return "/pages/v1/zk";
    }

    @RequestMapping("/caseCnt")
    public String openCasePage() {

        return "/pages/v1/caseCnt";
    }

    @RequestMapping("/service")
    public String openEasyPage() {

        return "/pages/v1/service";
    }

    @RequestMapping("/addJar")
    public String openAddJarPage() {

        return "/pages/v1/addJar";
    }

    @RequestMapping("/listJar")
    public String openListJarPage() {

        return "/pages/v1/listJar";
    }
    @RequestMapping("/editPom")
    public String openEditPomPage() {

        return "/pages/v1/editPom";
    }

    @RequestMapping("/listZk")
    public String openListZkPage() {

        return "/pages/v1/listZk";
    }

    @RequestMapping("/sys")
    public String openSysPage() {

        return "/pages/v1/sys";
    }

}
