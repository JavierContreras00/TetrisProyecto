package Package.Loggers;


import java.util.logging.Level;

import java.util.logging.Logger;
public class Utilities {

	

	    private final static Logger LOGGER = Logger.getLogger("package.Loggers.Utilities");



	    public void funcionDudosa(){
	        LOGGER.log(Level.SEVERE, "ERROR MASIVO");

	    }

	}

