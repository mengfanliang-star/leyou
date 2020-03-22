package com.mengfanliang.controller;

import com.mengfanliang.bo.SpuBo;
import com.mengfanliang.entity.Sku;
import com.mengfanliang.entity.SpuDetail;
import com.mengfanliang.mapper.SkuMapper;
import com.mengfanliang.result.R;
import com.mengfanliang.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class GoodsAction {
    @Autowired
    private GoodsService goodsService;



    /**
     * 分页查询spu
     * @param key
     * @param saleable
     * @param page
     * @param rows
     * @return
     */
    @GetMapping("spu/page")
    public R querySpuByPage(
            @RequestParam(value = "key",required = false)String key,
            @RequestParam(value = "saleable",required = false)Boolean saleable,
            @RequestParam(value = "page",defaultValue = "1")Integer page,
            @RequestParam(value = "rows",defaultValue = "5")Integer rows
    ){
        Map<String,Object>spus=this.goodsService.querySpuByPage(key,saleable,page,rows);
        if(CollectionUtils.isEmpty(spus)){
            return R.notFound();
        }
        return R.ok().date(spus);

    }
    /**
     * 新增商品
     * @param spuBo
     * @return
     */
    @PostMapping("goods")
    public R saveGoods(@RequestBody SpuBo spuBo){
        System.out.println(spuBo);
        Integer i=this.goodsService.saveGoods(spuBo);

        if(i==1){
            return R.created();
        }

        return R.notFound();


    }


    /**
     * 更新商品,删除sku与库存,重新添加sku与库存..更新spu
     * @param spuBo
     * @return
     */
    @PutMapping("goods")
    public R updateGoods(@RequestBody SpuBo spuBo){
        System.out.println(spuBo);
        Integer i=this.goodsService.updateGoods(spuBo);

        if(i==1){
            return R.created();
        }

        return R.notFound();


    }

    /**
     * 根据spuId查询一条spuDetail记录
     * @param spuId
     * @return
     */
    @GetMapping("spu/detail/{spuId}")
    public R querySpuDetailBySpuId(@PathVariable("spuId")Long spuId){
        SpuDetail spuDetail=this.goodsService.querySpuDetailBySpuId(spuId);
        if(spuDetail==null){
            return R.notFound();
        }
        return R.ok().date("spuDetail",spuDetail);
    }

    /**
     * 根据spuid查询sku
     */
    @GetMapping("/sku/list")
    public R querySkusBySpuid(Long spuId){
        List<Sku> skus=goodsService.querySkusBySpuid(spuId);
        if(CollectionUtils.isEmpty(skus)){
            return R.notFound();
        }
        return R.ok().date("skus",skus);
    }
}
