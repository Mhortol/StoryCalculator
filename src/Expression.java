public abstract class Expression
{
    abstract public Object evaluate();

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

        public Object evaluate()
        {
            switch (operator.getType())
            {
                case TokenType.PLUS:
                    return (Double)left.evaluate() + (Double)right.evaluate();
                case TokenType.MINUS:
                    return (Double)left.evaluate() - (Double)right.evaluate();
                case TokenType.STAR:
                    return (Double)left.evaluate() * (Double)right.evaluate();
                case TokenType.SLASH:
                    return (Double)left.evaluate() / (Double)right.evaluate();
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
        private final Object value;
        
        public Literal(Double literal)
        {
            this.value = literal;
        }

        public Object getValue()
        {
            return value;
        }

        public Object evaluate()
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

        public Object evaluate()
        {
            if (operator.getType() == TokenType.MINUS)
            {
                return -(Double)right.evaluate();
            }

            return right.evaluate();
        }

        @Override
        public String toString()
        {
            return ("(" + operator.toString() + " " +right.toString() + ")");
        }
    }

    public static class Grouping extends Expression
    {
        final Expression expression;

        public Grouping(Expression expression)
        {
            this.expression = expression;
        }

        public Object evaluate()
        {
            return expression.evaluate();
        }

        @Override
        public String toString()
        {
            return expression.toString();
        }
    }
}
