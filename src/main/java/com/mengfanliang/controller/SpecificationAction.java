package com.mengfanliang.controller;

import com.mengfanliang.entity.SpecGroup;
import com.mengfanliang.entity.SpecParam;
import com.mengfanliang.result.R;
import com.mengfanliang.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpecificationAction {
    @Autowired
    private SpecificationService specificationService;
    /**
     * 根据分类id查询规格参数组
     * @param cid
     * @return
     */
    @GetMapping("groups/{cid}")
    public R queryGropsByCid(@PathVariable("cid") Long cid){
        List<SpecGroup> groups=this.specificationService.queryGroupsByCid(cid);
        if(CollectionUtils.isEmpty(groups)){
            return R.notFound();
        }
        return R.ok().date("groups",groups);

    }

    /**
     * 根据条件查询规格参数
     * @param gid
     * @return
     */
    @GetMapping("params")
    public R queryParams(@RequestParam(value = "gid",required = false)Long gid){
        List<SpecParam> params=this.specificationService.queryParams(gid);
        if(CollectionUtils.isEmpty(params)){
            return R.notFound();
        }
        return R.ok().date("params",params);

    }

}
