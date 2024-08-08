package hu.evocelot.foldsight.model;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import hu.evocelot.foldsight.dto.analysis.enums.AnalysisStatus;

/**
 * The analysis entity.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@Entity
@Table(name = "analysis")
public class Analysis extends AuditEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AnalysisStatus status;

    @Column(nullable = false, length = 255)
    private String rootFolder;

    @Column(length = 20)
    private String extension;

    @Column
    private OffsetDateTime finishDate;

    public OffsetDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(OffsetDateTime finishDate) {
        this.finishDate = finishDate;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getRootFolder() {
        return rootFolder;
    }

    public void setRootFolder(String rootFolder) {
        this.rootFolder = rootFolder;
    }

    public AnalysisStatus getStatus() {
        return status;
    }

    public void setStatus(AnalysisStatus status) {
        this.status = status;
    }
}
