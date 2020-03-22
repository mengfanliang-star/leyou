package com.mengfanliang.controller;

import com.mengfanliang.entity.Category;
import com.mengfanliang.exception.CategoryException;
import com.mengfanliang.result.R;
import com.mengfanliang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryAction {
    @Autowired
    CategoryService service;

    /**
     * 根据父类目的id查询所有子节点子id
     * @param pid
     * @return
     */
    @GetMapping("list")
    public R queryCategorysByPid(@RequestParam(value = "pid", defaultValue = "0") Long pid) {
        if (pid == null || pid < 0) {
            //404,参数不合法
            return R.badRequest();

        }

        List<Category> categorys = service.selectCategoryByPid(pid);
        if(categorys.isEmpty()){
            //400,资源没找到,空
            return R.notFound();
        }else{
            //200,请求成功
            return R.ok().date("categorys",categorys);
        }

    }

}
