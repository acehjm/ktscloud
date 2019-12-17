package com.github.acehjm.solbycloud.auth.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.github.acehjm.solbycloud.auth.api
 *
 * @author majhdk
 * @date 2019/12/14
 */
@RestController
@RequestMapping("/test")
public class AuthApi {

    @GetMapping("/success")
    public String token(){
        return "success";
    }

}
