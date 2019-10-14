package com.chaomeis.sparrowbeauty.api.service.carousel;

import com.chaomeis.sparrowbeauty.entity.TbCarousel;
import com.chaomeis.sparrowbeauty.mapper.TbCarouselMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApiCarouselService {

    @Resource
    private TbCarouselMapper tbCarouselMapper;

    public List<TbCarousel> findAll(){
        return tbCarouselMapper.findAll();
    }
}
