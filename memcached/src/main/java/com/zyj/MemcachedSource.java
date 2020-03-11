package com.zyj;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author:77
 * @date: 2020/3/11 0011
 * @time: 11:37
 */

@Component
@Slf4j
@Data
public class MemcachedSource {

    @Value("${memcached.ip:127.0.0.1}")
    private String ip;

    @Value("${memcached.port:11211}")
    private int port;

    public String getMessage() {
        return ip + " ： " + port;
    }


}
