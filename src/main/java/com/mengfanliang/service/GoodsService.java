package com.mengfanliang.service;

import com.mengfanliang.bo.SpuBo;
import com.mengfanliang.entity.Sku;
import com.mengfanliang.entity.SpuDetail;

import java.util.List;
import java.util.Map;

public interface GoodsService {


    Map<String, Object> querySpuByPage(String key, Boolean saleable, Integer page, Integer rows);

    Integer saveGoods(SpuBo spuBo);

    SpuDetail querySpuDetailBySpuId(Long spuId);

    List<Sku> querySkusBySpuid(Long spuId);

    Integer updateGoods(SpuBo spuBo);
}
