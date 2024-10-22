package com.samsung.sds.emarket.marketing.api.controller;

import com.samsung.sds.emarket.marketing.api.model.CampaignDTO;
import com.samsung.sds.emarket.marketing.api.model.NewCampaignDTO;
import com.samsung.sds.emarket.marketing.api.service.vo.CampaignVO;
import com.samsung.sds.emarket.marketing.api.service.vo.NewCampaignVO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface DTOMapper {
    CampaignDTO toCampaignDTO(CampaignVO campaign);

    NewCampaignVO toNewCampaignVO(NewCampaignDTO newCampaignDTO);

    CampaignVO toCampaignVO(NewCampaignDTO newcampaignDTO);
}
