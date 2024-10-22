package com.samsung.sds.emarket.marketing.api.service;

import com.samsung.sds.emarket.marketing.api.model.CampaignDTO;
import com.samsung.sds.emarket.marketing.api.repository.CampaignRepository;
import com.samsung.sds.emarket.marketing.api.repository.entity.CampaignEntity;
import com.samsung.sds.emarket.marketing.api.repository.mybatis.CampaignRepositoryDao;
import com.samsung.sds.emarket.marketing.api.service.vo.CampaignVO;
import com.samsung.sds.emarket.marketing.api.service.vo.NewCampaignVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepositoryDao campaignRepository;
    private final VOMapper voMapper;

    public CampaignServiceImpl(CampaignRepositoryDao campaignRepository, VOMapper voMapper) {
        this.campaignRepository = campaignRepository;
        this.voMapper = voMapper;
    }

    @Override
    public List<CampaignVO> listCampaigns() {
        List<CampaignVO> result = new ArrayList<>();
        for (CampaignEntity campaignEntity : campaignRepository.listCampaigns()) {
            result.add(voMapper.toCampaignVO(campaignEntity));
        }
        return result;
    }

    @Override
    public CampaignVO createCampaign(NewCampaignVO newCampaign) {
//        CampaignVO campaignVO = new CampaignVO();
//        campaignVO.setId(100);
//        campaignVO.setDescription(newCampaign.getDescription());
//        campaignVO.setDetailsUri(newCampaign.getDetailsUri());
//        campaignVO.setFrom(newCampaign.getFrom());
//        campaignVO.setTo(newCampaign.getTo());
//        campaignVO.setName(newCampaign.getName());
//        campaignVO.setPictureURL(newCampaign.getPictureURL());

//        return campaignVO;

        CampaignEntity campaignEntity = voMapper.toCampaignEntity(newCampaign);

        Integer maxId = campaignRepository.getMaxId(); // Use Integer to handle null
        int newId = (maxId == null) ? 1 : maxId + 1; // Start from 1 if table is empty
        campaignEntity.setId(newId);

        campaignRepository.createCampaign(campaignEntity);
        return voMapper.toCampaignVO(campaignEntity);
    }

    @Override
    public CampaignVO updateCampaign(CampaignVO campaignVO) {
//        return campaignVO;
        CampaignEntity campaignEntity = campaignRepository.getCampaign(campaignVO.getId());
        if (campaignEntity == null) {
            return null;
        }
        campaignEntity = voMapper.toCampaignEntity(campaignVO);
        campaignRepository.updateCampaign(campaignEntity);
        return voMapper.toCampaignVO(campaignEntity);

    }

    @Override
    public CampaignVO getCampaign(Integer id) {
        CampaignEntity campaignEntity = campaignRepository.getCampaign(id);
        return voMapper.toCampaignVO(campaignEntity);
    }
}