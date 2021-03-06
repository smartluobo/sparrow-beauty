package com.chaomeis.sparrowbeauty.api.service.user;

import com.chaomeis.sparrowbeauty.entity.TbApiUser;
import com.chaomeis.sparrowbeauty.mapper.TbApiUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ApiUserService {

    @Resource
    private TbApiUserMapper tbApiUserMapper;

    public TbApiUser findApiUserByOpenId(String openId){
        return tbApiUserMapper.selectByOpenId(openId);
    }

    public boolean receiveNewUserGift(TbApiUser userInfo) {
        //todo 一期实现方式 领取新人礼包构建四张优惠券插入用户优惠券记录表
        //todo 修改用户新人礼包领取状态
        return true;
    }

    /**
     * 保持用户信息
     * @param oppenId
     * @param referrerOppenId
     */
    public void saveApiUser (String oppenId, String referrerOppenId) {
        TbApiUser record = new TbApiUser();
        record.setOpenId(oppenId);
        record.setReferrerOpenId(referrerOppenId);
        TbApiUser apiUser = tbApiUserMapper.selectByOpenId(oppenId);
        if (null == apiUser) {
            tbApiUserMapper.insert(record);
        }
    }

    public void updateApiUserInfo (TbApiUser record) {
        tbApiUserMapper.updateOpenIdSelective(record);
    }

}
