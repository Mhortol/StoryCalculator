public class Token
{
    private TokenType type;
    private Object value = null;
    
    public Token(Object value, TokenType type)
    {
        setValue(value);
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
    
    public void setValue(Object value)
    {
        this.value = value;
    }
    
    public TokenType getType()
    {
        return type;
    }
    
    public Object getValue()
    {
        return value;
    }
    
    @Override
    public String toString()
    {
        return ("Token Type: " + type + ", Literal Value: " + value);
    }
}
