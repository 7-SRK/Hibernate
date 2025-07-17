package ApachePackages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Logging {
    private static final Log log = LogFactory.getLog(Logging.class);

    public static void main(String[] args) {
    log.info("This is an Info Message");
    log.warn("This is a Warn Message");
    log.error("This is an Error Message");

    try{
        int x = 1 / 0;
    } catch (ArithmeticException e) {
        log.error("Exception Caught:", e);
    }
    }
}
