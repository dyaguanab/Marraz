package com.masanz.marraz.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Triangle extends Figura{
    private Point p1;

    private Point p2;

    private Point p3;

    /**
     * Primer constructor, en el que le paso diferentes parámetros
     * @param p1
     * @param p2
     * @param p3
     * @param colorRelleno
     * @param colorContorno
     */
    public Triangle(Point p1, Point p2, Point p3, Color colorRelleno, Color colorContorno) {
        super();
        this.p1 = p1.clone();
        this.p2 = p2.clone();
        this.p3 = p3.clone();
        this.colorRelleno = colorRelleno;
        this.colorContorno = colorContorno;
    }

    /**
     * Segundo contructor en el que le paso la linea en la que guardo todos los datos del circulo
     * @param linea
     */
    public Triangle(String linea){
        super();

        String[] partesLinea =linea.split(";");
        Color colorContorno = Color.valueOf(partesLinea[1]);
        Color colorRelleno = Color.valueOf(partesLinea[0]);
        Point p1 = new Point(Double.parseDouble(partesLinea[2]), Double.parseDouble(partesLinea[3]));
        Point p2 = new Point(Double.parseDouble(partesLinea[4]), Double.parseDouble(partesLinea[5]));
        Point p3 = new Point(Double.parseDouble(partesLinea[6]), Double.parseDouble(partesLinea[7]));

        this.p1 = p1.clone();
        this.p2 = p2.clone();
        this.p3 = p3.clone();
        this.colorContorno = colorContorno;
        this.colorRelleno = colorRelleno;
    }

    /**
     * Utilizo los atributos para a raiz de sus posiciones pintar la figura del circulo
     * @param gc
     */
    @Override
    public void paint(GraphicsContext gc) {
        gc.setFill(colorRelleno);
        double[] xs= new double[]{p1.getX(),p2.getX(),p3.getX()};
        double[] ys= new double[]{p1.getY(),p2.getY(),p3.getY()};
        gc.fillPolygon(xs,ys,3);
        gc.setStroke(colorContorno);
        gc.strokePolygon(xs,ys,3);
    }

    /**
     * @return devuelve el area del triangulo
     */
    @Override
    public double getArea() {

        double a = p1.getDistance(p2);
        double b = p2.getDistance(p3);
        double c = p3.getDistance(p1);

        double s = (a+b+c)/2;
        double altura = (2/a) * Math.sqrt(s*(s-a)*(s-b)*(s-c));
        return a*altura/2;
    }

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
     * @return devuleve p3
     */
    public Point getP3(){
        return p3;
    }
//
//    public double[] getV1(){
//        return new double[]{p1.getX()-p2.getX(),p1.getY()-p2.getY()};
//    }
//
//    public double[] getV2(){
//        return new double[]{p1.getX()-p3.getX(),p1.getY()-p3.getY()};
//    }

    /**
     * Método para comparar los objetos y determinar si estos son iguales
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Triangle other = (Triangle) obj;
        return this.p1.equals(other.p1)
                && this.p2.equals(other.p2)
                && this.p3.equals(other.p3)
                && this.colorContorno.equals(other.colorContorno)
                && this.colorRelleno.equals(other.colorRelleno);
    }

    /**
     * @return devuelve un valor único generado de las variables
     */
    @Override
    public int hashCode() {
        return Objects.hash(p1, p2, p3, colorContorno, colorRelleno);
    }

    /**
     * @return devuelve una copia exacta del triangulo
     */
    @Override
    public Triangle clone() {
        return new Triangle(p1, p2, p3, colorRelleno, colorContorno);
    }

    /**
     * @return devuelve en el formato preeestablecido las variables que se le pasan
     */
    @Override
    public String toString() {
        return String.format("T;%s;%s;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f", colorRelleno.toString(), colorContorno.toString(),
                p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
    }
}
