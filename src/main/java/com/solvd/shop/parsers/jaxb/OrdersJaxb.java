package com.solvd.shop.parsers.jaxb;

import com.solvd.shop.models.Clients;
import com.solvd.shop.models.Employees;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement (name = "ordersM")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrdersJaxb {

    @XmlAttribute (name = "idOrders")
    private Long idOrders;

    @XmlElement (name = "amount_orders")
    private Double amount_orders;

    @XmlElement(name = "date_orders", required = true)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date date_orders;

    @XmlElementWrapper(name = "clients")
    @XmlElement(name = "client")
    private List<Clients> clients;

    @XmlElement (name = "employees")
    private Employees employees;

    @XmlElement (name = "idDelivery")
    private Long idDelivery;

    public OrdersJaxb() {
    }

    public OrdersJaxb(Long idOrders, Double amount_orders, Date date_orders, Employees employees, Long idDelivery) {
        this.idOrders = idOrders;
        this.amount_orders = amount_orders;
        this.date_orders = date_orders;
        this.employees = employees;
        this.idDelivery = idDelivery;
        this.clients = new ArrayList<Clients>();
    }

    public void addClients(Clients c){
        this.clients.add(c);
    }

    public Long getIdOrders() {
        return idOrders;
    }

    public void setIdOrders(Long idOrders) {
        this.idOrders = idOrders;
    }

    public Double getAmount_orders() {
        return amount_orders;
    }

    public void setAmount_orders(Double amount_orders) {
        this.amount_orders = amount_orders;
    }

    public Date getDate_orders() {
        return date_orders;
    }

    public void setDate_orders(Date date_orders) {
        this.date_orders = date_orders;
    }

    public List<Clients> getClients() {
        return clients;
    }

    public void setClients(List<Clients> clients) {
        this.clients = clients;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Long getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(Long idDelivery) {
        this.idDelivery = idDelivery;
    }

    @Override
    public String toString() {
        return "OrdersJaxb{" +
                "idOrders=" + idOrders +
                ", amount_orders=" + amount_orders +
                ", date_orders=" + date_orders +
                ", clients=" + clients +
                ", employees=" + employees +
                ", idDelivery=" + idDelivery +
                '}';
    }
}
