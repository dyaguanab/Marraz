package com.masanz.marraz.controller;

import com.masanz.marraz.model.Figura;
import com.masanz.marraz.model.Point;
import com.masanz.marraz.model.Triangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangulo extends ModoDibujo {

    private Point p3;

    /**
     * Se establece el valor del punto
     * @param point
     */
    @Override
    public void setPoint(Point point) {
        if (p1 == null) {
            p1 = point;
        } else if (p2 == null) {
            p2 = point;
        } else if (p3 == null) {
            p3 = point;
        }
    }

    /**
     * Desde figura se utilizan y se pintan los puntos del triangulo
     * @param gc
     * @return
     */
    @Override
    public Figura paint(GraphicsContext gc) {
        Figura figura = null;
        if (p1 != null && p2 == null && p3 == null) {
            p1.paint(gc);
        } else if (p1 != null && p2 != null && p3 == null) {
            p2.paint(gc);

        } else if (p1 != null && p2 !=null && p3 !=null) {
            p3.paint(gc);
            figura= new Triangle(p1, p2, p3, colorRelleno, colorContorno);
            figura.paint(gc);

            p1 = null;
            p2 = null;
            p3 = null;

        }
        return figura;
    }
}
