package hu.evocelot.foldsight.dto.analysis;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

import hu.evocelot.foldsight.dto.analysis.enums.AnalysisStatus;

/**
 * DTO for the analysis base details.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
public class BaseAnalysisType {

    @NotBlank(message = "The id of the analysis cannot be blank!")
    @Size(max = 30, message = "The max size of the id is 30!")
    @Schema(description = "The unique identifier of the analysis")
    private String analysisId;

    @NotNull(message = "The status of the analysis cannot be null!")
    @Schema(description = "The current status of the analysis.")
    private AnalysisStatus status;

    @NotBlank(message = "The rootFolder cannot be blank!")
    @Size(max = 255, message = "The max size of the rootFolder is 255!")
    @Schema(description = "The root folder of the analysis.")
    private String rootFolder;

    @NotBlank(message = "The extension cannot be blank!")
    @Size(max = 20, message = "The max size of the extension is 20!")
    @Schema(description = "The extension of the analysis.")
    private String extension;

    @NotNull(message = "The startDate cannot be null!")
    @Schema(description = "The start date of the analysis.")
    private OffsetDateTime startDate;

    @Schema(description = "The finish date of the analysis.")
    private OffsetDateTime finishDate;

    @NotBlank(message = "The creatorUser cannot be blank!.")
    @Size(max = 30, message = "The name of the creator user of the analysis.")
    private String creatorUser;

    public @NotBlank(message = "The id of the analysis cannot be blank!") @Size(max = 30, message = "The max size of the id is 30!") String getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(String analysisId) {
        this.analysisId = analysisId;
    }

    public AnalysisStatus getStatus() {
        return status;
    }

    public void setStatus(AnalysisStatus status) {
        this.status = status;
    }

    public String getRootFolder() {
        return rootFolder;
    }

    public void setRootFolder(String rootFolder) {
        this.rootFolder = rootFolder;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public OffsetDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(OffsetDateTime finishDate) {
        this.finishDate = finishDate;
    }

    public String getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(String creatorUser) {
        this.creatorUser = creatorUser;
    }
}
