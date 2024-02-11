package com.masanz.marraz.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Rectangle extends Figura{
    private Point p1;

    private double ancho;

    private double alto;

    /**
     * Primer constructor en el que se le pasan los diferentes parámetros
     * @param p1
     * @param ancho
     * @param alto
     * @param colorRelleno
     * @param colorContorno
     */
    public Rectangle(Point p1, double ancho, double alto, Color colorRelleno, Color colorContorno) {
        super();
        this.p1 = p1.clone();
        this.ancho = ancho;
        this.alto = alto;
        this.colorRelleno = colorRelleno;
        this.colorContorno = colorContorno;
    }

    /**
     * Segundo contructor en el que le paso la linea en la que guardo todos los datos del circulo
     * @param linea
     */
    public Rectangle(String linea){
        super();

        String[] partesLinea =linea.split(";");
        Color colorContorno = Color.valueOf(partesLinea[1]);
        Color colorRelleno = Color.valueOf(partesLinea[0]);

        Point p1 = new Point(Double.parseDouble(partesLinea[2]), Double.parseDouble(partesLinea[3]));
        double ancho = Double.parseDouble(partesLinea[4]);
        double alto = Double.parseDouble(partesLinea[5]);

        this.p1 = p1;
        this.ancho = ancho;
        this.alto = alto;
        this.colorContorno = colorContorno;
        this.colorRelleno = colorRelleno;
    }

    /**
     * Método en el que utilizan las diferentes variables para pintar el rectangulo
     * @param gc
     */
    @Override
    public void paint(GraphicsContext gc) {
        gc.setFill(getColorRelleno());
        gc.fillRect(p1.getX(), p1.getY(), ancho, alto);
        gc.setStroke(getColorContorno());
        gc.strokeRect(p1.getX(), p1.getY(), ancho, alto);
    }

    /**
     * @return devuelve el area
     */
    @Override
    public double getArea() {
        return getAncho()*getAlto();
    }

    /**
     * @return devuelve el ancho
     */
    public double getAncho(){
        return ancho;
    }

    /**
     * @return devuelve el alto
     */
    public double getAlto(){
        return alto;
    }

    /**
     * @return devuelve p1
     */
    public Point getP1(){
        return p1;
    }

    /**
     * Método para comparar los objetos y determinar si estos son iguales
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Rectangle other = (Rectangle) obj;
        return this.p1.equals(other.p1)
                && Double.compare(this.ancho,other.ancho) == 0
                && Double.compare(this.alto,other.alto) == 0
                && this.colorRelleno.equals(other.colorRelleno)
                && this.colorContorno.equals(other.colorContorno);
    }

    /**
     * @return devuelve un valor unico generado de las diferentes variables
     */
    @Override
    public int hashCode() {
        return Objects.hash(p1, ancho, alto, colorRelleno, colorContorno);
    }

    /**
     * @return devuelve un clon exacto del rectangulo
     */
    @Override
    public Rectangle clone() {
        return new Rectangle(p1, ancho, alto, colorRelleno, colorContorno);
    }

    /**
     * @return devuelve en el formato preestablecido, las diferentes variables
     */
    @Override
    public String toString() {
        return String.format("R;%s;%s;%.2f;%.2f;%.2f;%.2f", colorRelleno.toString(), colorContorno.toString(),p1.getX(), p1.getY(), ancho, alto);
    }
}
