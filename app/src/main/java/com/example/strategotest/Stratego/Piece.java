package com.example.strategotest.Stratego;

import com.example.strategotest.R;

/**
 * @author Gareth Rice
 * @author Caden Deutscher
 * @author Hewlett De Lara
 * @author Devam Patel
 * @version 3/21
 */
public class Piece {

    //player number (0 = red, 1 = blue)
    //Lake = -1
    private int player;

    private String name;

    //if the value is 0, it is a flag
    //if the value is 10, it is a bomb
    //if the value is 11, it is the spy
    private int value;

    private boolean isVisible = true;
    private boolean wasSeen = false;

    //the res drawable icon for the piece
    private int icon; //doesn't work like I want it to. Maybe fix later?

    public Piece(String name, int val, int player, int icon) {
        this.value = val;
        this.player = player;

        this.icon = icon;
        this.name = name;
    }

    public Piece(String name, int val, int player, boolean wasSeen) {
        this.name = name;
        this.value = val;

        this.player = player;
        this.wasSeen = wasSeen;
    }

    public String toString() {
        String toReturn;
        if (isVisible) {
//            toReturn = "P:" + player + ", N:" + name + ", V:" + value;
            toReturn = " (" + name.substring(0, 2) + ", " + value + ") ";
        } else {
            toReturn = " (INV) ";
        }

        return toReturn;
    }

    /**
     *  Getters and setters for piece class
     *
     */

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public boolean getVisible() {
        return isVisible;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getIcon() {
        return icon;
    }

    public void setWasSeen(boolean wasSeen) {
        this.wasSeen = wasSeen;
    }

    public boolean getWasSeen() {
        return wasSeen;
    }

    /**
     * move gives move checks to make sure a move is legal.
     *
     * @param toPlace
     * @return
     */
    public boolean move(Piece toPlace) {
        boolean toReturn = true;
        //prevent null point exception
        if (toPlace == null) {
            return true;
        }
        //don't move bomb or flag
        if (this.getValue() == 0 || this.getValue() == 10 || this.getPlayer() < 0) {
            return false;
        }
        //Don't move on lake
        if (toPlace.getPlayer() < 0) {
            return false;
        }
        //if a piece tries to move onto a space that is occupied by a friendly piece, can't move
        if (this.getPlayer() == toPlace.getPlayer()) {
            toReturn = false;
        }
        //If lake cannot move there
        else if (toPlace.getPlayer() == -1) {
            toReturn = false;
        }


        return toReturn;
    }

    /**
     * Attack compares values to determine legal attacks.
     *
     * @param toAttack
     * @return
     */
    public boolean attack(Piece toAttack) {
        if (toAttack.getValue() == 0) { // check if flag
            return true;
        } else if (this.getValue() == 8 && toAttack.getValue() == 10) {
            return true;
        } else if (toAttack.getValue() == 10) { // if bomb, fail attack
            return false;
        } else if (this.getValue() == 11 && toAttack.getValue() == 1) {
            return true;
        } else if (this.getValue() < toAttack.getValue()) { // if lower piece wins, return true
            return true;
        } else if (this.getValue() > toAttack.getValue()) { // if lower piece loses, return false
            return false;
        } else {
            return true;
        }
    }

    /**
     * Determines if two pieces are equal
     *
     * @param p - the piece to check against
     * @return true if the pieces are the same or false if the pieces are not
     */
    public boolean equals(Piece p) {
        if (p.getValue() != this.getValue()) {
            return false;
        }
        if (p.getPlayer() != this.getPlayer()) {
            return false;
        }
        if (p.getVisible() != this.getVisible() || p.getWasSeen() != this.getWasSeen()) {
            return false;
        }
        return true;
    }


}

