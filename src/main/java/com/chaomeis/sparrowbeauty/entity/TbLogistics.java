package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TbLogistics {
    private int id;
    private String logisticsName;
    private int logisticsPrice;
    private String logisticsApiUrl;
    private Date createTime;
    private Date updateTime;


}
