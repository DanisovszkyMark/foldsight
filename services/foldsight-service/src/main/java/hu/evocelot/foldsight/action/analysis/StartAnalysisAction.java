package hu.evocelot.foldsight.action.analysis;

import java.security.InvalidParameterException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.evocelot.foldsight.action.BaseAction;
import hu.evocelot.foldsight.converter.AnalysisConverter;
import hu.evocelot.foldsight.dto.analysis.StartAnalysisRequest;
import hu.evocelot.foldsight.dto.analysis.StartAnalysisResponse;
import hu.evocelot.foldsight.dto.analysis.enums.AnalysisStatus;
import hu.evocelot.foldsight.model.Analysis;
import hu.evocelot.foldsight.service.AnalysisService;
import hu.evocelot.foldsight.util.EnvUtil;

/**
 * Action class for starting new analysis.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@Component
public class StartAnalysisAction extends BaseAction {

    @Autowired
    private AnalysisService analysisService;

    @Autowired
    private AnalysisConverter analysisConverter;

    /**
     * For starting new analysis. Creates the analysis and throws async event to start the process.
     *
     * @param startAnalysisRequest - the request that contains information about the analysis to start.
     * @return - with {@link StartAnalysisResponse} that contains the id of the created analysis.
     */
    public StartAnalysisResponse startAnalysis(StartAnalysisRequest startAnalysisRequest) throws Exception {
        if (Objects.isNull(startAnalysisRequest)) {
            throw new InvalidParameterException("The startAnalysisRequest is null!");
        }

        if (analysisService.analysisInProgress(startAnalysisRequest.getRootFolder())) {
            throw new Exception("An analysis with the same root folder already started.");
        }

        Analysis analysis = new Analysis();
        analysis.setRootFolder(startAnalysisRequest.getRootFolder());
        analysis.setExtension(startAnalysisRequest.getExtension());
        analysis.setStatus(AnalysisStatus.CREATED);
        analysis.setCreatorUser(EnvUtil.getUsername());

        analysis = analysisService.save(analysis);

        // TODO: Throw new event (redis pub-sub)

        StartAnalysisResponse response = new StartAnalysisResponse();
        response.setAnalysisId(analysis.getId());
        handleSuccessfulResponse(response, startAnalysisRequest);

        return response;
    }
}
