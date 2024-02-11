package com.masanz.marraz.controller;

import com.masanz.marraz.model.Figura;
import com.masanz.marraz.model.House;
import com.masanz.marraz.model.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Casa extends ModoDibujo {

    /**
     * Desde figura se utilizan los puntos y se pintan de la casa
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
            figura= new House(p2, p1, colorRelleno, colorContorno);
            figura.paint(gc);
            p1 = null;
            p2 = null;
        }
        return figura;
    }

}
