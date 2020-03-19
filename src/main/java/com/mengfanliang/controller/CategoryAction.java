package com.mengfanliang.controller;

import com.mengfanliang.entity.Category;
import com.mengfanliang.exception.CategoryException;
import com.mengfanliang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryAction {
    @Autowired
    CategoryService service;
    @RequestMapping("aa")
    public List<Category> queryCategorys() throws CategoryException {
        throw new CategoryException(408,"cuowukxmkm");

        //return service.selectCategoryList();

    }

}
