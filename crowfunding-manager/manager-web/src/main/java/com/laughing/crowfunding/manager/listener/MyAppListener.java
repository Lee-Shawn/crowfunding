package com.laughing.crowfunding.manager.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * 
 * @ClassName MyAppListener
 * @Description 项目启动时，将一些常用的数据放在application域中，大家都能用
 * @author laughing
 * @Date 2018年5月5日 上午12:17:03
 * @version 1.0.0
 */
public class MyAppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        // 将项目路径放在application域中
        servletContext.setAttribute("ctp", servletContext.getContextPath());
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 项目关闭，销毁application域中所有数据
    }

}
