
package arkanoid;

import javax.swing.JFrame;

public class Application {
  public static void main(String[] args) {
    Principal frame = new Principal();
    frame.setSize(1000, 1000);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
