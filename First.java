import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
class First implements ActionListener{
	
	public First() {
		JFrame window = new JFrame("Keditore IDE");
		JMenuBar mb = new JMenuBar();
		JMenu ma = new JMenu("File");
		JMenuItem mi1a = new JMenuItem("New");
		JMenuItem mi2a = new JMenuItem("Open");
		JMenuItem mi3a = new JMenuItem("Save");
		JMenuItem mi4a = new JMenuItem("Exit");
	    ma.add(mi1a);
	    ma.add(mi2a);
	    ma.add(mi3a);
	    ma.add(mi4a);
	    mb.add(ma);
	    window.setBounds(100, 100, 600, 600);
	    window.setJMenuBar(mb);
	    JTextArea tf = new JTextArea();
	    tf.setFont(tf.getFont().deriveFont(25f));
	    Rectangle a = window.getBounds();
	    tf.setLineWrap(true);
	    JScrollPane sc = new JScrollPane(tf);
	    sc.setBounds(a);
	    window.add(sc);
	    window.setVisible(true);
	    mi1a.addActionListener(this);
	    mi2a.addActionListener(this);
	    mi3a.addActionListener(this);
	    mi4a.addActionListener(this);
	}
	
	public static void setLookFeel(){
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	 
	public static void main(String[] args) {
	First a = new First();
	setLookFeel();
      }
public void actionPerformed(ActionEvent e) {
	String command = e.getActionCommand();
			switch(command) {
			case "New":
			break;
			case "Open":
			break;
			case "Save": 
			break;
			case "Exit": System.exit(0);
			break;
			default: break;
			}
	}

public static void SaveFile() {
	
}
}