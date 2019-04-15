package com.swkang.springboot.springbootintegration.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sse")
public class SSEController {

    @RequestMapping(value = "get_data", produces = "text/event-stream;charset=UTF-8")
    public String push(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:swkang 行情" + Math.random() + "\n\n";
    }
}
