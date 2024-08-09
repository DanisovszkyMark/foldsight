package hu.evocelot.foldsight.action;

import org.springframework.data.domain.Page;

import hu.evocelot.foldsight.dto.common.BaseRequest;
import hu.evocelot.foldsight.dto.common.BaseResponse;
import hu.evocelot.foldsight.dto.common.FullPagingDetails;
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

    /**
     * Creates and returns a {@link FullPagingDetails} object populated with pagination details
     * based on the given {@link Page} object.
     *
     * @param page - the {@link Page} object containing the pagination information.
     * @return - with a {@link FullPagingDetails} object that contains the pagination details.
     */
    protected FullPagingDetails getPagingDetails(Page<?> page) {
        FullPagingDetails fullPagingDetails = new FullPagingDetails();
        fullPagingDetails.setMaxPage(page.getTotalPages());
        fullPagingDetails.setPageNumber(page.getNumber() + 1);
        fullPagingDetails.setRowsPerPage(page.getSize());
        fullPagingDetails.setRowCount((int) page.getTotalElements());

        return fullPagingDetails;
    }

}
