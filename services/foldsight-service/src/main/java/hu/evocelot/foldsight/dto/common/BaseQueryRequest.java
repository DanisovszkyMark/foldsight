package hu.evocelot.foldsight.dto.common;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Request DTO class for all the query requests.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
public class BaseQueryRequest extends BaseRequest {

    @Valid
    @NotNull(message = "The basePagingDetails cannot be null!")
    @Schema(description = "The details of the paging.")
    private BasePagingDetails basePagingDetails;

    public @NotNull(message = "The basePagingDetails cannot be null!") BasePagingDetails getBasePagingDetails() {
        return basePagingDetails;
    }

    public void setBasePagingDetails(@NotNull(message = "The basePagingDetails cannot be null!") BasePagingDetails basePagingDetails) {
        this.basePagingDetails = basePagingDetails;
    }
}
