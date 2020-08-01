package com.dt.server.helper;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.telnet.TelnetClient;

import java.io.*;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/27
 * @Modified:
 * @Description:
 * @Date:
 */
@Slf4j
public class TelnetHelper {

    public static TelnetClient initClient(String ip,int port,int timeout) {
        try{
            TelnetClient client = new TelnetClient("VT220");
            client.setDefaultTimeout(timeout <= 0 ? 6000 : timeout);
            client.connect(ip, port);
            return client;
        }catch (IOException ex){
            log.error("telnet连接失败.[ip="+ip+",port="+port+"]",ex);
        }
        return null;
    }

    public static String execute(TelnetClient client,String command, String endKey) throws IOException {
        log.info("telnet命令:[command={},endKey={}]",command,endKey);
        //输出流
        InputStream in = client.getInputStream();
        //输入流
        PrintStream out = new PrintStream(client.getOutputStream());
        out.println(command);
        out.flush();

        StringBuilder sb = new StringBuilder();
        BufferedInputStream bi = new BufferedInputStream(in);
        while (true) {
            byte[] buffer = new byte[1024];
            int len = bi.read(buffer);
            if (len <= -1) {
                break;
            }
            String msg = new String(buffer, 0, len, "utf-8");
            sb.append(msg);
            if (msg.endsWith(endKey)) {
                break;
            }
        }
        out.println("exit");
        out.flush();
        client.disconnect();
        log.info("cmd输出流:[{}]",sb.toString());
        return sb.toString();
    }

}
