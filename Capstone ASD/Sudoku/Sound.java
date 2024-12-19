/**
 * ES234317-Algorithm and Data Structures
 * Semester Ganjil, 2024/2025
 * Group Capstone Project
 * Group #11
 * 1 - 5026231036 - Shafly Hidayatullah
 * 2 - 5026231071 - Aryabima Kurnia Pratama Santoso
 * 3 - 5026231189 - Gabriel Hadi Melvanto Sihaloho
 */
package Sudoku;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound{

    private Clip backgroundClip; // Clip for background music

    // Method to play background music
    public void playBackgroundMusic(String filePath) {
        try {
            // Stop and close the current clip if it's running
            if (backgroundClip != null) {
                backgroundClip.stop();
                backgroundClip.close();
            }

            // Initialize a new clip
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            backgroundClip = AudioSystem.getClip();
            backgroundClip.open(audioStream);
            backgroundClip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the background music
            backgroundClip.start();
        } catch (Exception ex) {
            System.out.println("Error playing background music: " + ex.getMessage());
        }
    }

    // Method to stop background music
    public void stopBackgroundMusic() {
        if (backgroundClip != null && backgroundClip.isRunning()) {
            backgroundClip.stop();
            backgroundClip.close();
            backgroundClip = null; // Clear the reference
        }
    }

    // Method to play sound effects
    public void playSoundEffect(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip soundClip = AudioSystem.getClip();
            soundClip.open(audioStream);
            soundClip.start(); // Play the sound effect
        } catch (Exception ex) {
            System.out.println("Error playing sound effect: " + ex.getMessage());
        }
    }
}