public class Interpreter
{
   private final Expression expression;

   public Interpreter(Expression expression)
   {
      this.expression = expression;
   }

   public Double interpret()
   {
      return expression.evaluate();
   }
}
