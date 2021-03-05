package com.lsc.backhome.controller;

import com.lsc.backhome.common.api.ApiResult;
import com.lsc.backhome.model.entity.Site;
import com.lsc.backhome.service.SiteService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/")
public class SiteController extends BaseController {
    @Resource
    private SiteService siteService;

    @GetMapping("/sites")
    public ApiResult<List<Site>> getSitesInfo() {
        List<Site> sites = siteService.getSitesInfo();
        return ApiResult.success(sites);
    }
}
