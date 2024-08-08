package hu.evocelot.foldsight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.evocelot.foldsight.model.Analysis;
import hu.evocelot.foldsight.repository.AnalysisRepository;

/**
 * Service class for handling {@link Analysis} entities.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@Service
public class AnalysisService {

    @Autowired
    private AnalysisRepository analysisRepository;

    /**
     * Finds an {@link Analysis} entity by its unique identifier.
     *
     * @param id - the unique identifier of the {@link Analysis} entity.
     * @return - with the {@link Analysis} entity if found, {@code null} otherwise.
     */
    public Analysis findById(String id) {
        return analysisRepository.findById(id).orElse(null);
    }

    /**
     * Saves an {@link Analysis} entity to the database.
     *
     * @param analysis - the {@link Analysis} entity to be saved.
     * @return - with the saved {@link Analysis} entity.
     */
    public Analysis save(Analysis analysis) {
        return analysisRepository.save(analysis);
    }

    /**
     * Deletes the {@link Analysis} entity from the database.
     *
     * @param analysis - the {@link Analysis} entity to be deleted.
     */
    public void delete(Analysis analysis) {
        analysisRepository.delete(analysis);
    }

    /**
     * Checks if there is any {@link Analysis} entity with the given root folder that is in progress.
     *
     * @param rootFolder - the root folder to check for ongoing analyses.
     * @return - {@code true} if there is at least one {@link Analysis} with the given root folder
     * and its status is not {@code FINISHED}, {@code false} otherwise
     */
    public boolean analysisInProgress(String rootFolder) {
        return analysisRepository.analysisInProgress(rootFolder);
    }
}
