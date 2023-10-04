package graphCreator;

import utils.dot.Dot;

import java.util.List;

public interface GraphCreator {
    void createGraph(List<Dot> originalDots, List<Dot> interpolatedDots, List<Dot> startDots);
}
