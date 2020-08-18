package com.wangcanfeng01.freedomcurd.controller;

import com.wangcanfeng01.freedomcurd.service.CurdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能说明：
 * Created in 2020/8/15-13:46
 *
 * @author wangcanfeng
 * @since 2.0.0
 */
@RestController
public class TestController {
    @Autowired
    private CurdService curdService;
    @GetMapping("test")
    public void test(){
        curdService.getList();
    }
}
