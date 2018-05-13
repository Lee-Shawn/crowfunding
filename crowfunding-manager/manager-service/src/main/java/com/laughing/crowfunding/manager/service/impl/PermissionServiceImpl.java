package com.laughing.crowfunding.manager.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laughing.crowfunding.manager.bean.TPermission;
import com.laughing.crowfunding.manager.dao.TPermissionMapper;
import com.laughing.crowfunding.manager.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private TPermissionMapper permissionMapper;

    @Override
    public List<TPermission> getAllMenus() {
        // 父菜单
        List<TPermission> menus = new ArrayList<TPermission>();
        Map<Integer, TPermission> map = new HashMap<Integer, TPermission>();
        // 所有菜单
        List<TPermission> list = permissionMapper.selectByExample(null);

        // 1、将所有菜单都放在map中
        // 都是引用，如果从map中拿到这个数据改变以后，map中页面变化
        for (TPermission permission : list) {
            map.put(permission.getId(), permission);
        }
        // 二级菜单
        for (TPermission permission : list) {
            if (permission.getPid() == 0) {
                // 确定父菜单
                menus.add(permission);
            } else {
                // 子菜单添加到父菜单

                // 拿到父菜单
                Integer pid = permission.getPid();
                // 拿到父菜单；以pid的值作为map中的菜单id，就是父菜单
                TPermission p_menu = map.get(pid);
                // 拿到当前父菜单的子菜单；子菜单会有一些额外的问题
                // 这个list第一次获取是没有的，如果添加上一次以后。这个list是有的
                List<TPermission> childs = p_menu.getChilds();
                if (childs != null) {
                    // 当前有子菜单
                    childs.add(permission);
                } else {
                    // 当前没有子菜单
                    childs = new ArrayList<TPermission>();
                    // 新建子菜单
                    childs.add(permission);
                    // 将当前整理好的子菜单设置进去
                    p_menu.setChilds(childs);
                }
            }
        }
        return menus;
    }
}
