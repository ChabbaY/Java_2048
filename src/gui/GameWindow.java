package gui;

import game.Game;
import input.GameWindowListener;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class GameWindow extends Window {
    private final Game game;
    private final JButton[][] buttons;
    private final int size;
    public GameWindow(int size) {
        super(1000, 1000, size);
        this.size = size;

        buttons = new JButton[size][size];
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                JButton button = new JButton("0");
                button.setBackground(Color.RED);
                button.setEnabled(false);
                button.setFont(new Font("Arial", Font.BOLD, 50));
                button.setBorder(null);
                button.setFocusPainted(false);
                UIManager.put("Button.disabledText", new ColorUIResource(Color.BLACK));
                panel.add(button);
                buttons[column][row] = button;
            }
        }

        this.addKeyListener(new GameWindowListener(this));
        game = new Game(this, size);
        this.setVisible(true);
    }

    public void up() {
        game.up();
    }
    public void down() {
        game.down();
    }
    public void left() {
        game.left();
    }
    public void right() {
        game.right();
    }

    public void display(int[][] gameField, int points) {
        for (int column = 0; column < size; column++) {
            for (int row = 0; row < size; row++) {
                buttons[column][row].setText(String.valueOf(gameField[column][row]));
                buttons[column][row].setBackground(getColor(gameField[column][row]));
            }
        }
        this.setTitle("2048 - " + points);
        panel.repaint();
    }

    public Color getColor(int value) {
        return switch (value) {
            case 2 -> new Color(1f, 0f, 0f);//Rot
            case 4 -> new Color(1f, 0.25f, 0f);
            case 8 -> new Color(1f, 0.5f, 0f);
            case 16 -> new Color(1f, 0.75f, 0f);
            case 32 -> new Color(1f, 1f, 0f);//__Gelb
            case 64 -> new Color(0.75f, 1f, 0f);
            case 128 -> new Color(0.5f, 1f, 0f);
            case 256 -> new Color(0.25f, 1f, 0f);
            case 512 -> new Color(0f, 1f, 0f);//Grün
            case 1024 -> new Color(0f, 1f, 0.25f);
            case 2048 -> new Color(0f, 1f, 0.5f);
            case 4096 -> new Color(0f, 1f, 0.75f);
            case 8192 -> new Color(0f, 1f, 1f);//__Cyan
            case 16384 -> new Color(0f, 0.75f, 1f);
            case 32768 -> new Color(0f, 0.5f, 1f);
            case 65536 -> new Color(0f, 0.25f, 1f);
            case 131072 -> new Color(0f, 0f, 1f);//Blau
            case 262144 -> new Color(0.25f, 0f, 1f);
            case 524288 -> new Color(0.5f, 0f, 1f);
            case 1048576 -> new Color(0.25f, 0f, 1f);
            case 2097152 -> new Color(0f, 0f, 1f);//__Magenta
            default -> Color.LIGHT_GRAY;
        };
    }
}