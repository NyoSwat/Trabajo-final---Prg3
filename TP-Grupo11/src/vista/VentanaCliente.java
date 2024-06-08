package vista;

import java.awt.HeadlessException;


import javax.swing.JFrame;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VentanaCliente extends JFrame{
    private JTextArea area = new JTextArea();
  

    public void appendText(String arg)
    {
	    this.area.append(arg+"\n");
    }
}
