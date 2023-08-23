package com.acme.newjob.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementacion de constantes de la aplicacion
 * 
 * @author Alexander.Prada
 *
 */
public class AppConstants {
	public static String strToken="";

	/**
     * El log para reportar fallos.
     */
    //public static Logger log = LoggerUtil.log; //  Logger.getLogger("RTBill");
	public static final Logger log = LoggerFactory.getLogger(AppConstants.class);
    /**
     * Propiedades
     */
    public static PropertiesLoader properties               = PropertiesLoader.getInstance();
    
    public static String WS_URL             = properties.getProperty("ws.url");

}
