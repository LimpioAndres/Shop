package com.solvd.shop.dao.mysql;

import com.solvd.shop.dao.IEmployeesDAO;
import com.solvd.shop.models.Employees;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO extends MySQLDAO implements IEmployeesDAO {

    private final static String INSERT = "INSERT INTO employees(name_employees, last_name_employees, age_employees, phone_employees, email_employees, salary_employees, idOffices) VALUES(?, ?, ?, ?, ?, ?, ?)";

    private final static String UPDATE = "UPDATE employees SET name_employees = ?, last_name_employees = ?, age_employees = ?, phone_employees = ?, email_employees = ?, salary_employees = ?, idOffices = ? WHERE idEmployees = ?";

    private final static String DELETE = "DELETE FROM employees WHERE idEmployees = ?";

    private final static String GETALL = "SELECT idEmployees, name_employees, last_name_employees, age_employees, phone_employees, email_employees, salary_employees, idOffices FROM employees";

    private final static String GETONE = "SELECT idEmployees,name_employees, last_name_employees, age_employees, phone_employees, email_employees, salary_employees, idOffices FROM employees WHERE idEmployees = ?";

    private Connection connection;
    public EmployeesDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public void create(Employees a) throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, a.getName_employees());
            statement.setString(2, a.getLast_name_employees());
            statement.setInt(3, a.getAge_employees());
            statement.setString(4, a.getPhone_employees());
            statement.setString(5, a.getEmail_employees());
            statement.setDouble(6, a.getSalary_employees());
            statement.setLong(7, a.getIdOffices());
            if(statement.executeUpdate() == 0){
                throw new ExceptionDAO("Maybe the changes haven't been saved");
            }
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                a.setIdEmployees(resultSet.getLong(1));
            }else{
                throw new ExceptionDAO("Can't be possible add a ID to this client");
            }
        }catch (SQLException ex){
            throw new ExceptionDAO("SQL Error", ex);
        }finally{
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    new ExceptionDAO("SQL Error", ex);
                }
            }
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
    public void update(Employees a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(UPDATE,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, a.getName_employees());
            statement.setString(2, a.getLast_name_employees());
            statement.setInt(3, a.getAge_employees());
            statement.setString(4, a.getPhone_employees());
            statement.setString(5, a.getEmail_employees());
            statement.setDouble(6, a.getSalary_employees());
            statement.setLong(7, a.getIdOffices());
            statement.setLong(8, a.getIdEmployees());
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
    public void remove(Employees a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(DELETE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdEmployees());
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

    private Employees transform (ResultSet resultSet) throws SQLException{
        String name = resultSet.getString("name_employees");
        String lastName = resultSet.getString("last_name_employees");
        Integer age = resultSet.getInt("age_employees");
        String phone = resultSet.getString("phone_employees");
        String email = resultSet.getString("email_employees");
        Double salary = resultSet.getDouble("salary_employees");
        Long offices = resultSet.getLong("idOffices");

        Employees employees = new Employees(name, lastName, age, phone, email, salary, offices);
        employees.setIdEmployees(resultSet.getLong("idEmployees"));

        return employees;
    }

    @Override
    public List<Employees> selectAll() throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List <Employees> employees = new ArrayList<>();
        try {
            statement = connection.prepareStatement(GETALL, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                employees.add(transform(resultSet));
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
        return employees;
    }

    @Override
    public Employees select(Long id) throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Employees employees = null;
        try {
            statement = connection.prepareStatement(GETONE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                employees = transform(resultSet);
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
        return employees;
    }
}
