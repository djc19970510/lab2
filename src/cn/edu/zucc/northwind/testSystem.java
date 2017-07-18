package cn.edu.zucc.northwind;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.edu.zucc.northwind.control.OrderDetailsManager;
import cn.edu.zucc.northwind.control.OrdersManager;
import cn.edu.zucc.northwind.model.OrderDetails;
import cn.edu.zucc.northwind.model.Orders;
import cn.edu.zucc.northwind.util.BaseException;
import cn.edu.zucc.northwind.util.DBUtil;

public class testSystem {
    public static void main(String[] args){
        (new testSystem()).testConnection();
        System.out.println("------------------");
        (new testSystem()).addThreeOrders();
        System.out.println("------------------");
        (new testSystem()).addNineOrderDetails();
        System.out.println("------------------");
        (new testSystem()).find001Orders();
        System.out.println("------------------");
        (new testSystem()).find001OrderDetails();
        System.out.println("------------------");
        (new testSystem()).deletea01Order();
    }

    public void testConnection(){
        Connection conn=null;
        try {
            conn=DBUtil.getConnection();
            System.out.println("connected!");
        } catch (SQLException e) {
            System.out.println("connect failed!");
            e.printStackTrace();
        }
        finally{
            if(conn!=null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }

    public void addThreeOrders(){
        OrdersManager om = new OrdersManager();
        Orders orders1 = new Orders();
        orders1.setOrderID(1);
        orders1.setCustomerID("001");
        orders1.setEmployeeID("a01");
        Orders orders2 = new Orders();
        orders2.setOrderID(2);
        orders2.setCustomerID("001");
        orders2.setEmployeeID("a02");
        Orders orders3 = new Orders();
        orders3.setOrderID(3);
        orders3.setCustomerID("002");
        orders3.setEmployeeID("a03");
        try {
            om.createOrder(orders1);
            om.createOrder(orders2);
            om.createOrder(orders3);
            System.out.println("insert OK");
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }

    public void addNineOrderDetails(){
        OrderDetailsManager odm = new OrderDetailsManager();
        OrderDetails od1 = new OrderDetails(1,1,0.1,1);
        OrderDetails od2 = new OrderDetails(1,2,0.2,2);
        OrderDetails od3 = new OrderDetails(1,3,0.3,3);
        OrderDetails od4 = new OrderDetails(2,4,0.4,4);
        OrderDetails od5 = new OrderDetails(2,5,0.5,5);
        OrderDetails od6 = new OrderDetails(2,6,0.6,6);
        OrderDetails od7 = new OrderDetails(3,7,0.7,7);
        OrderDetails od8 = new OrderDetails(3,8,0.8,8);
        OrderDetails od9 = new OrderDetails(3,9,0.9,9);
        try {
            odm.createOrderDetail(od1);
            odm.createOrderDetail(od2);
            odm.createOrderDetail(od3);
            odm.createOrderDetail(od4);
            odm.createOrderDetail(od5);
            odm.createOrderDetail(od6);
            odm.createOrderDetail(od7);
            odm.createOrderDetail(od8);
            odm.createOrderDetail(od9);
            System.out.println("insert OK!");
        } catch (BaseException e) {
            e.printStackTrace();
        }

    }

    public void find001Orders(){
        OrdersManager om = new OrdersManager();
        try {
            List< Orders > result =  om.qryOrders("001","");
            for (int i=0;i<result.size();i++){
                System.out.println(result.get(i));
            }
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }

    public void find001OrderDetails(){
        OrderDetailsManager odm = new OrderDetailsManager();
        try {
            List<OrderDetails> result = odm.qryOrderDetails("001");
            for (int i=0;i<result.size();i++){
                System.out.println(result.get(i));
            }
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }

    public void deletea01Order(){
        OrderDetailsManager odm = new OrderDetailsManager();
        OrdersManager om = new OrdersManager();
        try {
            List<Orders> list = om.qryOrders("","a01");
            for (int i=0;i<list.size();i++){
                odm.deleteOrderDetail(String.valueOf(list.get(i).getOrderID()));
            }
            for (int i=0;i<list.size();i++){
                om.deleteOrder(String.valueOf(list.get(i).getOrderID()));
            }
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }
}
