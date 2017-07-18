package cn.edu.zucc.northwind.model;

/**
 * Created by Administrator on 2017/7/18 0018.
 */
public class OrderDetails {
    private int OrderID;
    private int ProductID;
    private double UnitPrice;
    private int Quantity;
    private double Discount;

    public OrderDetails(){}
    public OrderDetails(int orderID,int productID,double uniteprice,int quantity){
        OrderID = orderID;
        ProductID = productID;
        UnitPrice = uniteprice;
        Quantity = quantity;
    }
    public String toString(){
        return (OrderID+" "+ProductID+" "+UnitPrice+" "+Quantity);
    }
    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double discount) {
        Discount = discount;
    }
}
