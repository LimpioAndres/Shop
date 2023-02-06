package com.solvd.shop.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.Reader;

public class SessionFactory {

    private static final Logger LOGGER = LogManager.getLogger(SessionFactory.class);
    private static SessionFactory sessionFactory;
    private SqlSessionFactory factory;

    private SessionFactory() {
        String resource = "config.xml";
        Reader reader = null;

        try {
            reader = Resources.getResourceAsReader(resource);
            factory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }

    public static SessionFactory getInstance() {
        if (sessionFactory == null) {
            sessionFactory = new SessionFactory();
        }
        return sessionFactory;
    }

    public SqlSessionFactory getFactory() {
        return factory;
    }
}
