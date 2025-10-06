import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Tokenizer
{
    public static ArrayList<Token> tokenize(String path)
    {
        ArrayList<Token> list = new ArrayList<Token>();
        
        System.out.println(getSource(path));
        
        return list;
    }
    
    private static String getSource(String path)
    {
        String text = "";
        
        //text = new String(Files.readAllBytes(Paths.get(path)));
        
        try
        {
            text = new String(Files.readAllBytes(Paths.get(path)));
        }
        catch (Exception e)
        {
            System.out.println("An exception occurred");
            System.out.println(e);
        }
        
        return text;
    }
}
