package ApachePackages;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CommonsIO {
    public static void main(String[] args) throws IOException {
        File file = new File("TestFile.txt");

        //FileUtils : Write and Read String

        FileUtils.writeStringToFile(file,"Apache Commons IO", StandardCharsets.UTF_8);
        String content = FileUtils.readFileToString(file,StandardCharsets.UTF_8);
        System.out.println("File Content: " + content);

        //FileUtils: Copy file
        File copyfile  = new File("Copy_TestFile.txt");
        FileUtils.copyFile(file,copyfile);

        //IOUtils
        try(InputStream input = new FileInputStream(file)){
            String str = IOUtils.toString(input,StandardCharsets.UTF_8);
            System.out.println("Read Using IOUtils: "+ str);
        }

        //IOUtils: Copy Stream
        try(InputStream in = new ByteArrayInputStream("Stream Copy Example".getBytes());
            OutputStream out = new ByteArrayOutputStream()){
            IOUtils.copy(in,out);
            System.out.println("Copied Stream Bytes count: " +((ByteArrayOutputStream)out).size());
        }

    }
}
