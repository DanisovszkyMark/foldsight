package hu.evocelot.foldsight.dto.analysis;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

import hu.evocelot.foldsight.dto.analysis.enums.AnalysisStatus;

/**
 * Filtering DTO for analysis queries.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
public class AnalysisFilterOptions {

    @Schema(description = "Equal filter for the current status of the analysis.")
    private AnalysisStatus status;

    @Size(max = 255, message = "The max size of the rootFolder is 255!")
    @Schema(description = "Equal filter for the root folder of the analysis.")
    private String rootFolder;

    @Size(max = 20, message = "The max size of the extension is 20!")
    @Schema(description = "Equal filter for the extension of the analysis.")
    private String extension;

    @Schema(description = "Greater or equal filter for the start date of the analysis.")
    private OffsetDateTime startDateMin;

    @Schema(description = "Lesser or equal filter for the start date of the analysis.")
    private OffsetDateTime startDateMax;

    public AnalysisStatus getStatus() {
        return status;
    }

    public void setStatus(AnalysisStatus status) {
        this.status = status;
    }

    public @Size(max = 255, message = "The max size of the rootFolder is 255!") String getRootFolder() {
        return rootFolder;
    }

    public void setRootFolder(@Size(max = 255, message = "The max size of the rootFolder is 255!") String rootFolder) {
        this.rootFolder = rootFolder;
    }

    public @Size(max = 20, message = "The max size of the extension is 20!") String getExtension() {
        return extension;
    }

    public void setExtension(@Size(max = 20, message = "The max size of the extension is 20!") String extension) {
        this.extension = extension;
    }

    public OffsetDateTime getStartDateMin() {
        return startDateMin;
    }

    public void setStartDateMin(OffsetDateTime startDateMin) {
        this.startDateMin = startDateMin;
    }

    public OffsetDateTime getStartDateMax() {
        return startDateMax;
    }

    public void setStartDateMax(OffsetDateTime startDateMax) {
        this.startDateMax = startDateMax;
    }
}
