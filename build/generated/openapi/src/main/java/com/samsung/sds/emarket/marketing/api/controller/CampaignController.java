package com.samsung.sds.emarket.marketing.api.controller;

import com.samsung.sds.emarket.marketing.api.CampaignsApi;
import com.samsung.sds.emarket.marketing.api.model.CampaignDTO;
import com.samsung.sds.emarket.marketing.api.model.NewCampaignDTO;
import com.samsung.sds.emarket.marketing.api.service.CampaignService;
import com.samsung.sds.emarket.marketing.api.service.vo.CampaignVO;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@Api(tags = "Campaigns")
public class CampaignController implements CampaignsApi {

    private final CampaignService campaignService;
    private final DTOMapper dtoMapper;

    public CampaignController(CampaignService campaignService, DTOMapper dtoMapper) {
        this.campaignService = campaignService;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public ResponseEntity<CampaignDTO> getCampaign(Integer id) {
        CampaignVO campaignVO = campaignService.getCampaign(id);
        if (campaignVO == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(dtoMapper.toCampaignDTO(campaignVO));
        }
    }

    @Override
    public ResponseEntity<List<CampaignDTO>> getCampaignList() {
        List<CampaignDTO> result = new ArrayList<>();

//        CampaignDTO campaignDTO = new CampaignDTO();
//        campaignDTO.setId(1);
//        campaignDTO.setName("campaign 1");
//        result.add(campaignDTO);
//
//        campaignDTO = new CampaignDTO();
//        campaignDTO.setId(2);
//        campaignDTO.setName("campaign 2");
//        result.add(campaignDTO);

        for (CampaignVO campaignVO : campaignService.listCampaigns()) {
//            CampaignDTO campaignDTO = new CampaignDTO();
//            campaignDTO.setId(campaignVO.getId());
//            campaignDTO.setName(campaignVO.getName());
//            result.add(campaignDTO);
            result.add(dtoMapper.toCampaignDTO(campaignVO));
        }

        return ResponseEntity.ok().body(result);
    }

    @Override
    public ResponseEntity<CampaignDTO> postCampaign(@Valid NewCampaignDTO newCampaignDTO) {
//        CampaignDTO result = new CampaignDTO();
//        result.setId(100);
//        result.setName(newCampaignDTO.getName());

        CampaignVO campaignVO = campaignService.createCampaign(dtoMapper.toNewCampaignVO(newCampaignDTO));
        CampaignDTO result = dtoMapper.toCampaignDTO(campaignVO);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Override
    public ResponseEntity<CampaignDTO> putCampaign(Integer id, @Valid NewCampaignDTO newCampaignDTO) {
//        CampaignDTO result = new CampaignDTO();
//        result.setId(300);
//        result.setDescription(newCampaignDTO.getDescription());
//        result.setDetailsUri(newCampaignDTO.getDetailsUri());
//        result.setFrom(newCampaignDTO.getFrom());
//        result.setName(newCampaignDTO.getName());
//        result.setPictureURL(newCampaignDTO.getPictureURL());
//
//        return ResponseEntity.ok().body(result);

            CampaignVO campaign = dtoMapper.toCampaignVO(newCampaignDTO);
            campaign.setId(id);
            CampaignVO result = campaignService.updateCampaign(campaign);

            if (result == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok().body(dtoMapper.toCampaignDTO(result));
            }
    }
}
