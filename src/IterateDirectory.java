/**
 * Created by Duc.Nguyen on 6/25/2018.
 */
import java.io.IOException;
import java.nio.file.*;
public class IterateDirectory {
    public  static void main(String [] args) throws IOException{
        Files.list(Paths.get("C:\\Users\\Duc.Nguyen\\Desktop\\PRC"))
                .filter(Files::isRegularFile)
                .forEach(file -> System.out.println( file.getFileName() ));

    }
}
