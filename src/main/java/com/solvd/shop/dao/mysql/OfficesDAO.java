package com.solvd.shop.dao.mysql;

import com.solvd.shop.dao.IOfficesDAO;
import com.solvd.shop.models.Offices;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OfficesDAO extends MySQLDAO implements IOfficesDAO {

    private final static String INSERT = "INSERT INTO offices(idOffices, name_offices, department, manager) VALUES(?, ?, ?, ?)";

    private final static String UPDATE = "UPDATE offices SET name_offices = ?, department = ?, manager = ? WHERE idOffices = ?";

    private final static String DELETE = "DELETE FROM offices WHERE idOffices = ?";

    private final static String GETALL = "SELECT idOffices, name_offices, department, manager FROM offices";

    private final static String GETONE = "SELECT idOffices, name_offices, department, manager FROM offices WHERE idOffices = ?";
    private Connection connection;

    public OfficesDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public void create(Offices a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdOffices());
            statement.setString(2, a.getName_offices());
            statement.setString(3, a.getDepartment());
            statement.setString(4, a.getManager());
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
    public void update(Offices a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, a.getName_offices());
            statement.setString(2, a.getDepartment());
            statement.setString(3, a.getManager());
            statement.setLong(4, a.getIdOffices());
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
    public void remove(Offices a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(DELETE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdOffices());
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

    private Offices transform (ResultSet resultSet) throws SQLException{
        String name = resultSet.getString("name_offices");
        String department = resultSet.getString("department");
        String manager = resultSet.getString("manager");

       Offices offices = new Offices(name, department, manager);
        offices.setIdOffices(resultSet.getLong("idOffices"));

        return offices;
    }

    @Override
    public List<Offices> selectAll() throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List <Offices> offices = new ArrayList<>();
        try {
            statement = connection.prepareStatement(GETALL, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                offices.add(transform(resultSet));
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
        return offices;
    }

    @Override
    public Offices select(Long id) throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Offices offices = null;
        try {
            statement = connection.prepareStatement(GETONE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                offices = transform(resultSet);
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
        return offices;
    }
}
