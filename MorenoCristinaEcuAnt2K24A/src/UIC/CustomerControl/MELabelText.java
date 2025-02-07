package UIC.CustomerControl;

import javax.swing.*;

import UIC.MEStyle;

import java.awt.*;

public class MELabelText extends JPanel{
    private MELabel    lblEtiqueta = new MELabel();
    private METextBox  txtContenido= new METextBox();

    public MELabelText(String etiqueta) {
        setLayout(new BorderLayout());

        lblEtiqueta.setCustomizeComponent(  etiqueta, 
                                            MEStyle.FONT_SMALL, 
                                            MEStyle.COLOR_FONT_LIGHT, 
                                            MEStyle.ALIGNMENT_LEFT); 
        //txtContenido.setBorder(txtContenido.createBorderLine());
        txtContenido.setBorderLine();
        add(lblEtiqueta, BorderLayout.NORTH);
        add(txtContenido, BorderLayout.CENTER);
    }
}
