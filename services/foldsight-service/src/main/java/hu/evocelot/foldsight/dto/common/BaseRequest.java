package hu.evocelot.foldsight.dto.common;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * The base class of the all request DTO-s.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
public class BaseRequest {

    @Valid
    @NotNull(message = "The context cannot be null!")
    @Schema(description = "The context of the request.")
    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
