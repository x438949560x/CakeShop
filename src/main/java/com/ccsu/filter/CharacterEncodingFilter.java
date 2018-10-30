package com.ccsu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    private String encoding;
    private Boolean forceEncoding = false;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        if(hasLength(encoding) && request.getCharacterEncoding()==null || forceEncoding) {
            req.setCharacterEncoding(encoding);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("encoding");
        forceEncoding = Boolean.valueOf(config.getInitParameter("force"));
    }

    private boolean hasLength(String str) {
        return str!=null && !"".equals(str.trim());
    }

}
