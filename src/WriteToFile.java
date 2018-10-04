/**
 * Created by Duc.Nguyen on 8/22/2018.
 */
import java.io.IOException;
import java.nio.file.*;
public class WriteToFile {
    public static void writeFile() throws IOException{
        String content="Hello World";
        Files.write(Paths.get("C:\\Users\\Duc.Nguyen\\Desktop\\writeIntelj.txt"), content.getBytes());
    }

    public static void main(String[] args){
        try {
            writeFile();
        }catch(Exception e){}
    }
}
