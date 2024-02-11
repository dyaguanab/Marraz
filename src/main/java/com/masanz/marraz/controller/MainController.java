package com.masanz.marraz.controller;

import com.masanz.marraz.db.Conexion;
import com.masanz.marraz.model.Figura;
import com.masanz.marraz.model.Point;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


import java.util.LinkedList;
import java.util.List;


import static com.masanz.marraz.consts.Consts.*;

public class MainController {

    @FXML
    private Canvas canvas;
    @FXML
    private BorderPane paneCanvas;

    @FXML
    private Label labelArea;
    private GraphicsContext gc;
    private ModoDibujo modoDibujo;
    @FXML
    private ColorPicker colorRelleno;
    @FXML
    private ColorPicker colorContorno;
    private List<Figura> list;

    /**
     * Se inicializa el controlador
     */
    @FXML
    void initialize() {
        modoDibujo= null;

        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.RED);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(THICKNESS);
        list = new LinkedList<>();
    }

    /**
     * Se establece la acción al clicar en el botón de la linea
     * @param event
     */
    public void onLineButtonAction(ActionEvent event) {
        cambiarModoDibujo(new Linea());
    }

    /**
     * Se establece la acción al clicar en el botón del circulo
     * @param event
     */
    public void onCircleButtonAction(ActionEvent event) {
        cambiarModoDibujo(new Circulo());
    }

    /**
     * Se establece la acción al clicar en el botón del rectangulo
     * @param event
     */
    public void onRectangleButtonAction(ActionEvent event){
        cambiarModoDibujo(new Rectangulo());
    }

    /**
     * Se establece la acción al clicar en el botón del triangulo
     * @param event
     */
    public void onTriangleButtonAction(ActionEvent event) {
        cambiarModoDibujo(new Triangulo());
    }

    /**
     * Se establece la acción al clicar en el botón de la casa
     * @param event
     */
    public void onHouseButtonAction(ActionEvent event) {
        cambiarModoDibujo(new Casa());
    }

    /**
     * Se establece la acción al clicar en el botón de cambiar el color relleno
     * @param event
     */
    public void onColorRellenoAction(ActionEvent event) {
        if (modoDibujo != null){
            modoDibujo.setColorRelleno(colorRelleno.getValue());
        }
    }

    /**
     * Se establece la acción al clicar en el botón de cambiar el color contorno
     * @param event
     */
    public void onColorContornoAction(ActionEvent event) {
        if (modoDibujo!=null) {
            modoDibujo.setColorContorno(colorContorno.getValue());
        }
    }

    /**
     * Se establece la acción al clicar en el canvas
     * @param event
     */
    @FXML
    public void onCanvasMouseClicked(MouseEvent event) {
        if (modoDibujo != null) {
            modoDibujo.setPoint(new Point(event.getX(), event.getY()));
            Figura figura = modoDibujo.paint(gc);
            if (figura != null){
                list.add(figura);
                labelArea.setText(getTotalArea()+" px^2");
            }
        }
    }

    /**
     * Se establece la acción al clicar en el botón de guardar
     * Se utilizan ventanas con las que el usuario interactua y se establecen
     * las posibles aacciones del usuario
     */
    public void onSaveAction(){
        TextInputDialog ventana = new TextInputDialog();
        ventana.setContentText("Escribe el nombre del dibujo: ");
        ventana.setTitle("Guardar");
        ventana.setGraphic(null);
        ventana.setHeaderText("");
        String nombre = ventana.showAndWait().orElse("");
        if (nombre.isEmpty()){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setContentText("No se ha guardado correctamente");
            error.show();
        }else {
            System.out.println(nombre);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i).toString());
                sb.append("|");
            }
            if(sb.length()>0){
                sb.deleteCharAt(sb.length()-1);
            }
            Conexion.getConexion().guardarFigura(nombre, sb.toString());
            System.out.println(sb.toString());
            //TODO
            //ventana para decir que está guardado
        }
    }

    /**
     * Se establece la opción de guardar al clicar el botón
     */
    public void onChargeAction(){
        TextInputDialog ventana = new TextInputDialog();
        ventana.setContentText("Escribe el nombre del dibujo: ");
        ventana.setTitle("Cargar");
        ventana.setGraphic(null);
        ventana.setHeaderText("");
        String nombre = ventana.showAndWait().orElse("");
        if (!nombre.isEmpty()) {
            String figuras= Conexion.getConexion().cargarFigura(nombre);
            list = Figura.crearDibujo(figuras);
            gc.clearRect(0,0, canvas.getWidth(), canvas.getHeight());
            for (int i = 0; i < list.size(); i++) {
                list.get(i).paint(gc);
            }
        }

        //TODO
    }

    /**
     * @return devuelve el area total
     */
    private int getTotalArea(){
        int areaTotal = 0;
        for (int i = 0; i < list.size(); i++) {
            areaTotal+=list.get(i).getArea();
        }
        return areaTotal;
    }

    /**
     * Se cambia los colores
     * @param modo
     */
    private void cambiarModoDibujo(ModoDibujo modo){
        modo.setColorRelleno(colorRelleno.getValue());
        modo.setColorContorno(colorContorno.getValue());
        modoDibujo=modo;
    }
}