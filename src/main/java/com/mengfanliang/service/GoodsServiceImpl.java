package com.mengfanliang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mengfanliang.bo.SkuBo;
import com.mengfanliang.bo.SpuBo;
import com.mengfanliang.entity.*;
import com.mengfanliang.mapper.*;

import org.apache.commons.collections.functors.FalsePredicate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private SpuMapper spuMapper;
    @Autowired
    private SpuDetailMapper spuDetailMapper;
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SkuMapper skuMapper;
    @Autowired
    private StockMapper stockMapper;

    @Override
    public Map<String, Object> querySpuByPage(String key, Boolean saleable, Integer page, Integer rows) {
        SpuExample spuExample = new SpuExample();
        SpuExample.Criteria criteria = spuExample.createCriteria();
        if (StringUtils.isNotBlank(key)) {
            criteria.andTitleLike("%" + key + "%");
        }
        if (saleable != null) {
            criteria.andSaleableEqualTo(saleable);
        }
        PageHelper.startPage(page, rows);
        List<Spu> spus = spuMapper.selectByExample(spuExample);
        PageInfo<Spu> pageInfo = new PageInfo<Spu>(spus);
        List<SpuBo> spuBos = spus.stream().map(spu -> {
            SpuBo spuBo = new SpuBo();
            BeanUtils.copyProperties(spu, spuBo);
            Brand brand = brandMapper.selectByPrimaryKey(spuBo.getBrandId());
            spuBo.setBname(brand.getName());
            List<String> names = this.categoryService.queryNamesByIds(Arrays.asList(spu.getCid1(), spu.getCid2(), spu.getCid3()));

            spuBo.setCname(StringUtils.join(names, "-"));
            return spuBo;
        }).collect(Collectors.toList());

        Map<String, Object> spuBOMap = new HashMap<>();
        spuBOMap.put("totle", pageInfo.getTotal());
        spuBOMap.put("spuBos", spuBos);
        return spuBOMap;


    }

    /**
     * 新增商品
     *
     * @param spuBo
     * @return
     */
    @Transactional
    @Override
    public Integer saveGoods(SpuBo spuBo) {
        //添加spu
        spuBo.setId(null);
        spuBo.setSaleable(true);
        spuBo.setValid(true);
        spuBo.setCreateTime(new Date());
        spuBo.setLastUpdateTime(spuBo.getCreateTime());
        this.spuMapper.insertSelective(spuBo);

        //添加spustail
        SpuDetail spuDetail = spuBo.getSpuDetail();
        spuDetail.setSpuId(spuBo.getId());
        int i=this.spuDetailMapper.insertSelective(spuDetail);

        //添加sku
        List<SkuBo> skus = spuBo.getSkus();

        for (SkuBo skuBo : skus) {
            skuBo.setId(null);
            skuBo.setSpuId(spuBo.getId());
            skuBo.setCreateTime(new Date());
            skuBo.setLastUpdateTime(skuBo.getCreateTime());
           this.skuMapper.insertSelective(skuBo);
            //添加stock
            Stock stock = new Stock();
            stock.setSkuId(skuBo.getId());
            stock.setStock(skuBo.getStock());
            stockMapper.insertSelective(stock);


        }

        return i;
    }

    @Override
    public SpuDetail querySpuDetailBySpuId(Long spuId) {
        SpuDetailExample spuDetailExample = new SpuDetailExample();
        SpuDetailExample.Criteria criteria = spuDetailExample.createCriteria();
        criteria.andSpuIdEqualTo(spuId);
        List<SpuDetail> spuDetails = spuDetailMapper.selectByExample(spuDetailExample);

        return spuDetails.get(0);

    }

    @Override
    public List<Sku> querySkusBySpuid(Long spuId) {
        SkuExample skuExample = new SkuExample();
        SkuExample.Criteria criteria = skuExample.createCriteria();
        criteria.andSpuIdEqualTo(spuId);
        List<Sku> skus = skuMapper.selectByExample(skuExample);
        return skus;
    }

    @Override
    public Integer updateGoods(SpuBo spuBo) {
        return null;
    }
}
