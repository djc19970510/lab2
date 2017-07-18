package cn.edu.zucc.northwind.dao;

import cn.edu.zucc.northwind.model.OrderDetails;
import cn.edu.zucc.northwind.util.BaseException;
import cn.edu.zucc.northwind.util.DbException;

import java.util.List;

/**
 * Created by Administrator on 2017/7/18 0018.
 */
public interface IOrderDetailsDAO{
        public  void createOrderDetail(OrderDetails od) throws BaseException;//创建订单详细信息
        public void modifyOrderDetail(OrderDetails od) throws BaseException;//修改订单详细信息
        public void deleteOrderDetail(OrderDetails od)throws BaseException;//删除订单，并删除相应的订单详细信息
        public List< OrderDetails > getOrderDetails(String orderID) throws DbException;//根据订单编号，获取订单详细信息
        public List< OrderDetails > qryOrderDetails(String customerID)throws BaseException;//根据客户编号模糊查询订单信息

}
