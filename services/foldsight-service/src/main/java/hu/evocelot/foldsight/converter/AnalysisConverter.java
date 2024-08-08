package hu.evocelot.foldsight.converter;

import org.springframework.stereotype.Component;

import hu.evocelot.foldsight.dto.analysis.AnalysisType;
import hu.evocelot.foldsight.model.Analysis;

/**
 * Converter class that handles conversion from {@link Analysis} to {@link AnalysisType}.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@Component
public class AnalysisConverter implements EntityConverter<Analysis, AnalysisType> {
    @Override
    public AnalysisType convert(Analysis analysis) {
        AnalysisType analysisType = new AnalysisType();
        analysisType.setAnalysisId(analysis.getId());
        analysisType.setStatus(analysis.getStatus());
        analysisType.setRootFolder(analysis.getRootFolder());
        analysisType.setExtension(analysis.getExtension());
        analysisType.setStartDate(analysis.getCreationDate());
        analysisType.setCreatorUser(analysis.getCreatorUser());
        return analysisType;
    }
}
