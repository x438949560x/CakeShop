package com.ccsu.listener;

import com.ccsu.domain.Type;
import com.ccsu.service.TypeService;
import com.ccsu.service.impl.TypeServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class ApplicationListener implements ServletContextListener {
    private TypeService typeService = new TypeServiceImpl();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<Type> list = typeService.selectAll();
        sce.getServletContext().setAttribute("typeList", list);
        System.out.println(list);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
