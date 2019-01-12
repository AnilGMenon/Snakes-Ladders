/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANIL MENON
 */
public class SnLSquare {

    private int number;

    /**
     * Allocates the instance variable "number" with the initial position of the
     * player.
     */
    public SnLSquare(int number) {

        this.number = number;
    }

    /**
     * Returns the square number.
     */
    public int getNumber() {

        return this.number;
    }

    /**
     * Returns the square that the player has landed on.
     */
    public int landOn() {

        return this.number;
    }

    /**
     * Outputs the square the player is positioned.
     */
    public String toString() {

        return "" + number;
    }

    /**
     * Checks to see if the instance variable of Object o is equal to the
     * instance variable of c.
     */
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        SnLSquare c = (SnLSquare) o;
        return (this.number == c.number);

    }

}
