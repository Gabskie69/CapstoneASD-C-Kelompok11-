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

    // Method memulai backsound musik
    public void playBackgroundMusic(String filePath) {
        try {
            // stop backsound musik
            if (backgroundClip != null) {
                backgroundClip.stop();
                backgroundClip.close();
            }

            // inisiasi audio clip
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

    // Method stop backsound musik
    public void stopBackgroundMusic() {
        if (backgroundClip != null && backgroundClip.isRunning()) {
            backgroundClip.stop();
            backgroundClip.close();
            backgroundClip = null; // Clear the reference
        }
    }

    // Method play sound effects
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
