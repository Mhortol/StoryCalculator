import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer
{
    private final Pattern numberLiteral = Pattern.compile("([0-9]+|[0-9]+\\.[0-9]+)");
    private final Pattern identifierLiteral = Pattern.compile("[a-zA-Z]+");
    
    private String source;
    
    public ArrayList<Token> tokenize(String path)
    {
        ArrayList<Token> list = new ArrayList<Token>();
        
        //System.out.println(getSource(path));
        
        source = getSource(path);
        
        while(!source.isEmpty())
        {
            Token token = nextToken();
            
            list.add(token);
            
            System.out.println(token.toString());
        }

        list.add(new Token(TokenType.EOF));
        
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
        
        Pattern bite = Pattern.compile("[a-zA-Z0-9]+|[a-zA-Z0-9]+\\.[a-zA-Z0-9]+| |\\.|\\(|\\)|-");
        Matcher matcher = bite.matcher(source);
        
        if (matcher.find())
        {
            String tokenText = matcher.group();
            
            int length = tokenText.length();
            
            switch (tokenText)
            {
                case String string when numberLiteral.matcher(tokenText).matches():
                    token = new Token(Double.parseDouble(string), TokenType.NUMBER);
                    break;
                case "increased":
                    token = new Token(TokenType.INCREASED);
                    break;
                case "decreased":
                    token = new Token(TokenType.DECREASED);
                    break;
                case "multiplied":
                    token = new Token(TokenType.MULTIPLIED);
                    break;
                case "divided":
                    token = new Token(TokenType.DIVIDED);
                    break;
                case "(":
                    token = new Token(TokenType.LEFT_PAREN);
                    break;
                case ")":
                    token = new Token(TokenType.RIGHT_PAREN);
                    break;
                case "by":
                    token = new Token(TokenType.BY);
                    break;
                case "Say":
                    token = new Token(TokenType.PRINT);
                    break;
                case " ":
                    token = new Token(TokenType.SPACE);
                    break;
                case ".":
                    token = new Token(TokenType.DOT);
                    break;
                case "-":
                    token = new Token(TokenType.MINUS);
                    break;
                case "There":
                    token = new Token(TokenType.THERE);
                    break;
                case "is", "are":
                    token = new Token(TokenType.IS);
                    break;
                case String string when identifierLiteral.matcher(tokenText).matches():
                    token = new Token(string, TokenType.IDENTIFIER);
                    break;
                default:
                    break;
            }
            
            source = source.substring(length);
        }
        
        return token;
    }
    
    private int checkBy(int length)
    {
        if (source.startsWith("by ", length))
        {
            length+=3;
        }
        
        return length;
    }
}
