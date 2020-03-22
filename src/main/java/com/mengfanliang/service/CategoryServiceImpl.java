package com.mengfanliang.service;

import com.mengfanliang.entity.Category;
import com.mengfanliang.entity.CategoryExample;
import com.mengfanliang.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper mapper;
    @Override
    public List<Category> selectCategoryList() {
        return mapper.selectByExample(null);
    }

    /**
     * 根据父类目的id查询所有子节点子id
     * @param pid
     * @return
     */
    @Override
    public List<Category> selectCategoryByPid(Long pid) {
        CategoryExample example = new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(pid);
        return mapper.selectByExample(example);
    }

    @Override
    public List<String> queryNamesByIds(List<Long> ids) {
        List<String> categoryNames=new ArrayList<>();
        for (Long id : ids) {

            Category category = mapper.selectByPrimaryKey(id);
            categoryNames.add(category.getName());
        }
        return categoryNames;
    }


}
