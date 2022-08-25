package com.roboterh.vuln.controller;

import com.roboterh.vuln.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/deserializer")
public class FastJsonVuln {
    @RequestMapping(value = {"/fastjson"}, method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object getUser() {
        User user = new User();
        user.setName("Alice");
        user.setAge(Integer.valueOf(18));
        return user;
    }

    @PostMapping(value = {"/fastjson"}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object setUser(@RequestBody User user) {
        return user;
    }
}
