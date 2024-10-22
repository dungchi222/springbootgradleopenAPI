package com.samsung.sds.emarket.marketing.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CampaignDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class CampaignDTO {

  private Integer id;

  private String name = null;

  private String description = null;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime from;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime to;

  private String pictureURL = null;

  private String detailsUri = null;

  private String pictureName = null;

  public CampaignDTO id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public CampaignDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CampaignDTO description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  
  @Schema(name = "description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CampaignDTO from(OffsetDateTime from) {
    this.from = from;
    return this;
  }

  /**
   * Get from
   * @return from
  */
  @Valid 
  @Schema(name = "From", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("From")
  public OffsetDateTime getFrom() {
    return from;
  }

  public void setFrom(OffsetDateTime from) {
    this.from = from;
  }

  public CampaignDTO to(OffsetDateTime to) {
    this.to = to;
    return this;
  }

  /**
   * Get to
   * @return to
  */
  @Valid 
  @Schema(name = "to", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("to")
  public OffsetDateTime getTo() {
    return to;
  }

  public void setTo(OffsetDateTime to) {
    this.to = to;
  }

  public CampaignDTO pictureURL(String pictureURL) {
    this.pictureURL = pictureURL;
    return this;
  }

  /**
   * Get pictureURL
   * @return pictureURL
  */
  
  @Schema(name = "pictureURL", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pictureURL")
  public String getPictureURL() {
    return pictureURL;
  }

  public void setPictureURL(String pictureURL) {
    this.pictureURL = pictureURL;
  }

  public CampaignDTO detailsUri(String detailsUri) {
    this.detailsUri = detailsUri;
    return this;
  }

  /**
   * Get detailsUri
   * @return detailsUri
  */
  
  @Schema(name = "detailsUri", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("detailsUri")
  public String getDetailsUri() {
    return detailsUri;
  }

  public void setDetailsUri(String detailsUri) {
    this.detailsUri = detailsUri;
  }

  public CampaignDTO pictureName(String pictureName) {
    this.pictureName = pictureName;
    return this;
  }

  /**
   * Get pictureName
   * @return pictureName
  */
  
  @Schema(name = "pictureName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pictureName")
  public String getPictureName() {
    return pictureName;
  }

  public void setPictureName(String pictureName) {
    this.pictureName = pictureName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CampaignDTO campaignDTO = (CampaignDTO) o;
    return Objects.equals(this.id, campaignDTO.id) &&
        Objects.equals(this.name, campaignDTO.name) &&
        Objects.equals(this.description, campaignDTO.description) &&
        Objects.equals(this.from, campaignDTO.from) &&
        Objects.equals(this.to, campaignDTO.to) &&
        Objects.equals(this.pictureURL, campaignDTO.pictureURL) &&
        Objects.equals(this.detailsUri, campaignDTO.detailsUri) &&
        Objects.equals(this.pictureName, campaignDTO.pictureName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, from, to, pictureURL, detailsUri, pictureName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CampaignDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    pictureURL: ").append(toIndentedString(pictureURL)).append("\n");
    sb.append("    detailsUri: ").append(toIndentedString(detailsUri)).append("\n");
    sb.append("    pictureName: ").append(toIndentedString(pictureName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

