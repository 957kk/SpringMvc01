package com.itheima.controller;

import domain.Address;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringMvc01
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-09-13 19:52
 **/
@RestController
public class JsonController {
    @RequestMapping(value = "fast1", method = RequestMethod.GET)
    @ResponseBody
    public Address fast1() {
        Address address = new Address("浙江", "杭州", "钱塘");
        return address;
    }


}
