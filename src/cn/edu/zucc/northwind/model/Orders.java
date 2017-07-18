package cn.edu.zucc.northwind.model;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.sql.Date;

/**
 * Created by Administrator on 2017/7/18 0018.
 */
public class Orders {
    private int OrderID;
    private String CustomerID;
    private String EmployeeID;
    private Date OrderDate;
    private Date RequiredDate;
    private Date ShippedDate;
    private int ShipVia;
    private double Freight;
    private String ShipName;
    private String ShipAddress;
    private String ShipCity;
    private String ShipRegion;
    private String ShipPostalCode;
    private String ShipCountry;

    public Orders(){

    }
    public Orders(String CustomerID){
        this.CustomerID = CustomerID;
    }

    public String toString(){
        return (OrderID+" "+CustomerID+" "+EmployeeID);
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }

    public Date getRequiredDate() {
        return RequiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        RequiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return ShippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        ShippedDate = shippedDate;
    }

    public int getShipVia() {
        return ShipVia;
    }

    public void setShipVia(int shipVia) {
        ShipVia = shipVia;
    }

    public double getFreight() {
        return Freight;
    }

    public void setFreight(double freight) {
        Freight = freight;
    }

    public String getShipName() {
        return ShipName;
    }

    public void setShipName(String shipName) {
        ShipName = shipName;
    }

    public String getShipAddress() {
        return ShipAddress;
    }

    public void setShipAddress(String shipAddress) {
        ShipAddress = shipAddress;
    }

    public String getShipCity() {
        return ShipCity;
    }

    public void setShipCity(String shipCity) {
        ShipCity = shipCity;
    }

    public String getShipRegion() {
        return ShipRegion;
    }

    public void setShipRegion(String shipRegion) {
        ShipRegion = shipRegion;
    }

    public String getShipPostalCode() {
        return ShipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        ShipPostalCode = shipPostalCode;
    }

    public String getShipCountry() {
        return ShipCountry;
    }

    public void setShipCountry(String shipCountry) {
        ShipCountry = shipCountry;
    }
}
