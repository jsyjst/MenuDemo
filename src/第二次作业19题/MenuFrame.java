package 第二次作业19题;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

/**
 * 菜单实现类
 *
 * @author:袁健策
 */
public class MenuFrame extends JFrame {
    //放置照片的文件路径
    private static final String FILE_NAME = "C:\\Users\\残渊\\Desktop\\音乐播放器\\";
    private static final String IMG_FILE = "C:\\Users\\残渊\\Pictures\\壁纸";

    private JMenu mFileMenu, mEditMenu, mSettingsMenu, mHelpMenu; //一级菜单
    private JMenu mBackgroundMenu; //二级菜单
    private JMenuItem mNewItem, mOpenItem, mSaveItem, mSaveAsItem, mExitItem; //File菜单项
    private JMenuItem mCutItem, mCopyItem, mPasteItem; //Edit菜单项
    private JMenuItem mAboutItem; //Help菜单项
    private ButtonGroup mBackgroundBg; //setting菜单项
    private JRadioButtonMenuItem mDefaultItem, mBlackItem, mBlueItem, mGrayItem; //二级背景菜单项
    private JFileChooser mChooser;
    private JLabel mLabel;
    private int mWidth, mHeight;  //窗口大小
    private AboutDialog mAboutDialog; //about的弹窗

    public MenuFrame() {
        setFrameSize();//设置适合电脑屏幕的大小
        initView();  //初始化菜单
        onClick(); //点击事件
        initMenu(); //处理菜单的显示
        initOpenFile(); //打开照片操作
    }

    /**
     * 初始化菜单
     */
    private void initView() {
        mLabel = new JLabel();
        mChooser = new JFileChooser();
        //菜单
        mFileMenu = new JMenu("File");
        mEditMenu = new JMenu("Edit");
        mSettingsMenu = new JMenu("Settings");
        mHelpMenu = new JMenu("Help");
        mBackgroundMenu = new JMenu("Background");

        //File菜单项
        mNewItem = new JMenuItem("New");
        mOpenItem = new JMenuItem("Open");
        mSaveItem = new JMenuItem("Save");
        mSaveAsItem = new JMenuItem("Save As");
        mExitItem = new JMenuItem("Exit");

        //Edit菜单项
        mCutItem = new JMenuItem("Cut");
        setSizeOfEditIcon(mCutItem, "cut.png");
        mCopyItem = new JMenuItem("Copy");
        setSizeOfEditIcon(mCopyItem, "copy.png");
        mPasteItem = new JMenuItem("Paste");
        setSizeOfEditIcon(mPasteItem, "paste.png");

        //Setting菜单项
        mBackgroundBg = new ButtonGroup();
        mDefaultItem = new JRadioButtonMenuItem("Default");
        mBlackItem = new JRadioButtonMenuItem("Black");
        mBlueItem = new JRadioButtonMenuItem("Blue");
        mGrayItem = new JRadioButtonMenuItem("Gray");

        //Help菜单项
        mAboutItem = new JMenuItem("About");
    }

    private void onClick() {
        //打开图片文件
        mOpenItem.addActionListener(e -> {
            mChooser.setCurrentDirectory(new File(IMG_FILE));
            int result = mChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = mChooser.getSelectedFile().getPath();
                ImageIcon imageIcon = new ImageIcon(name);
                if (imageIcon.getIconWidth() > getWidth() || imageIcon.getIconHeight() > getHeight()) {
                    imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(getWidth(), -1, Image.SCALE_DEFAULT));
                    mLabel.setIcon(imageIcon);
                }
                pack();
            }
        });

        //弹出退出选择框
        mExitItem.addActionListener(e ->
        {
            int result = JOptionPane.showConfirmDialog(this, "确认退出该程序吗?", "确认", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        });


        //背景颜色点击效果
        mDefaultItem.addActionListener(e -> getContentPane().setBackground(Color.WHITE));
        mBlackItem.addActionListener(e -> getContentPane().setBackground(Color.BLACK));
        mBlueItem.addActionListener(e -> getContentPane().setBackground(Color.BLUE));
        mGrayItem.addActionListener(e -> getContentPane().setBackground(Color.LIGHT_GRAY));

        //Help点击效果
        mAboutItem.addActionListener(e -> {
            if (mAboutDialog == null) {
                mAboutDialog = new AboutDialog(this);
            }
            mAboutDialog.setSize(mWidth / 2, mHeight / 2);
            mAboutDialog.setLocation(mWidth * 3 / 4, mHeight * 3 / 4);
            mAboutDialog.setVisible(true);
        });

    }

    /**
     * 适配屏幕的方法
     */
    private void setFrameSize() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        mWidth = screenWidth / 2;
        mHeight = screenHeight / 2;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocation(screenWidth / 4, screenHeight / 4);
    }

    /**
     * 处理菜单的显示及快捷键
     */
    private void initMenu() {
        //设置第一级菜单的快捷键
        mFileMenu.setMnemonic('F');
        mEditMenu.setMnemonic('E');
        mSettingsMenu.setMnemonic('S');
        mHelpMenu.setMnemonic('H');

        //设置加速器
        mOpenItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        mExitItem.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
        //添加到File菜单
        mFileMenu.add(mNewItem);
        mFileMenu.add(mOpenItem);
        mFileMenu.addSeparator();
        mFileMenu.add(mSaveItem);
        mFileMenu.add(mSaveAsItem);
        mFileMenu.addSeparator();
        mFileMenu.add(mExitItem);
        //添加到Edit菜单
        mEditMenu.add(mCutItem);
        mEditMenu.add(mCopyItem);
        mEditMenu.add(mPasteItem);
        //添加到Settings菜单
        mSettingsMenu.add(mBackgroundMenu);
        mDefaultItem.setSelected(true); //背景为默认
        mBackgroundBg.add(mDefaultItem);
        mBackgroundBg.add(mBlackItem);
        mBackgroundBg.add(mBlueItem);
        mBackgroundBg.add(mGrayItem);
        mBackgroundMenu.add(mDefaultItem);
        mBackgroundMenu.add(mBlackItem);
        mBackgroundMenu.add(mBlueItem);
        mBackgroundMenu.add(mGrayItem);
        //添加到Help菜单
        mAboutItem.setMnemonic('A');
        mHelpMenu.add(mAboutItem);
        //将File,Edit,settings,Help菜单添加到菜单栏中
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(mFileMenu);
        menuBar.add(mEditMenu);
        menuBar.add(mSettingsMenu);
        menuBar.add(mHelpMenu);
    }

    //打开本地文件对话框操作
    private void initOpenFile() {
        mLabel.setPreferredSize(new Dimension(mWidth, mHeight));
        add(mLabel);
        //过滤器
        FileFilter filter = new FileNameExtensionFilter("ImageFiles", "jpg", "png", "gif");
        mChooser.setFileFilter(filter);
        //文件对话框的右侧预览图
        mChooser.setAccessory(new ImagePreviewer(mChooser));

    }

    //改变edit中的图标大小
    private void setSizeOfEditIcon(JMenuItem menuItem, String name) {
        ImageIcon imageIcon = new ImageIcon(FILE_NAME + name);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        menuItem.setIcon(imageIcon);
    }
}
