import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Tokenizer
{
    public ArrayList<Token> tokenize(String path)
    {
        ArrayList<Token> list = new ArrayList<Token>();
        
        
        
        return list;
    }
    
    private String getSource(String path)
    {
        String text = "";
        
        File sourceCode = new File(path);
        
        try (Scanner reader = new Scanner(sourceCode))
        {
            text = reader.toString();
        }
        catch (Exception e)
        {
            System.out.println("An exception occurred");
        }
        
        return text;
    }
}
