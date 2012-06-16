package com.mima.db.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * * Liest beim Verbindungsaufbau alle benoetigten Daten aus dem "daoProperties"-File,
 * welches sich im Root-Verzeichnis des Projekts befinden muss
 * @Deprecated
 *
 * @author i10b@zhaw: M. Mueller / M. Ott
 *
 */
public class DAOProperties {

    private static final String PROPERTIES_FILE = "src/main/java/resources/properties/database.properties";
    private static final Properties PROPERTIES = new Properties();

    private String specificKey;

    /**
     * Inizialisiert DAOProperties und liest die connection-Variablen in PROPERTIES
     * @throws DAOConfigurationException
     */
    public DAOProperties() {
        this.specificKey = "shortestWay.jdbc";
        InputStream propertiesFile = null;
		
        try {
			propertiesFile = new FileInputStream(PROPERTIES_FILE);
			PROPERTIES.load(propertiesFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /**
     * Liest die Properties aus dem daoProperties-File
     * @param key
     * @param mandatory
     * @return property
     * @throws DAOConfigurationException
     */
    public String getProperty(String key, boolean mandatory) {
        String fullKey = specificKey + "." + key;
        String property = PROPERTIES.getProperty(fullKey);

        if (property == null || property.equals("")) {
            property = null;
        }

        return property;
    }

}
