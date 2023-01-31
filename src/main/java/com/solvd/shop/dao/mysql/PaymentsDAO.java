package com.solvd.shop.dao.mysql;

import com.solvd.shop.dao.IPaymentsDAO;
import com.solvd.shop.models.Offices;
import com.solvd.shop.models.Payments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentsDAO extends MySQLDAO implements IPaymentsDAO {

    private final static String INSERT = "INSERT INTO payments(id_payments, idOrders, amount_payments, date_payments) VALUES(?, ?, ?, ?)";

    private final static String UPDATE = "UPDATE payments SET idOrders = ?, amount_payments = ?, date_payments = ? WHERE id_payments = ?";

    private final static String DELETE = "DELETE FROM payments WHERE id_payments = ?";

    private final static String GETALL = "SELECT id_payments, idOrders, amount_payments, date_payments FROM payments";

    private final static String GETONE = "SELECT id_payments, idOrders, amount_payments, date_payments FROM payments WHERE id_payments = ?";
    private Connection connection;

    public PaymentsDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public void create(Payments a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getId_payments());
            statement.setLong(2, a.getIdOrders());
            statement.setDouble(3, a.getAmount_payments());
            statement.setDate(4, new Date((a.getDate_payments().getTime())));
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
    public void update(Payments a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdOrders());
            statement.setDouble(2, a.getAmount_payments());
            statement.setDate(3, new Date((a.getDate_payments().getTime())));
            statement.setLong(4, a.getId_payments());
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
    public void remove(Payments a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(DELETE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getId_payments());
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

    private Payments transform (ResultSet resultSet) throws SQLException{
        Long idOrders = resultSet.getLong("idOrders");
        Double amount = resultSet.getDouble("amount_payments");
        Date date = resultSet.getDate("date_payments");

        Payments payments = new Payments(idOrders, amount, date);
        payments.setId_payments(resultSet.getLong("id_payments"));

        return payments;
    }

    @Override
    public List<Payments> selectAll() throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List <Payments> payments = new ArrayList<>();
        try {
            statement = connection.prepareStatement(GETALL, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                payments.add(transform(resultSet));
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
        return payments;
    }

    @Override
    public Payments select(Long id) throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Payments payments = null;
        try {
            statement = connection.prepareStatement(GETONE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                payments = transform(resultSet);
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
        return payments;
    }
}
