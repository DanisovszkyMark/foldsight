package hu.evocelot.foldsight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hu.evocelot.foldsight.model.Analysis;

/**
 * Repository class for handling {@link Analysis} entities.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@Repository
public interface AnalysisRepository extends JpaRepository<Analysis, String> {

    /**
     * Checks if there is an analysis with the given rootFolder where the status is not FINISHED.
     *
     * @param rootFolder - the root folder to check
     * @return - true if such an analysis exists, false otherwise
     */
    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END " +
            "FROM Analysis a " +
            "WHERE a.rootFolder = :rootFolder AND a.status != 'FINISHED'")
    boolean analysisInProgress(@Param("rootFolder") String rootFolder);
}
