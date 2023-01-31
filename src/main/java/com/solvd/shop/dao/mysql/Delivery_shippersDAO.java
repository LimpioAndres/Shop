package com.solvd.shop.dao.mysql;

import com.solvd.shop.dao.IDelivery_shippersDAO;
import com.solvd.shop.models.Delivery_shippers;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Delivery_shippersDAO extends MySQLDAO implements IDelivery_shippersDAO {

    private final static String INSERT = "INSERT INTO delivery_shippers(idDelivery, idShippers, date_creation) VALUES(?, ?, ?)";

    private final static String UPDATE = "UPDATE delivery_shippers SET idShippers = ?, date_creation = ? WHERE idDelivery = ?";

    private final static String DELETE = "DELETE FROM delivery_shippers WHERE idDelivery = ?";

    private final static String GETALL = "SELECT idDelivery, idShippers, date_creation FROM delivery_shippers";

    private final static String GETONE = "SELECT idDelivery, idShippers, date_creation FROM delivery_shippers WHERE idDelivery = ?";

    private Connection connection;

    public Delivery_shippersDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public void create(Delivery_shippers a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdDelivery());
            statement.setLong(2, a.getIdShippers());
            statement.setDate(3, new Date(a.getDate_creation().getTime()));
            if(statement.executeUpdate() == 0){
                throw new ExceptionDAO("Maybe the changes haven't been saved");
            }
        }catch (SQLException ex){
            throw new ExceptionDAO("SQL Error", ex);
        }finally{
            if (statement != null){
                try{
                    statement.close();
                }catch (SQLException ex){
                    throw new ExceptionDAO("SQL Error",ex);
                }
            }
        }
    }

    @Override
    public void update(Delivery_shippers a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdShippers());
            statement.setDate(2, a.getDate_creation());
            statement.setLong(3, a.getIdDelivery());
            if (statement.executeUpdate() == 0){
                throw new ExceptionDAO("Maybe the update haven't been done");
            }
        }catch(SQLException ex){
            throw new ExceptionDAO("SQL Error", ex);
        }finally{
            if (statement != null){
                try{
                    statement.close();
                }catch (SQLException ex){
                    throw new ExceptionDAO("SQL Error", ex);
                }
            }
        }
    }

    @Override
    public void remove(Delivery_shippers a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(DELETE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdDelivery());
            if (statement.executeUpdate() == 0){
                throw new ExceptionDAO("Maybe the erased haven't been done");
            }
        }catch(SQLException ex){
            throw new ExceptionDAO("SQL Error", ex);
        }finally{
            if (statement != null){
                try{
                    statement.close();
                }catch (SQLException ex){
                    throw new ExceptionDAO("SQL Error", ex);
                }
            }
        }
    }

    private Delivery_shippers transform (ResultSet resultSet) throws SQLException{
        Long idShippers = resultSet.getLong("idShippers");
        Date dateCreation = resultSet.getDate("date_creation");

        Delivery_shippers delivery_shippers = new Delivery_shippers(idShippers, dateCreation);
        delivery_shippers.setIdDelivery(resultSet.getLong("idDelivery"));

        return delivery_shippers;
    }

    @Override
    public List<Delivery_shippers> selectAll() throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List <Delivery_shippers> delivery_shippers = new ArrayList<>();
        try {
            statement = connection.prepareStatement(GETALL, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                delivery_shippers.add(transform(resultSet));
            }
        }catch(SQLException ex){
            throw new ExceptionDAO("SQL Error", ex);
        }finally{
            if (resultSet != null){
                try {
                    resultSet.close();
                }catch (SQLException ex){
                    new ExceptionDAO("SQL Error", ex);
                }
            }
            if (statement != null){
                try {
                    statement.close();
                }catch (SQLException ex){
                    new ExceptionDAO("SQL Error", ex);
                }
            }
        }
        return delivery_shippers;
    }

    @Override
    public Delivery_shippers select(Long id) throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Delivery_shippers delivery_shippers = null;
        try {
            statement = connection.prepareStatement(GETONE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                delivery_shippers = transform(resultSet);
            }else{
                throw new ExceptionDAO("Don't found that register");
            }
        }catch(SQLException ex){
            throw new ExceptionDAO("SQL Error", ex);
        }finally{
            if (resultSet != null){
                try {
                    resultSet.close();
                }catch (SQLException ex){
                    new ExceptionDAO("SQL Error", ex);
                }
            }
            if (statement != null){
                try {
                    statement.close();
                }catch (SQLException ex){
                    new ExceptionDAO("SQL Error", ex);
                }
            }
        }
        return delivery_shippers;
    }
}
