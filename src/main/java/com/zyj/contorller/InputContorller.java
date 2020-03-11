package com.zyj.contorller;

import com.zyj.service.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutionException;

/**
 * @author:77
 * @date: 2020/3/11 0011
 * @time: 16:53
 */
@Controller
@ResponseBody
public class InputContorller {
    @Autowired
    private InputService service;

    @RequestMapping("/set")
    public Object set() {
        try {
            service.insert();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
