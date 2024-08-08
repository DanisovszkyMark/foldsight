package hu.evocelot.foldsight.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * The file result entity.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@Entity
@Table(name = "file_result")
public class FileResult extends AbstractEntity {

    @NotNull
    @Column(name = "file_name", length = 255)
    @Size(max = 255)
    private String fileName;

    @NotNull
    @Column
    private Integer count;

    @NotNull
    @Column(name = "analysis_id", length = 36)
    @Size(max = 36)
    private String analysisId;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(String analysisId) {
        this.analysisId = analysisId;
    }
}
