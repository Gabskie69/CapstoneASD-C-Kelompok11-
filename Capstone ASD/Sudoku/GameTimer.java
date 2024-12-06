package Sudoku;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimer extends JLabel {
    private static final long serialVersionUID = 1L; // Untuk menghindari warning serialisasi

    private Timer timer;
    private int secondsElapsed;

    public GameTimer() {
        super("Time: 00:00");
        secondsElapsed = 0;

        // Buat timer yang di-trigger setiap detik
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secondsElapsed++;
                updateDisplay();
            }
        });

        // Tambahkan style ke JLabel
        setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
    }

    /** Mulai timer */
    public void start() {
        secondsElapsed = 0;  // Reset waktu
        updateDisplay();
        timer.start();
    }

    /** Hentikan timer */
    public void stop() {
        timer.stop();
    }

    /** Format waktu ke "MM:SS" */
    private void updateDisplay() {
        int minutes = secondsElapsed / 60;
        int seconds = secondsElapsed % 60;
        setText(String.format("Time: %02d:%02d", minutes, seconds));
    }
}
