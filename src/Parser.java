import java.util.ArrayList;

public class Parser
{
    private ArrayList<Token> tokens;
    private int current = 0;
    
    public Parser(ArrayList<Token> tokens)
    {
        this.tokens = tokens;
    }
    
    private Expression expression()
    {
        return equality();
    }
    
    private Expression equality()
    {
        Expression expression = comparison();
        
        
        
        return expression;
    }
    
    private Expression comparison()
    {
        Expression expression = term();
        
        
        
        return expression;
    }
    
    private Expression term()
    {
        Expression expression = factor();
        
        while (match(TokenType.MINUS, TokenType.PLUS))
        {
            Token operator = previous();
            
            Expression right = factor();
            
            expression = new Expression.Binary(expression, operator, right);
        }
        
        return expression;
    }
    
    private Expression factor()
    {
        Expression expression = unary();
        
        while (match(TokenType.SLASH, TokenType.STAR))
        {
            Token operator = previous();
            
            Expression right = unary();
            
            expression = new Expression.Binary(expression, operator, right);
        }
        
        return expression;
    }
    
    private Expression unary()
    {
        if (match(TokenType.MINUS))
        {
            Token operator = previous();
            
            Expression right = unary();
            
            return new Expression.Unary(operator, right);
        }
        
        return primary();
    }
    
    private Expression primary()
    {
        if (match(TokenType.NUMBER))
        {
            return new Expression.Literal(previous().getLiteral());
        }
        
        return null;
    }
    
    
    
    private Token peek()
    {
        return tokens.get(current);
    }
    
    private Token previous()
    {
        return tokens.get(current - 1);
    }
    
    private boolean isAtEnd()
    {
        return peek().getType() == TokenType.EOF;
    }
    
    private Token advance()
    {
        if (!isAtEnd())
        {
            current++;
        }
        
        return previous();
    }
    
    private boolean check(TokenType type)
    {
        if(isAtEnd())
        {
            return false;
        }
        
        return peek().getType() == type;
    }
    
    private boolean match(TokenType... types)
    {
        for (TokenType type : types)
        {
            if (check(type))
            {
                advance();
                return true;
            }
        }
        
        return false;
    }
}
