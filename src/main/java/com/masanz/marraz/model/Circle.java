package com.masanz.marraz.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Circle extends Figura {
    private Point center;
    private double radius;

    /**
     * Primer constructor, en el que le paso diferentes parámetros
     * @param center
     * @param radius
     * @param colorRelleno
     * @param colorContorno
     */
    public Circle(Point center, double radius, Color colorRelleno, Color colorContorno) {
        super();
        this.center = center.clone();
        this.radius = radius;
        this.colorContorno = colorContorno;
        this.colorRelleno = colorRelleno;
    }

    /**
     * Segundo contructor en el que le paso la linea en la que guardo todos los datos del circulo
     * @param linea
     */
    public Circle(String linea){
        super();

        String[] partesLinea =linea.split(";");
        Color colorContorno = Color.valueOf(partesLinea[1]);
        Color colorRelleno = Color.valueOf(partesLinea[0]);
        Point center = new Point(Double.parseDouble(partesLinea[2]), Double.parseDouble(partesLinea[3]));
        double radius = Double.parseDouble(partesLinea[4]);

        this.center = center;
        this.radius = radius;
        this.colorContorno = colorContorno;
        this.colorRelleno = colorRelleno;
    }

    /**
     * Tercer constructor
     * @param p1
     * @param p2
     * @param colorRelleno
     * @param colorContorno
     */
    public Circle(Point p1, Point p2, Color colorRelleno, Color colorContorno ) {
        center = p1.getMiddlePoint(p2);
        radius = center.getDistance(p1);
        this.colorRelleno = colorRelleno;
        this.colorContorno = colorContorno;
    }

    // region getters y setters atributos

    /**
     * @return el valor de centro
     */
    public Point getCenter() {
        return center;
    }

    /**
     * @param center establece el valor de centro
     */
    public void setCenter(Point center) {
        this.center = center;
    }

    /**
     * @return el valor de radio
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param radius establece el valor de radio
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
    // endregion

    /**
     * Utilizo los atributos para a raiz de sus posiciones pintar la figura del circulo
     * @param gc
     */
    @Override
    public void paint(GraphicsContext gc) {
        Point esquina = new Point(center.getX() - radius, center.getY() - radius);
        gc.setFill(colorRelleno);
        gc.fillOval(esquina.getX(), esquina.getY(), 2 * radius, 2 * radius);
        gc.setStroke(colorContorno);
        gc.strokeOval(esquina.getX(), esquina.getY(), 2 * radius, 2 * radius);
        center.paint(gc);
    }

    /**
     * @return el area
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
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
        Circle other = (Circle) obj;
        return Double.compare(this.radius, other.radius) == 0
                && this.center.equals(other.center)
                && this.colorRelleno.equals(other.colorRelleno)
                && this.colorContorno.equals(other.colorContorno);
    }

    /**
     * @return devuelve un valor único que se le genera a las variables
     */
    @Override
    public int hashCode() {
        return Objects.hash(center, radius, colorContorno, colorRelleno);
    }

    /**
     * @return devuelve una copia exacta de las variables
     */
    @Override
    public Circle clone() {
        return new Circle(center, radius, colorRelleno, colorContorno);
    }

    /**
     * @return devuelve en el formato preestablecido las variables que se le pasan
     */
    @Override
    public String toString() {
        return String.format("C%;s;%s;%.2f;%.2f;%.2f", colorRelleno.toString(), colorContorno.toString(), center.getX(), center.getY(), radius);
    }

}
