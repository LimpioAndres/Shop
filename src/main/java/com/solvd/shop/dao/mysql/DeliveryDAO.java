package com.solvd.shop.dao.mysql;

import com.solvd.shop.dao.IDeliveryDAO;
import com.solvd.shop.models.Delivery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAO extends MySQLDAO implements IDeliveryDAO {

    private final static String INSERT = "INSERT INTO delivery(idDelivery, id_tracker_delivery, date_registered) VALUES(?, ?, ?)";

    private final static String UPDATE = "UPDATE delivery SET id_tracker_delivery = ?, date_registered = ? WHERE idDelivery = ?";

    private final static String DELETE = "DELETE FROM delivery WHERE idDelivery = ?";

    private final static String GETALL = "SELECT idDelivery, id_tracker_delivery, date_registered FROM delivery";

    private final static String GETONE = "SELECT idDelivery, id_tracker_delivery, date_registered FROM delivery WHERE idDelivery = ?";

    private Connection connection;

    public DeliveryDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public void create(Delivery a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdDelivery());
            statement.setString(2, a.getId_tracker_delivery());
            statement.setDate(3, new Date(a.getDate_registered().getTime()));
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
    public void update(Delivery a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, a.getId_tracker_delivery());
            statement.setDate(2, a.getDate_registered());
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
    public void remove(Delivery a) throws ExceptionDAO{
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

    private Delivery transform (ResultSet resultSet) throws SQLException{
        String idTracker = resultSet.getString("id_tracker_delivery");
        Date dateRegistered = resultSet.getDate("date_registered");

        Delivery delivery = new Delivery(idTracker, dateRegistered);
        delivery.setIdDelivery(resultSet.getLong("idDelivery"));

        return delivery;
    }

    @Override
    public List<Delivery> selectAll() throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List <Delivery> delivery = new ArrayList<>();
        try {
            statement = connection.prepareStatement(GETALL, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                delivery.add(transform(resultSet));
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
        return delivery;
    }

    @Override
    public Delivery select(Long id) throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Delivery delivery = null;
        try {
            statement = connection.prepareStatement(GETONE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                delivery = transform(resultSet);
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
        return delivery;
    }
}
