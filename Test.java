import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;

class Test extends JFrame implements ActionListener{
    ArrayList<JTextField> memos = new ArrayList<JTextField>();
    JTextField txt;
    JPanel p,p2,p3;
    Path out = Paths.get("./save/save.csv");
    JButton delete[] = new JButton[80];
    int i = 0;
    Test(String title){
        this.txt = new JTextField("今後の予定は?");
        txt.setColumns(30);
        txt.setBorder(null);
        JButton btn = new JButton("追加");
        btn.addActionListener(this);
        btn.setActionCommand("addButton");

        JButton save = new JButton("保存");
        save.addActionListener(this);
        save.setActionCommand("saveButton");

        JButton view = new JButton("アーカイブを見る");
        view.addActionListener(this);
        view.setActionCommand("viewButton");

        this.p = new JPanel();
        this.p2 = new JPanel();
        this.p3 = new JPanel();
        p.add(txt);
        p.add(btn);
        p3.add(save);
        p3.add(view);

        Container contentPane = getContentPane();
        contentPane.add(p, BorderLayout.NORTH);
        contentPane.add(p2, BorderLayout.CENTER);
        contentPane.add(p3, BorderLayout.PAGE_END);

        setTitle(title);
        setBounds(100, 100, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        for(int a=0;80>a;a++){
            if(cmd.equals(String.valueOf(a))){
                System.out.println(a);
                this.p2.setVisible(false);
                this.p2.removeAll();
                this.p2.setVisible(true);
                this.memos.remove(a);
                int count = memos.size();
                this.i = 0;
                for(int c=0;count>c;c++){
                    delete[this.i] = new JButton("削除");
                    delete[this.i].addActionListener(this);
                    delete[this.i].setActionCommand(String.valueOf(i));

                    JButton arc = new JButton("アーカイブ");
                    arc.addActionListener(this);
                    arc.setActionCommand("arcButton");

                    JCheckBox check = new JCheckBox();
                    check.setActionCommand("check");

                    //this.memos.add(memos.get(c));
                    memos.get(memos.size() - 1).setColumns(30);
                    memos.get(memos.size()-1).setBorder(null);
                    this.p2.add(check);
                    this.p2.add(this.memos.get(c));
                    this.p2.add(delete[this.i]);
                    this.p2.add(arc);
                    Container contentPane = getContentPane();
                    contentPane.add(this.p2, BorderLayout.CENTER);
                    this.setVisible(true);
                    this.i+=1;
                }
            }
        }

        if(cmd.equals("addButton")) {
            delete[this.i] = new JButton("削除");
            delete[this.i].addActionListener(this);
            delete[this.i].setActionCommand(String.valueOf(i));

            JButton arc = new JButton("アーカイブ");
            arc.addActionListener(this);
            arc.setActionCommand("arcButton");

            JCheckBox check = new JCheckBox();
            check.setActionCommand("check");

            this.memos.add(new JTextField(this.txt.getText()));
            memos.get(memos.size() - 1).setColumns(30);
            memos.get(memos.size()-1).setBorder(null);
            this.p2.add(check);
            this.p2.add(this.memos.get(memos.size() - 1));
            this.p2.add(delete[this.i]);
            this.p2.add(arc);
            Container contentPane = getContentPane();
            contentPane.add(this.p2, BorderLayout.CENTER);
            this.setVisible(true);
            this.i += 1;
        }else if(cmd.equals("delButton")){
            this.setVisible(false);
            System.out.println("delete");
        }else if(cmd.equals("saveButton")){
            fileCheck fc = new fileCheck();
            //fileがあればfileに上書き
            if(fc.fileCheck()){ System.out.println("saved file"); }
            //fileがなければ作った上で上書き
            else{ System.out.println("make and saved file"); }
            ArrayList<String> tmp = new ArrayList<String>();
            for(int i=0;i < memos.size(); i++){
                tmp.add(memos.get(i).getText());
            }
            try {
                Files.write(this.out,tmp, Charset.defaultCharset());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void readFile(ArrayList<String> tmp){
        for(int b=0;tmp.size()>b;b++){
            delete[this.i] = new JButton("削除");
            delete[this.i].addActionListener(this);
            delete[this.i].setActionCommand(String.valueOf(this.i));

            JButton arc = new JButton("アーカイブ");
            arc.addActionListener(this);
            arc.setActionCommand("arcButton");

            JCheckBox check = new JCheckBox();
            check.setActionCommand("check");

            this.memos.add(new JTextField(tmp.get(b)));
            memos.get(memos.size() - 1).setColumns(30);
            memos.get(memos.size()-1).setBorder(null);
            this.p2.add(check);
            this.p2.add(this.memos.get(memos.size() - 1));
            this.p2.add(delete[this.i]);
            this.p2.add(arc);
            Container contentPane = getContentPane();
            contentPane.add(this.p2, BorderLayout.CENTER);
            this.setVisible(true);
            this.i += 1;
        }
    }

}