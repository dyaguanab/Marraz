package com.masanz.marraz.controller;

import com.masanz.marraz.model.Figura;
import com.masanz.marraz.model.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class ModoDibujo {
    protected Color colorRelleno;
    protected Color colorContorno;
    protected Point p1;
    protected Point p2;

    /**
     * Se establence los puntos
     * @param point
     */
    public void setPoint(Point point) {
        if (p1 == null) {
            p1 = point;
        } else if (p2 == null) {
            p2 = point;
        }
    }

    public abstract Figura paint(GraphicsContext gc);

    public void setColorRelleno(Color color) {
        colorRelleno=color;
    }

    public void setColorContorno(Color color) {
        colorContorno=color;
    }
}
