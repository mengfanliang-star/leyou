package com.mengfanliang.controller;

import com.mengfanliang.entity.Brand;
import com.mengfanliang.result.R;
import com.mengfanliang.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("brand")
public class BrandAction {
    @Autowired
    BrandService brandService;

    @GetMapping("page")
    public R queryBrandPage(
            @RequestParam(value = "key", defaultValue = "") String key,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "10") Integer rows,
            @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc

    ) {
        //System.out.println(key+page+""+rows+sortBy+desc);
        Map<String, Object> resultMap = this.brandService.findBrandPage(key, page, rows, sortBy, desc);
        if (resultMap.isEmpty()) {
            return R.notFound();
        }
        return R.ok().date(resultMap);
    }

    /**
     * 新增品牌,品牌与分类中间表新增参数cids
     *
     * @param brand
     * @param cids
     * @return
     */
    @PostMapping
    public R saveBrand(Brand brand, @RequestParam(value = "cids") List<Long> cids) {
        System.out.println(brand);
        System.out.println(cids);
        Integer i = this.brandService.saveBrand(brand, cids);
        return R.created().date("创建成功", i);
    }

    /**
     * 根据分类id查询对应品牌的集合
     * @param cid
     * @return
     */
    @GetMapping("cid/{cid}")
    public R queryBrandByCid(@PathVariable(value = "cid")Long cid){
        if(cid!=null){
            List<Brand>brands=brandService.queryBrandByCid(cid);
            if(CollectionUtils.isEmpty(brands)){
                return R.notFound();
            }
            return R.ok().date("brands",brands);

        }

        return R.notFound();


    }

}
