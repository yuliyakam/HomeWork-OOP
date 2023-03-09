package Calc;

public class SumRational implements Option{

    @Override
    public String discription() {
        return "Сложение рациональных чисел";
    }

    @Override
    public void execute() {
        Rational newR = new Rational();
        Rational operand1 = new Rational(1);
        Rational operand2 = new Rational(1);
        Operation operation = new Operation();

        newR.setNumerator(operand1.getNumerator() * operand2.getDenominator() +
                operand1.getDenominator() * operand2.getNumerator());
        newR.setDenominator(operand1.getDenominator() * operand2.getDenominator());

        String str = String.format("%s + %s = %s", operand1.toString(), operand2.toString(), newR.toString());
        operation.getAnswer(str);

    }
}
