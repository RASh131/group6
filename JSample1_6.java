import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

//delete用のコード
public class JSample1_6 extends JFrame implements  ActionListener{
    public static void main(String args[]){
        JSample1_6 frame = new JSample1_6("MyTitle");
        frame.setVisible(true);
    }

    JSample1_6(String title){
        setTitle(title);
        setBounds(100, 100, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        JButton btn = new JButton("削除");
        btn.setForeground(Color.RED);
        //btn.setBackground(Color.RED);
        btn.addActionListener(this);

        p.add(btn);
        getContentPane().add(p, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e){
        JLabel label = new JLabel("削除しました");
        //実際にファイルを消す
        File deleteFile = new File("./save/save.txt");
        deleteFile.delete();
        JOptionPane.showMessageDialog(this, label);
    }

}