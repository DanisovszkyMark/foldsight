package hu.evocelot.foldsight.dto.common;

import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * The base paging details that contains the actual page number and the row number.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
public class BasePagingDetails {

    @NotNull(message = "The page number cannot be null!")
    @Schema(description = "The actual page number.")
    private int pageNumber;

    @NotNull(message = "The rowsPerPage number cannot be null!")
    @Schema(description = "The number of rows on the current page.")
    private int rowsPerPage;

    @NotNull(message = "The page number cannot be null!")
    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(@NotNull(message = "The page number cannot be null!") int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @NotNull(message = "The rowsPerPage number cannot be null!")
    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(@NotNull(message = "The rowsPerPage number cannot be null!") int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }
}
