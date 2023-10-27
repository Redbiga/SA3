package experiment.CS3.client;

import experiment.CS3.logicserver.LogicServer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//三层cs结构和bs结构使用二层cs结构的数据访问层和实体类
public class Client {
    public static void main(String[] args){
        //加载ui
        JFrame jf = new JFrame("个人通讯录系统");
        jf.setSize(1000, 800);//设置窗口大小
        jf.setLocationRelativeTo(null);//把窗口位置设置到屏幕中心
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//当点击窗口的关闭按钮时退出程序

        //创建中间容器（选项卡面板）
        JTabbedPane tabbedPane = new JTabbedPane();

        //创建选项卡并指定默认选项卡
        tabbedPane.addTab("查询联系人",createTabbedPanelSelect());
        tabbedPane.addTab("添加联系人",createTabbedPanelAdd());
        tabbedPane.addTab("删除联系人",createTabbedPanelDelete());
        tabbedPane.addTab("修改联系人",createTabbedPanelUpdate());
        tabbedPane.setSelectedIndex(0);

        //把面板容器设置到窗口
        jf.setContentPane(tabbedPane);

        //显示窗口（把内存中的窗口显示在屏幕上）
        jf.setVisible(true);
    }
    public static JComponent createTabbedPanelSelect(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel userLabel = new JLabel("查询联系人(若输入为空则会查询所有联系人):");
        userLabel.setFont(new Font(null, Font.PLAIN, 20));
        userLabel.setBounds(10,10,450,50);
        panel.add(userLabel);

        final JTextField userText = new JTextField(20);
        userText.setBounds(450,20,300,30);
        panel.add(userText);

        JButton Button = new JButton("查询");
        Button.setFont(new Font(null, Font.BOLD, 20));
        Button.setForeground(Color.BLUE);
        Button.setBackground(Color.WHITE);
        Button.setBounds(800,10,100,60);
        panel.add(Button);

        final Object[] header = {"编号","姓名","地址","电话"};
        Object[][] content = {
                {"","","",""}
        };
        final JTable result = new JTable(content,header);
        JScrollPane jScrollPane = new JScrollPane(result);
        result.setBounds(20,100,900,600);
        jScrollPane.setBounds(20,100,900,600);
        panel.add(jScrollPane);

        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object[][] res_content = LogicServer.select(userText.getText());
                TableModel tableModel = new DefaultTableModel(res_content,header);
                result.setModel(tableModel);
            }
        });

        return panel;
    }
    public static JComponent createTabbedPanelAdd(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel userLabel1 = new JLabel("姓名:");
        userLabel1.setFont(new Font(null, Font.PLAIN, 30));
        userLabel1.setBounds(0,0,100,100);
        panel.add(userLabel1);

        final JTextField userText1 = new JTextField(20);
        userText1.setBounds(130,40,300,30);
        panel.add(userText1);

        JLabel userLabel2 = new JLabel("地址:");
        userLabel2.setFont(new Font(null, Font.PLAIN, 30));
        userLabel2.setBounds(0,50,100,100);
        panel.add(userLabel2);

        final JTextField userText2 = new JTextField(20);
        userText2.setBounds(130,90,300,30);
        panel.add(userText2);

        JLabel userLabel3 = new JLabel("电话:");
        userLabel3.setFont(new Font(null, Font.PLAIN, 30));
        userLabel3.setBounds(0,100,100,100);
        panel.add(userLabel3);

        final JTextField userText3 = new JTextField(20);
        userText3.setBounds(130,140,300,30);
        panel.add(userText3);

        JButton Button1 = new JButton("添加");
        Button1.setBounds(520,150,100,60);
        Button1.setFont(new Font(null, Font.BOLD, 20));
        Button1.setForeground(Color.GREEN);
        Button1.setBackground(Color.WHITE);
        panel.add(Button1);

        Button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LogicServer.add(userText1.getText(),userText2.getText(),userText3.getText());
            }
        });

        return panel;
    }
    public static JComponent createTabbedPanelDelete(){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel userLabel = new JLabel("删除联系人的编号:");
        userLabel.setFont(new Font(null, Font.PLAIN, 20));
        userLabel.setBounds(10,10,180,50);
        panel.add(userLabel);

        final JTextField userText = new JTextField(20);
        userText.setBounds(200,20,300,30);
        panel.add(userText);

        JButton Button = new JButton("删除");
        Button.setBounds(800,10,100,60);
        Button.setFont(new Font(null, Font.BOLD, 20));
        Button.setForeground(Color.RED);
        Button.setBackground(Color.WHITE);
        panel.add(Button);

        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LogicServer.delete(userText.getText());
            }
        });

        return panel;
    }
    public static JComponent createTabbedPanelUpdate(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel userLabel = new JLabel("编号:");
        userLabel.setFont(new Font(null, Font.PLAIN, 30));
        userLabel.setBounds(0,0,100,100);
        panel.add(userLabel);

        final JTextField userText = new JTextField(20);
        userText.setBounds(130,40,300,30);
        panel.add(userText);

        JLabel userLabel1 = new JLabel("姓名:");
        userLabel1.setFont(new Font(null, Font.PLAIN, 30));
        userLabel1.setBounds(0,50,100,100);
        panel.add(userLabel1);

        final JTextField userText1 = new JTextField(20);
        userText1.setBounds(130,90,300,30);
        panel.add(userText1);

        JLabel userLabel2 = new JLabel("地址:");
        userLabel2.setFont(new Font(null, Font.PLAIN, 30));
        userLabel2.setBounds(0,100,100,100);
        panel.add(userLabel2);

        final JTextField userText2 = new JTextField(20);
        userText2.setBounds(130,140,300,30);
        panel.add(userText2);

        JLabel userLabel3 = new JLabel("电话:");
        userLabel3.setFont(new Font(null, Font.PLAIN, 30));
        userLabel3.setBounds(0,150,100,100);
        panel.add(userLabel3);

        final JTextField userText3 = new JTextField(20);
        userText3.setBounds(130,190,300,30);
        panel.add(userText3);

        JButton Button1 = new JButton("修改");
        Button1.setBounds(520,180,100,60);
        Button1.setFont(new Font(null, Font.BOLD, 20));
        Button1.setForeground(Color.MAGENTA);
        Button1.setBackground(Color.WHITE);
        panel.add(Button1);

        Button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LogicServer.update(userText.getText(),userText1.getText(),userText2.getText(),userText3.getText());
            }
        });

        return panel;
    }
}
