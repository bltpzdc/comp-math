package applicationManager;

import factories.Factory;
import functions.Function;
import generator.dotsGenerator.AbstractDotsGenerator;
import generator.dotsGenerator.OriginalDotsGenerator;
import graphCreator.GraphCreator;
import graphCreator.GraphCreatorV1;
import interpolation.InterpolationMethod;
import utils.dot.Dot;
import utils.printer.Printer;
import utils.reader.Reader;

import java.util.List;

public class ApplicationManager {
    private final Factory<Function> factory;
    private final AbstractDotsGenerator randomDotsGenerator;
    private final OriginalDotsGenerator originalDotsGenerator;
    private final InterpolationMethod method;
    private final GraphCreator graphCreator;
    public ApplicationManager(Factory<Function> factory, AbstractDotsGenerator randomDotsGenerator, InterpolationMethod method, OriginalDotsGenerator originalDotsGenerator, GraphCreator graphCreator){
        this.factory = factory;
        this.randomDotsGenerator = randomDotsGenerator;
        this.method = method;
        this.originalDotsGenerator = originalDotsGenerator;
        this.graphCreator = graphCreator;
    }
    public void manage(){
        Function function = factory.create();
        randomDotsGenerator.setFunction(function);
        List<Dot> dots = randomDotsGenerator.generate();
        List<Dot> interpolatedDots = method.interpolate(dots);
        originalDotsGenerator.setFunction(function);
        originalDotsGenerator.setStart(dots.get(0).getX());
        originalDotsGenerator.setEnd(dots.get(dots.size() - 1).getX());
        originalDotsGenerator.setStep(0.01);
        List<Dot> originalDots = originalDotsGenerator.generate();
        graphCreator.createGraph(originalDots, interpolatedDots, dots);
    }
}
