package Calc;

public class MinusComplex implements Option{
    @Override
    public String discription() {
        return "Разность комплексных чисел";
    }

    @Override
    public void execute() {
        Complex newC = new Complex();
        Complex operand1 = new Complex(1);
        Complex operand2 = new Complex(1);
        Operation operation = new Operation();

        newC.setRealPart(operand1.getRealPart() - operand2.getRealPart());
        newC.setImaginaryPart(operand1.getImaginaryPart() - operand2.getImaginaryPart());

        String str = String.format("%s - %s = %s", operand1.toString(), operand2.toString(), newC.toString());
        operation.getAnswer(str);
    }
}
