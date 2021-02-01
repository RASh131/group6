import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
class Frame extends JFrame implements ActionListener{
  ArrayList<JTextField> memos = new ArrayList<JTextField>();
  ArrayList<JTextField> days = new ArrayList<JTextField>();
  ArrayList<JButton> deletes = new ArrayList<JButton>();
  JTextField memo,day;
  JPanel p,p2;
  JButton btn;
  Frame(String title){
    this.memo = new JTextField("ここに書いて");memo.setColumns(30);
    this.day = new JTextField("日付");day.setColumns(5);
    this.btn = new JButton("追加");btn.addActionListener(this);

    this.p = new JPanel();
    this.p2 = new JPanel();
    p.add(memo);
    p.add(day);
    p.add(btn);

    Container contentPane = getContentPane();
    contentPane.add(p, BorderLayout.NORTH);
    contentPane.add(p2, BorderLayout.CENTER);

    setTitle(title);
    setBounds(100, 100, 600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }
  public void rara() {
    System.out.println("!!");
  }
  public void actionPerformed(ActionEvent e) {
    this.memos.add(new JTextField(this.memo.getText()));
    this.days.add(new JTextField(this.day.getText()));
    this.deletes.add(new JButton("削除"));

    memos.get(memos.size()-1).setColumns(30);
    days.get(days.size()-1).setColumns(5);

    this.p2.add(this.memos.get(memos.size()-1));
    this.p2.add(this.days.get(days.size()-1));
    this.p2.add(this.deletes.get(deletes.size()-1));

    Container contentPane = getContentPane();
    contentPane.add(this.p2, BorderLayout.CENTER);
    this.setVisible(true);
  }
}