/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.0.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.samsung.sds.emarket.marketing.api;

import com.samsung.sds.emarket.marketing.api.model.CampaignDTO;
import com.samsung.sds.emarket.marketing.api.model.NewCampaignDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "Campaigns", description = "the Campaigns API")
public interface CampaignsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /api/v1/campaigns/{id}
     * Delete a campaign
     *
     * @param id ID of campaign to delete (required)
     * @return Campaign deleted successfully (status code 204)
     *         or Campaign not found (status code 404)
     */
    @Operation(
        operationId = "deleteCampaign",
        description = "Delete a campaign",
        tags = { "Campaigns" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Campaign deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Campaign not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/api/v1/campaigns/{id}"
    )
    default ResponseEntity<Void> deleteCampaign(
        @Parameter(name = "id", description = "ID of campaign to delete", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/campaigns/{id}
     *
     * @param id ID of campaign to return (required)
     * @return successful operation (status code 200)
     *         or No campaign with the specified id (status code 404)
     */
    @Operation(
        operationId = "getCampaign",
        tags = { "Campaigns" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = CampaignDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "No campaign with the specified id")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/campaigns/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<CampaignDTO> getCampaign(
        @Parameter(name = "id", description = "ID of campaign to return", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"detailsUri\" : \"detailsUri\", \"pictureURL\" : \"pictureURL\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : 1, \"From\" : \"2000-01-23T04:56:07.000+00:00\", \"to\" : \"2000-01-23T04:56:07.000+00:00\", \"pictureName\" : \"pictureName\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/campaigns
     *
     * @return successful operation (status code 200)
     */
    @Operation(
        operationId = "getCampaignList",
        tags = { "Campaigns" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CampaignDTO.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/v1/campaigns",
        produces = { "application/json" }
    )
    default ResponseEntity<List<CampaignDTO>> getCampaignList(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"detailsUri\" : \"detailsUri\", \"pictureURL\" : \"pictureURL\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : 1, \"From\" : \"2000-01-23T04:56:07.000+00:00\", \"to\" : \"2000-01-23T04:56:07.000+00:00\", \"pictureName\" : \"pictureName\" }, { \"detailsUri\" : \"detailsUri\", \"pictureURL\" : \"pictureURL\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : 1, \"From\" : \"2000-01-23T04:56:07.000+00:00\", \"to\" : \"2000-01-23T04:56:07.000+00:00\", \"pictureName\" : \"pictureName\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /api/v1/campaigns
     * Create a new campaign
     *
     * @param newCampaignDTO  (optional)
     * @return successful operation (status code 201)
     */
    @Operation(
        operationId = "postCampaign",
        description = "Create a new campaign",
        tags = { "Campaigns" },
        responses = {
            @ApiResponse(responseCode = "201", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = CampaignDTO.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api/v1/campaigns",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<CampaignDTO> postCampaign(
        @Parameter(name = "NewCampaignDTO", description = "") @Valid @RequestBody(required = false) NewCampaignDTO newCampaignDTO
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"detailsUri\" : \"detailsUri\", \"pictureURL\" : \"pictureURL\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : 1, \"From\" : \"2000-01-23T04:56:07.000+00:00\", \"to\" : \"2000-01-23T04:56:07.000+00:00\", \"pictureName\" : \"pictureName\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /api/v1/campaigns/{id}
     * Update a campaign
     *
     * @param id ID of campaign to update (required)
     * @param newCampaignDTO  (optional)
     * @return successful operation (status code 200)
     *         or Campaign not found (status code 404)
     */
    @Operation(
        operationId = "putCampaign",
        description = "Update a campaign",
        tags = { "Campaigns" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = CampaignDTO.class))
            }),
            @ApiResponse(responseCode = "404", description = "Campaign not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/api/v1/campaigns/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<CampaignDTO> putCampaign(
        @Parameter(name = "id", description = "ID of campaign to update", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
        @Parameter(name = "NewCampaignDTO", description = "") @Valid @RequestBody(required = false) NewCampaignDTO newCampaignDTO
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"detailsUri\" : \"detailsUri\", \"pictureURL\" : \"pictureURL\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : 1, \"From\" : \"2000-01-23T04:56:07.000+00:00\", \"to\" : \"2000-01-23T04:56:07.000+00:00\", \"pictureName\" : \"pictureName\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
