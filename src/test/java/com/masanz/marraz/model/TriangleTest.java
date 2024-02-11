package com.masanz.marraz.model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TriangleTest {

    /*Establece la localización en EEUU para solucionar un problema de , y .*/
    public TriangleTest(){
        Locale.setDefault(Locale.US);
    }

    /**
     * Se hacen pruebas del primer constructor para verificar el funcionamiento deseado
     */
    @Test
    void testTriangle1(){
        Point p1= new Point(1,2);
        Point p2= new Point(3,4);
        Point p3= new Point(5,6);
        Triangle t = new Triangle(p1, p2, p3, Color.CORAL, Color.BLUE);

        assert (p1 != t.getP1());
        assert (p2 != t.getP2());
        assert (p3 != t.getP3());
        assert (p1.equals(t.getP1()));
        assert (p2.equals(t.getP2()));
        assert (p3.equals(t.getP3()));
        assert (Color.CORAL.equals(t.getColorRelleno()));
        assert (Color.BLUE.equals(t.getColorContorno()));
    }


    /**
     * Se hacen pruebas al segundo contructor para verificar el funcionamiento deseado
     */
    @Test
    void testTriangle2(){
        Triangle t = new Triangle("0x812727ff;0x55a6d1ff;303.20;420.80;404.80;234.40;535.20;397.60");
//        Point p1 = new Point(x)
    }

    /**
     * Se hace un test para verificar el funcionamiento deseado del area
     */
    @Test
    void testGetArea(){
        Point p1= new Point(0,0);
        Point p2= new Point(2,0);
        Point p3= new Point(2,3);
        Triangle t = new Triangle(p1, p2, p3, Color.CORAL, Color.BLUE);

        assertEquals (3, t.getArea(), 0.01);
    }

    /**
     * Se hacen pruebas para verificar el objeto
     */
    @Test
    void testEquals(){
        Point p1= new Point(1,2);
        Point p2= new Point(3,4);
        Point p3= new Point(5,6);
        Triangle t = new Triangle(p1, p2, p3, Color.CORAL, Color.BLUE);

        assert (t.equals(t));
    }

    /**
     * Se hacen pruebas para verificar el objeto y las clases
     */
    @Test
    void testEquals1(){
        Point p1= new Point(0,0);
        Point p2= new Point(2,0);
        Point p3= new Point(2,3);
        Triangle t = new Triangle(p1, p2, p3, Color.CORAL, Color.BLUE);

        assertFalse (t.equals(null));
        assertFalse (p1.equals(t));
    }

    /**
     * Se hacen pruebas para verificar la igualdad de objetos con valores  diferentes
     */
    @Test
    void testEquals2(){
        Point p1= new Point(0,0);
        Point p2= new Point(2,0);
        Point p3= new Point(2,3);
        Triangle t = new Triangle(p1, p2, p3, Color.CORAL, Color.BLUE);
        Triangle t1 = new Triangle(p3, p2, p1, Color.CORAL, Color.BLUE);

        assertFalse (t1.equals(t));
    }

    /**
     * Se hacen pruebas para verificar la igualdad de diferentes objetos
     * con diferentes valores
     */
    @Test
    void testEquals3(){
        Point p1= new Point(1,2);
        Point p2= new Point(3,4);
        Point p3= new Point(5,6);

        Point p4= new Point(1,2);
        Point p5= new Point(3,4);
        Point p6= new Point(5,6);

        Triangle t = new Triangle(p1, p2, p3, Color.CORAL, Color.BLUE);
        Triangle t1 = new Triangle(p4, p5, p6, Color.RED, Color.GREEN);
        Triangle t2 = new Triangle(p1, p2, p3, Color.RED, Color.GREEN);

        assertFalse (t.equals(t1));
        assertFalse (t.equals(t2));
    }

    /**
     * Se hacen pruebas para verificar el funcionamiento del clon
     */
    @Test
    void testClone(){
        Point p1= new Point(0,0);
        Point p2= new Point(2,0);
        Point p3= new Point(2,3);
        Triangle t = new Triangle(p1, p2, p3, Color.CORAL, Color.BLUE);

        Triangle t1 = t.clone();

        assert(t1 != t);
        assert (t1.equals(t));
    }

    /**
     * Se hacen pruebas para ver el funcionamiento del toString
     */
    @Test
    void testToString(){
        Point p1= new Point(0,0);
        Point p2= new Point(2,0);
        Point p3= new Point(2,3);
        Triangle t = new Triangle(p1, p2, p3, Color.WHITE, Color.BLACK);

        String s = "T;0xffffffff;0x000000ff;0.00;0.00;2.00;0.00;2.00;3.00";

        assert (s.equals(t.toString()));
    }
}
