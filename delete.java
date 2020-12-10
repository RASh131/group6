package stu_lab1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class delete extends JFrame implements  ActionListener{
    public static void main(String args[]){
        JSample1_6 frame = new JSample1_6("MyTitle");
        frame.setVisible(true);
    }

    delete(String title){
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
        JOptionPane.showMessageDialog(this, label);
    }

}