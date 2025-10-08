import java.util.HashMap;

public class Environment
{
   private static final HashMap<String, Object> values = new HashMap<>();

   public static void define(String name, Object value)
   {
      values.put(name, value);
   }

   public static Object get(Token name)
   {
      if (values.containsKey((String)name.getValue()))
      {
         return values.get((String)name.getValue());
      }

      return null;
   }
}
