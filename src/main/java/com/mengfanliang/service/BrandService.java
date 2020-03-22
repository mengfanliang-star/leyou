package com.mengfanliang.service;

import com.mengfanliang.entity.Brand;

import java.util.List;
import java.util.Map;

public interface BrandService {

    Map<String, Object> findBrandPage(String key, Integer page, Integer rows, String sortBy, Boolean desc);


    Integer saveBrand(Brand brand, List<Long> cids);

    List<Brand> queryBrandByCid(Long cid);
}
