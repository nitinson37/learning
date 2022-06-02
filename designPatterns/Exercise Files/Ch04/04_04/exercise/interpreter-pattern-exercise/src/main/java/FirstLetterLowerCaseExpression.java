public class FirstLetterLowerCaseExpression implements Expression {
    @Override
    public String interpret(String context) {
        return new EndsWithPeriodExpression().interpret(HelperMethods.firstLetterLowerCase(context));
    }
}
