package com.solvd.shop.dao.mysql;

import com.solvd.shop.dao.ICategoriesDAO;
import com.solvd.shop.models.Categories;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAO extends MySQLDAO implements ICategoriesDAO {

    private final static String INSERT = "INSERT INTO categories(idCategories, name_categories, description_categories) VALUES(?, ?, ?)";

    private final static String UPDATE = "UPDATE categories SET name_categories = ?, description_categories = ? WHERE idCategories = ?";

    private final static String DELETE = "DELETE FROM categories WHERE idCategories = ?";

    private final static String GETALL = "SELECT idCategories, name_categories, description_categories FROM categories";

    private final static String GETONE = "SELECT idCategories, name_categories, description_categories FROM categories WHERE idCategories = ?";

    private Connection connection;

    public CategoriesDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public void create(Categories a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdCategories());
            statement.setString(2, a.getName_categories());
            statement.setString(3, a.getDescription_categories());
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
    public void update(Categories a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, a.getName_categories());
            statement.setString(2, a.getDescription_categories());
            statement.setLong(3, a.getIdCategories());
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
    public void remove(Categories a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(DELETE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdCategories());
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

    private Categories transform (ResultSet resultSet) throws SQLException{
        String name = resultSet.getString("name_categories");
        String description = resultSet.getString("description_categories");

        Categories categories = new Categories(name, description);
        categories.setIdCategories(resultSet.getLong("idCategories"));

        return categories;
    }

    @Override
    public List<Categories> selectAll() throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List <Categories> categories = new ArrayList<>();
        try {
            statement = connection.prepareStatement(GETALL, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                categories.add(transform(resultSet));
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
        return categories;
    }

    @Override
    public Categories select(Long id) throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Categories categories = null;
        try {
            statement = connection.prepareStatement(GETONE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                categories = transform(resultSet);
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
        return categories;
    }

    private static final Logger LOGGER = LogManager.getLogger(CategoriesDAO.class);

    public static void main(String[] args) throws SQLException, ExceptionDAO{
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "admin");
            ICategoriesDAO dao = new CategoriesDAO(connection);

            /*// -------- Adding new data to my table  to test if this works --------
            Categories newCategories = new Categories("Charms 6mm", "Charms, Chains, Bracelets");
             newCategories.setIdCategories(5L);
             dao.create(newCategories);
             LOGGER.info("The client was generated with the ID " + newCategories.getIdCategories());*/

            List<Categories> categories = dao.selectAll();
            for (Categories c : categories) {
                LOGGER.info(c.toString());
            }
        }finally{
            if (connection != null){
                connection.close();
            }
        }
    }
}
