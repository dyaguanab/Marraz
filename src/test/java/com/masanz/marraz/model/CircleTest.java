package com.masanz.marraz.model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    /*Establece la localización en EEUU para solucionar un problema de , y .*/
    public CircleTest(){
        Locale.setDefault(Locale.US);
    }

    /**
     * Se hacen pruebas del primer constructor para verificar el funcionamiento deseado
     */
    @Test
    void testCircle1() {
        Point p1 = new Point(10, 20);
        double r1 = 5;
        double r = 5;
        Circle c1 = new Circle(p1, r1, Color.CORAL, Color.BLUE);

        assert(Double.compare(r, c1.getRadius()) == 0);
        assert (p1 != c1.getCenter());
        assert (p1.equals(c1.getCenter()));
        assert (Color.CORAL.equals(c1.getColorRelleno()));
        assert (Color.BLUE.equals(c1.getColorContorno()));
    }

    /**
     * Se hacen pruebas al segundo contructor para verificar el funcionamiento deseado
     */
    @Test
    void testCircle2() {
        Circle c1 = new Circle("0x800080ff;0x55a6d1ff;278.00;243.60;174.94");
        double r = 174.94;
        assert(Double.compare(r, c1.getRadius()) == 0);
        Point p = new Point(278,243.6);
        assert (p != c1.getCenter());
        assert (p.equals(c1.getCenter()));

        Color relleno = Color.valueOf("0x800080ff");
        Color contorno = Color.valueOf("0x55a6d1ff");
        assert(relleno.equals(c1.getColorRelleno()));
        assert(contorno.equals(c1.getColorContorno()));
    }

    /**
     * Se hacen pruebas al tercer constructor para verificar el funcionamiento deseado
     */
    @Test
    void testCircle3() {
        Point p1 = new Point(10, 10);
        Point p2 = new Point(20, 20);
        Circle c1 = new Circle(p1, p2, Color.GAINSBORO, Color.GREEN);
        Point p = new Point(15, 15);

        double r = p.getDistance(p2);
        assert(Double.compare(r, c1.getRadius()) == 0);
        assert (p != c1.getCenter());
        assert (p.equals(c1.getCenter()));
    }

    /**
     * Se hace un test para verificar el funcionamiento deseado del area
     */
    @Test
    void testGetArea() {
        Circle c1 = new Circle("0x800080ff;0x55a6d1ff;00.00;0.00;10.0");
        assertEquals(314.1592, c1.getArea(), 0.001);
    }

    /**
     * Se hacen pruebas para verificar el objeto
     */
    @Test
    void testEquals(){
        Point p1 = new Point(10, 20);
        double r1 = 5;
        Circle c1 = new Circle(p1, r1, Color.CORAL, Color.BLUE);

        assert (c1.equals(c1));
    }

    /**
     * Se hacen pruebas para verificar el objeto y las clases
     */
    @Test
    void testEquals1(){
        Point p1 = new Point(10, 20);
        double r1 = 5;
        Circle c1 = new Circle(p1, r1, Color.CORAL, Color.BLUE);

        assertFalse (c1.equals(null));
        assertFalse (c1.equals(p1));
    }

    /**
     * Se hacen pruebas para verificar la igualdad de objetos con valores  diferentes
     */
    @Test
    void testEquals2(){
        Point p1 = new Point(10, 20);
        double r1 = 5;
        Circle c1 = new Circle(p1, r1, Color.CORAL, Color.BLUE);
        Circle c2 = new Circle(p1, r1, Color.BLUE, Color.CORAL);

        assertFalse (c1.equals(c2));
    }

    /**
     * Se hacen pruebas para verificar la igualdad de diferentes objetos
     * con diferentes valores
     */
    @Test
    void testEquals3(){
        Point p1 = new Point(10, 20);
        Point p2 = new Point(10, 20);
        double r1 = 5;
        double r2 = 5;

        Circle c1 = new Circle(p1, r1, Color.CORAL, Color.BLUE);
        Circle c2 = new Circle(p2, r2, Color.CORAL, Color.BLUE);
        Circle c3 = new Circle(p1, r1, Color.RED, Color.GREEN);

        assert (c1.equals(c2));
        assertFalse (c1.equals(c3));
    }

    /**
     * Se hacen pruebas para verificar el funcionamiento del clon
     */
    @Test
    void testClone() {
        Point p1 = new Point(10, 20);
        double r1 = 5;
        Circle c1 = new Circle(p1, r1, Color.CORAL, Color.BLUE);
        Circle r = c1.clone();

        assert (r != c1);
        assert (r.equals(c1));
//        assert (Color.CORAL.equals(c1.getColorRelleno()));
//        assert (Color.BLUE.equals(c1.getColorContorno()));
//        assert r.getCenter().equals(c1.getCenter());
//        assert r.getRadius() == c1.getRadius();
    }

    /**
     * Se hacen pruebas para ver el funcionamiento del toString
     */
    @Test
    void testToString() {
        Point center = new Point(10.0, 20.0);
        Circle c1 = new Circle(center, 5.0, Color.CORAL, Color.BLUE);

        String r = "C;0xff7f50ff;0x0000ffff;10.00;20.00;5.00";
        String r1 = c1.toString();
        assertEquals(r, r1);
    }
    //revisar

//    @Test
//    void testToString2() {
//        Point p1 = new Point(10, 20);
//        double r1 = 5;
//        Circle c1 = new Circle(p1, r1, Color.CORAL, Color.BLUE);
//        String r = "(10.00,20.00)_r=5.00";
//        assertEquals(r, c1.toString());
//    }


//    @Test
//    void testToString2() {
//        Point p1 = new Point(10, 20);
//        double r1 = 5;
//        Circle c1 = new Circle(p1, r1);
//        String r = "(10.00,20.00)_r=5.00";
//        assertEquals(r, c1.toString());
//    }
//
//    @Test
//    void testToString3() {
//        Point p1 = new Point(10, 10);
//        Point p2 = new Point(20, 20);
//        Circle c1 = new Circle(p1, p2);
//        String r = "(15.00,15.00)_r=7.07";
//        assertEquals(r, c1.toString());
//    }

}