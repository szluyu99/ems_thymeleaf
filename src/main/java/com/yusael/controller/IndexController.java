package com.yusael.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 直接访问templates下的静态页面是无法获取static中的样式的
// 用该控制器进行去访问, 该控制器没有其他作用, 只是为了访问界面而已
@Controller
public class IndexController {

    @GetMapping("index")
    public String toIndex() {
        return "ems/login";
    }

    @GetMapping("toRegister")
    public String toRgsiter() {
        return "ems/regist";
    }

    @GetMapping("toSave")
    public String toSaave() {
        return "ems/addEmp";
    }
}
