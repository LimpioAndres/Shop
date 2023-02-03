package com.solvd.shop.parsers.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.shop.models.Clients;
import com.solvd.shop.models.Employees;
import com.solvd.shop.parsers.OrdersParsers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.sql.Date;


public class JacksonMain {

    private static OrdersParsers createOrder(){


        Employees employees = new Employees(2L, "Maria", "Maso", 35, "4234776890", "mmaso.laba@solvd.com", 4000.0, 18481L);
        Clients client = new Clients(9L, "Abel", "Illieri", 18, "8987701147", "aillieri.laba@solvd.com");

        OrdersParsers ordersJackson = new OrdersParsers(6577L, 5118.5, new Date(2023-12-31), employees, 202027L);
        ordersJackson.addClients(client);

        return ordersJackson;
    }

    private static final Logger LOGGER = LogManager.getLogger(JacksonMain.class);

    public static void main(String[] args){

        ObjectMapper objectMapper = new ObjectMapper();
        String route = "C:/Users/gatm_/Desktop/SOLVD/shop/src/main/resources/JSON/ordersP.json";
        OrdersParsers ordersParsers = createOrder();

   /*    //Java Objects to JSON
        try{

            objectMapper.writeValue(new File(route), ordersParsers);
            String printer = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(ordersParsers);

            LOGGER.info(printer);

        }catch(IOException e){
            e.printStackTrace();
        }
*/
        //JSON to Java Objects
        try{

           OrdersParsers orders = objectMapper.readValue(new File(route), OrdersParsers.class);
           String jsonInString = "{\"date_orders\":\"2023-12-31\",\"idOrders\":6577,\"amount_orders\":5118.5,\"client\":[{\"idClients\":9,\"name_clients\":\"Abel\",\"last_name_clients\":\"Illieri\",\"age_clients\":18,\"phone_clients\":\"8987701147\",\"email_clients\":\"aillieri.laba@solvd.com\"}],\"employees\":{\"idEmployees\":2,\"name_employees\":\"Maria\",\"last_name_employees\":\"Maso\",\"age_employees\":35,\"phone_employees\":\"4234776890\",\"email_employees\":\"mmaso.laba@solvd.com\",\"salary_employees\":4000.0,\"idOffices\":18481},\"idDelivery\":202027}";
           OrdersParsers ordersP = objectMapper.readValue(jsonInString, OrdersParsers.class);

           String reader = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(ordersP);
           LOGGER.info(reader);

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
