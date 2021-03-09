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
    public ApiResult<List<Site>> getSitesInfoByRegion(@RequestParam(value = "region") String region) {
        List<Site> sites = siteService.getSitesInfoByRegion(region);
        return ApiResult.success(sites);
    }
}
