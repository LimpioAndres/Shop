package com.solvd.shop.dao.mysql;

import com.solvd.shop.dao.ISuppliersDAO;
import com.solvd.shop.models.Offices;
import com.solvd.shop.models.Suppliers;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SuppliersDAO extends MySQLDAO implements ISuppliersDAO {

    private final static String INSERT = "INSERT INTO suppliers(idSuppliers, company_name_suppliers, email_suppliers, phone_suppliers, contact_suppliers) VALUES(?, ?, ?, ?, ?)";

    private final static String UPDATE = "UPDATE suppliers SET company_name_suppliers = ?, email_suppliers = ?, phone_suppliers = ?, contact_suppliers = ? WHERE idSuppliers = ?";

    private final static String DELETE = "DELETE FROM suppliers WHERE idSuppliers = ?";

    private final static String GETALL = "SELECT idSuppliers, company_name_suppliers, email_suppliers, phone_suppliers, contact_suppliers FROM suppliers";

    private final static String GETONE = "SELECT idSuppliers, company_name_suppliers, email_suppliers, phone_suppliers, contact_suppliers FROM suppliers WHERE idSuppliers = ?";
    private Connection connection;

    public SuppliersDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public void create(Suppliers a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdSuppliers());
            statement.setString(2, a.getCompany_name_suppliers());
            statement.setString(3, a.getEmail_suppliers());
            statement.setString(4, a.getPhone_suppliers());
            statement.setString(5, a.getContact_suppliers());
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
    public void update(Suppliers a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, a.getCompany_name_suppliers());
            statement.setString(2, a.getEmail_suppliers());
            statement.setString(3, a.getPhone_suppliers());
            statement.setString(4, a.getContact_suppliers());
            statement.setLong(5, a.getIdSuppliers());
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
    public void remove(Suppliers a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(DELETE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdSuppliers());
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

    private Suppliers transform (ResultSet resultSet) throws SQLException{
        String companyName = resultSet.getString("company_name_suppliers");
        String email = resultSet.getString("email_suppliers");
        String phone = resultSet.getString("phone_suppliers");
        String contact = resultSet.getString("contact_suppliers");

        Suppliers suppliers = new Suppliers(companyName, email, phone, contact);
        suppliers.setIdSuppliers(resultSet.getLong("idSuppliers"));

        return suppliers;
    }

    @Override
    public List<Suppliers> selectAll() throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List <Suppliers> suppliers = new ArrayList<>();
        try {
            statement = connection.prepareStatement(GETALL, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                suppliers.add(transform(resultSet));
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
        return suppliers;
    }

    @Override
    public Suppliers select(Long id) throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Suppliers suppliers = null;
        try {
            statement = connection.prepareStatement(GETONE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                suppliers = transform(resultSet);
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
        return suppliers;
    }
}
