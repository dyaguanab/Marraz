package com.masanz.marraz.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;

public abstract class Figura {
    protected Color colorRelleno;
    protected Color colorContorno;

    /**
     * Es un método abstracto que dice que las subclases que hereden de la clase Figura, deben de tener este método de obtener el area
     */
    public abstract double getArea();

    /**
     * @return devuelve el color relleno
     */
    public Color getColorRelleno() {
        return colorRelleno;
    }

    /**
     * Establece el valor del parámetro
     * @param colorRelleno
     */
    public void setColorRelleno(Color colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    /**
     * @return devuelve el color contorno
     */
    public Color getColorContorno() {
        return colorContorno;
    }

    /**
     * @param colorContorno establece el valor de color contorno
     */
    public void setColorContorno(Color colorContorno) {
        this.colorContorno = colorContorno;
    }

    /**
     * Es un método abstracto que dice que las subclases que hereden de la clase Figura, deben de tener este método de pintar
     * @param gc
     */
    public abstract void paint(GraphicsContext gc);

    /**
     * Método que va a crear el dibujo de cada tipo de figura y las va a guardar en el formato que se desea
     * @param s
     * @return
     */
    public static List<Figura> crearDibujo(String s){
        List<Figura> dibujo = new LinkedList<>();
        if (s.length()==0){
            return dibujo;
        }
        String[] figuras= s.split("\\|");
        for (int i = 0; i < figuras.length; i++) {
            String figura = figuras[i].replaceAll(",",".");
            switch (figura.charAt(0)){
                case 'L':
                    dibujo.add(new Line(figura.substring(2)));
                    break;
                case 'R':
                    dibujo.add(new Rectangle(figura.substring(2)));
                    break;
                case 'T':
                    dibujo.add(new Triangle(figura.substring(2)));
                    break;
                case 'C':
                    dibujo.add(new Circle(figura.substring(2)));
                    break;
                case 'H':
                    dibujo.add(new House(figura.substring(2)));
                    break;
            }
        }
        return dibujo;
    }
}
