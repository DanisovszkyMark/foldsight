package hu.evocelot.foldsight.dto.common;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Response DTO class for all the query responses.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
public class BaseQueryResponse extends BaseResponse {

    @Valid
    @NotNull(message = "The fullPagingDetails cannot be null!")
    @Schema(description = "The full details of the paging.")
    private FullPagingDetails fullPagingDetails;

    public @NotNull(message = "The fullPagingDetails cannot be null!") FullPagingDetails getFullPagingDetails() {
        return fullPagingDetails;
    }

    public void setFullPagingDetails(@NotNull(message = "The fullPagingDetails cannot be null!") FullPagingDetails fullPagingDetails) {
        this.fullPagingDetails = fullPagingDetails;
    }
}
