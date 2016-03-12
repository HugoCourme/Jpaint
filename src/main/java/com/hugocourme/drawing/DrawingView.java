package com.hugocourme.drawing;

import com.hugocourme.listener.DrawingListener;
import com.hugocourme.shape.OurShape;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import javax.swing.JPanel;

public class DrawingView extends JPanel implements DrawingListener {

    private Drawing drawing;

    public DrawingView(Drawing drawing) {
        super();

        this.drawing = drawing;

        // On s'enregistre auprès du modèle pour recevoir ses événements
        drawing.addListener(this);
    }

    @Override
    public void drawingChanged(DrawingEvent e) {
        // Le modèle nous a notifié qu'il a a été modifié
        // On redessine la vue
        repaint(); // Cela va automatiquement appeler la méthode paintComponent
    }

    @Override
    public void paintComponent(Graphics g) {
        // Dessin du fond
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g; // should be checked

        Iterator it = drawing.iterator();

        // Dessin des formes
        while (it.hasNext()) {
            Object o = it.next();
            OurShape shape = (OurShape) o;
            shape.draw(g2d);
        }
    }
}
