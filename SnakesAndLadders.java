/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANIL MENON
 */
public class SnakesAndLadders {

    public static final int NUM_PLAYERS = 2;
    public static final int NUM_SQUARES = 100;
    private SnLSquare[] board;
    private int[] players;
    private Dice dice;

    /**
     * Constructor chaining for 2 dice.
     */
    public SnakesAndLadders() {

        this(2);
    }

    /**
     * The constructor constructs the board and sets players to square #1.
     */
    public SnakesAndLadders(int nPlayers) {

        players = new int[nPlayers];
        board = new SnLSquare[100];
        int count = 0;

        board[3] = new LadderSquare(4, 14);
        board[8] = new LadderSquare(9, 31);
        board[16] = new SnakeSquare(17, 7);
        board[19] = new LadderSquare(20, 38);
        board[27] = new LadderSquare(28, 84);
        board[39] = new LadderSquare(40, 59);
        board[52] = new SnakeSquare(53, 34);
        board[61] = new SnakeSquare(62, 18);
        board[62] = new LadderSquare(63, 81);
        board[63] = new SnakeSquare(64, 60);
        board[70] = new LadderSquare(71, 91);
        board[86] = new SnakeSquare(87, 24);
        board[92] = new SnakeSquare(93, 73);
        board[94] = new SnakeSquare(95, 75);
        board[98] = new SnakeSquare(99, 78);

        for (int i = 0; i < NUM_SQUARES; i++) {
            if (board[i] instanceof SorLSquare) {
                count++;
            } else {
                count += 1;
                board[i] = new SnLSquare(count);
            }
        }

        for (int i = 0; i < nPlayers; i++) {
            players[i] = board[0].getNumber();
        }
    }

    /**
     * Allows a player to roll the dice and move forward along the S&L board. If
     * the player rolls a double then takeTurn will return true. It will also
     * check to see if player rolls more than required to land on the 100th
     * square. *
     */
    public boolean takeTurn(int player) {

        Dice die = new Dice();
        int diceSum;
        diceSum = die.roll();
        System.out.println("Player " + player + " rolled " + diceSum);

        if (board[players[player] - 1] instanceof SorLSquare) {
            players[player] = board[players[player] - 1].landOn();
        } else {
            players[player] += board[diceSum - 1].getNumber();
        }

        if (players[player] != 100) {
            if (100 - (players[player]) < diceSum) {
                int backward = 100 - players[player];
                int forward = diceSum - backward;
                players[player] += (backward - forward);
            }
        } else {
            isPlayerWinner(player);
        }

        return die.hasDoubles();

    }

    /**
     * Returns true if a player is at the 100th square otherwise it returns
     * false.
     */
    public boolean isPlayerWinner(int player) {

        if (players[player] == 100) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns which player is the winner.
     */
    public int getWinner() {

        int winner = -1;

        for (int i = 0; i < players.length; i++) {
            if (players[i] == 100) {
                winner = i;
            }
        }

        return winner;
    }

    /**
     * Returns the current position of the player.
     */
    public int getPlayerPosition(int player) {

        return players[player];
    }

    /**
     * Outputs the board.
     */
    public String toString() {

        String board = "";
        int counter = 1;

        for (int i = 0; i < NUM_SQUARES; i++) {
            board += "| " + this.board[i] + " ";

            if (counter == 10) {
                board += "\n";
                counter = 0;
            }
            counter++;
        }

        return board;
    }

    /**
     * Outputs the current position of each player.
     */
    public String toStringCurrentPositions() {

        String curr = "";

        for (int i = 0; i < players.length; i++) {
            curr += i + ":" + getPlayerPosition(i) + " ";
        }

        return curr;
    }

    public static void main(String args[]) {

        boolean player;
        boolean hasdoubles;
        int winner;

        SnakesAndLadders board = new SnakesAndLadders();
        System.out.println(board.toString());

        do {
            for (int i = 0; i < 2; i++) {
                player = board.takeTurn(i);
                System.out.println(board.toStringCurrentPositions());

                if (player == true) {
                    player = board.takeTurn(i);
                }
                if (board.getWinner() != -1) {
                    break;
                }
            }

        } while (board.getWinner() == -1);

        if (board.isPlayerWinner(0)) {
            System.out.println("Player " + 0 + " wins.");
        }
        if (board.isPlayerWinner(1)) {
            System.out.println("Player " + 1 + " wins.");
        }
    }
}
