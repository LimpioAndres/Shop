package com.solvd.shop.dao.mysql;

import com.solvd.shop.dao.IDetail_ordersDAO;
import com.solvd.shop.models.Detail_orders;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Detail_ordersDAO extends MySQLDAO implements IDetail_ordersDAO {

    private final static String INSERT = "INSERT INTO detail_orders(idDetail_orders, idOrders, idProducts) VALUES(?, ?, ?)";

    private final static String UPDATE = "UPDATE detail_orders SET idOrders = ?, idProducts = ? WHERE idDetail_orders = ?";

    private final static String DELETE = "DELETE FROM detail_orders WHERE idDetail_orders = ?";

    private final static String GETALL = "SELECT idDetail_orders, idOrders, idProducts FROM detail_orders";

    private final static String GETONE = "SELECT idDetail_orders, idOrders, idProducts FROM detail_orders WHERE idDetail_orders = ?";

    private Connection connection;

    public Detail_ordersDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public void create(Detail_orders a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdDetail_orders());
            statement.setLong(2, a.getIdOrders());
            statement.setLong(3, a.getIdProducts());
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
    public void update(Detail_orders a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdOrders());
            statement.setLong(2, a.getIdProducts());
            statement.setLong(3, a.getIdDetail_orders());
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
    public void remove(Detail_orders a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(DELETE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdDetail_orders());
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

    private Detail_orders transform (ResultSet resultSet) throws SQLException{
        Long idOrders = resultSet.getLong("idOrders");
        Long idProducts = resultSet.getLong("idProducts");

        Detail_orders detailOrders = new Detail_orders(idOrders, idProducts);
        detailOrders.setIdDetail_orders(resultSet.getLong("idDetail_orders"));

        return detailOrders;
    }

    @Override
    public List<Detail_orders> selectAll() throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List <Detail_orders> detailOrders = new ArrayList<>();
        try {
            statement = connection.prepareStatement(GETALL, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                detailOrders.add(transform(resultSet));
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
        return detailOrders;
    }

    @Override
    public Detail_orders select(Long id) throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Detail_orders detailOrders = null;
        try {
            statement = connection.prepareStatement(GETONE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                detailOrders = transform(resultSet);
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
        return detailOrders;
    }
}
