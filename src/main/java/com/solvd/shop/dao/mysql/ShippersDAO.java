package com.solvd.shop.dao.mysql;

import com.solvd.shop.dao.IShippersDAO;
import com.solvd.shop.models.Shippers;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShippersDAO extends MySQLDAO implements IShippersDAO {


    private final static String INSERT = "INSERT INTO shippers(idShippers, company_name_shippers) VALUES(?, ?)";

    private final static String UPDATE = "UPDATE shippers SET company_name_shippers = ? WHERE idShippers = ?";

    private final static String DELETE = "DELETE FROM shippers WHERE idShippers = ?";

    private final static String GETALL = "SELECT idShippers, company_name_shippers FROM shippers";

    private final static String GETONE = "SELECT idShippers, company_name_shippers FROM shippers WHERE idShippers = ?";
    private Connection connection;

    public ShippersDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public void create(Shippers a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdShippers());
            statement.setString(2, a.getCompany_name_shippers());
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
    public void update(Shippers a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, a.getCompany_name_shippers());
            statement.setLong(2, a.getIdShippers());
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
    public void remove(Shippers a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(DELETE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdShippers());
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

    private Shippers transform (ResultSet resultSet) throws SQLException{
        String companyName = resultSet.getString("company_name_shippers");

        Shippers shippers = new Shippers(companyName);
        shippers.setIdShippers(resultSet.getLong("idShippers"));

        return shippers;
    }

    @Override
    public List<Shippers> selectAll() throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List <Shippers> shippers = new ArrayList<>();
        try {
            statement = connection.prepareStatement(GETALL, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                shippers.add(transform(resultSet));
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
        return shippers;
    }

    @Override
    public Shippers select(Long id) throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Shippers shippers = null;
        try {
            statement = connection.prepareStatement(GETONE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                shippers = transform(resultSet);
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
        return shippers;
    }
}
