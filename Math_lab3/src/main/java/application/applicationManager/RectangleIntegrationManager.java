package application.applicationManager;

import application.answerPrinter.AnswerPrinter;
import application.answerPrinter.AnswerPrinterV1;
import application.functionDefiner.FunctionDefiner;
import application.functionDefiner.FunctionDefinerV1;
import application.functions.IntegrableFunction;
import application.readers.Reader;
import application.sectionDefiner.SectionDefiner;
import application.sectionDefiner.SectionDefinerV1;
import application.solutionMethods.LeftRectanglesMethod;
import application.solutionMethods.MiddleRectanglesMethod;
import application.solutionMethods.RightRectanglesMethod;
import application.solutionMethods.SolutionMethod;

public class RectangleIntegrationManager implements ApplicationManager{
    private final Reader consoleReader;
    private final FunctionDefiner functionDefiner;
    private final SectionDefiner sectionDefiner;
    private final SolutionMethod middleMethodSolution;
    private final SolutionMethod rightMethodSolution;
    private final SolutionMethod leftMethodSolution;
    private final AnswerPrinter answerPrinter;

    public RectangleIntegrationManager(Reader consoleReader){
        this.consoleReader = consoleReader;
        functionDefiner = new FunctionDefinerV1(consoleReader);
        sectionDefiner = new SectionDefinerV1(consoleReader);
        middleMethodSolution = new MiddleRectanglesMethod();
        rightMethodSolution = new RightRectanglesMethod();
        leftMethodSolution = new LeftRectanglesMethod();
        answerPrinter = new AnswerPrinterV1();
    }

    @Override
    public void manage() {
        IntegrableFunction function = functionDefiner.defineFunction();
        double[] section = sectionDefiner.defineSection();
        double middleResult = middleMethodSolution.calculateIntegral(function, section);
        double leftResult = leftMethodSolution.calculateIntegral(function, section);
        double rightResult = rightMethodSolution.calculateIntegral(function, section);
        answerPrinter.printAnswer(middleResult, leftResult, rightResult);
    }
}
