package Calc;

public class MultComplex implements Option{
    @Override
    public String discription() {
        return "Умножение комплексных чисел";
    }

    @Override
    public void execute() {
        Complex newC = new Complex();
        Complex operand1 = new Complex(1);
        Complex operand2 = new Complex(1);
        Operation operation = new Operation();

        newC.setRealPart(operand1.getRealPart() * operand2.getRealPart() +
                operand1.getImaginaryPart() * (operand2.getImaginaryPart() * (-1)));
        newC.setImaginaryPart(operand1.getRealPart() * operand2.getImaginaryPart() +
                operand1.getImaginaryPart() * operand2.getRealPart());

        String str = String.format("%s * %s = %s", operand1.toString(), operand2.toString(), newC.toString());
        operation.getAnswer(str);
    }
}
