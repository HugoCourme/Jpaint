package com.hugocourme.listener;

import com.hugocourme.controller.DrawingController;
import com.hugocourme.controller.ShapeFillingController;
import com.hugocourme.drawing.Drawing;
import com.hugocourme.drawing.DrawingView;
import com.hugocourme.model.edition.ModelDEdition;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class ShapeFillingListener implements ActionListener {

    private Drawing drawing;
    private DrawingView drawingView;

    public ShapeFillingListener(Drawing drawing, DrawingView drawingView) {
        this.drawing = drawing;
        this.drawingView = drawingView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // si il y a une instance de ShapeFillingController alors on lance le contrôleur avec "run"
        // sinon on l'instancie
        // et on ferme les autres contrôleurs
        Iterator it = ModelDEdition.controleur.iterator();
        while (it != null && it.hasNext()) {
            Object o = it.next();

            DrawingController drawingController = (DrawingController) o;
            if (o != null) {
                drawingController.setRun(false);
            }
        }
        if (ShapeFillingController.getInstance() != null) {
            ShapeFillingController.getInstance().setRun(true);
        }
        else {
            ShapeFillingController.setInstance(drawing, drawingView);
        }
    }
}
