public class Main {

  public static void main(String[] args) {

    String context = "this is a a sentence";

    context = new FirstLetterLowerCaseExpression().interpret(context);

    System.out.println(context);

  }

}
