/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANIL MENON
 */
public class LadderSquare extends SorLSquare {

    /**
     * Places the player at the particular position (endSquare) if the player
     * lands on a ladder square (number).
     */
    public LadderSquare(int number, int endSquare) {

        super(number, endSquare);

        if (endSquare < number) {
            throw new IllegalArgumentException("lower");
        }
    }

    /**
     * Returns the square that the player ends up after landing on a ladder
     * square.
     */
    public int landOn() {

        return super.getEndSquare();
    }

    /**
     * Outputs number+endSquare.
     */
    public String toString() {

        return super.getNumber() + "+" + super.getEndSquare();
    }

    /**
     * There is no equals method hence we do not need to override because there
     * are no additional values to check since the SorLSquare checks the
     * endSquares and the number variables.
     */
}
