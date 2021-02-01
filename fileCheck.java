import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileReader;
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
    public ArrayList<String> fileRead(){
        ArrayList<String> tmp = new ArrayList<>();
        try (FileReader f = new FileReader("./save/save.csv")) {
            StringBuffer sb = new StringBuffer();
            while (f.ready()) {
                char c = (char) f.read();
                if (c == '\n') {
                    tmp.add(sb.toString());
                    sb = new StringBuffer();
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() > 0) {
                tmp.add(sb.toString());
            }
        }catch(IOException e){
            System.out.println(e);
        }
        return tmp;
    }
}