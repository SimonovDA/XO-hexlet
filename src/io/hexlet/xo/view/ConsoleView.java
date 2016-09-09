package io.hexlet.xo.view;

import io.hexlet.xo.controller.CurrentMoveController;
import io.hexlet.xo.controller.MoveController;
import io.hexlet.xo.controller.WinnerController;
import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.awt.*;

public class ConsoleView {

    private CurrentMoveController currentMoveController = new CurrentMoveController();

    private WinnerController winnerController = new WinnerController();

    private MoveController moveController = new MoveController();

    public void show(final Game game) {
        System.out.format("Game name: %s \n", game.getName());
        final Field field = game.getField();
        for (int x = 0; x < field.getSize(); x ++) {
            printLine(field,x);
            if (x != 2)
            printSeparator();
        }
    }

    public boolean move(final Game game) {
        final Field field = game.getField();

        final Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            System.out.format("Winner is: %s\n", winner);
            return false;
        }
        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
                System.out.println("No winner and moves left!");
                return false;
        }
        System.out.format("Please ienter move point for:  %s \n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field,point,currentFigure);
        } catch (final InvalidPointException |AlreadyOccupiedException e) {
            System.out.println("Point is invalid!");
        }
        return true;
    }

    private Point askPoint() {
        return new Point(askCoorfinate("X") - 1, askCoorfinate("Y") - 1);
    }

    private int askCoorfinate(final String cordinateName) throws InputMismatchException{
        System.out.format("Please input %s ", cordinateName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("0_0 olololo!!!");
            return askCoorfinate(cordinateName);
        }
    }

    private void printLine(final Field field,
                           final int x) {

        for (int y = 0; y < field.getSize(); y++) {
            if (y != 0)
                System.out.print("|");
            System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(y , x));
            } catch (final InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("~~~~~~~~~~~");
    }

}
