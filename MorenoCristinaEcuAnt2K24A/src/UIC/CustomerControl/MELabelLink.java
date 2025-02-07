package UIC.CustomerControl;

import javax.swing.ImageIcon;

import UIC.MEStyle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MELabelLink extends MELabel implements MouseListener {

    MELabelLink(String text){
        super(text);
        setPersonalizacion();
    }

    MELabelLink(String text, String iconPath){
        super(text);
        setPersonalizacion();
        setIcon(new ImageIcon(iconPath));
    }
    
    void setPersonalizacion(){
        addMouseListener(this);
        setOpaque(false);
        setForeground(MEStyle.COLOR_FONT);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setCursor(MEStyle.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setCursor(MEStyle.CURSOR_DEFAULT);
    }
}
