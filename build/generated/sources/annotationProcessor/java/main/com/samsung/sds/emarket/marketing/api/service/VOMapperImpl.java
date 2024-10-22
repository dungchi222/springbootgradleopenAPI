package com.samsung.sds.emarket.marketing.api.service;

import com.samsung.sds.emarket.marketing.api.repository.entity.CampaignEntity;
import com.samsung.sds.emarket.marketing.api.service.vo.CampaignVO;
import com.samsung.sds.emarket.marketing.api.service.vo.NewCampaignVO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-22T08:51:50+0700",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class VOMapperImpl implements VOMapper {

    @Override
    public CampaignVO toCampaignVO(CampaignEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CampaignVO campaignVO = new CampaignVO();

        campaignVO.setFrom( entity.getStartDate() );
        campaignVO.setTo( entity.getEndDate() );
        campaignVO.setPictureURL( entity.getPictureUri() );
        campaignVO.setPictureName( entity.getPictureName() );
        if ( entity.getId() != null ) {
            campaignVO.setId( entity.getId() );
        }
        campaignVO.setName( entity.getName() );
        campaignVO.setDescription( entity.getDescription() );
        campaignVO.setDetailsUri( entity.getDetailsUri() );

        return campaignVO;
    }

    @Override
    public CampaignEntity toCampaignEntity(NewCampaignVO newCampaign) {
        if ( newCampaign == null ) {
            return null;
        }

        CampaignEntity campaignEntity = new CampaignEntity();

        campaignEntity.setStartDate( newCampaign.getFrom() );
        campaignEntity.setEndDate( newCampaign.getTo() );
        campaignEntity.setPictureUri( newCampaign.getPictureURL() );
        campaignEntity.setPictureName( newCampaign.getPictureName() );
        campaignEntity.setName( newCampaign.getName() );
        campaignEntity.setDescription( newCampaign.getDescription() );
        campaignEntity.setDetailsUri( newCampaign.getDetailsUri() );

        return campaignEntity;
    }

    @Override
    public CampaignEntity toCampaignEntity(CampaignVO campaignVO) {
        if ( campaignVO == null ) {
            return null;
        }

        CampaignEntity campaignEntity = new CampaignEntity();

        campaignEntity.setStartDate( campaignVO.getFrom() );
        campaignEntity.setEndDate( campaignVO.getTo() );
        campaignEntity.setPictureUri( campaignVO.getPictureURL() );
        campaignEntity.setPictureName( campaignVO.getPictureName() );
        campaignEntity.setId( campaignVO.getId() );
        campaignEntity.setName( campaignVO.getName() );
        campaignEntity.setDescription( campaignVO.getDescription() );
        campaignEntity.setDetailsUri( campaignVO.getDetailsUri() );

        return campaignEntity;
    }
}
