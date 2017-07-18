package cn.edu.zucc.northwind.control;

import cn.edu.zucc.northwind.dao.OrdersDAO;
import cn.edu.zucc.northwind.model.Orders;
import cn.edu.zucc.northwind.util.BaseException;
import cn.edu.zucc.northwind.util.DBUtil;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/7/18 0018.
 */
public class OrdersManager {
    //查询所有订单
    public List<Orders> loadAllOrders() throws BaseException{
        List<Orders> result = null;
        OrdersDAO ordersDAO = new OrdersDAO();
        result = ordersDAO.qryOrders("","");
        return result;
    }
    //新增订单
    public void createOrder(Orders c) throws BaseException{
        Connection conn = null;
        try {
            String sql = "select * from orders where orderID = ?";
            conn = DBUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,c.getOrderID());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                throw new BaseException("订单已存在");
            }
            OrdersDAO ordersDAO = new OrdersDAO();
            ordersDAO.createOrder(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //根据订单号，删除订单
    public void deleteOrder(String orderID) throws BaseException{
        OrdersDAO ordersDAO = new OrdersDAO();
        Connection conn = null;
        try {
            Orders orders = null;
            String sql = "select * from orders where orderID = ?";
            conn = DBUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,Integer.parseInt(orderID));
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                orders = ordersDAO.getOrder(orderID);
            }else{
                throw new BaseException("订单不存在");
            }
            ordersDAO.deleteOrder(orders);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //根据客户编号，员工编号模糊查询订单信息
    public List< Orders >  qryOrders(String customerID,String employeeID)throws BaseException{
        OrdersDAO ordersDAO = new OrdersDAO();
        return ordersDAO.qryOrders(customerID,employeeID);
    }

}
