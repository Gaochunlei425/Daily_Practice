package com.gcl.module.controller;

import com.gcl.module.domain.Product;

import com.gcl.module.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;


//    产品添加
    @RequestMapping("/save.do")
    @RolesAllowed("ADMIN")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }

//    @RolesAllowed("ADMIN")
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        System.out.println("进入这里");
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();

        mv.addObject("productList", ps);
        mv.setViewName("product-list1");
        return mv;
    }
}
