package vista;



import javax.swing.JFrame;

import javax.swing.JTextArea;


public class VentanaChofer extends JFrame{
    private JTextArea area = new JTextArea();
  

    public void appendText(String arg)
    {
	    this.area.append(arg+"\n");
    }
}
