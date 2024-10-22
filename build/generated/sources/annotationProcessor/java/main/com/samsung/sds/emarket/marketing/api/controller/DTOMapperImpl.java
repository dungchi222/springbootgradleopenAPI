package com.samsung.sds.emarket.marketing.api.controller;

import com.samsung.sds.emarket.marketing.api.model.CampaignDTO;
import com.samsung.sds.emarket.marketing.api.model.NewCampaignDTO;
import com.samsung.sds.emarket.marketing.api.service.vo.CampaignVO;
import com.samsung.sds.emarket.marketing.api.service.vo.NewCampaignVO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-22T08:50:29+0700",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class DTOMapperImpl implements DTOMapper {

    @Override
    public CampaignDTO toCampaignDTO(CampaignVO campaign) {
        if ( campaign == null ) {
            return null;
        }

        CampaignDTO campaignDTO = new CampaignDTO();

        campaignDTO.setId( campaign.getId() );
        campaignDTO.setName( campaign.getName() );
        campaignDTO.setDescription( campaign.getDescription() );
        campaignDTO.setFrom( campaign.getFrom() );
        campaignDTO.setTo( campaign.getTo() );
        campaignDTO.setPictureURL( campaign.getPictureURL() );
        campaignDTO.setDetailsUri( campaign.getDetailsUri() );
        campaignDTO.setPictureName( campaign.getPictureName() );

        return campaignDTO;
    }

    @Override
    public NewCampaignVO toNewCampaignVO(NewCampaignDTO newCampaignDTO) {
        if ( newCampaignDTO == null ) {
            return null;
        }

        NewCampaignVO newCampaignVO = new NewCampaignVO();

        newCampaignVO.setName( newCampaignDTO.getName() );
        newCampaignVO.setDescription( newCampaignDTO.getDescription() );
        newCampaignVO.setFrom( newCampaignDTO.getFrom() );
        newCampaignVO.setTo( newCampaignDTO.getTo() );
        newCampaignVO.setPictureURL( newCampaignDTO.getPictureURL() );
        newCampaignVO.setDetailsUri( newCampaignDTO.getDetailsUri() );
        newCampaignVO.setPictureName( newCampaignDTO.getPictureName() );

        return newCampaignVO;
    }

    @Override
    public CampaignVO toCampaignVO(NewCampaignDTO newcampaignDTO) {
        if ( newcampaignDTO == null ) {
            return null;
        }

        CampaignVO campaignVO = new CampaignVO();

        campaignVO.setName( newcampaignDTO.getName() );
        campaignVO.setDescription( newcampaignDTO.getDescription() );
        campaignVO.setFrom( newcampaignDTO.getFrom() );
        campaignVO.setTo( newcampaignDTO.getTo() );
        campaignVO.setPictureURL( newcampaignDTO.getPictureURL() );
        campaignVO.setDetailsUri( newcampaignDTO.getDetailsUri() );
        campaignVO.setPictureName( newcampaignDTO.getPictureName() );

        return campaignVO;
    }
}
