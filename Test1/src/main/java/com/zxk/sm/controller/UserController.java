package com.zxk.sm.controller;

import com.zxk.sm.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: SpringMvc01
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-09-09 10:07
 **/
@Controller
public class UserController {

    @RequestMapping("/user")
    public String show(String name) {
        System.out.println(name);
        return "success.jsp";
    }
    @RequestMapping("/requestParam1")
    public String requestParam1(){
        System.out.println("name+age");
        return "success.jsp";
    }
    //方法传递普通类型参数，使用@RequestParam参数匹配URL传参中的参数名称与方法形参名称
    //http://localhost/requestParam2?userName=Jock
    @RequestMapping("/requestParam2")
    public String requestParam2(@RequestParam(value = "userName",required = true) String name){
        System.out.println(name);
        return "success.jsp";
    }

    //方法传递POJO类型参数，URL地址中的参数作为POJO的属性直接传入对象
    //http://localhost/requestParam3?name=Jock&age=39
    @RequestMapping("/requestParam3")
    public String requestParam3(User user){
        System.out.println(user);
        return "success.jsp";
    }

    //当方法参数中具有POJO类型参数与普通类型参数嘶，URL地址传入的参数不仅给POJO对象属性赋值，也给方法的普通类型参数赋值
    //http://localhost/requestParam4?name=Jock&age=39
    @RequestMapping("/requestParam4")
    public String requestParam4(User user,int age){
        System.out.println("user="+user+",age="+age);
        return "success.jsp";
    }

    //使用对象属性名.属性名的对象层次结构可以为POJO中的POJO类型参数属性赋值
    //http://localhost/requestParam5?address.city=beijing
    @RequestMapping("/requestParam5")
    public String requestParam5(User user){
        System.out.println(user.getAddress().getCity());
        return "success.jsp";
    }

    //通过URL地址中同名参数，可以为POJO中的集合属性进行赋值，集合属性要求保存简单数据
    //http://localhost/requestParam6?nick=Jock1&nick=Jockme&nick=zahc
    @RequestMapping("/requestParam6")
    public String requestParam6(User user){
        System.out.println(user);
        return "success.jsp";
    }

    //POJO中List对象保存POJO的对象属性赋值，使用[数字]的格式指定为集合中第几个对象的属性赋值
    //http://localhost/requestParam7?addresses[0].city=beijing&addresses[1].province=hebei
    @RequestMapping("/requestParam7")
    public String requestParam7(User user){
        System.out.println(user.getAddresses());
        return "success.jsp";
    }
    //POJO中Map对象保存POJO的对象属性赋值，使用[key]的格式指定为Map中的对象属性赋值
    //http://localhost/requestParam8?addressMap['job'].city=beijing&addressMap['home'].province=henan
    @RequestMapping("/requestParam8")
    public String requestParam8(User user){
        System.out.println(user.getAddressMap());
        return "success.jsp";
    }

    //方法传递普通类型的数组参数，URL地址中使用同名变量为数组赋值
    //http://localhost/requestParam9?nick=Jockme&nick=zahc
    @RequestMapping("/requestParam9")
    public String requestParam9(String[] nick){
        System.out.println(nick[0]+","+nick[1]);
        return "success.jsp";
    }

    //方法传递保存普通类型的List集合时，无法直接为其赋值，需要使用@RequestParam参数对参数名称进行转换
    //http://localhost/requestParam10?nick=Jockme&nick=zahc
    @RequestMapping("/requestParam10")
    public String requestParam10(@RequestParam("nick") List<String> nick){
        System.out.println(nick);
        return "success.jsp";
    }

}
