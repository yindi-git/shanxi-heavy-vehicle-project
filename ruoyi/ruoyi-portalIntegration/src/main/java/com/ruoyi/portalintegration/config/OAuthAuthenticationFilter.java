//package com.ruoyi.portalintegration.config;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.para.osc.framework.common.Application;
//import com.para.osc.framework.security.view.UserAuthInfo;
//
//public class OAuthAuthenticationFilter implements Filter {
//    private boolean checkFilteredUrl(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        String url = request.getRequestURI();
//        if (
//                url.indexOf("callback") > -1 ||
//                        url.indexOf("oauth_error") > -1 ||
//                        url.indexOf("/js") > -1 ||
//                        url.indexOf("/css") > -1 ||
//                        url.indexOf("/images") > -1 ||
//                        url.indexOf("/favicon") > -1) {
//            return true;
//        }
//        return false;
//    }
//
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        if (checkFilteredUrl(httpRequest, httpResponse)) {
//            chain.doFilter(httpRequest, httpResponse);
//            return;
//        }
//        UserAuthInfo userInfo = Application.getUserAuthInfo();
//        if (userInfo != null) {
//            chain.doFilter(httpRequest, httpResponse);
//            return;
//        }
//        httpRequest.getRequestDispatcher("/oauth_authentication").forward(httpRequest, httpResponse);
//        return;
//
//    }
//
//    public void destroy() {
//        // TODO Auto-generated method stub
//
//    }
//
//    public void init(FilterConfig arg0) throws ServletException {
//        // TODO Auto-generated method stub
//
//    }
//}
