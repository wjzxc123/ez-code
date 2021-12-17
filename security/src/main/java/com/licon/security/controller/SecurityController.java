package com.licon.security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

    @RequestMapping("/main")
    //@Secured("ROLE_ADMINS")//判断是否具有该角色
    //@PreAuthorize("hasRole('ROLE_ADMIN')")//判断是否有该权限，可以以ROLE_开头
    public String toMain(){
        return "redirect:main.html";
    }

    @RequestMapping("/toError")
    public String toError(){
        return "redirect:error.html";
    }
}
