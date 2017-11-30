package Lab8;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RWFile extends JFrame {
	
	JButton bO,bM,bS;
	JTextArea aO,aM;
	JFileChooser fc ;
	JScrollPane sO,sM;
	
	public  RWFile() {
		JPanel p = new JPanel();
	
		bO = new JButton("Open");
		bM = new JButton("Import");
		bS = new JButton("Save");
		
		JPanel pW = new JPanel();
		aO = new JTextArea(10,20);
		sO = new JScrollPane(aO);
		pW.add(sO);
		
		JPanel pE = new JPanel();
		aM = new JTextArea(10,20);
		sM = new JScrollPane(aM);
		pE.add(sM);
		
		bO.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fc = new JFileChooser(".");
				int option = fc.showOpenDialog(null);
				if (option == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					FileReader fR;
					try {
						fR = new FileReader(f);
						BufferedReader reader = new BufferedReader(fR);
						String s = reader.readLine();
						while (s != null) {
							//System.out.println(s);
									aO.append(s+"\n" );
									s = reader.readLine();
					
						}
						reader.close();
						fR.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					
				}
				
			}
		});
		
		bM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fc = new JFileChooser(".");
				int option = fc.showOpenDialog(null);
				if (option == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					FileReader fR;
					try {
						fR = new FileReader(f);
						BufferedReader reader = new BufferedReader(fR);
						String s = reader.readLine();
						while (s != null) {
							//System.out.println(s);
									aM.append(s+"\n" );
									s = reader.readLine();
					
						}
						reader.close();
						fR.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		bS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fc = new JFileChooser(".");
				int option = fc.showSaveDialog(null);
				if (option == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					FileWriter fW;
					try {
						fW = new FileWriter(f);
						BufferedWriter writer = new BufferedWriter(fW);
						writer.write(aO.getText());
						writer.write(aM.getText());
						
	
						
						writer.close();
						fW.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		p.add(bO);
		p.add(bM);
		p.add(bS);
		
		
		
		
		
		add(pW,BorderLayout.WEST);
		add(pE,BorderLayout.EAST);
		add(p,BorderLayout.NORTH);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new RWFile();
	}

}
