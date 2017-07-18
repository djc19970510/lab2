package cn.edu.zucc.northwind.ui;

import cn.edu.zucc.northwind.control.OrdersManager;
import cn.edu.zucc.northwind.dao.OrdersDAO;
import cn.edu.zucc.northwind.model.Orders;
import cn.edu.zucc.northwind.util.BaseException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Administrator on 2017/7/18 0018.
 */
public class FrmOrdersManager extends JDialog implements ActionListener {
    private JPanel toolBar = new JPanel();
    private Button btnAdd = new Button("新增");
    private Button btnModify = new Button("修改");
    private Button btnDelete = new Button("删除");

    private List<Orders> orderlist=null;
    DefaultTableModel tablmod=new DefaultTableModel();
    private JTable readerTable=new JTable(tablmod);

    public FrmOrdersManager(Frame f, String s, boolean b) {
        super(f, s, b);
        toolBar.add(btnAdd);
        toolBar.add(btnModify);
        toolBar.add(btnDelete);
        this.getContentPane().add(toolBar, BorderLayout.NORTH);
        f.add(toolBar);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args){
        Frame frame = new Frame();
        FrmOrdersManager f = new FrmOrdersManager(frame,"test",true);
    }

}
