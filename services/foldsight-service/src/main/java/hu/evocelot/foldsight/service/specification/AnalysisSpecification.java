package hu.evocelot.foldsight.service.specification;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.criteria.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import hu.evocelot.foldsight.dto.analysis.AnalysisFilterOptions;
import hu.evocelot.foldsight.dto.analysis.enums.AnalysisStatus;
import hu.evocelot.foldsight.model.Analysis;
import hu.evocelot.foldsight.model.Analysis_;

/**
 * Specification class for defining the filter parameters for {@link Analysis} query.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
public class AnalysisSpecification {

    /**
     * For defining the filter predicates.
     *
     * @param filterOptions - the filter value.
     * @return - with {@link Specification<Analysis>}.
     */
    public static Specification<Analysis> filterByOptions(AnalysisFilterOptions filterOptions) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (Objects.nonNull(filterOptions)) {

                AnalysisStatus statusFilterValue = filterOptions.getStatus();
                if (Objects.nonNull(statusFilterValue)) {
                    predicates.add(criteriaBuilder.equal(root.get(Analysis_.STATUS), statusFilterValue));
                }

                String rootFolderFilterValue = filterOptions.getRootFolder();
                if (StringUtils.isNotBlank(rootFolderFilterValue)) {
                    predicates.add(criteriaBuilder.equal(root.get(Analysis_.ROOT_FOLDER), rootFolderFilterValue));
                }

                String extensionFilterValue = filterOptions.getExtension();
                if (StringUtils.isNotBlank(extensionFilterValue)) {
                    predicates.add(criteriaBuilder.equal(root.get(Analysis_.EXTENSION), extensionFilterValue));
                }

                OffsetDateTime startDateMinFilterValue = filterOptions.getStartDateMin();
                if (Objects.nonNull(startDateMinFilterValue)) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(Analysis_.CREATION_DATE), startDateMinFilterValue));
                }

                OffsetDateTime startDateMaxFilterValue = filterOptions.getStartDateMax();
                if (Objects.nonNull(startDateMaxFilterValue)) {
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(Analysis_.CREATION_DATE), startDateMaxFilterValue));
                }
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
