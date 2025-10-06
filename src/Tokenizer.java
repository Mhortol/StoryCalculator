import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Tokenizer
{
    public static Pattern numberLiteral = Pattern.compile("([0-9]+\\.[0-9]+|[0-9]+)( |.)");
    public static Pattern plus = Pattern.compile("increased ");
    public static Pattern minus = Pattern.compile("decreased ");
    public static Pattern star = Pattern.compile("multiplied ");
    public static Pattern slash = Pattern.compile("divided ");
    public static Pattern by = Pattern.compile("by ");
    public static Pattern leftParen = Pattern.compile("\\(");
    public static Pattern rightParen = Pattern.compile("\\)( |.)");
    
    public static ArrayList<Token> tokenize(String path)
    {
        ArrayList<Token> list = new ArrayList<Token>();
        
        //System.out.println(getSource(path));
        
        String source = getSource(path);
        
        while(!source.isEmpty())
        {
        
        }
        
        return list;
    }
    
    private static String getSource(String path)
    {
        String text = "";
        
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
    
    private static Token nextToken(String source)
    {
        Token token;
        
        
        
        return token;
    }
}
