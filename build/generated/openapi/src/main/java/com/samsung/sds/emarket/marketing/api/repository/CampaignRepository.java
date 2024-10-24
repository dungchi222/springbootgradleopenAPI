package com.samsung.sds.emarket.marketing.api.repository;

import com.samsung.sds.emarket.marketing.api.repository.entity.CampaignEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CampaignRepository {
//    @Select("SELECT * FROM campaigns")
    List<CampaignEntity> listCampaigns();

    CampaignEntity getCampaign(int id);

    int createCampaign(CampaignEntity entity);

    int updateCampaign(CampaignEntity entity);

    int getMaxId();

    int deleteCampaign(int id);
}