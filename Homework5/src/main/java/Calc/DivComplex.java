package Calc;

public class DivComplex implements Option{
    @Override
    public String discription() {
        return "Деление комплексных чисел";
    }

    @Override
    public void execute() {
        Complex newC = new Complex();
        Complex operand1 = new Complex(1);
        Complex operand2 = new Complex(1);
        Operation operation = new Operation();

        newC.setRealPart((operand1.getRealPart() * operand2.getRealPart() -
                operand1.getImaginaryPart() * operand2.getImaginaryPart()*(-1)) /
                (Math.pow(operand2.getRealPart(), 2) - Math.pow(operand2.getImaginaryPart(),
                        2)*(-1)));
        newC.setImaginaryPart((operand2.getRealPart() * operand1.getImaginaryPart() -
                operand1.getRealPart() * operand2.getImaginaryPart()) / (Math.pow(
                operand2.getRealPart(), 2) - Math.pow(operand2.getImaginaryPart(),
                2)*(-1)));

        String str = String.format("%s / %s = %s", operand1.toString(), operand2.toString(), newC.toString());
        operation.getAnswer(str);

    }
}
