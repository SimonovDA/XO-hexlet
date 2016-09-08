package io.hexlet.xo.model;

import org.junit.Test;
import sun.text.resources.cldr.gu.FormatData_gu;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Simonov on 08.09.2016.
 */
public class FieldTest {
    @Test
    public void getSize() throws Exception {
        Field field = new Field();

        assertEquals(3,field.getSize());
    }

    @Test
    public void getFigure() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint,inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure,actualFigure);
    }

    @Test
    public void setFigure() throws Exception {

    }

}