public class Token
{
    private TokenType type;
    private Double literal = null;
    
    public Token(Double literal, TokenType type)
    {
        setLiteral(literal);
        setType(type);
    }
    
    public Token(TokenType type)
    {
        setType(type);
    }
    
    public void setType(TokenType type)
    {
        this.type = type;
    }
    
    public void setLiteral(Double literal)
    {
        this.literal = literal;
    }
    
    public TokenType getType()
    {
        return type;
    }
    
    public Double getLiteral()
    {
        return literal;
    }
    
    @Override
    public String toString()
    {
        return ("Token Type: " + type + ", Literal Value: " + literal);
    }
}
