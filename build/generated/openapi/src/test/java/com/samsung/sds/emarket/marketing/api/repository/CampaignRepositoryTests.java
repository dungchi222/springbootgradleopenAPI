package com.samsung.sds.emarket.marketing.api.repository;

import com.samsung.sds.emarket.marketing.api.repository.entity.CampaignEntity;
import com.samsung.sds.emarket.marketing.api.repository.mybatis.CampaignRepositoryDao;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

import java.util.List;

@MybatisTest
@TestPropertySource(properties = {
    "spring.config.location=classpath:application-test.properties"
})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CampaignRepositoryTests {

    @Autowired
    private CampaignRepositoryDao campaignRepository;

    @Test
    public void testListCampaigns() {
        List<CampaignEntity> list = campaignRepository.listCampaigns();
        assertThat(list).extracting("id", "name").contains(
            tuple(3, "Campaign 3"),
            tuple(4, "Campaign 4")
        );
    }
}
