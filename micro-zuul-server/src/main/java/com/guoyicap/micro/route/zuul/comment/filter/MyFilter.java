/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2017.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen JiMi Network Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2017年8月31日    Li.Shangzhi         Create the class
 * http://www.jimilab.com/
 */
package com.guoyicap.micro.route.zuul.comment.filter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
/**
 * @FileName MyFilter.java
 * @Description: zuul不仅只是路由，并且还能过滤，还可以做一些安全验证
 *
 * @Date 2017年8月31日 下午22:28:30
 * @author Li.Shangzhi
 * @version 1.0
 */
@Component
public class MyFilter extends ZuulFilter{

	private static Logger log = LoggerFactory.getLogger(MyFilter.class);
	
	/**
	 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下： 
			pre：路由之前
			routing：路由之时
			post： 路由之后
			error：发送错误调用
			filterOrder：过滤的顺序
			shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
			run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问
	*/
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		Object accessToken = request.getParameter("token");
		if(accessToken == null) {
			log.warn("token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try {
				ctx.getResponse().getWriter().write("token is empty");
			}catch (Exception e){}

			return null;
		}
		log.info("ok");
		return null;
	}
}
