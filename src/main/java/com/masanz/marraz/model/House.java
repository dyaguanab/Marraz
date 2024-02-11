package com.masanz.marraz.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class House extends Figura{
    private Point p1;
    private Point p2;

    /**
     * Primer constructor de la clase casa, en el que se le pasa diferentes parámetros
     * @param p1
     * @param p2
     * @param colorRelleno
     * @param colorContorno
     */
    public House(Point p1, Point p2, Color colorRelleno, Color colorContorno) {
        super();
        this.p1 = p1.clone();
        this.p2 = p2.clone();
        this.colorContorno = colorContorno;
        this.colorRelleno = colorRelleno;
    }

    /**
     * Segundo constructor en el que se le pasa la linea en el que guardo todos los datos de la casa
     * @param linea
     */
    public House(String linea){
        super();

        String[] partesLinea =linea.split(";");

        this.p1 = new Point(Double.parseDouble(partesLinea[2]), Double.parseDouble(partesLinea[3]));
        this.p2 = new Point(Double.parseDouble(partesLinea[4]), Double.parseDouble(partesLinea[5]));
        this.colorContorno = Color.valueOf(partesLinea[1]);
        this.colorRelleno = Color.valueOf(partesLinea[0]);
    }

    /**
     * Método en el que ha raiz de los puntos de la casa, los utilizo, para calcular la posición del resto de puntos, en el caso del cuadrado
     * para que este tenga los lados iguales y con los 2 nuevos puntos generados, calcular el último punto que sería la punta del triangulo
     * y pintar la figura
     * @param gc
     */
    @Override
    public void paint(GraphicsContext gc) {
        gc.setStroke(colorContorno);
        gc.setFill(colorRelleno);

        Point p3 = new Point(p2.getX()-(p2.getY()-p1.getY()),p2.getY()+(p2.getX()-p1.getX()));
        Point p4 = new Point(p1.getX()-(p2.getY()-p1.getY()),p1.getY()+(p2.getX()-p1.getX()));
        Point medio = p3.getMiddlePoint(p4);
        Point p5 = new Point(medio.getX()-(p2.getY()-p1.getY()),medio.getY()+(p2.getX()-p1.getX()));

        //cuadrado
        double[] xs= new double[]{p1.getX(),p2.getX(),p3.getX(),p4.getX()};
        double[] ys= new double[]{p1.getY(),p2.getY(),p3.getY(),p4.getY()};
        gc.fillPolygon(xs,ys,4);
        gc.strokePolygon(xs,ys,4);

        //triangulo
        xs= new double[]{p3.getX(),p4.getX(),p5.getX()};
        ys= new double[]{p3.getY(),p4.getY(),p5.getY()};
        gc.fillPolygon(xs,ys,3);
        gc.strokePolygon(xs,ys,3);
    }

    /**
     * @return el area del cuadrado por un lado y por otro la del circulo, se le suma y se obtiene todo el area
     */
    @Override
    public double getArea() {
        double base = p1.getDistance(p2);
        double cuadrado = base*base;
        Point medio = p1.getMiddlePoint(p2);
        Point p5 = new Point(medio.getX()-(p2.getY()-p1.getY()),medio.getY()+(p2.getX()-p1.getX()));
        double altura = medio.getDistance(p5);
        double triangulo = base*altura/2;
        return cuadrado+triangulo;
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
     * Método para comparar los objetos y determinar si estos son iguales
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        House other = (House) obj;
        return this.p1.equals(other.p1)
                && this.p2.equals(other.p2)
                && this.colorRelleno.equals(other.colorRelleno)
                && this.colorContorno.equals(other.colorContorno);
    }

    /**
     * @return devuelve un valor único que se le genera a las variables
     */
    @Override
    public int hashCode() {
        return Objects.hash(p1, p2, colorRelleno, colorContorno);
    }

    /**
     * @return devuelve una copia exacta de las variables
     */
    @Override
    public House clone() {
        return new House(p1, p2, colorRelleno, colorContorno);
    }

    /**
     * @return devuelve en el formato preestablecido las variables que se le pasan
     */
    @Override
    public String toString() {
        return String.format("H;%s;%s;%.2f;%.2f;%.2f;%.2f", colorRelleno.toString(), colorContorno.toString(), p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}
