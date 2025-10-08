import java.util.ArrayList;

public class Interpreter
{
   /*private final Expression expression;

   public Interpreter(Expression expression)
   {
      this.expression = expression;
   }

   public Double interpretOld()
   {
      return expression.evaluate();
   }*/

   public void interpret(ArrayList<Statement> statements)
   {
      for (Statement statement : statements)
      {
         statement.execute();
      }
   }
}
