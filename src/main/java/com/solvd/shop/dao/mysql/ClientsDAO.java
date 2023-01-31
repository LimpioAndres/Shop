package com.solvd.shop.dao.mysql;

import com.solvd.shop.dao.IClientsDAO;
import com.solvd.shop.models.Clients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientsDAO extends MySQLDAO implements IClientsDAO {

    private final static String INSERT = "INSERT INTO clients(name_clients, last_name_clients, age_clients, phone_clients, email_clients) VALUES(?, ?, ?, ?, ?)";

    private final static String UPDATE = "UPDATE clients SET name_clients = ?, last_name_clients = ?, age_clients = ?, phone_clients = ?, email_clients = ? WHERE idClients = ?";

    private final static String DELETE = "DELETE FROM clients WHERE idClients = ?";

    private final static String GETALL = "SELECT idClients, name_clients, last_name_clients, age_clients, phone_clients, email_clients FROM clients";

    private final static String GETONE = "SELECT idClients, name_clients, last_name_clients, age_clients, phone_clients, email_clients FROM clients WHERE idClients = ?";

   private Connection connection;
   public ClientsDAO(Connection connection){
       this.connection = connection;
   }


    @Override
    public void create(Clients a) throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, a.getName_clients());
            statement.setString(2, a.getLast_name_clients());
            statement.setInt(3, a.getAge_clients());
            statement.setString(4, a.getPhone_clients());
            statement.setString(5, a.getEmail_clients());
                if(statement.executeUpdate() == 0){
                    throw new ExceptionDAO("Maybe the changes haven't been saved");
                }
                resultSet = statement.getGeneratedKeys();
                if(resultSet.next()){
                    a.setIdClients(resultSet.getLong(1));
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
    public void update(Clients a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(UPDATE,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, a.getName_clients());
            statement.setString(2, a.getLast_name_clients());
            statement.setInt(3, a.getAge_clients());
            statement.setString(4, a.getPhone_clients());
            statement.setString(5, a.getEmail_clients());
            statement.setLong(6, a.getIdClients());
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
    public void remove(Clients a) throws ExceptionDAO{
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(DELETE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, a.getIdClients());
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

    private Clients transform (ResultSet resultSet) throws SQLException{
        String name = resultSet.getString("name_clients");
        String lastName = resultSet.getString("last_name_clients");
        Integer age = resultSet.getInt("age_clients");
        String phone = resultSet.getString("phone_clients");
        String email = resultSet.getString("email_clients");

        Clients clients = new Clients(name, lastName, age, phone, email);
        clients.setIdClients(resultSet.getLong("idClients"));

        return clients;
    }

    @Override
    public List<Clients> selectAll() throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List <Clients> clients = new ArrayList<>();
        try {
            statement = connection.prepareStatement(GETALL, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                clients.add(transform(resultSet));
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
        return clients;
    }

    @Override
    public Clients select(Long id) throws ExceptionDAO{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Clients clients = null;
            try {
                statement = connection.prepareStatement(GETONE, Statement.RETURN_GENERATED_KEYS);
                statement.setLong(1, id);
                resultSet = statement.executeQuery();
                if(resultSet.next()){
                    clients = transform(resultSet);
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
            return clients;
    }
    private static final Logger LOGGER = LogManager.getLogger(ClientsDAO.class);
    public static void main(String[] args) throws SQLException, ExceptionDAO{
       Connection connection = null;
       try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","admin");
            IClientsDAO dao = new ClientsDAO(connection);

           /*//-------- Adding new data to my table  to test if this works --------
             Clients newClient = new Clients("Abel", "Illieri", 18, "8987701147", "aillieri.laba@solvd.com");
             dao.create(newClient);
             LOGGER.info("The client was generated with the ID " + newClient.getIdClients());*/

            List<Clients> clients = dao.selectAll();
            for (Clients c : clients){
                LOGGER.info(c.toString());
            }
       }finally{
           if (connection != null){
               connection.close();
           }
       }
    }
}
