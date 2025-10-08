import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Tokenizer tokenizer = new Tokenizer();
        
        ArrayList<Token> tokens = tokenizer.tokenize("expression.txt");

        Combiner combiner =  new Combiner(tokens);

        tokens = new ArrayList<>(combiner.combineTokens());

        System.out.println();

        for (Token token : tokens)
        {
            System.out.println(token.toString());
        }

        System.out.println();

        Parser parser = new Parser(tokens);

        //Expression expression = parser.parseOld();

        ArrayList<Statement> statements = parser.parse();

        //System.out.println(expression.toString());
        //Interpreter interpreter = new Interpreter(expression);
        //System.out.println(interpreter.interpretOld());

        Interpreter interpreter = new Interpreter();
        interpreter.interpret(statements);
    }
}