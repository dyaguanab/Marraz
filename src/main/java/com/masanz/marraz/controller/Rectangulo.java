package com.masanz.marraz.controller;

import com.masanz.marraz.model.Figura;
import com.masanz.marraz.model.Point;
import com.masanz.marraz.model.Rectangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangulo extends ModoDibujo {


    /**
     * Se establece los puntos
     * @param point
     */
    @Override
    public void setPoint(Point point) {
        if (p1 == null) {
            p1 = point;
        } else if (p2 == null) {
            p2 = point;
            if(p1.getX() > p2.getX()){
                p1.setX(p1.getX()+getAncho());
            }
            if(p1.getY() > p2.getY()){
                p1.setY((p1.getY()+getAlto()));
            }
        }
    }

    /**
     * Desde figuta se utilizan los puntos y se le dan colores al rectangulo
     * @param gc
     * @return
     */
    @Override
    public Figura paint(GraphicsContext gc) {
        Figura figura = null;
        if (p1 != null && p2 == null) {
            p1.paint(gc);
        } else if (p1 != null && p2 !=null) {
            figura= new Rectangle(p1, getAncho(), getAlto(), colorRelleno, colorContorno);
            figura.setColorRelleno(colorRelleno);
            figura.setColorContorno(colorContorno);
            figura.paint(gc);
            p2.paint(gc);
            p1 = null;
            p2 = null;
        }
        return figura;
    }

    /**
     * @return se obtiene el valor de ancho
     */
    public double getAncho(){
        return (p2.getX()-p1.getX())*2;
    }

    /**
     * @return se obtiene el valor de alto
     */
    public double getAlto(){
        return (p2.getY()-p1.getY())*2;
    }
}
