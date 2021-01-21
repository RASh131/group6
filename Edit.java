import javax.swing.*;
import java.io.*;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.*;

public class Edit extends JFrame implements ActionListener{

  JTextArea textarea;

  public static void main(String[] args){
    Edit frame = new Edit();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(10, 10, 300, 200);
    frame.setTitle("タイトル");
    frame.setVisible(true);
  }

  Edit(){
    JButton editbutton = new JButton("Edit");
    //JButton f_searchbutton = new JButton("file_search");
    editbutton.addActionListener(this);
   

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(editbutton);
    //buttonPanel.add(f_searchbutton);

    textarea = new JTextArea();
    textarea.setLineWrap(true);

    JScrollPane scrollpane = new JScrollPane(textarea);
    scrollpane.setPreferredSize(new Dimension(200, 120));

    JPanel textPanel = new JPanel();
    textPanel.add(scrollpane);

    getContentPane().add(textPanel, BorderLayout.CENTER);
    getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
  }

  public void actionPerformed(ActionEvent e){
    JFileChooser filechooser = new JFileChooser();

    int selected = filechooser.showOpenDialog(this);
    if (selected == JFileChooser.APPROVE_OPTION){
      File file = filechooser.getSelectedFile();

      textarea.setText("");

      try{
        if (checkBeforeReadfile(file)){
          BufferedReader br 
            = new BufferedReader(new FileReader(file));

          String str;
          while((str = br.readLine()) != null){
            textarea.append(str);
            textarea.append("¥n");
          }

          br.close();
        }else{
          System.out.println("ファイルが見つからないか開けません");
        }
      }catch(FileNotFoundException err){
        System.out.println(err);
      }catch(IOException err){
        System.out.println(err);
      }
    }
  }

  private static boolean checkBeforeReadfile(File file){
    if (file.exists()){
      if (file.isFile() && file.canRead()){
        return true;
      }
    }

    return false;
  }
}