package hu.evocelot.foldsight.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Util class for handling environment variables.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
public final class EnvUtil {

    private EnvUtil() {
        throw new IllegalStateException();
    }

    private static final String LINUX_USERNAME_ENV = "USER";
    private static final String WINDOWS_USERNAME_ENV = "USERNAME";
    private static final String UNKNOWN_USERNAME = "UNKNOWN";

    /**
     * Reads the default username env (linux/windows).
     *
     * @return - with the logged username or with the value of the UNKNOWN_USERNAME constant.
     */
    public static String getUsername() {
        String username = System.getenv(LINUX_USERNAME_ENV);
        if (StringUtils.isBlank(username)) {
            username = System.getenv(WINDOWS_USERNAME_ENV);
        }
        if (StringUtils.isBlank(username)) {
            username = UNKNOWN_USERNAME;
        }

        return username;
    }
}
