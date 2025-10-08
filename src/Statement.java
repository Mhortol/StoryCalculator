public abstract class Statement
{
   public abstract void execute();

   static class StatementExpression extends Statement
   {
      final Expression expression;

      public StatementExpression(Expression expression)
      {
         this.expression = expression;
      }

      @Override
      public void execute()
      {
         expression.evaluate();
      }
   }

   static class Print extends Statement
   {
      final Expression expression;

      public Print(Expression expression)
      {
         this.expression = expression;
      }

      @Override
      public void execute()
      {
         Object value = expression.evaluate();

         System.out.println(value);
      }
   }
}
