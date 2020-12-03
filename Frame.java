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
  }
  public void makememos(){
    JTextField text1 = new JTextField();
    text1.setColumns(30);

    JPanel p = new JPanel();
    p.add(text1);
    
    text1.setText("ここにメモを書いていくぜ/!/!");

    Container contentPane = getContentPane();
    contentPane.add(p, BorderLayout.CENTER);
  }
}