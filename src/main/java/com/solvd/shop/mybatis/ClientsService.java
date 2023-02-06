package com.solvd.shop.mybatis;

import com.solvd.shop.dao.IClientsDAO;
import com.solvd.shop.models.Clients;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ClientsService implements IClientsDAO {

    private final static Logger LOGGER = LogManager.getLogger(ClientsService.class);
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Clients a) {

    }

    @Override
    public void update(Clients a) {

    }

    @Override
    public void remove(Clients a) {

    }

    @Override
    public List<Clients> selectAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IClientsDAO clientsDAO = session.getMapper(IClientsDAO.class);
            List<Clients> clients = clientsDAO.selectAll();
            return clients;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Clients select(Long id)  {
        return null;
    }
}
