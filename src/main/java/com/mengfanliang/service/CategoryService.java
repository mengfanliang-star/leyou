package com.mengfanliang.service;

import com.mengfanliang.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> selectCategoryList();

    List<Category> selectCategoryByPid(Long pid);

    List<String> queryNamesByIds(List<Long> ids);

}
