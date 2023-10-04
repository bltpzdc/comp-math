package utils.printer;

public class ConsolePrinterV1 implements Printer{
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public void printError(String error) {
        System.err.println(error);
    }
}
