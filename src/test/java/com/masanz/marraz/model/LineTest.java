package com.masanz.marraz.model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class LineTest {

    /*Establece la localización en EEUU para solucionar un problema de , y .*/
    public LineTest(){
        Locale.setDefault(Locale.US);
    }

    /**
     * Se hacen pruebas del primer constructor para verificar el funcionamiento deseado
     */
    @Test
    public void testLine1(){
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Line l = new Line(p1, p2, Color.CORAL);

        assert (p1 != l.getP1());
        assert (p2 != l.getP2());
        assert (p1.equals(l.getP1()));
        assert (p2.equals(l.getP2()));
        assert (Color.CORAL.equals(l.getColor()));
    }


    /**
     * Se hacen pruebas al segundo contructor para verificar el funcionamiento deseado
     */
    @Test
    public void testLine2(){
        Line l1 = new Line("0x55a6d1ff;226.40;292.80;598.40;278.40");
        Point p1= new Point(226.40,292.80);
        Point p2= new Point(598.40,278.40);

        assert (Color.valueOf("0x55a6d1ff").equals(l1.getColor()));
        assert (p1.equals(l1.getP1()));
        assert (p2.equals(l1.getP2()));
    }

    /**
     * Se hace un test para verificar el funcionamiento deseado del area
     */
    @Test
    public void testGetArea(){
        Point p1 = new Point(1,2);
        Point p2 = new Point(3,4);
        Line l = new Line(p1, p2, Color.CORAL);

        assert (l.getArea() == 0);
    }

    /**
     * Se hacen pruebas para verificar el objeto
     */
    @Test
    public void testEquals(){
        Point p1 = new Point(1,2);
        Point p2 = new Point(3,4);
        Line l = new Line(p1, p2, Color.CORAL);

        assert (l.equals(l));
    }

    /**
     * Se hacen pruebas para verificar el objeto y las clases
     */
    @Test
    public void testEquals1(){
        Point p1 = new Point(1,2);
        Point p2 = new Point(3,4);
        Line l = new Line(p1, p2, Color.CORAL);

        assertFalse(l.equals(null));
        assertFalse(l.equals(p1));
    }

    /**
     * Se hacen pruebas para verificar la igualdad de objetos con valores  diferentes
     */
    @Test
    public void testEquals2(){
        Point p1 = new Point(1,2);
        Point p2 = new Point(3,4);
        Line l = new Line(p1, p2, Color.CORAL);
        Line l1 = new Line(p2, p1, Color.CORAL);

        assertFalse (l.equals(l1));
    }

    /**
     * Se hacen pruebas para verificar la igualdad de diferentes objetos
     * con diferentes valores
     */
    @Test
    public void testEquals3() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(1,2);
        Point p4 = new Point(3,4);

        Line l = new Line(p1, p2, Color.CORAL);
        Line l1 = new Line(p3, p4, Color.CORAL);
        Line l2 = new Line(p1, p2, Color.RED);

        assert(l.equals(l1));
        assertFalse (l.equals(l2));
    }

    /**
     * Se hacen pruebas para verificar el funcionamiento del clon
     */
    @Test
    public void testClone(){
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Line l = new Line(p1, p2, Color.CORAL);

        Line l1 = l.clone();

        assert (l1 != l);
        assert (l1.equals(l));
//        assert (Color.CORAL.equals(l.getColor()));
//        assert (l1.getP1().equals(l.getP1()));
//        assert (l1.getP2().equals(l.getP2()));
    }

    /**
     * Se hacen pruebas para ver el funcionamiento del toString
     */
    @Test
    public void testToString(){
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Line l = new Line(p1, p2, Color.WHITE);

        String s = "L;0xffffffff;1.00;2.00;3.00;4.00";

        assert (s.equals(l.toString()));
    }
}
