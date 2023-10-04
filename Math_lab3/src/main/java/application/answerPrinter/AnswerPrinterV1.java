package application.answerPrinter;

public class AnswerPrinterV1 implements AnswerPrinter {

    @Override
    public void printAnswer(double middle, double left, double right) {
        if (middle == Double.MAX_VALUE || left == Double.MAX_VALUE || right == Double.MAX_VALUE) {
            System.err.println("Отрезок не удовлетворяет ОДЗ");
        } else if (middle == Double.MIN_VALUE || left == Double.MIN_VALUE || right == Double.MIN_VALUE){
            System.out.println("Функция имеет разрыв второго рода.");
        }
        else {
            System.out.println("Решение методом средних прямоугольников: " + middle);
            System.out.println("Решение методом левых прямоугольников: " + left);
            System.out.println("Решение методом правых прямоугольников: " + right);
        }
    }
}
