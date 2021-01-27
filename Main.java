import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        fileCheck fc = new fileCheck();
        ArrayList<String> tmp = new ArrayList<String>();
        //directoryがあればそのまま
        if(fc.dirCheck()){ System.out.println("already exist"); }
        //directoryがなければ作る
        else{ System.out.println("make directory"); }
        //fileがあれば読み出し
        if(fc.fileCheck()){ tmp=fc.fileRead(); }
        //Frame frame = new Frame("sample");
        //frame.readFile(tmp);
        Test test = new Test("sample");
        test.readFile(tmp);
    }
}
