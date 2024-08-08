package hu.evocelot.foldsight.rest;

/**
 * The class for defining the service information.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
public final class FoldSightServiceInformation {

    private FoldSightServiceInformation() {
        throw new IllegalStateException();
    }

    /**
     * The GET_ANALYSIS_SUMMARY.
     */
    public static final String GET_ANALYSIS_SUMMARY = "Get analysis";

    /**
     * The GET_ANALYSIS_DESCRIPTION.
     */
    public static final String GET_ANALYSIS_DESCRIPTION = "Retrieve the current status of the analysis. "
            + "If the status is IN_PROGRESS, the analysis is not yet complete.";

    /**
     * The START_ANALYSIS_SUMMARY.
     */
    public static final String START_ANALYSIS_SUMMARY = "Start analysis";

    /**
     * The START_ANALYSIS_DESCRIPTION.
     */
    public static final String START_ANALYSIS_DESCRIPTION = "Initiate a new analysis. "
            + "The endpoint returns an analysis ID that can be used with the GET endpoint to check the status. "
            + "Two analyses with the same source folder cannot be started at the same time.";

    /**
     * The QUERY_ANALYSIS_SUMMARY.
     */
    public static final String QUERY_ANALYSIS_SUMMARY = "Query analysis";

    /**
     * The QUERY_ANALYSIS_DESCRIPTION.
     */
    public static final String QUERY_ANALYSIS_DESCRIPTION = "Query the analyses in the system with filtering and pagination parameters.";
}
