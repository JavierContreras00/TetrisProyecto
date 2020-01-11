package Package.Loggers.CarptLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SysInterno {
	

	    private final static Logger LOGGER = Logger.getLogger("package.Loggers.CarptLogger.SysInterno");



	    public void llamadaSistema(){
	        LOGGER.log(Level.WARNING, "Ocurrio un error de acceso ");

	    }

	}

