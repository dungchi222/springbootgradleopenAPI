package com.samsung.sds.emarket.marketing.api.repository.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class CampaignEntity {
    private Integer id;

    private String name;

    private String description;

    private OffsetDateTime startDate;

    private OffsetDateTime endDate;

    private String pictureUri;

    private String detailsUri;

    private String pictureName;
}
