package com.solvd.shop.dao.mysql;

import com.solvd.shop.dao.IInventoryDAO;
import com.solvd.shop.models.Inventory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAO extends MySQLDAO implements IInventoryDAO {

    private final static String INSERT = "INSERT INTO inventory(idInventory, stock_inventory, date_adquisition_inventory) VALUES(?, ?, ?)";

    private final static String UPDATE = "UPDATE inventory SET stock_inventory = ?, date_adquisition_inventory = ? WHERE idInventory = ?";

    private final static String DELETE = "DELETE FROM inventory WHERE idInventory = ?";

    private final static String GETALL = "SELECT idInventory, stock_inventory, date_adquisition_inventory FROM inventory";

    private final static String GETONE = "SELECT idInventory, stock_inventory, date_adquisition_inventory FROM inventory WHERE idInventory = ?";
    private Connection connection;

    public InventoryDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public void create(Inventory a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdInvetory());
            statement.setDouble(2, a.getStock_inventory());
            statement.setDate(3, new Date(a.getDate_adquisition_inventory().getTime()));
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
    public void update(Inventory a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
            statement.setDouble(1, a.getStock_inventory());
            statement.setDate(2, a.getDate_adquisition_inventory());
            statement.setLong(3, a.getIdInvetory());
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
    public void remove(Inventory a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(DELETE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdInvetory());
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

    private Inventory transform (ResultSet resultSet) throws SQLException{
        Double stockInventory = resultSet.getDouble("stock_inventory");
        Date dateAdquisition = resultSet.getDate("date_adquisition_inventory");

        Inventory inventory = new Inventory(stockInventory, dateAdquisition);
        inventory.setIdInvetory(resultSet.getLong("idInventory"));

        return inventory;
    }

    @Override
    public List<Inventory> selectAll() throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List <Inventory> inventory = new ArrayList<>();
        try {
            statement = connection.prepareStatement(GETALL, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                inventory.add(transform(resultSet));
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
        return inventory;
    }

    @Override
    public Inventory select(Long id) throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Inventory inventory = null;
        try {
            statement = connection.prepareStatement(GETONE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                inventory = transform(resultSet);
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
        return inventory;
    }
}
