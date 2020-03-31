package com.chaomeis.sparrowbeauty.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TbCmsUser {
    private int id;

    private String userName;

    private String loginName;

    private String password;

    private Date createTime;

    private String menuIds;


}
