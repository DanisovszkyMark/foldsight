package hu.evocelot.foldsight.dto.analysis;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.media.Schema;

import hu.evocelot.foldsight.dto.common.BaseQueryRequest;

/**
 * Request DTO for querying the analysis.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
public class QueryAnalysisRequest extends BaseQueryRequest {

    @Valid
    @Schema(description = "The optional filtering option for the query.")
    private AnalysisFilterOptions filterOptions;

    public AnalysisFilterOptions getFilterOptions() {
        return filterOptions;
    }

    public void setFilterOptions(AnalysisFilterOptions filterOptions) {
        this.filterOptions = filterOptions;
    }
}
