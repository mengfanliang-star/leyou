package com.mengfanliang.service;

import com.mengfanliang.entity.SpecGroup;
import com.mengfanliang.entity.SpecParam;

import java.util.List;

public interface SpecificationService {
    List<SpecGroup> queryGroupsByCid(Long cid);

    List<SpecParam> queryParams(Long gid);

}
