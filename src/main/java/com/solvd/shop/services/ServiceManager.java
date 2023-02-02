
package com.solvd.shop.services;

import com.solvd.shop.dao.*;
import com.solvd.shop.dao.mysql.*;
import com.solvd.shop.models.Clients;
import com.solvd.shop.models.Employees;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ServiceManager implements IServiceDAO {

    private Connection connection;

    ICategoriesDAO categories = null;
    IClientsDAO clients = null;
    IDelivery_shippersDAO delivery_shippers = null;
    IDeliveryDAO delivery = null;
    IDetail_ordersDAO detail_orders = null;
    IEmployeesDAO employees = null;
    IInventoryDAO inventory = null;
    IOfficesDAO offices = null;
    IOrdersDAO orders = null;
    IPaymentsDAO payments = null;
    IProductsDAO products = null;
    IShippersDAO shippers = null;
    ISuppliersDAO suppliers = null;

    public ServiceManager(String host,  String username, String password, String database) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, username , password);
    }

    @Override
    public ICategoriesDAO getCategoriesDAO() {
        if (categories == null){
            categories = new CategoriesDAO(connection);
        }
        return categories;
    }

    @Override
    public IClientsDAO getClientsDAO() {
        if (clients == null){
            clients = new ClientsDAO(connection);
        }
        return clients;
    }

    @Override
    public IDelivery_shippersDAO getDelivery_shippersDAO() {
        if (delivery_shippers == null){
            delivery_shippers = new Delivery_shippersDAO(connection);
        }
        return delivery_shippers;
    }

    @Override
    public IDeliveryDAO getDeliveryDAO() {
        if (delivery == null){
            delivery = new DeliveryDAO(connection);
        }
        return delivery;
    }

    @Override
    public IDetail_ordersDAO getDetail_ordersDAO() {
        if (detail_orders == null){
            detail_orders = new Detail_ordersDAO(connection);
        }
        return detail_orders;
    }

    @Override
    public IEmployeesDAO getEmployeesDAO() {
        if (employees == null){
            employees = new EmployeesDAO(connection);
        }
        return employees;
    }

    @Override
    public IInventoryDAO getInvetoryDAO() {
        if (inventory == null){
            inventory = new InventoryDAO(connection);
        }
        return inventory;
    }

    @Override
    public IOfficesDAO getOfficesDAO() {
        if (offices == null){
            offices = new OfficesDAO(connection);
        }
        return offices;
    }

    @Override
    public IOrdersDAO getOrdersDAO() {
        if (orders == null){
            orders = new OrdersDAO(connection);
        }
        return orders;
    }

    @Override
    public IPaymentsDAO getPaymentsDAO() {
        if (payments == null){
            payments = new PaymentsDAO(connection);
        }
        return payments;
    }

    @Override
    public IProductsDAO getProductsDAO() {
        if (products == null){
            products = new ProductsDAO(connection);
        }
        return products;
    }

    @Override
    public IShippersDAO getShippersDAO() {
        if (shippers == null){
            shippers = new ShippersDAO(connection);
        }
        return shippers;
    }

    @Override
    public ISuppliersDAO getSuppliersDAO() {
        if (suppliers == null){
            suppliers = new SuppliersDAO(connection);
        }
        return suppliers;
    }

    private static final Logger LOGGER = LogManager.getLogger(ServiceManager.class);

    public static void main(String[] args) throws  SQLException, ExceptionDAO {

        ServiceManager serviceManager = new ServiceManager("localhost:3306", "root", "admin", "shop");
        List<Clients> clients = serviceManager.getClientsDAO().selectAll();
        for(Clients print : clients){
            LOGGER.info(print);
        }

        LOGGER.info("\n");

        List<Employees> employees = serviceManager.getEmployeesDAO().selectAll();
        for(Employees printE : employees){
            LOGGER.info(printE);
        }
    }
}
