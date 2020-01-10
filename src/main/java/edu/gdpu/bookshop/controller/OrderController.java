package edu.gdpu.bookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class OrderController {


    @RequestMapping("/confirmMyOrder")
    public String confirmMyOrder(HttpSession session, String cartIds){

        return "confirmOrderInfo";
    }
}
