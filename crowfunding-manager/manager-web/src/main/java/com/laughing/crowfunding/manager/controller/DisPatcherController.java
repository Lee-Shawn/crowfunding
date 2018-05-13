package com.laughing.crowfunding.manager.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laughing.crowfunding.manager.bean.TPermission;
import com.laughing.crowfunding.manager.constant.Constant;
import com.laughing.crowfunding.manager.service.PermissionService;

@Controller
public class DisPatcherController {

    @Autowired
    PermissionService permissionService;

    @RequestMapping(value = "/main.html")
    public String toMainPage(HttpSession session) {
        Object object = session.getAttribute(Constant.LOGIN_USER);
        // 校验是否登录
        if (object == null) {
            return "redirect:/login.jsp";
        } else {
            // 用户登陆才来到主页，session中没有菜单，或者菜单被我们从session中清除了
            if (session.getAttribute(Constant.USER_MENU) == null) {
                // 1、先查出所有菜单，在页面进行显示
                List<TPermission> menus = permissionService.getAllMenus();
                // 2、将查到的菜单放在请求域中/session域中；
                // 菜单这些数据没必要每次来到主页，都调用service方法进行查询；放在session用户，
                // 当前用户的这次会话一直使用，只需要去数据库查一次
                session.setAttribute(Constant.USER_MENU, menus);
            }
            return "manager/main";
        }
    }

}
