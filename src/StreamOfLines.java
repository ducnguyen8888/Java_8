/**
 * Created by Duc.Nguyen on 6/25/2018.
 */
import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOfLines {

    // normal IO opertion till java 7

    public static void readLinesUsingFileReader() throws IOException{
        BufferedReader br = new BufferedReader( new FileReader( new File("C:\\Users\\Duc.Nguyen\\Desktop\\intelj.txt")));
        String line;
        while( (line = br.readLine())!=null ) {
            System.out.println(line);
        }
    }

    public static void readStreamofLine() throws IOException{
        Path path = Paths.get("C:\\Users\\Duc.Nguyen\\Desktop\\intelj.txt");
        try {
            Stream<String> data = Files.lines(path).map(s -> s.split("\\s+"))
                             .flatMap(Arrays::stream)
                             .distinct();
            List<String> myList = data.collect(Collectors.toList());
            myList.forEach(s -> System.out.println(s.length()));



        } catch (IOException IE){}
    }

    public static void  main(String [] args ){
        try {
            readStreamofLine();
        } catch (Exception e){}
    }
}
