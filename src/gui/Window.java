package gui;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class Window extends JFrame {
    protected JPanel panel;
    protected NumberFormatter formatter;

    public Window(int width, int height, int size) {
        super("2048");
        this.setSize(width, height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(size, size));
        this.add(panel);

        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false);
        formatter = new NumberFormatter(format);
        formatter.setAllowsInvalid(false);
    }
}