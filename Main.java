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
        Path out = Paths.get("./save/save.txt");
        List<String> arrayList = new ArrayList<>(Arrays.asList("not test","sample","code"));
        fileCheck fc = new fileCheck();
        //directoryがあればそのまま
        if(fc.dirCheck()){ System.out.println("already exist"); }
        //directoryがなければ作る
        else{ System.out.println("make directory"); }
        //fileがあればfileに上書き
        if(fc.fileCheck()){
            System.out.println("saved file");
            Files.write(out,arrayList,Charset.defaultCharset());
        }
        //fileがなければ作った上で上書き
        else{
            System.out.println("make and saved file");
            Files.write(out,arrayList,Charset.defaultCharset());
        }
        
        Frame frame = new Frame("sample");
    }
}