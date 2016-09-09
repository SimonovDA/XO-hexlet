package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.io.IOException;

public class Field {

    private static final int MIN_COORDINATE = 0;

    private final int field_size;

    private final Figure[][] field;

    public Field(int field_size) {
        this.field_size = field_size;
         field = new Figure[field_size][field_size];
    }

    public int getSize () {
        return field_size;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinat(point.x, field.length) && checkCoordinat(point.y, field[point.x].length);
    }

    private boolean checkCoordinat(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }

}
