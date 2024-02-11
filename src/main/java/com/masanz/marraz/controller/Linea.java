package com.masanz.marraz.controller;

import com.masanz.marraz.model.Figura;
import com.masanz.marraz.model.Line;
import com.masanz.marraz.model.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Linea extends ModoDibujo {

    /**
     * Desde figura se utilizan los puntos para pintar la linea
     * @param gc
     * @return
     */
    @Override
    public Figura paint(GraphicsContext gc) {
        Figura figura = null;
        if (p1 != null && p2 == null) {
            p1.paint(gc);
        } else if (p1 != null && p2 !=null) {
            p2.paint(gc);
            figura = new Line(p1, p2, colorContorno);
            figura.paint(gc);
            p1 = null;
            p2 = null;
        }
        return figura;
    }
}

