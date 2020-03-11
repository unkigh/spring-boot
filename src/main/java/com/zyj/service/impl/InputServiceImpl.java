package com.zyj.service.impl;

import com.sun.corba.se.impl.orbutil.closure.Future;
import com.zyj.MemcachedPool;
import com.zyj.service.InputService;
import lombok.extern.slf4j.Slf4j;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

/**
 * @author:77
 * @date: 2020/3/11 0011
 * @time: 16:40
 */
//@Slf4j
@Service
public class InputServiceImpl implements InputService {
    @Autowired
    private MemcachedPool pool;

    private Log log = LogFactory.getLog(this.getClass());

    @Override
    public void insert() throws ExecutionException, InterruptedException {
        MemcachedClient client = pool.getClient();
        OperationFuture<Boolean> future = client.set("key1", 900, "value1");
        log.info("set state：" + future.get());
        Object key = client.get("key1");
        log.info("get：" + key.toString());
        future = client.add("key2", 900, "value2");
        log.info("add state：" + future.get());
        log.info("get2：" + client.get("key2"));
        client.shutdown();
    }
}
