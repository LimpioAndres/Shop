package com.solvd.shop.mybatis;

import com.solvd.shop.models.Clients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        ClientsService clientsService = new ClientsService();
        List<Clients> clients = clientsService.selectAll();
        LOGGER.info("Clients founded: \n" + clients);

    }
}
