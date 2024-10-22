package com.samsung.sds.emarket.marketing.api.service;

import com.samsung.sds.emarket.marketing.api.repository.CampaignRepository;
import com.samsung.sds.emarket.marketing.api.repository.entity.CampaignEntity;
import com.samsung.sds.emarket.marketing.api.repository.mybatis.CampaignRepositoryDao;
import com.samsung.sds.emarket.marketing.api.service.vo.CampaignVO;
import com.samsung.sds.emarket.marketing.api.service.vo.NewCampaignVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CampaignServiceTests {

    @Mock
    private CampaignRepositoryDao campaignRepository;

    @Test
    public void testListCampaigns() {

        List<CampaignEntity> result = new ArrayList<>();

        CampaignEntity campaign = new CampaignEntity();
        campaign.setId(3);
        campaign.setName("campaign 3");
        result.add(campaign);

        campaign = new CampaignEntity();
        campaign.setId(4);
        campaign.setName("campaign 4");
        result.add(campaign);

        when(campaignRepository.listCampaigns()).thenReturn(result);

        CampaignService campaignService = new CampaignServiceImpl(campaignRepository, new VOMapperImpl());

        List<CampaignVO> list = campaignService.listCampaigns();
        assertThat(list).extracting("id", "name").contains(
                tuple(3, "campaign 3"),
                tuple(4, "campaign 4")
        );
    }

    @Test
    public void testCreateCampaign() {
        String name = "campaign 4";
        OffsetDateTime from = OffsetDateTime.now();
        OffsetDateTime to = from.plusMonths(3);

        NewCampaignVO newCampaign = new NewCampaignVO();
        newCampaign.setName(name);
        newCampaign.setFrom(from);
        newCampaign.setTo(to);
        newCampaign.setDescription("description");
        newCampaign.setDetailsUri("http://details");
        newCampaign.setPictureURL("http://picture");

        when(campaignRepository.createCampaign(any(CampaignEntity.class)))
                .thenAnswer(
                        (InvocationOnMock invocation) -> {
                            ((CampaignEntity) invocation.getArguments()[0]).setId(100);
                            return 1;

                        });

        CampaignService campaignService = new CampaignServiceImpl(campaignRepository, new VOMapperImpl());
        assertThat(campaignService.createCampaign(newCampaign))
                .hasFieldOrPropertyWithValue("id", 100)
                .hasFieldOrPropertyWithValue("name", name);

    }

    @Test
    public void testUpdateCampaigns(){
        String name = "campaign 4";
        OffsetDateTime from = OffsetDateTime.now();
        OffsetDateTime to = from.plusMonths(3);

        CampaignVO newCampaign = new CampaignVO();
        newCampaign.setId(300);
        newCampaign.setName(name);
        newCampaign.setFrom(from);
        newCampaign.setTo(to);
        newCampaign.setDescription("description");
        newCampaign.setDetailsUri("http://details");
        newCampaign.setPictureURL("http://picture");

        when(campaignRepository.getCampaign(300)).thenReturn(new CampaignEntity());

        CampaignService campaignService = new CampaignServiceImpl(campaignRepository, new VOMapperImpl());

        assertThat(campaignService.updateCampaign(newCampaign))
                .hasFieldOrPropertyWithValue("id", 300)
                .hasFieldOrPropertyWithValue("name", name);
    }
}
