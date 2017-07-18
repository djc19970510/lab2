package cn.edu.zucc.northwind.control;

import cn.edu.zucc.northwind.dao.OrderDetailsDAO;
import cn.edu.zucc.northwind.model.OrderDetails;
import cn.edu.zucc.northwind.util.BaseException;
import cn.edu.zucc.northwind.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/7/18 0018.
 */
public class OrderDetailsManager {
    //根据订单号，查询详细信息
    public List<OrderDetails> loadAllOrderDetails(String orderID) throws BaseException {
        OrderDetailsDAO odd = new OrderDetailsDAO();
        List<OrderDetails> result = odd.qryOrderDetails("");
        return result;
    }
    //新增订单详细信息
    public void createOrderDetail(OrderDetails od) throws BaseException{
        OrderDetailsDAO odd = new OrderDetailsDAO();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from orders where orderID = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,od.getOrderID());
            ResultSet rs = pst.executeQuery();
            if(!rs.next()){
                throw new BaseException("订单不存在，无法增加信息");
            }
            odd.createOrderDetail(od);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //根据订单号，删除订单详细信息
    public void deleteOrderDetail(String orderID) throws BaseException{
        OrderDetailsDAO odd = new OrderDetailsDAO();
        OrderDetails od = null;
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from orderdetails where orderID = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,Integer.parseInt(orderID));
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                od = new OrderDetails();
                od.setOrderID(rs.getInt(1));
                od.setProductID(rs.getInt(2));
                od.setUnitPrice(rs.getDouble(3));
                od.setQuantity(rs.getInt(4));
                od.setDiscount(rs.getDouble(5));
            }else{
                throw new BaseException("订单不存在，无法删除");
            }
            odd.deleteOrderDetail(od);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //根据客户编号，查询订单详细信息
    public List<OrderDetails> qryOrderDetails(String customerID) throws BaseException{
        OrderDetailsDAO odd = new OrderDetailsDAO();
        return odd.qryOrderDetails(customerID);
    }

}
