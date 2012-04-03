package com.mima.db.utils;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateDaoHelper extends HibernateDaoSupport {
	
	@Autowired
	public void setSession(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
    }

}
