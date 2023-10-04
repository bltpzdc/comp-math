package utils.printer;

public class PrinterV1 implements Printer{
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printError(String error) {
        System.err.println(error);
    }
}
