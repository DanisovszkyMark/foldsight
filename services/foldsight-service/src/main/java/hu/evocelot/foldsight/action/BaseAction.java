package hu.evocelot.foldsight.action;

import hu.evocelot.foldsight.dto.common.BaseRequest;
import hu.evocelot.foldsight.dto.common.BaseResponse;
import hu.evocelot.foldsight.dto.common.enums.FuncCode;

/**
 * Base class for the action classes.
 *
 * @author mark.danisovszky
 */
public class BaseAction {

    /**
     * Sets the function code of the response to indicate a successful operation.
     *
     * @param response the response object to be updated.
     */
    protected void handleSuccessfulResponse(BaseResponse response) {
        response.setFuncCode(FuncCode.OK);
    }

    /**
     * Sets the function code of the response to indicate a successful operation
     * and copies the context from the request to the response.
     *
     * @param response the response object to be updated.
     * @param request  the request object whose context is to be copied.
     */
    protected void handleSuccessfulResponse(BaseResponse response, BaseRequest request) {
        handleSuccessfulResponse(response);
        response.setContext(request.getContext());
    }
}
