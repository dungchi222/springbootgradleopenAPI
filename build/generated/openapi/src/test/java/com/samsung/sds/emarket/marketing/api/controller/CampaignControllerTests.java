package com.samsung.sds.emarket.marketing.api.controller;

import com.samsung.sds.emarket.marketing.api.controller.CampaignController;
import com.samsung.sds.emarket.marketing.api.repository.CampaignRepository;
import com.samsung.sds.emarket.marketing.api.service.CampaignService;
import com.samsung.sds.emarket.marketing.api.service.vo.CampaignVO;
import com.samsung.sds.emarket.marketing.api.service.vo.NewCampaignVO;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

//import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;


@ExtendWith(MockitoExtension.class)
@WebMvcTest(CampaignController.class)
@ComponentScan(
        basePackageClasses = {
                DTOMapper.class
        }
)
public class CampaignControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CampaignService campaignService;

    @MockBean(name = "campaignRepository")
    private CampaignRepository campaignRepository;

    @Test
    public void test_getCampaignList() throws Exception {

        List<CampaignVO> result = new ArrayList<>();
        CampaignVO campaignVO = new CampaignVO();
        campaignVO.setId(1);
        campaignVO.setName("campaign 1");
        result.add(campaignVO);

        campaignVO = new CampaignVO();
        campaignVO.setId(2);
        campaignVO.setName("campaign 2");
        result.add(campaignVO);

        when(campaignService.listCampaigns()).thenReturn(result);

        this.mvc.perform(get("/api/v1/campaigns"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id", is(1)))
                .andExpect(jsonPath("$.[0].name", is("campaign 1")))
                .andExpect(jsonPath("$.[1].id", is(2)))
                .andExpect(jsonPath("$.[1].name", is("campaign 2")));
    }

    @Test
    public void test_postCampaign() throws Exception {

        String name = "campaign 1";

        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("description", "description");

        CampaignVO campaignVO = new CampaignVO();
        campaignVO.setId(100);
        campaignVO.setName(name);

        when(campaignService.createCampaign(any(NewCampaignVO.class))).thenReturn(campaignVO);

        this.mvc.perform(post("/api/v1/campaigns")
                .contentType("application/json")
                .content(json.toString()))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(100)))
                .andExpect(jsonPath("$.name", is(name)));
    }

    @Test
    public void test_postCampaign_without_required() throws Exception {

        JSONObject json = new JSONObject();
        json.put("description", "description");

        this.mvc.perform(post("/api/v1/campaigns")
                .contentType("application/json")
                .content(json.toString()))
                .andExpect(status().is(400));

        json = new JSONObject();
        json.put("name", "campaign 1");

        this.mvc.perform(post("/api/v1/campaigns")
                .contentType("application/json")
                .content(json.toString()))
                .andExpect(status().is(400));
    }

    @Test
    public void testPutCampaigns() throws Exception {
        int id = 300;
        String name = "campaign 1";

        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("description", "description");
        json.put("from", "2022-01-01T00:00:00Z");
        json.put("to", "2022-01-01T00:00:00Z");
        json.put("detailsUri", "detailsUri");
        json.put("pictureURL", "pictureURL");

        when(campaignService.updateCampaign(any(CampaignVO.class))).thenAnswer(
                (InvocationOnMock invocation) -> {
                    return ((CampaignVO) invocation.getArguments()[0]);
                }
        );

        this.mvc.perform(put("/api/v1/campaigns/" + id)
                .contentType("application/json")
                .content(json.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id)))
                .andExpect(jsonPath("$.name", is(name)));
    }

}
