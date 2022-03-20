public class NoRepeatedWordsExpression implements Expression {
    @Override
    public String interpret(String context) {

        return HelperMethods.noRepeatedWords(context);
    }
}
