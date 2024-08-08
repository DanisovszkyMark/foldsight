package hu.evocelot.foldsight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.evocelot.foldsight.model.FileResult;

/**
 * Repository class for handling {@link FileResult} entities.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@Repository
public interface FileResultRepository extends JpaRepository<FileResult, String> {

}
