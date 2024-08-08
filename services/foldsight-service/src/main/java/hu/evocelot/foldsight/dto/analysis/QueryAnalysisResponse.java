package hu.evocelot.foldsight.dto.analysis;

import java.util.List;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.media.Schema;

import hu.evocelot.foldsight.dto.common.BaseQueryResponse;

/**
 * Response DTO for the analysis responses.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
public class QueryAnalysisResponse extends BaseQueryResponse {

    @Valid
    @Schema(description = "The results of the query")
    private List<BaseAnalysisType> results;

    public List<BaseAnalysisType> getResults() {
        return results;
    }

    public void setResults(List<BaseAnalysisType> results) {
        this.results = results;
    }
}
