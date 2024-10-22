package com.samsung.sds.emarket.marketing.api.service;

import com.samsung.sds.emarket.marketing.api.repository.entity.CampaignEntity;
import com.samsung.sds.emarket.marketing.api.service.vo.CampaignVO;
import com.samsung.sds.emarket.marketing.api.service.vo.NewCampaignVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VOMapper {

    @Mapping(source = "startDate", target = "from")
    @Mapping(source = "endDate", target = "to")
    @Mapping(source = "pictureUri", target = "pictureURL")
    @Mapping(source = "pictureName", target = "pictureName")
    CampaignVO toCampaignVO(CampaignEntity entity);

    @Mapping(source = "from", target = "startDate")
    @Mapping(source = "to", target = "endDate")
    @Mapping(source = "pictureURL", target = "pictureUri")
    @Mapping(source = "pictureName", target = "pictureName")
    CampaignEntity toCampaignEntity(NewCampaignVO newCampaign);

    @Mapping(source = "from", target = "startDate")
    @Mapping(source = "to", target = "endDate")
    @Mapping(source = "pictureURL", target = "pictureUri")
    @Mapping(source = "pictureName", target = "pictureName")
    CampaignEntity toCampaignEntity(CampaignVO campaignVO);
}