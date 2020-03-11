package com.zyj.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

/**
 * @author:77
 * @date: 2020/3/11 0011
 * @time: 16:39
 */

public interface InputService {
    public void insert() throws ExecutionException, InterruptedException;
}
