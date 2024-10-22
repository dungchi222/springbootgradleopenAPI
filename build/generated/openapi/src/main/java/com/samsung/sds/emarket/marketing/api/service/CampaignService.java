package com.samsung.sds.emarket.marketing.api.service;

import com.samsung.sds.emarket.marketing.api.service.vo.CampaignVO;
import com.samsung.sds.emarket.marketing.api.service.vo.NewCampaignVO;

import java.util.List;

public interface CampaignService {
    List<CampaignVO> listCampaigns();
    CampaignVO createCampaign(NewCampaignVO newCampaign);

    CampaignVO getCampaign(Integer id);

    CampaignVO updateCampaign(CampaignVO campaignVO);
}
