package hu.evocelot.foldsight.dto.common;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * The context of the request / response.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
public class Context {

    @NotBlank(message = "The requestId cannot be blank!")
    @Size(max = 30, message = "The max size of the requestId is 30!")
    @Schema(description = "The unique identifier of the request.")
    private String requestId;

    @NotNull(message = "The timestamp cannot be null!")
    @Schema(description = "The time of the request in UTC.")
    private OffsetDateTime timestamp;

    public @NotBlank @Size(max = 30) String getRequestId() {
        return requestId;
    }

    public void setRequestId(@NotBlank @Size(max = 30) String requestId) {
        this.requestId = requestId;
    }

    public @NotNull OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(@NotNull OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
