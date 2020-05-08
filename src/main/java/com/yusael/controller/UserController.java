package com.yusael.controller;

import com.yusael.entity.User;
import com.yusael.service.UserService;
import com.yusael.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    // 登录方法
    @PostMapping("login")
    public String login(String username, String password, HttpSession session) {
        User login = userService.login(username, password);
        if (login != null) {
            session.setAttribute("user", login);
            return "redirect:/emp/findAll"; // 跳转到查询所有
        } else {
            return "redirect:/index"; // 跳转回到登录
        }
    }

    // 注册方法
    @PostMapping("register")
    public String register(User user, String code, HttpSession session) {
        String sessionCode = (String) session.getAttribute("code");
        if (sessionCode.equalsIgnoreCase(code)) { // 忽略大小写比较验证码
            userService.register(user);
            return "redirect:/index"; // 跳转到登陆界面
        } else {
            return "redirect:/toRegister";
        }
    }

    // 生成验证码
    @GetMapping("code")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        // 生成验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        // 存入session作用域中
        session.setAttribute("code", securityCode);
        // 响应图片
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
    }

}
