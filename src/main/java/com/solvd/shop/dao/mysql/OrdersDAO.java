package com.solvd.shop.dao.mysql;

import com.solvd.shop.dao.IOrdersDAO;
import com.solvd.shop.models.Offices;
import com.solvd.shop.models.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO extends MySQLDAO implements IOrdersDAO {

    private final static String INSERT = "INSERT INTO orders(idOrders, amount_orders, date_orders, idClients, idEmployees, idDelivery) VALUES(?, ?, ?, ?, ?, ?)";

    private final static String UPDATE = "UPDATE orders SET amount_orders = ?, date_orders = ?, idClients = ?, idEmployees = ?, idDelivery = ? WHERE idOrders = ?";

    private final static String DELETE = "DELETE FROM orders WHERE idOrders = ?";

    private final static String GETALL = "SELECT idOrders, amount_orders, date_orders, idClients, idEmployees, idDelivery FROM orders";

    private final static String GETONE = "SELECT idOrders, amount_orders, date_orders, idClients, idEmployees, idDelivery FROM orders WHERE idOrders = ?";
    private Connection connection;

    public OrdersDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public void create(Orders a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdOrders());
            statement.setDouble(2, a.getAmount_orders());
            statement.setDate(3, new Date(a.getDate_orders().getTime()));
            statement.setLong(4, a.getIdClients());
            statement.setLong(5, a.getIdEmployees());
            statement.setLong(6, a.getIdDelivery());
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
    public void update(Orders a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
            statement.setDouble(1, a.getAmount_orders());
            statement.setDate(2, new Date(a.getDate_orders().getTime()));
            statement.setLong(3, a.getIdClients());
            statement.setLong(4, a.getIdEmployees());
            statement.setLong(5, a.getIdDelivery());
            statement.setLong(6, a.getIdOrders());
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
    public void remove(Orders a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(DELETE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdOrders());
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

    private Orders transform (ResultSet resultSet) throws SQLException{
        Double amount = resultSet.getDouble("amount_orders");
        Date department = resultSet.getDate("date_orders");
        Long idClients = resultSet.getLong("idClients");
        Long idEmployees = resultSet.getLong("idEmployees");
        Long idDelivery = resultSet.getLong("idDelivery");

        Orders orders = new Orders(amount, department, idClients, idEmployees, idDelivery);
        orders.setIdOrders(resultSet.getLong("idOrders"));

        return orders;
    }

    @Override
    public List<Orders> selectAll() throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List <Orders> orders = new ArrayList<>();
        try {
            statement = connection.prepareStatement(GETALL, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                orders.add(transform(resultSet));
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
        return orders;
    }

    @Override
    public Orders select(Long id) throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Orders orders = null;
        try {
            statement = connection.prepareStatement(GETONE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                orders = transform(resultSet);
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
        return orders;
    }
}
