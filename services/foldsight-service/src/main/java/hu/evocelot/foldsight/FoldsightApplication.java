package hu.evocelot.foldsight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The starter class.
 * <p>
 * If you need to do something before the app starts, you can do it here.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@SpringBootApplication
public class FoldsightApplication {

    /**
     * The entry point of the application.
     *
     * @param args - the args.
     */
    public static void main(String[] args) {
        SpringApplication.run(FoldsightApplication.class, args);
    }
}
