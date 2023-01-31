package com.solvd.shop.dao.mysql;

import com.solvd.shop.dao.IProductsDAO;
import com.solvd.shop.models.Offices;
import com.solvd.shop.models.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsDAO extends MySQLDAO implements IProductsDAO {


    private final static String INSERT = "INSERT INTO products(idProducts, name_products, stock_inventory, price_sell_products, price_buy_products, idSuppliers, idCategories, idInventory) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

    private final static String UPDATE = "UPDATE products SET name_products = ?, stock_inventory = ?, price_sell_products = ?, price_buy_products = ?, idSuppliers = ?, idCategories = ?, idInventory = ? WHERE idProducts = ?";

    private final static String DELETE = "DELETE FROM products WHERE idProducts = ?";

    private final static String GETALL = "SELECT idProducts, name_products, stock_inventory, price_sell_products, price_buy_products, idSuppliers, idCategories, idInventory FROM products";

    private final static String GETONE = "SELECT idProducts, name_products, stock_inventory, price_sell_products, price_buy_products, idSuppliers, idCategories, idInventory FROM products WHERE idProducts = ?";
    private Connection connection;

    public ProductsDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public void create(Products a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdProducts());
            statement.setString(2, a.getName_products());
            statement.setInt(3, a.getStock_inventory());
            statement.setDouble(4, a.getPrice_sell_products());
            statement.setDouble(5, a.getPrice_buy_products());
            statement.setLong(6, a.getIdSuppliers());
            statement.setLong(7, a.getIdCategories());
            statement.setLong(8, a.getIdInventory());
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
    public void update(Products a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, a.getName_products());
            statement.setInt(2, a.getStock_inventory());
            statement.setDouble(3, a.getPrice_sell_products());
            statement.setDouble(4, a.getPrice_buy_products());
            statement.setLong(5, a.getIdSuppliers());
            statement.setLong(6, a.getIdCategories());
            statement.setLong(7, a.getIdInventory());
            statement.setLong(8, a.getIdProducts());
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
    public void remove(Products a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(DELETE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdProducts());
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

    private Products transform (ResultSet resultSet) throws SQLException{
        String name = resultSet.getString("name_products");
        Integer stock = resultSet.getInt("stock_inventory");
        Double priceSell = resultSet.getDouble("price_sell_products");
        Double priceBuy = resultSet.getDouble("price_buy_products");
        Long idSuppliers = resultSet.getLong("idSuppliers");
        Long idCategories = resultSet.getLong("idCategories");
        Long idInventory = resultSet.getLong("idInventory");

        Products products = new Products(name, stock, priceSell, priceBuy, idSuppliers, idCategories, idInventory);
        products.setIdProducts(resultSet.getLong("idOffices"));

        return products;
    }

    @Override
    public List<Products> selectAll() throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List <Products> products = new ArrayList<>();
        try {
            statement = connection.prepareStatement(GETALL, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                products.add(transform(resultSet));
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
        return products;
    }

    @Override
    public Products select(Long id) throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Products products = null;
        try {
            statement = connection.prepareStatement(GETONE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                products = transform(resultSet);
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
        return products;
    }
}
