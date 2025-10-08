import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Tokenizer tokenizer = new Tokenizer();
        
        ArrayList<Token> tokens = tokenizer.tokenize("expression.txt");

        Parser parser = new Parser(tokens);

        Expression expression = parser.parse();

        System.out.println(expression.toString());

        Interpreter interpreter = new Interpreter(expression);

        System.out.println(interpreter.interpret());
    }
}