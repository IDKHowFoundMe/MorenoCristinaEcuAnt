import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import UIC.Form.MEHormigueroPanel;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            // Crear el marco principal
            JFrame frame = new JFrame("Hormiguero Experimental");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600); // Tamaño de la ventana
            frame.setLocationRelativeTo(null); // Centrar la ventana

            // Crear el panel de hormiguero y agregarlo al marco
            MEHormigueroPanel panelHormiguero = new MEHormigueroPanel();
            frame.add(panelHormiguero);

            // Hacer visible el marco
            frame.setVisible(true);
        });
    }
}
