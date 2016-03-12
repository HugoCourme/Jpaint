package com.hugocourme.model.edition;

import com.hugocourme.controller.DrawingController;
import com.hugocourme.shape.OurShape;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

public class ModelDEdition {

    public static List<DrawingController> controleur = new LinkedList<DrawingController>();
    public static List<OurShape> selectedShape = new LinkedList<OurShape>();
    public static Color currentFillingColor = Color.WHITE;
    public static Color currentBorderColor = Color.BLACK;
}
