package com.guoyicap.oauth2.ui.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by wuyu on 2016/9/10.
 */
@Controller
public class UiController {

    @RequestMapping("/login")
    public String dashboard() {
        return "redirect:/#/";
    }


    @RequestMapping(value = "/me")
    @ResponseBody
    public Principal me(Principal principal) {
        return principal;
    }
}
