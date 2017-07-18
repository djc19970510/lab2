package cn.edu.zucc.northwind.dao;

import cn.edu.zucc.northwind.model.Orders;
import cn.edu.zucc.northwind.util.BaseException;
import cn.edu.zucc.northwind.util.DbException;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18 0018.
 */
public interface IOrdersDAO {
    public  void createOrder(Orders order) throws BaseException;//创建订单
    public void modifyOrder(Orders order) throws BaseException;//修改订单信息
    public void deleteOrder(Orders order)throws BaseException;//删除订单，并删除相应的订单详细信息
    public Orders getOrder(String orderId) throws DbException;//根据订单编号，获取订单信息
    public List< Orders > qryOrders(String customerID, String employeeID)throws BaseException;//根据客户编号，员工编号模糊查询订单信息

}
