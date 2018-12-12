package 第二次作业19题;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



/**
 *  第二次作业19题：
 *  编写一个图形用户界面的Application程序：
 * （1）有一个菜单条
 * （2）菜单条中有一个菜单，该菜单有两个菜单项，其中一个菜单项又具有2个菜单子项。
 * （3）至少实现2个菜单项的事件响应。
 *
 *
 *  @author:袁健策
 */
public class Test_19 {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MenuFrame frame = new MenuFrame();
            //不执行任何操作;要求程序在已注册的 WindowListener 对象的 windowClosing 方法中处理该操作
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    int result = JOptionPane.showConfirmDialog(null, "确认退出?", "确认", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if(result == JOptionPane.OK_OPTION){
                        System.exit(0);
                    }
                }
            });
            frame.setTitle("第二次作业");
            frame.setVisible(true);
        });
    }
}
