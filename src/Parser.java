import java.util.ArrayList;

public class Parser
{
    private ArrayList<Token> tokens;
    private int current = 0;
    
    public Parser(ArrayList<Token> tokens)
    {
        this.tokens = tokens;
    }

    public Expression parseOld()
    {
        return expression();
    }

    public ArrayList<Statement> parse()
    {
        ArrayList<Statement> statements = new ArrayList<Statement>();
        while(!isAtEnd())
        {
            statements.add(declaration());
        }

        return  statements;
    }



    private Statement statement()
    {
        if (match(TokenType.PRINT))
        {
            return printStatement();
        }

        return expressionStatement();
    }

    private Statement printStatement()
    {
        Expression value = expression();
        consume(TokenType.DOT, "Expect '.' after value.");

        return new Statement.Print(value);
    }

    private Statement expressionStatement()
    {
        Expression expression = expression();
        consume(TokenType.DOT, "Expect '.' after value.");

        return new Statement.StatementExpression(expression);
    }

    private Statement declaration()
    {
        if (match(TokenType.VAR))
        {
            return varDeclaration();
        }

        return statement();
    }

    private Statement varDeclaration()
    {
        Expression initializer = null;

        initializer = expression();

        Token name = consume(TokenType.IDENTIFIER, "Expect variable name after value");
        consume(TokenType.DOT, "Expect '.' after variable declaration.");

        return new Statement.Variable(name, initializer);
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
            return new Expression.Literal((Double) previous().getValue());
        }

        if (match(TokenType.LEFT_PAREN))
        {
            Expression expression = expression();
            consume(TokenType.RIGHT_PAREN, "Expect ')' after expression.");
            return new Expression.Grouping(expression);
        }

        if (match(TokenType.IDENTIFIER))
        {
            return new Expression.Variable(previous());
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

    private Token consume(TokenType type, String message)
    {
        if (check(type))
        {
            return advance();
        }

        return null;
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
