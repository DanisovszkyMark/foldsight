package hu.evocelot.foldsight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.evocelot.foldsight.model.FileResult;
import hu.evocelot.foldsight.repository.FileResultRepository;

/**
 * Service class for handling {@link FileResult} entities.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@Service
public class FileResultService {

    @Autowired
    private FileResultRepository fileResultRepository;

    /**
     * Finds an {@link FileResult} entity by its unique identifier.
     *
     * @param id - the unique identifier of the {@link FileResult} entity.
     * @return - with the {@link FileResult} entity if found, {@code null} otherwise.
     */
    public FileResult findById(String id) {
        return fileResultRepository.findById(id).orElse(null);
    }

    /**
     * Finds all the {@link FileResult} based on the analysis id.
     *
     * @param analysisId - the id of the result owner analysis.
     * @return - with the list of {@link FileResult}.
     */
    public List<FileResult> findByAnalysisId(String analysisId) {
        return fileResultRepository.findByAnalysisId(analysisId);
    }

    /**
     * Saves an {@link FileResult} entity to the database.
     *
     * @param fileResult - the {@link FileResult} entity to be saved.
     * @return - with the saved {@link FileResult} entity.
     */
    public FileResult save(FileResult fileResult) {
        return fileResultRepository.save(fileResult);
    }

    /**
     * Deletes the {@link FileResult} entity from the database.
     *
     * @param fileResult - the {@link FileResult} entity to be deleted.
     */
    public void delete(FileResult fileResult) {
        fileResultRepository.delete(fileResult);
    }
}
