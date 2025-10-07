public abstract class Expression
{
    static class Binary extends Expression
    {
        private final Expression left;
        private final Token operator;
        private final Expression right;
        
        public Binary(Expression left, Token operator, Expression right)
        {
            this.left = left;
            this.operator = operator;
            this.right = right;
        }
    }
    
    static class Literal extends Expression
    {
        private final Double literal;
        
        public Literal(Double literal)
        {
            this.literal = literal;
        }
    }
    
    static class Unary extends Expression
    {
        private final Token operator;
        private final Expression right;
        
        public Unary(Token operator, Expression right)
        {
            this.operator = operator;
            this.right = right;
        }
    }
}
