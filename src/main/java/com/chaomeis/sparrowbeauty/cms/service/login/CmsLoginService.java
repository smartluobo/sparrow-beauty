package com.chaomeis.sparrowbeauty.cms.service.login;

import com.chaomeis.sparrowbeauty.entity.TbCmsUser;
import com.chaomeis.sparrowbeauty.mapper.TbCmsUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CmsLoginService {
    @Resource
    private TbCmsUserMapper tbCmsUserMapper;

    public TbCmsUser login(TbCmsUser tbCmsUser) {
        TbCmsUser dbUser = tbCmsUserMapper.findUserByLoginName(tbCmsUser.getLoginName());
        if (dbUser == null){
            return null;
        }
        if (dbUser.getPassword().equals(tbCmsUser.getPassword())){
            return dbUser;
        }
        return null;
    }
}
