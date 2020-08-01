package com.dt.server.helper;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.telnet.TelnetClient;

import java.io.IOException;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/27
 * @Modified:
 * @Description:
 * @Date:
 */
@Slf4j
public class TelnetManager {
    private ThreadLocal<TelnetClient> telnetClient = new ThreadLocal<TelnetClient>();

    public TelnetClient init(String ip,int port,int timeout) {
        try{
            TelnetClient client = new TelnetClient("VT220");
            client.setDefaultTimeout(timeout <= 0 ? 6000 : timeout); // socket延迟时间：5000ms
            client.connect(ip, port);
            setClient(client);
            return client;
        }catch (IOException ex){
            log.error("telnet连接失败.[ip="+ip+",port="+port+"]",ex);
        }
        return null;
    }





    public TelnetClient getClient() {
        return telnetClient.get();
    }

    public void setClient(TelnetClient telnetClient) {
        this.telnetClient.set(telnetClient);
    }
}
