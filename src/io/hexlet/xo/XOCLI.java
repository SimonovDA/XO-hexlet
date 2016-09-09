package io.hexlet.xo;

import com.sun.org.apache.bcel.internal.classfile.ConstantValue;
import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Player;
import io.hexlet.xo.view.ConsoleView;

public class XOCLI {

    public static void main(String[] args) {
        final String name1 = "Gleb";
        final String name2 = "Slava";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2,Figure.O);

        Game gameXO = new Game(players,new Field(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while (consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }
    }

}
