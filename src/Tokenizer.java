import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer
{
    private final Pattern numberLiteral = Pattern.compile("([0-9]+\\.[0-9]+|[0-9]+)[ .]");
    private final Pattern plus = Pattern.compile("increased ");
    private final Pattern minus = Pattern.compile("decreased ");
    private final Pattern star = Pattern.compile("multiplied ");
    private final Pattern slash = Pattern.compile("divided ");
    private final Pattern by = Pattern.compile("by ");
    private final Pattern leftParen = Pattern.compile("\\(");
    private final Pattern rightParen = Pattern.compile("\\)[ .]");
    
    private String source;
    
    public ArrayList<Token> tokenize(String path)
    {
        ArrayList<Token> list = new ArrayList<Token>();
        
        //System.out.println(getSource(path));
        
        source = getSource(path);
        
        while(!source.isEmpty())
        {
        
        }
        
        return list;
    }
    
    private String getSource(String path)
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
    
    private Token nextToken()
    {
        Token token = null;
        
        Pattern bite = Pattern.compile("[a-zA-Z1-9.]+[ .]");
        Matcher matcher = bite.matcher(source);
        
        if (matcher.find())
        {
            String tokenText = matcher.group();
            
            switch (tokenText)
            {
                case String string when numberLiteral.matcher(tokenText).matches():
                    token = new Token(Double.parseDouble(string), TokenType.NUMBER);
                    break;
                case String string when plus.matcher(tokenText).matches():
                    token = new Token(TokenType.PLUS);
                    break;
                case String string when minus.matcher(tokenText).matches():
                    token = new Token(TokenType.MINUS);
                    break;
                case String string when star.matcher(tokenText).matches():
                    token = new Token(TokenType.STAR);
                    break;
                case String string when slash.matcher(tokenText).matches():
                    token = new Token(TokenType.SLASH);
                    break;
                case String string when leftParen.matcher(tokenText).matches():
                    token = new Token(TokenType.LEFT_PAREN);
                    break;
                case String string when rightParen.matcher(tokenText).matches():
                    token = new Token(TokenType.RIGHT_PAREN);
                    break;
                default:
                    break;
            }
            source = source.substring(tokenText.length());
            
        }
        
        return token;
    }
}
