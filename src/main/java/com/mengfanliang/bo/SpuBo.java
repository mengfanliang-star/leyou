package com.mengfanliang.bo;



import com.mengfanliang.entity.Spu;
import com.mengfanliang.entity.SpuDetail;

import java.util.List;

public class SpuBo extends Spu {

    private String cname;
    private String bname;
    private List<SkuBo> skus;
    private SpuDetail spuDetail;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }



    public SpuDetail getSpuDetail() {
        return spuDetail;
    }

    public void setSpuDetail(SpuDetail spuDetail) {
        this.spuDetail = spuDetail;
    }

    public List<SkuBo> getSkus() {
        return skus;
    }

    public void setSkus(List<SkuBo> skus) {
        this.skus = skus;
    }
}
