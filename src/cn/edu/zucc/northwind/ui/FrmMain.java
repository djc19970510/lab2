package cn.edu.zucc.northwind.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Administrator on 2017/7/18 0018.
 */
public class FrmMain extends JFrame implements ActionListener {
    private JMenuBar menubar=new JMenuBar(); ;

    private JMenu order_Manager=new JMenu("订单管理");
    private JMenuItem  order_Add=new JMenuItem("新增订单");
    private JMenuItem  order_Modify=new JMenuItem("修改订单");
    private JMenuItem  order_Qry=new JMenuItem("模糊查询");
    private JMenu orderdetail_Manager=new JMenu("订单细节管理");
    private JMenuItem  orderdetail_Add=new JMenuItem("订单细节增加");
    private JMenuItem  orderdetail_Modify=new JMenuItem("订单细节修改");
    private JMenuItem  orderdetail_Qry=new JMenuItem("订单细节查询");

    private JPanel statusBar = new JPanel();

    public FrmMain(){
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setTitle("订单管理系统");
        order_Manager.add(order_Add);
        order_Add.addActionListener(this);
        order_Manager.add(order_Modify);
        order_Modify.addActionListener(this);
        order_Manager.add(order_Qry);
        order_Qry.addActionListener(this);
        menubar.add(order_Manager);
        orderdetail_Manager.add(this.orderdetail_Add);
        orderdetail_Add.addActionListener(this);
        orderdetail_Manager.add(this.orderdetail_Modify);
        orderdetail_Modify.addActionListener(this);
        orderdetail_Manager.add(this.orderdetail_Qry);
        orderdetail_Qry.addActionListener(this);
        menubar.add(orderdetail_Manager);

        this.setJMenuBar(menubar);
        //状态栏
        statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel label=new JLabel("您好!");
        statusBar.add(label);
        this.getContentPane().add(statusBar,BorderLayout.SOUTH);
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args){
        FrmMain t = new FrmMain();
    }
}
