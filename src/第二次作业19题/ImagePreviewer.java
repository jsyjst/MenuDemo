package 第二次作业19题;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * 文件对话框的预览图
 */
public class ImagePreviewer extends JLabel {
    public ImagePreviewer(JFileChooser chooser){
        setPreferredSize(new Dimension(100,100));
        setBorder(BorderFactory.createEtchedBorder());

        chooser.addPropertyChangeListener(event->{
            if(event.getPropertyName()==JFileChooser.SELECTED_FILE_CHANGED_PROPERTY){
                File f=(File)event.getNewValue();
                if(f==null){
                    setIcon(null);
                    return;
                }
                ImageIcon imageIcon=new ImageIcon(f.getPath());
                if(imageIcon.getIconWidth()>getWidth()){
                    imageIcon=new ImageIcon(imageIcon.getImage().getScaledInstance(getWidth(),-1,Image.SCALE_DEFAULT));
                    setIcon(imageIcon);
                }
            }
        });
    }
}
