package game;

import gui.GameWindow;
import java.util.Random;

public class Game {
    private final GameWindow window;
    private final int[][] gameField;
    /**
     * dimension of the gameField e.g. 3x3
     */
    private final int size;
    private int points = 0;
    public Game(GameWindow window, int size) {
        this.window = window;
        this.size = size;
        gameField = new int[size][size];
        prefill();
        window.display(gameField, points);
    }

    private void prefill() {
        for (int i = 0; i < size; i++) {
            fillEmpty();
        }
    }
    private boolean hasEmpty() {
        for (int[] array : gameField) {
            for (int number : array) {
                if (number == 0) return true;
            }
        }
        return false;
    }
    private void fillEmpty() {
        if (!hasEmpty()) return;
        boolean filled = false;
        do {
            Random r = new Random();
            int column = r.nextInt(size);
            int row = r.nextInt(size);
            if (gameField[column][row] == 0) {
                gameField[column][row] = 2;
                filled = true;
                points += 2;
            }
        } while (!filled);
    }

    public void up() {
        for (int i = 0; i < (size - 1); i++) {
            for (int row = 1; row < size; row++) {
                for (int column = 0; column < size; column++) {
                    if (gameField[column][row] == gameField[column][row - 1]) {
                        gameField[column][row - 1] *= 2;
                        gameField[column][row] = 0;
                        points += gameField[column][row - 1];
                    } else if (gameField[column][row - 1] == 0) {
                        gameField[column][row - 1] = gameField[column][row];
                        gameField[column][row] = 0;
                    }
                }
            }
        }
        fillEmpty();
        window.display(gameField, points);
    }
    public void down() {
        for (int i = 0; i < (size - 1); i++) {
            for (int row = (size - 2); row >= 0; row--) {
                for (int column = 0; column < size; column++) {
                    if (gameField[column][row] == gameField[column][row + 1]) {
                        gameField[column][row + 1] *= 2;
                        gameField[column][row] = 0;
                        points += gameField[column][row + 1];
                    } else if (gameField[column][row + 1] == 0) {
                        gameField[column][row + 1] = gameField[column][row];
                        gameField[column][row] = 0;
                    }
                }
            }
        }
        fillEmpty();
        window.display(gameField, points);
    }
    public void left() {
        for (int i = 0; i < (size - 1); i++) {
            for (int column = 1; column < size; column++) {
                for (int row = 0; row < size; row++) {
                    if (gameField[column][row] == gameField[column - 1][row]) {
                        gameField[column - 1][row] *= 2;
                        gameField[column][row] = 0;
                        points += gameField[column - 1][row];
                    } else if (gameField[column - 1][row] == 0) {
                        gameField[column - 1][row] = gameField[column][row];
                        gameField[column][row] = 0;
                    }
                }
            }
        }
        fillEmpty();
        window.display(gameField, points);
    }
    public void right() {
        for (int i = 0; i < (size - 1); i++) {
            for (int column = (size - 2); column >= 0; column--) {
                for (int row = 0; row < size; row++) {
                    if (gameField[column][row] == gameField[column + 1][row]) {
                        gameField[column + 1][row] *= 2;
                        gameField[column][row] = 0;
                        points += gameField[column + 1][row];
                    } else if (gameField[column + 1][row] == 0) {
                        gameField[column + 1][row] = gameField[column][row];
                        gameField[column][row] = 0;
                    }
                }
            }
        }
        fillEmpty();
        window.display(gameField, points);
    }
}