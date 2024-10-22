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
 * NewCampaignDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class NewCampaignDTO {

  private String name;

  private String description;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime from;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime to;

  private String pictureURL;

  private String detailsUri;

  private String pictureName;

  public NewCampaignDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public NewCampaignDTO(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public NewCampaignDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "Campaign 2022", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public NewCampaignDTO description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  @NotNull 
  @Schema(name = "description", example = "This is a campaign for 2022", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public NewCampaignDTO from(OffsetDateTime from) {
    this.from = from;
    return this;
  }

  /**
   * Get from
   * @return from
  */
  @Valid 
  @Schema(name = "from", example = "2022-01-01T00:00Z", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("from")
  public OffsetDateTime getFrom() {
    return from;
  }

  public void setFrom(OffsetDateTime from) {
    this.from = from;
  }

  public NewCampaignDTO to(OffsetDateTime to) {
    this.to = to;
    return this;
  }

  /**
   * Get to
   * @return to
  */
  @Valid 
  @Schema(name = "to", example = "2022-12-31T23:59:59Z", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("to")
  public OffsetDateTime getTo() {
    return to;
  }

  public void setTo(OffsetDateTime to) {
    this.to = to;
  }

  public NewCampaignDTO pictureURL(String pictureURL) {
    this.pictureURL = pictureURL;
    return this;
  }

  /**
   * Get pictureURL
   * @return pictureURL
  */
  
  @Schema(name = "pictureURL", example = "https://example", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pictureURL")
  public String getPictureURL() {
    return pictureURL;
  }

  public void setPictureURL(String pictureURL) {
    this.pictureURL = pictureURL;
  }

  public NewCampaignDTO detailsUri(String detailsUri) {
    this.detailsUri = detailsUri;
    return this;
  }

  /**
   * Get detailsUri
   * @return detailsUri
  */
  
  @Schema(name = "detailsUri", example = "https://example.com/campaigns/1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("detailsUri")
  public String getDetailsUri() {
    return detailsUri;
  }

  public void setDetailsUri(String detailsUri) {
    this.detailsUri = detailsUri;
  }

  public NewCampaignDTO pictureName(String pictureName) {
    this.pictureName = pictureName;
    return this;
  }

  /**
   * Get pictureName
   * @return pictureName
  */
  
  @Schema(name = "pictureName", example = "campaign.jpg", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    NewCampaignDTO newCampaignDTO = (NewCampaignDTO) o;
    return Objects.equals(this.name, newCampaignDTO.name) &&
        Objects.equals(this.description, newCampaignDTO.description) &&
        Objects.equals(this.from, newCampaignDTO.from) &&
        Objects.equals(this.to, newCampaignDTO.to) &&
        Objects.equals(this.pictureURL, newCampaignDTO.pictureURL) &&
        Objects.equals(this.detailsUri, newCampaignDTO.detailsUri) &&
        Objects.equals(this.pictureName, newCampaignDTO.pictureName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, from, to, pictureURL, detailsUri, pictureName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewCampaignDTO {\n");
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

