import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
class First implements ActionListener{
	static JTextArea tf;
	static JFrame window;
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
	    window = new JFrame("Keditore IDE");
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
	    tf = new JTextArea();
	    tf.setFont(tf.getFont().deriveFont(25f));
	    Rectangle a = window.getBounds();
	    tf.setLineWrap(true);
	    JScrollPane sc = new JScrollPane(tf);
	    sc.setBounds(a);
	    window.add(sc);
	    window.setVisible(true);
	    First ab = new First();
	    mi1a.addActionListener(ab);
	    mi2a.addActionListener(ab);
	    mi3a.addActionListener(ab);
	    mi4a.addActionListener(ab);
		setLookFeel();
		window.setTitle("Keditore  IDE - New File");	
	}
	
public void actionPerformed(ActionEvent e) {
	String command = e.getActionCommand();
	String data = tf.getText();		
	switch(command) {
			case "New":
			window.setTitle("Keditore  IDE - New File");
			tf.setText("");
			break;
			
			case "Open":
		try {
			OpenFile(data);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
			break;
			
			case "Save": 
		try {
			SaveFile(data);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			break;
			 
			case "Exit": System.exit(0);
			
			break;
			
			default: break;
			}
	}

public static void SaveFile(String a) throws IOException{
	JFileChooser sdialog = new JFileChooser();
	int res = sdialog.showSaveDialog(null);
	if(res == JFileChooser.APPROVE_OPTION)
	{
	String path	 = sdialog.getSelectedFile().getAbsolutePath();
	    FileWriter f = new FileWriter(path);
		BufferedWriter bw = new BufferedWriter(f);
		PrintWriter of = new PrintWriter(bw);
		of.println(a);
		of.close();
		System.out.println(a+"  "+path);
	}
	}
	


public static void OpenFile(String a) throws IOException {
	JFileChooser odialog = new JFileChooser();
	int res = odialog.showSaveDialog(null);
	tf.setText("");
	if(res == JFileChooser.APPROVE_OPTION) {
		String path = odialog.getSelectedFile().getAbsolutePath();
		FileReader f;
	        String tempdata;
			f = new FileReader(path);
			BufferedReader inp =  new BufferedReader(f);
			while((tempdata = inp.readLine())!= null) {
				tf.append(tempdata+"\n");
			    }
	        window.setTitle("Keditore IDE - "+odialog.getSelectedFile().getPath());
			inp.close();		
	}}


}