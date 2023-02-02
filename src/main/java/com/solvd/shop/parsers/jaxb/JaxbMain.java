package com.solvd.shop.parsers.jaxb;


import com.solvd.shop.models.Clients;
import com.solvd.shop.models.Employees;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.Date;


public class JaxbMain {

    private static final Logger LOGGER = LogManager.getLogger(JaxbMain.class);

    public static void main(String[] args) throws JAXBException{

        Employees employees = new Employees(2L, "Maria", "Maso", 35, "4234776890", "mmaso.laba@solvd.com", 4000.0, 18481L);
        Clients client = new Clients(9L, "Abel", "Illieri", 18, "8987701147", "aillieri.laba@solvd.com");

        OrdersJaxb ordersJaxb = new OrdersJaxb(6577L, 5118.5, new Date(2023-01-31), employees, 202027L);
        ordersJaxb.addClients(client);


            JAXBContext jaxbContext = JAXBContext.newInstance(OrdersJaxb.class);

           /* //Marshall
            Marshaller marshall = jaxbContext.createMarshaller();
            marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshall.marshal(ordersJaxb, new File("C:/Users/gatm_/Desktop/SOLVD/shop/src/main/resources/jaxb/ordersM.xml"));
            LOGGER.info("Marshall Done"); */

            //Unmarshall
            Unmarshaller unmarshall = jaxbContext.createUnmarshaller();
            OrdersJaxb object = (OrdersJaxb) unmarshall.unmarshal(new File("C:/Users/gatm_/Desktop/SOLVD/shop/src/main/resources/jaxb/ordersM.xml"));
            LOGGER.info("Unmarshall Done");
            LOGGER.info(object.getClients());
            LOGGER.info("\n" + object.getEmployees());

    }
}
