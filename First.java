import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;

class First implements ActionListener {
	static JTextArea tf;
	static JFrame window;
	static String path="";
    static int cbselect;
    static String s1[] = {"C++","HTML","Java"};
    static String filename="";
    static JComboBox ddmenu = new JComboBox(s1);
    public static void setLookFeel() {
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
		JToolBar toolbar = new JToolBar("Applications");
		toolbar.add(ddmenu);
		toolbar.setFloatable(false);
		JButton d = new JButton("RUN");
		JButton d2 = new JButton("STOP");
		toolbar.add(d);
		toolbar.add(d2);
		window.setLayout(new BorderLayout());
		window.getContentPane().add(toolbar, BorderLayout.PAGE_START);
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
		d.addActionListener(ab);
		ddmenu.addActionListener(ab);
		window.setTitle("Keditore  IDE - New File");
	}

public void actionPerformed(ActionEvent e) {
	String command = e.getActionCommand();
	
	String data = tf.getText();		
	switch(command) {
			case "New":
			window.setTitle("Keditore  IDE - New File");
			tf.setText("");
			path="";
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
		   
			e1.printStackTrace();
		}
			break;
			
			case "RUN":
		       String a =(String) ddmenu.getSelectedItem();
				if(path=="") {error(1);try {
					String Data =tf.getText();
					SaveFile(Data);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
				else {
					String k = tf.getText();
					try {
						FileWriter f = new FileWriter(path);
						BufferedWriter bw = new BufferedWriter(f);
						PrintWriter of = new PrintWriter(bw);
						of.println(k);
						of.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				switch(a) 
				{
				case "C++":
				c();
					break;
				
				case "Java":
					jav();
					break;
				
				case "HTML":
					try {
						html(1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				}}
				break;
				
			case "Exit": System.exit(0);
			
			break;
			
			default: break;
			}
				
	}

	public static void SaveFile(String a) throws IOException {
		JFileChooser sdialog = new JFileChooser();
		int res = sdialog.showSaveDialog(null);
		if (res == JFileChooser.APPROVE_OPTION) {
			path = sdialog.getSelectedFile().getAbsolutePath();
			filename = sdialog.getSelectedFile().getName();			
			FileWriter f = new FileWriter(path);
			BufferedWriter bw = new BufferedWriter(f);
			PrintWriter of = new PrintWriter(bw);
			of.println(a);
			window.setTitle("Keditore IDE - " + sdialog.getSelectedFile().getPath());
			of.close();
		}
	}

	public static void OpenFile(String a) throws IOException {
		JFileChooser odialog = new JFileChooser();
		int res = odialog.showOpenDialog(null);
		tf.setText("");
		if (res == JFileChooser.APPROVE_OPTION) {
			path = odialog.getSelectedFile().getAbsolutePath();
			FileReader f;
			String tempdata;
			f = new FileReader(path);
			BufferedReader inp = new BufferedReader(f);
			while ((tempdata = inp.readLine()) != null) {
				tf.append(tempdata + "\n");
			}
			window.setTitle("Keditore IDE - " + odialog.getSelectedFile().getPath());
			
			inp.close();
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			tf.append("\r\n");
		}
		
	}
	
    public static void error(int errorcode) {
    	switch(errorcode) {
    	case 1: JOptionPane.showMessageDialog(null, "Please Save your file before running your code", "Errorr!! Errorr!! Errorr!!", JOptionPane.WARNING_MESSAGE);break;
    	case 2:JOptionPane.showMessageDialog(null, "Please enter a valid path!!! Can't open or save unvalid file paths!!", "Errorr!! Errorr!! Errorr!!", JOptionPane.WARNING_MESSAGE);break;
    	default: break;
    }
}
public static void html(int a) throws IOException {
	
	ProcessBuilder builder = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",path);
        builder.redirectErrorStream(true);
        Process p = builder.start();
        if(a==2)
        {p.destroy();}   

}
public static void c() {
	try {
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"g++ "+path+" "+"&& a.exe \"");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	

public static void jav() {
	String execp = path.replaceFirst(".java", ".class");
	String javac= "\"C:\\Program Files\\BlueJ\\jdk\\bin\\javac.exe\"";
	String j = "\"C:\\Program Files\\BlueJ\\jdk\\bin\\java.exe\"";
	try {
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K"+javac+" "+path);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K"+j+" "+execp+" "+"timeout 12s");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
