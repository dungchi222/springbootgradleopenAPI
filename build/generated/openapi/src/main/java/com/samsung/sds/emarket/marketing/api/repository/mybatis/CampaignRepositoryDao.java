package com.samsung.sds.emarket.marketing.api.repository.mybatis;

import com.samsung.sds.emarket.marketing.api.repository.CampaignRepository;
import com.samsung.sds.emarket.marketing.api.repository.entity.CampaignEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface CampaignRepositoryDao extends CampaignRepository {

    @Select("select max(id) from campaigns")
    int getMaxId();

    @Select("select id, description, start_date, name, pictureUri, end_date, detailsUri, pictureName from campaigns")
    public List<CampaignEntity> listCampaigns();

    @Select("select id, description, start_date, name, pictureUri, end_date, detailsUri, pictureName from campaigns where id = #{id}")
    public CampaignEntity getCampaign(int id);

//    @Insert("insert into campaigns (description, start_date, name, pictureUri, end_date, detailsUri, pictureName) values (#{description}, #{startDate}, #{name}, #{pictureUri}, #{endDate}, #{detailsUri}, #{pictureName})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
//    public int createCampaign(CampaignEntity entity);

    @Insert("insert into campaigns (id, description, start_date, name, pictureUri, end_date, detailsUri, pictureName) values (#{id}, #{description}, #{startDate}, #{name}, #{pictureUri}, #{endDate}, #{detailsUri}, #{pictureName})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    int createCampaign(CampaignEntity entity);

    @Update(
        "update campaigns set description = #{description}, start_date = #{startDate}, name = #{name}, pictureUri = #{pictureUri}, end_date = #{endDate}, detailsUri = #{detailsUri}, pictureName = #{pictureName} where id = #{id}"
    )
    public int updateCampaign(CampaignEntity entity);
}
