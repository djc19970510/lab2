package cn.edu.zucc.northwind.dao;

import cn.edu.zucc.northwind.model.OrderDetails;
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
public class OrderDetailsDAO implements IOrderDetailsDAO {
    @Override//创建订单详细信息
    public void createOrderDetail(OrderDetails od) throws BaseException {
        try {
            String sql = "insert into orderdetails values (?,?,?,?,?)";
            Connection conn = DBUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,od.getOrderID());
            pst.setInt(2,od.getProductID());
            pst.setDouble(3,od.getUnitPrice());
            pst.setInt(4,od.getQuantity());
            pst.setDouble(5,od.getDiscount());
            pst.execute();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override//修改订单详细信息
    public void modifyOrderDetail(OrderDetails od) throws BaseException {
        try {
            String sql = "update orderdetails set OrderID=?,ProductID=?,UnitPrice=?,Quantity=?,Discount=?"+
                    "where orderID = ?";
            Connection conn = DBUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,od.getOrderID());
            pst.setInt(2,od.getProductID());
            pst.setDouble(3,od.getUnitPrice());
            pst.setInt(4,od.getQuantity());
            pst.setDouble(5,od.getDiscount());
            pst.setInt(6,od.getOrderID());
            pst.execute();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override//删除订单，并删除相应的订单详细信息
    public void deleteOrderDetail(OrderDetails od) throws BaseException {
        try {
            String sql = "delete from orderdetails where orderid=?";
            Connection conn = DBUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,od.getOrderID());
            pst.execute();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override//根据订单编号，获取订单详细信息
    public List<OrderDetails> getOrderDetails(String orderID) throws DbException {
        List<OrderDetails> result = new ArrayList<OrderDetails>();
        String sql = "select * from orderdetails where orderid=?";
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,Integer.parseInt(orderID));
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                OrderDetails od = new OrderDetails();
                od = new OrderDetails();
                od.setOrderID(rs.getInt(1));
                od.setProductID(rs.getInt(2));
                od.setUnitPrice(rs.getDouble(3));
                od.setQuantity(rs.getInt(4));
                od.setDiscount(rs.getDouble(5));
                result.add(od);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override//根据客户编号模糊查询订单信息
    public List<OrderDetails> qryOrderDetails(String customerID) throws BaseException {
        List<OrderDetails> result = new ArrayList<OrderDetails>();
        String sql = "select * from orders where customerID like ?";
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,"%"+customerID+"%");
            ResultSet rs = pst.executeQuery();
            List<Integer> tmp = new ArrayList<Integer>();
            while (rs.next()){
                tmp.add(rs.getInt(1));
            }
            String sql2 = "select * from orderdetails where orderID = ?";
            pst = conn.prepareStatement(sql2);
            for(int j=0;j<tmp.size();j++){
                pst.setInt(1,tmp.get(j).intValue());
                rs = pst.executeQuery();
                while(rs.next()){
                    OrderDetails od = new OrderDetails();
                    od.setOrderID(rs.getInt(1));
                    od.setProductID(rs.getInt(2));
                    od.setUnitPrice(rs.getDouble(3));
                    od.setQuantity(rs.getInt(4));
                    od.setDiscount(rs.getDouble(5));
                    result.add(od);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
