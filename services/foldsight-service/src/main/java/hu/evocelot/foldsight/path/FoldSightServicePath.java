package hu.evocelot.foldsight.path;

/**
 * The class for defining the service paths.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
public final class FoldSightServicePath {

    private FoldSightServicePath() {
        throw new IllegalStateException();
    }

    /**
     * The base path of the service.
     */
    public static final String BASE_SERVICE_PATH = "/api";

    /**
     * The base path for the analysis endpoints.
     */
    public static final String ANALYSIS_BASE_PATH = BASE_SERVICE_PATH + "/analysis";

    /**
     * The {@value } sub-path.
     */
    public static final String START = "/start";

    /**
     * The {@value } sub-path.
     */
    public static final String QUERY = "/query";

    /**
     * The {@value } parameter.
     */
    public static final String ID_PARAM = "id";

    /**
     * The {@value } path parameter.
     */
    public static final String ID_PATH_PARAM = "/{" + ID_PARAM + "}";
}
