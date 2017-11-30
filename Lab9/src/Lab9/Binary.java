package Lab9;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Binary extends JFrame {
	public class person {

	}

	JTextArea txtArea;
	JLabel lSum,lCal;
	JButton btnOpen, btnSave;
	JFileChooser open, save;
	FileOutputStream fo = null;
	ObjectOutputStream os;
	FileInputStream fi = null;
	ObjectInputStream is;
	double sum;

	public Binary() {
		JPanel pN = new JPanel();
		txtArea = new JTextArea(10, 20);
		pN.add(txtArea);

		JPanel pS = new JPanel();
		JPanel p = new JPanel();
		
		btnOpen = new JButton("Open");
		btnSave = new JButton("Save");
		
		
		btnOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = "";
				
				open = new JFileChooser();
				int option = open.showOpenDialog(null);
				if (option == JFileChooser.APPROVE_OPTION) {
					File f = open.getSelectedFile();
					try {
						fi = new FileInputStream(f);
						is = new ObjectInputStream(fi);

						while (true) {
							try {
								double d = is.readDouble();
								sum += d;
								
								String s = d + " " ;
								txtArea.append(s + "\n");
								//System.out.println(s);
								
								
							} catch (EOFException e1) {
								//System.out.println("End of file");
								break;
							}
						}
						str = sum+"";
						lSum.setText("Sum: " + str);
						is.close();
						fi.close();

					} catch (FileNotFoundException e1) {
						System.out.println("FileNotFound");
					} catch (IOException e1) {
						System.out.println("IOException");
					}

				}
				
				

			}
		});
		

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				save = new JFileChooser();
				int option = save.showSaveDialog(null);
				if (option == JFileChooser.APPROVE_OPTION) {
					File f = save.getSelectedFile();
					try {
						fo = new FileOutputStream(f);
						os = new ObjectOutputStream(fo);
						String str = txtArea.getText();
						String[] txt = str.split("\n");
						for (int i = 0; i < txtArea.getLineCount(); i++) {
							double d = Double.parseDouble(txt[i]);
							os.writeDouble(d);
						}

						os.close();
						fo.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						System.out.println("FileNotFound");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						System.out.println("IOException");
					}

				}

			}
		});

		lSum = new JLabel("Sum:");
		pS.add(lSum,BorderLayout.WEST);
		pS.add(btnOpen,BorderLayout.EAST);
		pS.add(btnSave,BorderLayout.EAST);
		add(pN, BorderLayout.NORTH);
		add(pS, BorderLayout.SOUTH);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) throws IOException {

		new Binary();
		/*
		 * File f = new File("Binary.txt"); FileOutputStream fo = new
		 * FileOutputStream(f); ObjectOutputStream os = new
		 * ObjectOutputStream(fo);
		 * 
		 * os.writeDouble(10.1); os.close(); fo.close();
		 * 
		 * FileInputStream fi = new FileInputStream(f); ObjectInputStream is =
		 * new ObjectInputStream(fi); try { while(true){ double d =
		 * is.readDouble(); System.out.println(d);
		 * 
		 * }
		 * 
		 * } catch (EOFException e) { System.out.println("End of file"); }
		 * 
		 * 
		 * is.close(); fi.close();
		 */

	}

}
