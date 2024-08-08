package hu.evocelot.foldsight.dto.analysis;

import java.util.List;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.media.Schema;

import hu.evocelot.foldsight.dto.fileresult.FileResultType;

/**
 * DTO for the analysis details.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
public class AnalysisType extends BaseAnalysisType {

    @Valid
    @Schema(description = "The results of the analysis.")
    private List<FileResultType> results;

    public @Valid List<FileResultType> getResults() {
        return results;
    }

    public void setResults(@Valid List<FileResultType> results) {
        this.results = results;
    }
}
