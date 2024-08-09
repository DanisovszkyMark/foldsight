package hu.evocelot.foldsight.action.analysis;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import hu.evocelot.foldsight.action.BaseAction;
import hu.evocelot.foldsight.converter.AnalysisConverter;
import hu.evocelot.foldsight.dto.analysis.AnalysisFilterOptions;
import hu.evocelot.foldsight.dto.analysis.BaseAnalysisType;
import hu.evocelot.foldsight.dto.analysis.QueryAnalysisRequest;
import hu.evocelot.foldsight.dto.analysis.QueryAnalysisResponse;
import hu.evocelot.foldsight.dto.common.BasePagingDetails;
import hu.evocelot.foldsight.model.Analysis;
import hu.evocelot.foldsight.service.specification.AnalysisSpecification;
import hu.evocelot.foldsight.service.AnalysisService;

/**
 * Action class for querying analysis.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@Component
public class QueryAnalysisAction extends BaseAction {

    @Autowired
    private AnalysisService analysisService;

    @Autowired
    private AnalysisConverter analysisConverter;

    /**
     * For querying the analysis.
     *
     * @param queryAnalysisRequest - the request that contains the details of the paging and filtering.
     * @return - with {@link QueryAnalysisResponse} that contains the details of the query response.
     */
    public QueryAnalysisResponse queryAnalysis(QueryAnalysisRequest queryAnalysisRequest) {
        if (Objects.isNull(queryAnalysisRequest)) {
            throw new InvalidParameterException("The queryAnalysisRequest cannot be null!");
        }

        BasePagingDetails basePagingDetails = queryAnalysisRequest.getBasePagingDetails();
        AnalysisFilterOptions filterOptions = queryAnalysisRequest.getFilterOptions();

        int pageNumber = basePagingDetails.getPageNumber();
        int rowsPerPage = basePagingDetails.getRowsPerPage();
        Pageable pageable = PageRequest.of(pageNumber - 1, rowsPerPage);

        Page<Analysis> analysisPage = analysisService.findPage(AnalysisSpecification.filterByOptions(filterOptions), pageable);

        List<BaseAnalysisType> results = new ArrayList<>();
        for (Analysis analysis : analysisPage) {
            results.add(analysisConverter.convert(analysis));
        }

        QueryAnalysisResponse response = new QueryAnalysisResponse();
        response.setResults(results);
        response.setFullPagingDetails(getPagingDetails(analysisPage));
        handleSuccessfulResponse(response, queryAnalysisRequest);

        return response;
    }
}
