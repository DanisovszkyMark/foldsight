package hu.evocelot.foldsight.dto.analysis;

import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

import hu.evocelot.foldsight.dto.common.BaseResponse;

/**
 * Response DTO for the analysis responses.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
public class AnalysisResponse extends BaseResponse {

    @NotNull(message = "The analysisDetails cannot be null!")
    @Schema(description = "The details of the analysis.")
    private AnalysisType analysisDetails;

    public AnalysisType getAnalysisDetails() {
        return analysisDetails;
    }

    public void setAnalysisDetails(AnalysisType analysisDetails) {
        this.analysisDetails = analysisDetails;
    }
}
