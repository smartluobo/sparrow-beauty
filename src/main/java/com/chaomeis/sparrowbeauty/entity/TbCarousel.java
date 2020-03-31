package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TbCarousel {
    private Integer id;

    private String imageUrl;

    private String gotoUrl;

    private Date createTime;

    private Date updateTime;


}
