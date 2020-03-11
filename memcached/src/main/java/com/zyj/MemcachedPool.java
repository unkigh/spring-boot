package com.zyj;

import com.sun.corba.se.spi.orbutil.threadpool.NoSuchThreadPoolException;
import lombok.extern.slf4j.Slf4j;
import net.spy.memcached.MemcachedClient;
import org.mockito.exceptions.misusing.NullInsteadOfMockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author:77
 * @date: 2020/3/11 0011
 * @time: 11:28
 */
@Slf4j
@Component
public class MemcachedPool {

    private MemcachedSource source;

    private MemcachedClient client;

    public  MemcachedPool(MemcachedSource source) {
        this.source = source;
        log.info(source.getMessage());
        InetSocketAddress inetSocketAddress = new InetSocketAddress(source.getIp(), source.getPort());
//                new InetSocketAddress(source.getIp(), source.getPort());
        try {
            client = new MemcachedClient(inetSocketAddress);
        } catch (Exception e) {
            log.error("Memcached 缓存池 ===》 初始化失败");
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

//    public MemcachedPool(String host, int port) {
//        InetSocketAddress inetSocketAddress = new InetSocketAddress(host, port);
//        try {
//            client = new MemcachedClient(inetSocketAddress);
//        } catch (Exception e) {
//            log.error("Memcached 缓存池 ===》 初始化失败");
//            throw new IllegalStateException(e.getMessage(), e);
//        }
//    }

    public MemcachedClient getClient() {
        return client;
    }

    public void close(){
        client.shutdown();
    }
}
