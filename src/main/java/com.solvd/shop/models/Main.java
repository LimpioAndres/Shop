package com.solvd.shop.models;

import java.sql.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Main{
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[]args){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shop","root","admin");

            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from clients");

            while(resultSet.next())
                LOGGER.info(resultSet.getInt(1)+"  "+resultSet.getString(2)+
                        "  "+resultSet.getString(3)+"  "+resultSet.getString(4)+
                        "  "+resultSet.getString(5)+"  "+resultSet.getString(6));
                connection.close();
        }catch(Exception e){
            LOGGER.info(e);
        }
    }
}

