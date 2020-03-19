package com.mengfanliang.service;

import com.mengfanliang.entity.Category;
import com.mengfanliang.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper mapper;
    @Override
    public List<Category> selectCategoryList() {
        return mapper.selectByExample(null);
    }
}
