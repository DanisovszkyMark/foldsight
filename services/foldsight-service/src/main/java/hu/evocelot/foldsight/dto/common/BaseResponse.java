package hu.evocelot.foldsight.dto.common;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

import hu.evocelot.foldsight.dto.common.enums.FuncCode;

/**
 * The base class of the all response DTO-s.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
public class BaseResponse {

    @Valid
    @Schema(description = "The context of the response.")
    private Context context;

    @NotNull(message = "The funcCode cannot be null!")
    @Schema(description = "The func code of the response.")
    private FuncCode funcCode;

    @Schema(description = "The optional message of the response.")
    private String message;

    public @NotNull @Valid Context getContext() {
        return context;
    }

    public void setContext(@NotNull @Valid Context context) {
        this.context = context;
    }

    public @NotNull FuncCode getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(@NotNull FuncCode funcCode) {
        this.funcCode = funcCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
