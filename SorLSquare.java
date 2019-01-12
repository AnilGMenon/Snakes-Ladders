/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANIL MENON
 */
public class SorLSquare extends SnLSquare {

    private int endSquare;

    /**
     * Receives the number of the square at which the player is at and where
     * they land on (endSquare) depending if they land on a snake or ladder
     * square.
     */
    public SorLSquare(int number, int endSquare) {

        super(number);
        this.endSquare = endSquare;

        if (endSquare == number) {
            throw new IllegalArgumentException("Wrong number");
        }
    }

    /**
     * returns the square that the player will end up depending if they land on
     * snake or ladder square.
     */
    public int getEndSquare() {

        return this.endSquare;
    }

    /**
     * Returns the players position.
     */
    public int landOn() {

        return endSquare;
    }

    /**
     * Overrides the SnLSquare toString() by displaying where the player ends up
     * depending on if the player is on a ladder or snake square.
     */
    public String toString() {

        return super.toString() + ":" + endSquare;
    }

    /**
     * First checks to see if the objects have the same square number then
     * overrides the SnLSquare equals() and checks to see if the instance
     * variable end squares are equal.
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
        SorLSquare s = (SorLSquare) o;
        return super.equals(s) && this.endSquare==s.endSquare;
       
    }

}
