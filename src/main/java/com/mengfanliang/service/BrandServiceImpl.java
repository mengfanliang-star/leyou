package com.mengfanliang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mengfanliang.entity.Brand;
import com.mengfanliang.entity.BrandExample;
import com.mengfanliang.entity.CategoryBrand;
import com.mengfanliang.entity.CategoryBrandExample;
import com.mengfanliang.mapper.BrandMapper;
import com.mengfanliang.mapper.CategoryBrandMapper;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandMapper brandMapper;
    @Autowired
    CategoryBrandMapper categoryBrandMapper;

    @Override
    public Map<String, Object> findBrandPage(String key, Integer page, Integer rows, String sortBy, Boolean desc) {
        BrandExample brandExample = new BrandExample();
        BrandExample.Criteria criteria = brandExample.createCriteria();
        BrandExample.Criteria criteria2 = brandExample.createCriteria();
        criteria.andNameLike("%" + key + "%");
        criteria2.andLetterEqualTo(key);
        brandExample.or(criteria2);
        PageHelper.startPage(page, rows);
        brandExample.setOrderByClause(sortBy +" "+ (desc ? "desc" : "asc"));
        List<Brand> brands = brandMapper.selectByExample(brandExample);
        PageInfo pageInfo = new PageInfo(brands);
        long total = pageInfo.getTotal();
        HashMap<String, Object> brandMap = new HashMap<>();
        brandMap.put("total", total);
        brandMap.put("brands", brands);
        return brandMap;
    }

    @Transactional
    public Integer saveBrand(Brand brand, List<Long> cids) {

        int i = this.brandMapper.insertSelective(brand);
        Long brandId = brand.getId();
        System.out.println(brandId);
       CategoryBrand categoryBrand = new CategoryBrand();
        categoryBrand.setBrandId(brandId);
        for (Long cid : cids) {
            categoryBrand.setCategoryId(cid);
            System.out.println(cid);
              categoryBrandMapper.insertSelective(categoryBrand);
        }
        return i;
    }

    @Override
    public List<Brand> queryBrandByCid(Long cid) {

        CategoryBrandExample categoryBrandExample = new CategoryBrandExample();
        CategoryBrandExample.Criteria criteria = categoryBrandExample.createCriteria();
        criteria.andCategoryIdEqualTo(cid);
        List<CategoryBrand> categoryBrands = categoryBrandMapper.selectByExample(categoryBrandExample);
        if(CollectionUtils.isEmpty(categoryBrands)){
            return null;
        }
        List<Brand> brands=new ArrayList<>();
//        categoryBrands.stream().map(brand->{
//
//        }).collect()
        for (CategoryBrand categoryBrand : categoryBrands) {
            Brand brand = brandMapper.selectByPrimaryKey(categoryBrand.getBrandId());
            boolean add = brands.add(brand);

        }

        return brands;


    }
}
