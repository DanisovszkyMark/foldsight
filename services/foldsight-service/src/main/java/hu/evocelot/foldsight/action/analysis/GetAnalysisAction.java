package hu.evocelot.foldsight.action.analysis;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.evocelot.foldsight.action.BaseAction;
import hu.evocelot.foldsight.converter.AnalysisConverter;
import hu.evocelot.foldsight.converter.FileResultConverter;
import hu.evocelot.foldsight.dto.analysis.AnalysisResponse;
import hu.evocelot.foldsight.dto.analysis.AnalysisType;
import hu.evocelot.foldsight.dto.analysis.enums.AnalysisStatus;
import hu.evocelot.foldsight.dto.fileresult.FileResultType;
import hu.evocelot.foldsight.model.Analysis;
import hu.evocelot.foldsight.model.FileResult;
import hu.evocelot.foldsight.service.AnalysisService;
import hu.evocelot.foldsight.service.FileResultService;

/**
 * Action class for getting analysis with the results.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@Component
public class GetAnalysisAction extends BaseAction {

    @Autowired
    private AnalysisService analysisService;

    @Autowired
    private FileResultService fileResultService;

    @Autowired
    private AnalysisConverter analysisConverter;

    @Autowired
    private FileResultConverter fileResultConverter;

    /**
     * For getting the analysis based on the id.
     *
     * @param analysisId - the id of the {@link Analysis} entity.
     * @return - with {@link AnalysisResponse} that contains the details of the analysis and the optional results.
     */
    public AnalysisResponse getAnalysis(String analysisId) throws Exception {
        if (StringUtils.isBlank(analysisId)) {
            throw new InvalidParameterException("The analysisId is blank!");
        }

        Analysis analysis = analysisService.findById(analysisId);
        if (Objects.isNull(analysis)) {
            throw new Exception("Analysis not found!");
        }

        List<FileResult> fileResults = new ArrayList<>();
        if (analysis.getStatus() != AnalysisStatus.CREATED) {
            fileResults = fileResultService.findByAnalysisId(analysis.getId());
        }

        AnalysisResponse response = new AnalysisResponse();

        AnalysisType analysisType = analysisConverter.convert(analysis);

        List<FileResultType> fileResultTypes = new ArrayList<>();
        for (FileResult fileResult : fileResults) {
            fileResultTypes.add(fileResultConverter.convert(fileResult));
        }
        analysisType.setResults(fileResultTypes);

        response.setAnalysisDetails(analysisType);
        handleSuccessfulResponse(response);

        return response;
    }
}
