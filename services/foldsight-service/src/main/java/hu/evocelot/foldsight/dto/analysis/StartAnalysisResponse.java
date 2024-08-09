package hu.evocelot.foldsight.dto.analysis;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

import hu.evocelot.foldsight.dto.common.BaseResponse;

/**
 * Response DTO for the start analysis responses.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
public class StartAnalysisResponse extends BaseResponse {

    @NotBlank(message = "The id of the analysis cannot be blank!")
    @Size(max = 30, message = "The max size of the id is 30!")
    @Schema(description = "The unique identifier of the analysis")
    private String analysisId;

    public String getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(String analysisId) {
        this.analysisId = analysisId;
    }
}
