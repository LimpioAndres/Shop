package com.solvd.shop.dao;

public interface IServiceDAO {

    ICategoriesDAO getCategoriesDAO();
    IClientsDAO getClientsDAO();
    IDelivery_shippersDAO getDelivery_shippersDAO();
    IDeliveryDAO getDeliveryDAO();
    IDetail_ordersDAO getDetail_ordersDAO();
    IEmployeesDAO getEmployeesDAO();
    IInventoryDAO getInvetoryDAO();
    IOfficesDAO getOfficesDAO();
    IOrdersDAO getOrdersDAO();
    IPaymentsDAO getPaymentsDAO();
    IProductsDAO getProductsDAO();
    IShippersDAO getShippersDAO();
    ISuppliersDAO getSuppliersDAO();

}
