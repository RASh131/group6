package e195741;
import java.io.File;
import java.io.IOException;
//ファイル確認してなければ作成
public class fileCheck {
    public boolean dirCheck(){
        File dir = new File("./save");
        if(dir.exists()) { return true; }
        else {
            dir.mkdir();
            return false;
        }
    }
    public boolean fileCheck(){
        File file = new File("./save/save.txt");
        if(file.exists()) { return true; }
        else {
            try{ file.createNewFile(); }
            catch (IOException err){ System.out.println(err); }
            return false;
        }
    }
}
