package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TbLogistics {
    private int id;
    //物流名称
    private String logisticsName;
    //物流价格
    private int logisticsPrice;
    //物流对接api
    private String logisticsApiUrl;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;


}
