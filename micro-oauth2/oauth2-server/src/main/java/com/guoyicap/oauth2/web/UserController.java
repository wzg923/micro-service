package com.guoyicap.oauth2.web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.guoyicap.oauth2.service.User;

/**
 * Created by wuyu on 2016/8/29.
 */
@SessionAttributes("authorizationRequest")
@Controller
public class UserController {

    @Autowired
    ClientDetailsService clientDetailsService;

    @Autowired
    DefaultTokenServices tokenServices;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/user")
    @ResponseBody
    public User user(@AuthenticationPrincipal User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return user;
    }

    @RequestMapping(value = "/me")
    @ResponseBody
    public Object me(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        String access_token = null;
        if (authorization != null) {
            access_token = authorization.replace("Bearer", "").replace("bearer","").trim();
        }
        OAuth2Authentication oAuth2Authentication = tokenServices.loadAuthentication(access_token);
        return oAuth2Authentication.getPrincipal();
    }

    @RequestMapping(value = "/oauth/confirm_access")
    public ModelAndView confirmAccess(Map<String, Object> model) {
        return new ModelAndView("forward:/", model);
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(Map<String, Object> model) {
        return new ModelAndView("forward:/", model);
    }

    @GetMapping(value = "/user/company")
    @ResponseBody
    public JSONObject getCompany(Map<String, Object> model, HttpSession httpSession) {
        JSONObject json = new JSONObject();
        DefaultSavedRequest defaultSavedRequest = (DefaultSavedRequest) httpSession.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) model.get("authorizationRequest");
        if (defaultSavedRequest != null && defaultSavedRequest.getParameterValues("client_id") != null
                && defaultSavedRequest.getParameterValues("client_id").length > 0) {
            String[] client_ids = defaultSavedRequest.getParameterValues("client_id");
            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(client_ids[0]);
            Object company = clientDetails.getAdditionalInformation().get("company");
            Object loginType = clientDetails.getAdditionalInformation().get("loginType");
            String redirectUrl = defaultSavedRequest.getRedirectUrl();
            json.put("redirectUrl", redirectUrl);
            json.put("company", company);
            json.put("loginType", loginType);
        } else if (authorizationRequest != null && authorizationRequest.getClientId() != null) {
            String clientId = authorizationRequest.getClientId();
            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);
            Object company = clientDetails.getAdditionalInformation().get("company");
            Object loginType = clientDetails.getAdditionalInformation().get("loginType");
            String redirectUrl = authorizationRequest.getRedirectUri();
            json.put("redirectUrl", redirectUrl);
            json.put("company", company);
            json.put("loginType", loginType);
        } else {
            json.put("company", "视觉中国");
        }
        return json;

    }


}
