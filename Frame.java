import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

class Frame extends JFrame implements ActionListener{
  ArrayList<JTextField> memos = new ArrayList<JTextField>();
  JTextField txt;
  JPanel p,p2;
  Frame(String title){
    this.txt = new JTextField("ここに書いて");
    txt.setColumns(30);
    JButton btn = new JButton("追加");
    btn.addActionListener(this);

    /**
    this.memo1 = new JTextField("task1");
    memo1.setColumns(30);
    this.memo2 = new JTextField("task2");
    memo2.setColumns(30);
    this.memo3 = new JTextField("task3");
    memo3.setColumns(30);
     */

    this.p = new JPanel();
    this.p2 = new JPanel();
    p.add(txt);
    p.add(btn);

    /**
    p2.add(memo1);
    p2.add(memo2);
    p2.add(memo3);
     */

    Container contentPane = getContentPane();
    contentPane.add(p, BorderLayout.NORTH);
    contentPane.add(p2, BorderLayout.CENTER);

    setTitle(title);
    setBounds(100, 100, 600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }
  public void actionPerformed(ActionEvent e) {
    this.memos.add(new JTextField(this.txt.getText()));
    memos.get(memos.size()-1).setColumns(30);
    this.p2.add(this.memos.get(memos.size()-1));
    Container contentPane = getContentPane();
    contentPane.add(this.p2, BorderLayout.CENTER);
    this.setVisible(true);
  }
}