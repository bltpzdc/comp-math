package utils.graphPainter;

import entities.dot.Dot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class GraphPainterV1 implements GraphPainter{
    @Override
    public void paint(Dot[] originalDots, Dot[] dotsFromMethod) {
        XYSeries originalFunction = new XYSeries("Original function");
        XYSeries integrableFunction = new XYSeries("Integrable function");
        for (Dot i : originalDots){
            originalFunction.add(i.getX(), i.getY());
        }
        for (Dot i : dotsFromMethod){
            integrableFunction.add(i.getX(), i.getY());
        }
        XYSeriesCollection collection = new XYSeriesCollection();
        collection.addSeries(originalFunction);
        collection.addSeries(integrableFunction);
        JFreeChart chart = ChartFactory.createXYLineChart("Cauchy problem", "x", "y", collection, PlotOrientation.VERTICAL, true, false, false);
        XYPlot plot = chart.getXYPlot();

        plot.getRenderer().setSeriesPaint(1, Color.BLACK);

        XYSplineRenderer renderer = new XYSplineRenderer(10000);
        renderer.setSeriesPaint(0, Color.BLACK);
        renderer.setSeriesStroke(0, new BasicStroke(5.0f));
        renderer.setSeriesShape(0, new Ellipse2D.Double(-3, -3, 6, 6));

        XYSeries dot = new XYSeries("start dot");
        dot.add(dotsFromMethod[0].getX(), dotsFromMethod[0].getY());
        XYSeriesCollection startDot = new XYSeriesCollection();
        startDot.addSeries(dot);
        plot.setDataset(1, startDot);
        plot.setRenderer(1, renderer);

        dot = new XYSeries("calculated dot");
        dot.add(dotsFromMethod[dotsFromMethod.length - 1].getX(), dotsFromMethod[dotsFromMethod.length - 1].getY());
        XYSeriesCollection calculatedDot = new XYSeriesCollection();
        calculatedDot.addSeries(dot);
        plot.setDataset(2, calculatedDot);
        plot.setRenderer(2, renderer);

        ChartFrame frame = new ChartFrame("", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
