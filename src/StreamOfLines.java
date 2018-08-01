/**
 * Created by Duc.Nguyen on 6/25/2018.
 */
import java.util.*;
import java.io.IOException;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOfLines {
    public static List<String> readStreamOfLinesUsingFiles() throws IOException {
        List<String> lines = new ArrayList<String>();
        Stream<String>data = Files.lines(Paths.get("C:\\Users\\Duc.Nguyen\\Desktop\\test.txt"));
        lines = data.filter(line -> !line.isEmpty()).collect(Collectors.toList());


        return lines;
    }

    public static  void main(String [] args) throws Exception{
        List<String> lines = readStreamOfLinesUsingFiles();

        System.out.println(lines.size());
    }
}
