import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.BorderLayout;

class Frame extends JFrame{
  Frame(String title){
    setTitle(title);
    setBounds(100, 100, 600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JTextField text1 = new JTextField();
    JTextField text2 = new JTextField(10);
    JTextField text3 = new JTextField();
    text3.setColumns(20);

    JPanel p = new JPanel();
    p.add(text1);
    p.add(text2);
    p.add(text3);
    
    text1.setText("優先度?");
    text2.setText("メモタイトル?");
    text3.setText("メモ内容?");

    Container contentPane = getContentPane();
    contentPane.add(p, BorderLayout.CENTER);
  }
}