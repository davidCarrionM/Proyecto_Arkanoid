
package arkanoid;

import javax.swing.JFrame;

/**
 * Main
 */
public class Application {
  public static void main(String[] args) {
    Principal frame = new Principal();
    frame.setSize(1000, 1000);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

  }
}
