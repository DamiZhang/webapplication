/**
 * -----------------------------------
 *  Copyright (c) 2021-2022
 *  All rights reserved, Designed By www.linfeng.tech
 *  林风社交论坛商业版本请务必保留此注释头信息
 *  商业版授权联系技术客服	 QQ:  3582996245
 *  严禁分享、盗用、转卖源码或非法牟利！
 *  版权所有 ，侵权必究！
 * -----------------------------------
 */
package com.sk.userman.interceptor;


import com.sk.userman.exception.BusinessException;
import com.sk.userman.utils.BaseContext;
import com.sk.userman.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限(Token)验证
 *
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtUtils jwtUtils;

    private static String whiterList = "/login ,/register";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String requestURI = request.getRequestURI();

              if (whiterList.contains(requestURI.substring(requestURI.lastIndexOf("/")))){
            return true;
        }

        //获取用户凭证
        String token = request.getHeader(jwtUtils.getHeader());

        //凭证为空
        if(!StringUtils.hasText(token)){
            throw new BusinessException(jwtUtils.getHeader() + "不能为空", HttpStatus.UNAUTHORIZED.value());
        }

        Claims claims = jwtUtils.getClaimByToken(token);
        if(claims == null || jwtUtils.isTokenExpired(claims.getExpiration())){
            throw new BusinessException(jwtUtils.getHeader() + "失效，请重新登录", HttpStatus.UNAUTHORIZED.value());
        }

        BaseContext.set(claims.getSubject());
        return true;
    }
}
