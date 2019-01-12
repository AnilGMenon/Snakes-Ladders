/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANIL MENON
 */
public class SnakeSquare extends SorLSquare {

    /**
     * Places the player at the particular position (endSquare) if the player
     * lands on a snake square (number).
     */
    public SnakeSquare(int number, int endSquare) {

        super(number, endSquare);

        if (endSquare > number) {
            throw new IllegalArgumentException("lower");
        }
    }

    /**
     * Returns the square that the player ends up after landing on a snake
     * square.
     */
    public int landOn() {

        System.out.println("Oh no!");

        return super.getEndSquare();
    }

    /**
     * Outputs number-endSquare.
     */
    public String toString() {

        return super.getNumber() + "-" + super.getEndSquare();
    }

    /**
     * There is no equals method hence we do not need to override because there
     * are no additional values to check since the SorLSquare checks the
     * endSquares and the number variables.
     */
}
