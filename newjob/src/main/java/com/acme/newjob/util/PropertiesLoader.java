package com.acme.newjob.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesLoader {
    private static final String CONFIGURATION_FILE = "config/properties.properties";
    
    public PropertiesLoader() {
        load();
    }
    
    public static PropertiesLoader getInstance() {
        if (instance == null)
            synchronized (PropertiesLoader.class) {
                if (instance == null)
                    instance = new PropertiesLoader();
            }
        return instance;
    }
    
    public Properties load() {
        String strOS = System.getProperty("os.name").toUpperCase();
        try {
            FileInputStream f = null;
            if(strOS.contains("WINDOWS")){
                f = new FileInputStream(CONFIGURATION_FILE);
            } else {
                f = new FileInputStream("../"+CONFIGURATION_FILE);
                
            }
            //InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("../conf/props/PrepagoService.properties");
            properties.load(f);
        } catch (IOException e) {
            System.err.println("error cargando archivo de propiedades " + e.getMessage());
            e.printStackTrace();
        }
        return properties;
    }
    
    public String getProperty(String prop) {
        String value = properties.getProperty(prop);
        if (value == null) {
            AppConstants.log.error("ERROR propiedad NULA " + prop);
        } else {
            value=value.trim();
        }
        return value;
    }
    
    //public Enumeration<?> getPropertyNames() {
    public Enumeration getPropertyNames() {
        return properties.propertyNames();
    }
    public void putProperty(String key,String value){
        properties.put(key, value);
    }
    public Properties getPropertie(){
        return properties;
    }
    private static PropertiesLoader instance;
    private static Properties       properties = new Properties();
}