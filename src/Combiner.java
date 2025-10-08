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
               addCombinedToken(TokenType.PLUS);
               break;
            case DECREASED:
               addCombinedToken(TokenType.MINUS);
               break;
            case MULTIPLIED:
               addCombinedToken(TokenType.STAR);
               break;
            case DIVIDED:
               addCombinedToken(TokenType.SLASH);
               break;
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

   private void addCombinedToken(TokenType type)
   {
      if (tokens.get(current + 1).getType() == TokenType.SPACE && tokens.get(current + 2).getType() == TokenType.BY)
      {
         combinedList.add(new Token(type));
      }
      current += 3;
   }

}
