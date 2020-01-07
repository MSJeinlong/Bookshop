package edu.gdpu.bookshop.controller;

import edu.gdpu.bookshop.bean.BookCategory;
import edu.gdpu.bookshop.service.BookCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class BookCategoryController {

    @Resource
    private BookCategoryService bcService;

    @RequestMapping("/addBookType")
    public String addBookCategory(Model model,  String categoryName, String categoryAttr){

        //检查该图书类型名称是否重复
        BookCategory category = bcService.findBookCategoryByName(categoryName);
        if(category != null){
            //该图书类型名称没有重复
            model.addAttribute("addBookCategoryTips", "图书类型添加失败!原因：图书类型名称重复");
            return "addBookCategory";
        }
        else {
            BookCategory bookCategory = new BookCategory();
            bookCategory.setCategoryName(categoryName);
            bookCategory.setCategoryAttr(categoryAttr);
            bcService.addBookCategory(bookCategory);
            model.addAttribute("addBookCategoryTips", "图像类型添加成功！");
            return "addBookCategory";
        }
    }
}
