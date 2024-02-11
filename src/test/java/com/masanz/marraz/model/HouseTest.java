package com.masanz.marraz.model;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    /*Establece la localización en EEUU para solucionar un problema de , y .*/
    public HouseTest(){
        Locale.setDefault(Locale.US);
    }

    /**
     * Se hacen pruebas del primer constructor para verificar el funcionamiento deseado
     */
    @Test
    void testHouse1(){
        Point p1 = new Point(1,2);
        Point p2 = new Point(3,4);
        House h = new House(p1, p2, Color.CORAL, Color.BLUE);

        assert (p1 != h.getP1());
        assert (p2 != h.getP2());
        assert (p1.equals(h.getP1()));
        assert (p2.equals(h.getP2()));
        assert (Color.CORAL.equals(h.getColorRelleno()));
        assert (Color.BLUE.equals(h.getColorContorno()));
    }

    /**
     * Se hacen pruebas al segundo contructor para verificar el funcionamiento deseado
     */
    @Test
    void testHouse2(){
        Point p1= new Point(486.40,362.40);
        Point p2= new Point(320.80,376.80);
        House h = new House("0x812727ff;0x55a6d1ff;486.40;362.40;320.80;376.80");
        Color relleno = Color.valueOf("0x812727ff");
        Color contorno = Color.valueOf("0x55a6d1ff");

        assert (relleno.equals(h.getColorRelleno()));
        assert (contorno.equals(h.getColorContorno()));
        assert (p1.equals(h.getP1()));
        assert (p2.equals(h.getP2()));
    }//PROBAR CON OTROS VALORES

    /**
     * Se hace un test para verificar el funcionamiento deseado del area
     */
    @Test
    void testGetArea(){
        Point p1 = new Point(0,0);
        Point p2 = new Point(4,0);
        House h = new House(p1, p2, Color.CORAL, Color.BLUE);

        //lado^2 =D 4*4=16   b*h/2 =D 4*4/2=8      16+8=24
        assertEquals(24, h.getArea(), 0.01);
    }//area del tejado es la mitad de la casa

    /**
     * Se hacen pruebas para verificar el objeto
     */
    @Test
    void testEquals(){
        Point p1 = new Point(1,2);
        Point p2 = new Point(3,4);
        House h = new House(p1, p2, Color.CORAL, Color.BLUE);

        assert(h.equals(h));
    }

    /**
     * Se hacen pruebas para verificar el objeto y las clases
     */
    @Test
    void testEquals1(){
        Point p1 = new Point(1,2);
        Point p2 = new Point(3,4);
        House h = new House(p1, p2, Color.CORAL, Color.BLUE);

        assertFalse (h.equals(null));
        assertFalse (h.equals(p1));
    }

    /**
     * Se hacen pruebas para verificar la igualdad de objetos con valores  diferentes
     */
    @Test
    void testEquals2(){
        Point p1 = new Point(1,2);
        Point p2 = new Point(3,4);
        House h = new House(p1, p2, Color.CORAL, Color.BLUE);
        House h1 = new House(p2, p1, Color.CORAL, Color.BLUE);

        assertFalse (h.equals(h1));
    }

    /**
     * Se hacen pruebas para verificar la igualdad de diferentes objetos
     * con diferentes valores
     */
    @Test
    void testEquals3(){
        Point p1 = new Point(1,2);
        Point p2 = new Point(3,4);
        Point p3 = new Point(1,2);
        Point p4 = new Point(3,4);
        House h = new House(p1, p2, Color.CORAL, Color.BLUE);
        House h1 = new House(p3, p4, Color.RED, Color.GREEN);
        House h2 = new House(p1, p2, Color.RED, Color.GREEN);

        assertFalse (h.equals(h1));
        assertFalse (h.equals(h2));
    }

    /**
     * Se hacen pruebas para verificar el funcionamiento del clon
     */
    @Test
    void testClone(){
        Point p1 = new Point(1,2);
        Point p2 = new Point(3,4);
        House h = new House(p1, p2, Color.CORAL, Color.BLUE);
        House h1 = h.clone();

        assert (h1 != h);
        assert (h1.equals(h));
//        assert (Color.CORAL.equals(h.getColorRelleno()));
//        assert (Color.BLUE.equals(h.getColorContorno()));
//        assert (h1.getP1().equals(h.getP1()));
//        assert (h1.getP2().equals(h.getP2()));
    }

    /**
     * Se hacen pruebas para ver el funcionamiento del toString
     */
    @Test
    void testToString(){
        Point p1 = new Point(1,2);
        Point p2 = new Point(3,4);
        House h = new House(p1, p2, Color.WHITE, Color.BLACK);

        String s = "H;0xffffffff;0x000000ff;1.00;2.00;3.00;4.00";

        assert (s.equals(h.toString()));
    }
}
