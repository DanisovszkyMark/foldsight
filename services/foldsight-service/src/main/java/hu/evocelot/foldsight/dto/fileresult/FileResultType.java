package hu.evocelot.foldsight.dto.fileresult;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * The fileResultType.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
public class FileResultType {

    @NotBlank(message = "The fileName cannot be blank!")
    @Size(max = 255, message = "The max size of the fileName is 255!")
    @Schema(description = "The name of the file.")
    private String fileName;

    @NotNull(message = "The count cannot be null!")
    @Schema(description = "The occurrence count of the file")
    private int count;

    public @NotBlank(message = "The fileName cannot be blank!") @Size(max = 255, message = "The max size of the fileName is 255!") String getFileName() {
        return fileName;
    }

    public void setFileName(@NotBlank(message = "The fileName cannot be blank!") @Size(max = 255, message = "The max size of the fileName is 255!") String fileName) {
        this.fileName = fileName;
    }

    @NotNull(message = "The count cannot be null!")
    public int getCount() {
        return count;
    }

    public void setCount(@NotNull(message = "The count cannot be null!") int count) {
        this.count = count;
    }
}
