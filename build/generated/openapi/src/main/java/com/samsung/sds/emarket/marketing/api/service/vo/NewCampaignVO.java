package com.samsung.sds.emarket.marketing.api.service.vo;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class NewCampaignVO {

    private String name;

    private String description;

    private OffsetDateTime from;

    private OffsetDateTime to;

    private String pictureURL;

    private String detailsUri;

    private String pictureName;
}
