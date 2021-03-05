package com.lsc.backhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsc.backhome.mapper.SiteMapper;
import com.lsc.backhome.model.entity.Site;
import com.lsc.backhome.service.SiteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SiteServiceImpl extends ServiceImpl<SiteMapper, Site> implements SiteService {

    @Override
    public List<Site> getSitesInfo(){
        List <Site> siteInfo = null;
        try {
            siteInfo = this.baseMapper.selectList(null);
        } catch (Exception e) {
            log.info("Failed");
        }
        return siteInfo;
    }


}
