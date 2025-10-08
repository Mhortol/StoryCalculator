import java.util.ArrayList;

public class Combiner
{
   private final ArrayList<Token> tokens;
   private ArrayList<Token> combinedList = new ArrayList<Token>();
   private int current = 0;

   public Combiner(ArrayList<Token> tokens)
   {
      this.tokens = tokens;
   }

   public ArrayList<Token> combineTokens()
   {
      while (current != tokens.size())
      {
         switch (tokens.get(current).getType())
         {
            case INCREASED:
               addCombinedToken(TokenType.PLUS, TokenType.BY);
               break;
            case DECREASED:
               addCombinedToken(TokenType.MINUS, TokenType.BY);
               break;
            case MULTIPLIED:
               addCombinedToken(TokenType.STAR, TokenType.BY);
               break;
            case DIVIDED:
               addCombinedToken(TokenType.SLASH, TokenType.BY);
               break;
            case THERE:
               addCombinedToken(TokenType.VAR, TokenType.IS);
            case SPACE:
               current++;
               break;
            default:
               combinedList.add(tokens.get(current));
               current++;
         }
      }
      return combinedList;
   }

   private void addCombinedToken(TokenType typeToAdd, TokenType typeToMatch)
   {
      if (tokens.get(current + 1).getType() == TokenType.SPACE && tokens.get(current + 2).getType() == typeToMatch)
      {
         combinedList.add(new Token(typeToAdd));
      }
      current += 3;
   }

}
