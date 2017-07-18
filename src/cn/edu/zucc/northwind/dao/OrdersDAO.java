package cn.edu.zucc.northwind.dao;

import cn.edu.zucc.northwind.model.Orders;
import cn.edu.zucc.northwind.util.BaseException;
import cn.edu.zucc.northwind.util.DBUtil;
import cn.edu.zucc.northwind.util.DbException;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/18 0018.
 */
public class OrdersDAO implements IOrdersDAO {
    @Override//创建订单
    public void createOrder(Orders order) throws BaseException {
        try {
            String sql = "insert into orders values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Connection conn = DBUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,order.getOrderID());
            pst.setString(2,order.getCustomerID());
            pst.setString(3,order.getEmployeeID());
            pst.setDate(4,order.getOrderDate());
            pst.setDate(5,order.getRequiredDate());
            pst.setDate(6,order.getShippedDate());
            pst.setInt(7,order.getShipVia());
            pst.setDouble(8,order.getFreight());
            pst.setString(9,order.getShipName());
            pst.setString(10,order.getShipAddress());
            pst.setString(11,order.getShipCity());
            pst.setString(12,order.getShipRegion());
            pst.setString(13,order.getShipPostalCode());
            pst.setString(14,order.getShipCountry());
            pst.execute();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override//修改订单信息
    public void modifyOrder(Orders order) throws BaseException {
        try {
            String sql = "update orders set OrderID=?,CustomerID=?,EmployeeID=?,OrderDate=?,RequiredDate=?,ShippedDate=?," +
                    "ShipVia=?,Freight=?,ShipName=?,ShipAddress=?,ShipCity=?,ShipRegion=?,ShipPostalCode=?,ShipCountry=?," +
                    "where orderID = ?";
            Connection conn = DBUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,order.getOrderID());
            pst.setString(2,order.getCustomerID());
            pst.setString(3,order.getEmployeeID());
            pst.setDate(4,order.getOrderDate());
            pst.setDate(5,order.getRequiredDate());
            pst.setDate(6,order.getShippedDate());
            pst.setInt(7,order.getShipVia());
            pst.setDouble(8,order.getFreight());
            pst.setString(9,order.getShipName());
            pst.setString(10,order.getShipAddress());
            pst.setString(11,order.getShipCity());
            pst.setString(12,order.getShipRegion());
            pst.setString(13,order.getShipPostalCode());
            pst.setString(14,order.getShipCountry());
            pst.setInt(15,order.getOrderID());
            pst.execute();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override//删除订单，并删除相应的订单详细信息
    public void deleteOrder(Orders order) throws BaseException {
        try {
            Connection conn = DBUtil.getConnection();
//            String sql = "delete from orders where orderid=?";
//            PreparedStatement pst = conn.prepareStatement(sql);
//            pst.setInt(1,order.getOrderID());
//            pst.execute();
//            pst.close();
            String sql = "delete from orders where orderid=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,order.getOrderID());
            pst.execute();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override//根据订单编号，获取订单信息
    public Orders getOrder(String orderId) throws DbException {
        Orders order = null;
        String sql = "select * from orders where orderid=?";
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,Integer.parseInt(orderId));
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                order = new Orders();
                order.setOrderID(rs.getInt(1));
                order.setCustomerID(rs.getString(2));
                order.setEmployeeID(rs.getString(3));
                order.setOrderDate(rs.getDate(4));
                order.setRequiredDate(rs.getDate(5));
                order.setShippedDate(rs.getDate(6));
                order.setShipVia(rs.getInt(7));
                order.setFreight(rs.getDouble(8));
                order.setShipName(rs.getString(9));
                order.setShipAddress(rs.getString(10));
                order.setShipCity(rs.getString(11));
                order.setShipRegion(rs.getString(12));
                order.setShipPostalCode(rs.getString(13));
                order.setShipCountry(rs.getString(14));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override//根据客户编号，员工编号模糊查询订单信息
    public List<Orders> qryOrders(String customerID, String employeeID) throws BaseException {
        List<Orders> result = new ArrayList<Orders>();
        String sql = "select * from orders where customerID like ? and employeeID like ?";
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,"%"+customerID+"%");
            pst.setString(2,"%"+employeeID+"%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Orders order = new Orders();
                order.setOrderID(rs.getInt(1));
                order.setCustomerID(rs.getString(2));
                order.setEmployeeID(rs.getString(3));
                order.setOrderDate(rs.getDate(4));
                order.setRequiredDate(rs.getDate(5));
                order.setShippedDate(rs.getDate(6));
                order.setShipVia(rs.getInt(7));
                order.setFreight(rs.getDouble(8));
                order.setShipName(rs.getString(9));
                order.setShipAddress(rs.getString(10));
                order.setShipCity(rs.getString(11));
                order.setShipRegion(rs.getString(12));
                order.setShipPostalCode(rs.getString(13));
                order.setShipCountry(rs.getString(14));
                result.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
