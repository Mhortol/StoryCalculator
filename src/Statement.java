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
      private final Expression expression;

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

   static class Variable extends Statement
   {
      private final Token name;
      private final Expression initializer;

      public Variable(Token name, Expression initializer)
      {
         this.name = name;
         this.initializer = initializer;
      }

      @Override
      public void execute()
      {
         Object value = null;

         if (initializer != null)
         {
            value = initializer.evaluate();
         }

         Environment.define((String)name.getValue(), value);
      }
   }
}
