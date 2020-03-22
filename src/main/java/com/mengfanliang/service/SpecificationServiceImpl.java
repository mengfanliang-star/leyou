package com.mengfanliang.service;

import com.mengfanliang.entity.SpecGroup;
import com.mengfanliang.entity.SpecGroupExample;
import com.mengfanliang.entity.SpecParam;
import com.mengfanliang.entity.SpecParamExample;
import com.mengfanliang.mapper.SpecGroupMapper;
import com.mengfanliang.mapper.SpecParamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificationServiceImpl implements SpecificationService {
    @Autowired
    SpecGroupMapper specGroupMapper;
    @Autowired
    SpecParamMapper specParamMapper;

    /**
     * 根据分类id查询规格参数组
     * @param cid
     * @return
     */
    @Override
    public List<SpecGroup> queryGroupsByCid(Long cid) {
        SpecGroupExample specGroupExample = new SpecGroupExample();
        SpecGroupExample.Criteria criteria = specGroupExample.createCriteria();
        criteria.andCidEqualTo(cid);
        List<SpecGroup> specGroups = specGroupMapper.selectByExample(specGroupExample);
        return specGroups;
    }

    /**
     * 根据条件查询规格参数
     * @param gid
     * @return
     */
    @Override
    public List<SpecParam> queryParams(Long gid) {
        SpecParamExample specParamExample = new SpecParamExample();
        SpecParamExample.Criteria criteria = specParamExample.createCriteria();
        criteria.andGroupIdEqualTo(gid);
        List<SpecParam> specParams = specParamMapper.selectByExample(specParamExample);
        return specParams;
    }
}
