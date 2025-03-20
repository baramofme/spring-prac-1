package kr.co.fastcampus.web;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class SimpleFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        log.info("필터 - 안녕 세상아");
        // 필터를 진입시킴

        var request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        Object userNameObj = session.getAttribute("userName");
        String userName = (String) userNameObj;

        if(userName == null || userName.equals("")) {
            log.info("새 사용자");
            session.setAttribute("userName", "jihoonYi");
        } else {
            log.info("user -> : " + userName);
        }

        filterChain.doFilter(servletRequest, servletResponse);
        PrintWriter writer = servletResponse.getWriter();
        writer.println("필터 - 안녕 세상아");
    }
}
