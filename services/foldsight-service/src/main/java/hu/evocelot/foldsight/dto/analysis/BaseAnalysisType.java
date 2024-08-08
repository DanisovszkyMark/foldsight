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

    public void setAnalysisId(@NotBlank(message = "The id of the analysis cannot be blank!") @Size(max = 30, message = "The max size of the id is 30!") String analysisId) {
        this.analysisId = analysisId;
    }

    public @NotNull(message = "The status of the analysis cannot be null!") AnalysisStatus getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "The status of the analysis cannot be null!") AnalysisStatus status) {
        this.status = status;
    }

    public @NotBlank(message = "The rootFolder cannot be blank!") @Size(max = 255, message = "The max size of the rootFolder is 255!") String getRootFolder() {
        return rootFolder;
    }

    public void setRootFolder(@NotBlank(message = "The rootFolder cannot be blank!") @Size(max = 255, message = "The max size of the rootFolder is 255!") String rootFolder) {
        this.rootFolder = rootFolder;
    }

    public @NotBlank(message = "The extension cannot be blank!") @Size(max = 20, message = "The max size of the extension is 20!") String getExtension() {
        return extension;
    }

    public void setExtension(@NotBlank(message = "The extension cannot be blank!") @Size(max = 20, message = "The max size of the extension is 20!") String extension) {
        this.extension = extension;
    }

    public @NotNull(message = "The startDate cannot be null!") OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(@NotNull(message = "The startDate cannot be null!") OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public OffsetDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(OffsetDateTime finishDate) {
        this.finishDate = finishDate;
    }

    public @NotBlank(message = "The creatorUser cannot be blank!.") @Size(max = 30, message = "The name of the creator user of the analysis.") String getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(@NotBlank(message = "The creatorUser cannot be blank!.") @Size(max = 30, message = "The name of the creator user of the analysis.") String creatorUser) {
        this.creatorUser = creatorUser;
    }
}
