package utils.graphPainter;

import entities.dot.Dot;

public interface GraphPainter {
    void paint(Dot[] originalDots, Dot[] dotsFromMethod);
}
