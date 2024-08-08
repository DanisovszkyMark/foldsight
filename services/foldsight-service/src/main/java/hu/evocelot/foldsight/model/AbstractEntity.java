package hu.evocelot.foldsight.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Size;

import org.hibernate.annotations.UuidGenerator;

/**
 * Base entity class for all the entities.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(nullable = false, unique = true, updatable = false, length = 36)
    @Size(max = 36)
    private String id;

    public String getId() {
        return id;
    }
}
