package com.masanz.marraz.model;

import javafx.scene.canvas.GraphicsContext;

import java.util.Objects;

import static com.masanz.marraz.consts.Consts.*;

public class Point extends Figura{

    private double x;
    private double y;

    /**
     * Pirmer constructor en el que se establece la posición iniciañ
     */
    public Point() {
        this(0,0);
    }

    /**
     * Segundo contructor que se le pasan diferentes parámetros
     * @param x
     * @param y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // region getters y setters

    /**
     * @return devuelve x
     */
    public double getX() {
        return x;
    }

    /**
     * Establece el valor de x
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return Devuelve el valor de y
     */
    public double getY() {
        return y;
    }

    /**
     * Establece el valor de y
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }

    // endregion

    /**
     * Establece el valor de X e Y
     * @param x
     * @param y
     */
    public void setXY(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * @param otro
     * @return Devuelve el punto medio de 2 puntos
     */
    public Point getMiddlePoint(Point otro) {
        return new Point((this.x+otro.x)/2, (this.y+otro.y)/2);
    }

    /**
     * @param otro
     * @return Devuelve la distancia de un punto a otro
     */
    public double getDistance(Point otro) {
        return Math.sqrt((this.x - otro.x)*(this.x - otro.x) + (this.y - otro.y)*(this.y - otro.y));
    }

    /**
     * @return devuelve el area
     */
    @Override
    public double getArea(){
        return 0;
    }

    /**
     * @param otro
     * @return devuelve la distancia horizontal de un punto a otro
     */
    public double getHorizontalDistance(Point otro) {
        return Math.abs(this.x - otro.x);
    }

    /**
     * @param otro
     * @return devuelve la distancia vertical de un punto a otro
     */
    public double getVerticalDistance(Point otro) {
        return Math.abs(this.y - otro.y);
    }

    /**
     * @param otro
     * @return devuelve la esquina superior izquierda
     */
    public Point getTopLeftCorner(Point otro) {
        return new Point(Math.min(this.x, otro.x), Math.min(this.y, otro.y));
    }

    /**
     * Pinta el punto
     * @param gc
     */
    @Override
    public void paint(GraphicsContext gc) {
        gc.setStroke(COLOR_CLICK_POINT);
        gc.strokeLine(x - POINT_SIZE / 2.0, y, x + POINT_SIZE / 2.0, y);
        gc.strokeLine(x, y - POINT_SIZE / 2.0, x, y + POINT_SIZE / 2.0);
    }

    /**
     * Método para verificar si dos objetos son iguales
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(x, point.x) == 0 && Double.compare(y, point.y) == 0;
    }

    /**
     * @return devuelve un valor único que se le genera  a las variables que se le pasan
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * @return devuelve una copia exacta del punto
     */
    @Override
    public Point clone() {
        return new Point(x, y);
    }

    /**
     * @return devuelve en el formato preestablecido las diferentes variables
     */
    @Override
    public String toString() {
        return String.format("(%.2f,%.2f)", x, y);
    }

}
