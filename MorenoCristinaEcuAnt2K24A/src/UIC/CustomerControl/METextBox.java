package UIC.CustomerControl;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import UIC.MEStyle;

public class METextBox extends JTextField {

    public METextBox() {
        customizeComponent();
    }

    private void customizeComponent() {
        setBorderRect();
        setFont(MEStyle.FONT);  
        setForeground(MEStyle.COLOR_FONT_LIGHT);  
        setCaretColor(MEStyle.COLOR_CURSOR);    // Color del cursor
        setMargin(new Insets(5, 5, 5, 5));      // Ajusta los márgenes
        setOpaque(false);                       // Fondo transparente
        //setUI(new BasicTextFieldUI());  // Para deshabilitar el subrayado por defecto
    }

    public void setBorderRect() {
        Border lineBorder = BorderFactory.createLineBorder(MEStyle.COLOR_BORDER);
        Border emptyBorder = new EmptyBorder(5, 5, 5, 5);  // Márgenes internos
        setBorder( new CompoundBorder(lineBorder, emptyBorder));
    }

    public void setBorderLine(){
        int thickness = 1;
        setBorder(  BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(0, 0, thickness, 0),
                    BorderFactory.createMatteBorder(0, 0, thickness, 0, MEStyle.COLOR_BORDER) 
        ));
    }
}
