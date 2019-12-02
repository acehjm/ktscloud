package com.github.acehjm.solbycloud.boot.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.github.acehjm.solbycloud.boot.api
 *
 * @author majhdk
 * @date 2019/12/3
 */
@RestController
@RequestMapping("/test")
public class TestApi {

    @GetMapping
    public String test() {
        return "success";
    }

}
