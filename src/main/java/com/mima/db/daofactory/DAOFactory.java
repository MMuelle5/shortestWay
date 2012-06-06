package com.mima.db.daofactory;

import java.sql.Connection;
import java.sql.SQLException;

import com.mima.db.dao.PointDao;
import com.mima.db.dao.StrasseDao;
import com.mima.db.dao.exception.DAOConfigurationException;
import com.mima.db.dao.impl.PointDaoImpl;
import com.mima.db.dao.impl.StrasseDaoImpl;
import com.mima.db.dao.utility.DAOProperties;

public abstract class DAOFactory {

    private static final String PROPERTY_URL = "url";
    private static final String PROPERTY_DRIVER = "driver";
    private static final String PROPERTY_USERNAME = "username";
    private static final String PROPERTY_PASSWORD = "password";

    /**
     * Liest die Parameter aus dem daoProperties File und gibt eine DAOFactory zurueck
     */
    public static DAOFactory getInstance() throws DAOConfigurationException {

        DAOProperties properties = new DAOProperties();
        String url = properties.getProperty(PROPERTY_URL, true);
        String driverClassName = properties.getProperty(PROPERTY_DRIVER, false);
        String password = properties.getProperty(PROPERTY_PASSWORD, false);
        String username = properties.getProperty(PROPERTY_USERNAME, password != null);
        DAOFactory instance;

        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            throw new DAOConfigurationException("Classpath nicht gefunden", e);
        }
        instance = new DriverManagerDAOFactory(url, username, password);

        return instance;
    }

    /**
     * @return Eine connection zur Datenbank.
     * @throws SQLException Falls connection fail.
     * @throws Exception 
     */
    public abstract Connection getConnection() throws SQLException;

	public StrasseDao getStrasseDao() {
        return new StrasseDaoImpl(this);
	}
	
	public PointDao getPointDao() {
        return new PointDaoImpl(this);
	}
    
}
