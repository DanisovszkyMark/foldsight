package hu.evocelot.foldsight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    /**
     * Finds all the {@link FileResult} based on the analysis id.
     *
     * @param analysisId - the id of the result owner analysis.
     * @return - with the list of {@link FileResult}.
     */
    @Query("SELECT fr FROM FileResult fr " +
            "WHERE fr.analysisId = :analysisId")
    List<FileResult> findByAnalysisId(@Param("analysisId") String analysisId);
}
