public class EndsWithPeriodExpression implements Expression {



    @Override
    public String interpret(String context) {
        return new NoRepeatedWordsExpression().interpret(HelperMethods.endsWithPeriod(context));
    }
}
