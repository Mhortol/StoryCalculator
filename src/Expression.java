public abstract class Expression
{
    abstract public Double evaluate();

    public static class Binary extends Expression
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

        public Double evaluate()
        {
            switch (operator.getType())
            {
                case TokenType.PLUS:
                    return left.evaluate() + right.evaluate();
                case TokenType.MINUS:
                    return left.evaluate() - right.evaluate();
                case TokenType.STAR:
                    return left.evaluate() * right.evaluate();
                case TokenType.SLASH:
                    return left.evaluate() / right.evaluate();
            }

            return null;
        }

        @Override
        public String toString()
        {
            return ("(" + left.toString() + " " + operator.toString() + " " + right.toString() + ")");
        }
    }
    
    public static class Literal extends Expression
    {
        private final Double value;
        
        public Literal(Double literal)
        {
            this.value = literal;
        }

        public Double getValue()
        {
            return value;
        }

        public Double evaluate()
        {
            return value;
        }

        @Override
        public String toString()
        {
            return ("(" + value.toString() + ")");
        }
    }
    
    public static class Unary extends Expression
    {
        private final Token operator;
        private final Expression right;
        
        public Unary(Token operator, Expression right)
        {
            this.operator = operator;
            this.right = right;
        }

        public Double evaluate()
        {
            if (operator.getType() == TokenType.MINUS)
            {
                return -right.evaluate();
            }

            return right.evaluate();
        }

        @Override
        public String toString()
        {
            return ("(" + operator.toString() + " " +right.toString() + ")");
        }
    }
}
