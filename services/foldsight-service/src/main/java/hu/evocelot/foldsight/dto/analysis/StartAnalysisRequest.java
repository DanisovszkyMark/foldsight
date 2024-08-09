package hu.evocelot.foldsight.dto.analysis;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

import hu.evocelot.foldsight.dto.common.BaseRequest;

/**
 * Request DTO for starting new analysis.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
public class StartAnalysisRequest extends BaseRequest {

    @NotBlank(message = "The rootFolder cannot be blank!")
    @Size(max = 255, message = "The max size of the rootFolder is 255!")
    @Schema(description = "The root folder from where the analysis should start")
    private String rootFolder;

    @Size(max = 20, message = "The max size of the extension is 20!")
    @Schema(description = "The extension that allows defining which types of files need to be examined. If left empty, all files will be included in the examination.")
    private String extension;

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
}
