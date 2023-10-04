package applicationManager;

import entities.dot.Dot;
import factories.functionFactories.AbstractFunctionFactory;
import functions.Function;
import integralMethods.IntegralMethod;
import utils.definers.startDataDefiner.AbstractStartDataDefiner;
import utils.generators.DotsGenerator;
import utils.generators.Generator;
import utils.graphPainter.GraphPainter;

public class ApplicationManager {
    private final AbstractFunctionFactory functionFactory;
    private final AbstractStartDataDefiner dataDefiner;
    private final IntegralMethod<Dot[]> integralMethod;
    private Generator<Dot> dotsGenerator;
    private final GraphPainter painter;

    public ApplicationManager(AbstractFunctionFactory functionFactory, AbstractStartDataDefiner dataDefiner, IntegralMethod<Dot[]> integralMethod, GraphPainter painter){
        this.functionFactory = functionFactory;
        this.dataDefiner = dataDefiner;
        this.integralMethod = integralMethod;
        this.painter = painter;
    }

    public void manage(){
        Function function = functionFactory.create();
        double[] startData = dataDefiner.define();
        var dotBuilder = Dot.builder();
        dotBuilder.x(startData[0]);
        dotBuilder.y(startData[1]);
        Dot startDot = dotBuilder.build();
        function.calculateConstants(startDot);
        Dot[] dotsFromMethod = integralMethod.calculateIntegral(function, startDot, startData[2], startData[3]);
        dotsGenerator = new DotsGenerator(function, dotsFromMethod[0].getX(), dotsFromMethod.length,
                dotsFromMethod[1].getX() - dotsFromMethod[0].getX());
        Dot[] originalDots = dotsGenerator.generate();
        painter.paint(originalDots, dotsFromMethod);
    }
}
