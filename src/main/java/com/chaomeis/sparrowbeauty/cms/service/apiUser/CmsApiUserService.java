package com.chaomeis.sparrowbeauty.cms.service.apiUser;

import com.chaomeis.sparrowbeauty.common.PageReqVO;
import com.chaomeis.sparrowbeauty.common.PageRespDto;
import com.chaomeis.sparrowbeauty.entity.TbCmsApiUser;
import com.chaomeis.sparrowbeauty.mapper.TbCmsApiUserMapper;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class CmsApiUserService {
    @Resource
    private TbCmsApiUserMapper tbCmsApiUserMapper;

    public PageRespDto<TbCmsApiUser> findCouponsPageList(PageReqVO<TbCmsApiUser> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<TbCmsApiUser> cmsApiUserPage = tbCmsApiUserMapper.selectList(page.getCondition());
        PageRespDto<TbCmsApiUser> pageList = new PageRespDto(cmsApiUserPage);
        return pageList;
    }
}
