package hu.evocelot.foldsight.model;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

/**
 * Base class for all the entities with audit fields.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@MappedSuperclass
public abstract class AuditEntity extends AbstractEntity {

    @Column(nullable = false, updatable = false)
    private OffsetDateTime creationDate = OffsetDateTime.now();

    @Column(nullable = false)
    private String creatorUser = "0";

    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(OffsetDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(String creatorUser) {
        this.creatorUser = creatorUser;
    }
}
