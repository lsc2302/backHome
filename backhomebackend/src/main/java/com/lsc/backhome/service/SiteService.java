package com.lsc.backhome.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsc.backhome.model.entity.Site;

import java.util.List;

public interface SiteService extends IService<Site> {
    List<Site> getSitesInfo();
//    Site getSiteInfoBySiteID(int siteID);
}
