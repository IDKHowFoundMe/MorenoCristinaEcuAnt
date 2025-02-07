package UIC.CustomerControl;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import UIC.MEStyle;

public class MELabel extends JLabel{
    public MELabel(){
        customizeComponent();
    }
    public MELabel(String text){
        setText(text);
        customizeComponent();
    }
    private void customizeComponent(){
        setCustomizeComponent(getText(), MEStyle.FONT, MEStyle.COLOR_FONT_LIGHT, MEStyle.ALIGNMENT_LEFT);
    }
    public void setCustomizeComponent(String text, Font  font, Color color, int alignment) {
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(color);
        setHorizontalAlignment(alignment);
        //setIcon(new ImageIcon(iconPath));
    }
}