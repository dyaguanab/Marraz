package com.masanz.marraz.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Line extends Figura{

    private Color color;
    private Point p1;
    private Point p2;

    /**
     * Primer constructor en el que se le pasan diferentes parámetros
     * @param p1
     * @param p2
     * @param color
     */
    public Line(Point p1, Point p2, Color color) {
        super();
        this.p1 = p1.clone();
        this.p2 = p2.clone();
        this.color = color;
    }

    /**
     * Segundo constructor en el que se le pasa la linea en la que guardo los datos de la linea
     * @param linea
     */
    public Line(String linea){
        super();
        String[] partesLinea =linea.split(";");
        Color color = Color.valueOf(partesLinea[0]);
        Point p1 = new Point(Double.parseDouble(partesLinea[1]), Double.parseDouble(partesLinea[2]));
        Point p2 = new Point(Double.parseDouble(partesLinea[3]), Double.parseDouble(partesLinea[4]));

        this.p1 = p1;
        this.p2 = p2;
        this.color = color;
    }

    // region getters y setters atributos

    /**
     * @return devuelve p1
     */
    public Point getP1(){
        return p1;
    }

    /**
     * @return devuelve p2
     */
    public Point getP2(){
        return p2;
    }

    /**
     * @return devuelve color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color establece el valor de color contorno
     */
    public void setColorContorno(Color color) {
        this.color = color;
    }

    // endregion

    /**
     * Se pinta la linea a raiz de las posicones de los puntos
     * @param gc
     */
    @Override
    public void paint(GraphicsContext gc) {
        gc.setStroke(color);
        gc.strokeLine(p1.getX(), p1.getY(),p2.getX(), p2.getY());
    }

    /**
     * @return devuelve el area
     */
    @Override
    public double getArea() {
        return 0;
    }

    /**
     * Metodo para verificar que los objetos son iguales
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Line other = (Line) obj;
        return this.p1.equals(other.p1)
                && this.p2.equals(other.p2)
                && this.color.equals(other.color);
    }

    /**
     * @return devuelve un valor único que se le ha generado a las variables que se le pasan
     */
    @Override
    public int hashCode() {
        return Objects.hash(p1, p2,color);
    }

    /**
     * @return devuelve una copia exacta de la linea
     */
    @Override
    public Line clone() {
        return new Line(p1, p2,color);
    }

    /**
     * @return devuelve en el formato deseado las diferentes variables que se le pasan
     */
    @Override
    public String toString() {
        return String.format("L;%s;%.2f;%.2f;%.2f;%.2f", color.toString(), p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

}
