package hu.evocelot.foldsight.rest;

import static hu.evocelot.foldsight.rest.FoldSightServiceRestController.DESCRIPTION;
import static hu.evocelot.foldsight.rest.FoldSightServiceRestController.TAG;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import hu.evocelot.foldsight.dto.analysis.AnalysisResponse;
import hu.evocelot.foldsight.dto.analysis.AnalysisType;
import hu.evocelot.foldsight.dto.analysis.QueryAnalysisRequest;
import hu.evocelot.foldsight.dto.analysis.QueryAnalysisResponse;
import hu.evocelot.foldsight.dto.analysis.StartAnalysisRequest;
import hu.evocelot.foldsight.dto.analysis.enums.AnalysisStatus;
import hu.evocelot.foldsight.dto.common.FullPagingDetails;
import hu.evocelot.foldsight.dto.fileresult.FileResultType;
import hu.evocelot.foldsight.path.FoldSightServicePath;

/**
 * Rest controller for defining the service endpoints.
 * <p>
 * TODO: Response validation.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@RestController
@RequestMapping(FoldSightServicePath.ANALYSIS_BASE_PATH)
@Tag(name = TAG, description = DESCRIPTION)
public class FoldSightServiceRestController extends BaseRestController {

    public static final String TAG = "FoldSight service";

    public static final String DESCRIPTION = "Service for managing the analysis operations.";

    /**
     * HTTP GET method for reading the details of the analysis based on the id.
     *
     * @param analysisId - the id of the analysis to read.
     * @return - with {@link AnalysisResponse} that contains the details of the analysis.
     */
    @GetMapping(FoldSightServicePath.ID_PATH_PARAM)
    @Operation(summary = FoldSightServiceInformation.GET_ANALYSIS_SUMMARY, description = FoldSightServiceInformation.GET_ANALYSIS_DESCRIPTION)
    public AnalysisResponse getAnalysis(@PathVariable(FoldSightServicePath.ID_PARAM) String analysisId) {
        AnalysisResponse response = new AnalysisResponse();
        handleSuccessfulResponse(response);
        response.setMessage("Received id: " + analysisId);

        AnalysisType mockAnalysis = new AnalysisType();
        mockAnalysis.setAnalysisId("MOCK");
        mockAnalysis.setExtension("txt");
        mockAnalysis.setStatus(AnalysisStatus.IN_PROGRESS);
        mockAnalysis.setRootFolder("ec2");

        List<FileResultType> resultTypes = new ArrayList<>();
        FileResultType fileResultType = new FileResultType();
        fileResultType.setFileName("MOCK-file.txt");
        fileResultType.setCount(1);
        resultTypes.add(fileResultType);
        mockAnalysis.setResults(resultTypes);

        response.setAnalysisDetails(mockAnalysis);
        return response;
    }

    /**
     * HTTP POST method for starting new analysis.
     *
     * @param startAnalysisRequest - the dto that contains the details of the request.
     * @return - with {@link AnalysisResponse} that contains the details of the analysis.
     */
    @PostMapping(FoldSightServicePath.START)
    @Operation(summary = FoldSightServiceInformation.START_ANALYSIS_SUMMARY, description = FoldSightServiceInformation.START_ANALYSIS_DESCRIPTION)
    public AnalysisResponse startAnalysis(@Valid @RequestBody StartAnalysisRequest startAnalysisRequest) {
        AnalysisResponse response = new AnalysisResponse();
        handleSuccessfulResponse(response, startAnalysisRequest);

        AnalysisType mockAnalysis = new AnalysisType();
        mockAnalysis.setAnalysisId("MOCK");
        mockAnalysis.setExtension("txt");
        mockAnalysis.setStatus(AnalysisStatus.CREATED);
        mockAnalysis.setRootFolder("ec2");

        response.setAnalysisDetails(mockAnalysis);
        return response;
    }

    /**
     * HTTP POST method for listing the details of the analysis based on the filtering and paging details.
     *
     * @param queryAnalysisRequest - the request that contains the filtering and paging details.
     * @return - with {@link QueryAnalysisResponse} that contains the specified analysis details based on the request details.
     */
    @PostMapping(FoldSightServicePath.QUERY)
    @Operation(summary = FoldSightServiceInformation.QUERY_ANALYSIS_SUMMARY, description = FoldSightServiceInformation.QUERY_ANALYSIS_DESCRIPTION)
    public QueryAnalysisResponse queryAnalysis(@Valid @RequestBody QueryAnalysisRequest queryAnalysisRequest) {
        QueryAnalysisResponse response = new QueryAnalysisResponse();
        handleSuccessfulResponse(response, queryAnalysisRequest);

        FullPagingDetails fullPagingDetails = new FullPagingDetails();
        fullPagingDetails.setMaxPage(10);
        fullPagingDetails.setPageNumber(1);
        fullPagingDetails.setRowsPerPage(50);
        fullPagingDetails.setRowCount(256);

        response.setFullPagingDetails(fullPagingDetails);
        return response;
    }
}