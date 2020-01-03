package com.stevenprogramming.library.ocp8.ch1;

import java.util.Arrays;
import java.util.function.UnaryOperator;

/**
 *
 * @author steven mendez
 */
abstract class TouchScreen2 {
    abstract void tap();
    abstract void swipe();
    abstract void plugin();
    abstract void unplug();
}

interface TouchScreen {
    void tap();
    void swipe();
    void plugin();
    void unplug();
}

abstract class Tablet3 extends TouchScreen2 {
    abstract protected void tap();
    abstract void swipe();
    abstract void plugin();
    abstract void unplug();
}

enum WaterTemperature {
    BOILING(100), FREEZING(0);
    private double temp;

    WaterTemperature(double temp) {
        this.temp = temp;
    }
}

class BodyPart {

    private static double temp = 98.6;

    static class Ear extends BodyPart {

        private double temp = 97.6;

        public void printTemp() {
            System.out.println(super.temp + " " + this.temp);
        }

    }
}

class CharacterName222 {

    private String givenName, surname;

    public CharacterName222(String givenName) {
        this.givenName = givenName;

    }

    public CharacterName222(String givenName, String h) {
        this.givenName = givenName;

    }

}

class NonPlayerCharacterName extends CharacterName222 {

    public NonPlayerCharacterName(String d, String g) {
        super("", "");
    }

}

public class ShadowingPractice {

    public static void main(String[] args) {
        BodyPart e = new BodyPart.Ear();
        Object i;
        System.out.println(WaterTemperature.values());
        String[] emps = {"John"};
        Arrays.stream(emps).filter(emp -> emp.equals("John")).count();
    }
}

abstract class Player {

    String type = "Human";

    public void printType() {
        System.out.println(type);
    }
}

class GamePlayer extends Player {

    GamePlayer() {
        type = "Computer";
    }
}

class TurnBasedPlayer extends GamePlayer {

    //String type = "Turn-based";
}

class ChessPlayer extends TurnBasedPlayer {

    ChessPlayer() {
        type = "Chess";
    }

    public void printType() {
        System.out.println(type);
    }
}

class CheckersPlayer extends TurnBasedPlayer {

    CheckersPlayer() {
        //type = "Checkers";
    }

    public void printType() {
        System.out.println(type);
    }
}

class Walker {

    protected double elevation;
    protected int distance;

    int move(int data) {
        return distance += data;
    }

    protected static void getWalkerInfo(Walker w) {
        System.out.println(w.distance);
    }
}

class UphillHiker extends Walker {

    public double elevation;

    Double h;

    public int move(int data) {
        elevation += .5;
        return distance += data;
    }

    public static void getWalkerInfo(Walker w) {
        System.out.println(w.distance + "-" + w.elevation);
    }
}

class Certification {

    private Double getScore() {
        return 90.2;
    }
}

class JavaII extends Certification {

    public Integer getScore() throws Exception {
        return 65;
    }

    public void getScore(int v) throws Exception {
        return;
    }

}

class FlexibleAdder {

    public static String add(long v1, long v2) {
        return "longs";
    }

    public static String add(Long v1, Long v2) {
        return "Longs";
    }

    public static String add(Object vals) {
        return "Objects";
    }

    public static String add(long... vals) {
        return "varargs long";
    }

    public static String add(Long... vals) {
        return "varargs Long";
    }

    public static String add(Object... vals) {
        return "varargs Object";
    }
}
