package 第二次作业19题;

import javax.swing.*;
import java.awt.*;

/**
 * Help菜单中about的点击显示对话框
 */
public class AboutDialog extends JDialog {
    public AboutDialog(JFrame frame){
        super(frame,"About",true);

        JPanel hintPanel=new JPanel();
        hintPanel.setLayout(new GridLayout(2,0));
        JLabel authorLabel=new JLabel("姓名：袁健策     学号：3117004905    班级：软件工程3班",JLabel.LEFT);
        JLabel titleLabel=new JLabel("Java第二次作业",JLabel.CENTER);
        hintPanel.add(authorLabel);
        hintPanel.add(titleLabel);
        add(hintPanel,BorderLayout.NORTH);

        JTextArea textArea=new JTextArea(4,40);
        textArea.setLineWrap(true);
        textArea.append(" 19:编写一个图形用户界面的Application程序：\n" +
                        "（1）有一个菜单条\n" +
                        "（2）菜单条中有一个菜单，该菜单有两个菜单项，其中一个菜单项又具有2个菜单子项。\n" +
                        "（3）至少实现2个菜单项的事件响应。");
        textArea.setEnabled(false); //文本区不能修改
        add(textArea,BorderLayout.CENTER);
        JButton ok=new JButton("OK");
        ok.addActionListener(e->setVisible(false));



        JPanel panel=new JPanel();
        panel.add(ok);
        add(panel,BorderLayout.SOUTH);
        pack();
    }

}
