package com.struct.todo.app.filter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.struct.todo.app.exception.AppException;
import com.struct.todo.app.exception.ErrorCode;

public class SessionFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		if(! (Objects.isNull(request.getSession()))) {
			arg2.doFilter(arg0, arg1);
		} else {
			throw new AppException(ErrorCode.ACCESS_DENIED);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
