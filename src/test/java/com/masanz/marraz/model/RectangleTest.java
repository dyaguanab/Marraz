package com.masanz.marraz.model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RectangleTest {

    /*Establece la localización en EEUU para solucionar un problema de , y .*/
    public RectangleTest(){
        Locale.setDefault(Locale.US);
    }

    /**
     * Se hacen pruebas del primer constructor para verificar el funcionamiento deseado
     */
    @Test
    void testRectangle1(){
        Point p1 = new Point(1,2);
        double ancho = 5.0;
        double alto = 10.0;
        Rectangle r = new Rectangle(p1, ancho, alto, Color.CORAL, Color.BLUE);

        assert (p1 != r.getP1());
        assert (p1.equals(r.getP1()));
        assertEquals(ancho, r.getAncho());
        assertEquals(alto, r.getAlto());
        assert (Color.CORAL.equals(r.getColorRelleno()));
        assert (Color.BLUE.equals(r.getColorContorno()));
    }

    /**
     * Se hacen pruebas al segundo contructor para verificar el funcionamiento deseado
     */
    @Test
    void testRectangle2(){
        Rectangle r = new Rectangle("0x812727ff;0x55a6d1ff;276.00;239.20;676.80;294.40");
        Point p1 = new Point(276.00,239.20);
        double ancho = 676.80;
        double alto = 294.40;
        Color relleno = Color.valueOf("0x812727ff");
        Color contorno = Color.valueOf("0x55a6d1ff");

        assert (p1.equals(r.getP1()));
        assertEquals(ancho, r.getAncho());
        assertEquals(alto, r.getAlto());
        assert (relleno.equals(r.getColorRelleno()));
        assert (contorno.equals(r.getColorContorno()));
    }

    /**
     * Se hace un test para verificar el funcionamiento deseado del area
     */
    @Test
    void testGetArea(){
        Point p1 = new Point(1,2);
        double ancho = 5.0;
        double alto = 10.0;
        Rectangle r = new Rectangle(p1, ancho, alto, Color.CORAL, Color.BLUE);
        double r1= ancho*alto;

        assertEquals(r1,r.getArea());
    }

    /**
     * Se hacen pruebas para verificar el objeto
     */
    @Test
    void testEquals(){
        Point p1 = new Point(1,2);
        double ancho = 5.0;
        double alto = 10.0;
        Rectangle r = new Rectangle(p1, ancho, alto, Color.CORAL, Color.BLUE);

        assert (r.equals(r));
    }

    /**
     * Se hacen pruebas para verificar el objeto y las clases
     */
    @Test
    void testEquals1(){
        Point p1 = new Point(1,2);
        double ancho = 5.0;
        double alto = 10.0;
        Rectangle r = new Rectangle(p1, ancho, alto, Color.CORAL, Color.BLUE);

        assertFalse (r.equals(null));
        assertFalse (r.equals(p1));
    }

    /**
     * Se hacen pruebas para verificar la igualdad de objetos con valores  diferentes
     */
    @Test
    void testEquals2(){
        Point p1 = new Point(1,2);
        double ancho = 5.0;
        double alto = 10.0;
        Rectangle r = new Rectangle(p1, ancho, alto, Color.CORAL, Color.BLUE);
        Rectangle r1 = new Rectangle(p1, alto, ancho, Color.CORAL, Color.BLUE);

        assertFalse(r.equals(r1));
    }

    /**
     * Se hacen pruebas para verificar la igualdad de diferentes objetos
     * con diferentes valores
     */
    @Test
    void testEquals3(){
        Point p1 = new Point(1,2);
        Point p2 = new Point(1,2);
        double ancho = 5.0;
        double alto = 10.0;
        double ancho1 = 5.0;
        double alto1 =5.0;
        Rectangle r = new Rectangle(p1, ancho, alto, Color.CORAL, Color.BLUE);
        Rectangle r1 = new Rectangle(p2, ancho1, alto1, Color.CORAL, Color.BLUE);
        Rectangle r2 = new Rectangle(p1, ancho, alto, Color.RED, Color.GREEN);

        assertFalse (r.equals(r1));
        assertFalse (r.equals(r2));
    }

    /**
     * Se hacen pruebas para verificar el funcionamiento del clon
     */
    @Test
    void testClone(){
        Point p1 = new Point(1,2);
        double ancho = 5.0;
        double alto = 10.0;
        Rectangle r = new Rectangle(p1, ancho, alto, Color.CORAL, Color.BLUE);
        Rectangle c = r.clone();

        assert (c != r);
        assert (c.equals(r));
    }

    /**
     * Se hacen pruebas para ver el funcionamiento del toString
     */
    @Test
    void testToString(){
        Point p1 = new Point(1,2);
        double ancho = 5.0;
        double alto = 10.0;
        Rectangle r = new Rectangle(p1, ancho, alto, Color.WHITE, Color.BLACK);

        String s = "R;0xffffffff;0x000000ff;1.00;2.00;5.00;10.00";

        assert (s.equals(r.toString()));
    }
}
