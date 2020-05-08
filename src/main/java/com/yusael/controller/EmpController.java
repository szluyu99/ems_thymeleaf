package com.yusael.controller;

import com.yusael.entity.Emp;
import com.yusael.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    // 更新员工信息
    @PostMapping("/update") // 这里为什么用post, 因为html页面发送的就是get, 要保持一致
    public String update(Emp emp) {
        empService.update(emp);
        return "redirect:/emp/findAll";
    }

    // 根据id查询
    @GetMapping("/find") // 这里为什么不能用post
    public String find(String id, Model model) {
        Emp emp = empService.find(id);
        model.addAttribute("emp", emp);
        return "/ems/updateEmp";
    }
    // 删除员工
    @GetMapping("/delete")
    public String delete(String id) {
        empService.delete(id);
        return "redirect:/emp/findAll";
    }

    // 保存员工
    @PostMapping("/save")
    public String save(Emp emp) {
        empService.save(emp);
        return "redirect:/emp/findAll"; // 斜杠不能省略
    }
    // 查询所有
    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<Emp> emps = empService.findAll();
        model.addAttribute("emps", emps);
        return "/ems/emplist";
    }

}
