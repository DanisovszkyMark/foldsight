package hu.evocelot.foldsight.dto.common;

import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * The full paging details that contains the full details of the paging.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
public class FullPagingDetails extends BasePagingDetails {

    @NotNull(message = "The maxPage cannot be null!")
    @Schema(description = "The max page number.")
    private int maxPage;

    @NotNull(message = "The rowCount cannot be null!")
    @Schema(description = "The count of the all rows.")
    private int rowCount;

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }
}
