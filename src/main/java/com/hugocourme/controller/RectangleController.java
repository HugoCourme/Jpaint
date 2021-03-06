package com.hugocourme.controller;

import com.hugocourme.drawing.Drawing;
import com.hugocourme.drawing.DrawingView;
import com.hugocourme.model.edition.ModelDEdition;
import com.hugocourme.shape.Rectangle;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class RectangleController extends DrawingController {

    private Point previousClick = null;
    private Point currentClick = null;
    private boolean run = false;
    private static RectangleController instance = null;

    private RectangleController(Drawing drawing, DrawingView drawingView) {
        super(drawing, drawingView);
    }

    public static void setInstance(Drawing drawing, DrawingView drawingView) {
        if (instance == null) {
            instance = new RectangleController(drawing, drawingView);
            instance.run = true;
            ModelDEdition.controleur.add(instance);
        }
    }

    public static RectangleController getInstance() {
        return instance;
    }

    @Override
    public void setRun(boolean run) {
        this.run = run;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        previousClick = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        currentClick = e.getPoint();

        if (previousClick.x > currentClick.x) {
            int i;
            i = previousClick.x;
            previousClick.x = currentClick.x;
            currentClick.x = i;
        }
        if (previousClick.y > currentClick.y) {
            int i;
            i = previousClick.y;
            previousClick.y = currentClick.y;
            currentClick.y = i;
        }

        if (run == true) {
            // On a eu une interaction utilisateur, on modifie le modèle
            // Le modèle va ensuite notifier les vues pour qu'elles se rafraichissent
            if (super.drawing.add(new Rectangle(previousClick.x, previousClick.y,
                    currentClick.x - previousClick.x, currentClick.y - previousClick.y, ModelDEdition.currentBorderColor, ModelDEdition.currentFillingColor, 3))) {
                System.out.println("nouveau rectangle");
            }
            else {
                System.out.println("le rectangle ne marche pas :/");
            }
        }
    }
}
