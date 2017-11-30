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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QueryFile extends JFrame {
	JButton bDel;
	JTextField txtPath,txtQuery;
	JLabel lbPath,lbQuery;
	
	public  QueryFile() {
		JPanel p = new JPanel();
		lbPath = new JLabel("path");
		lbQuery = new JLabel("query");
		txtPath = new JTextField(10);
		txtQuery = new JTextField(10);
		
		bDel = new JButton("Delete");
		bDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				String result= "";
				
				
				try {
					
					BufferedReader reader = new BufferedReader(new FileReader(new File(txtPath.getText())));
					
					boolean b = false;
					String s = reader.readLine();
					CharSequence a = txtQuery.getText();
					
					while (s != null) {
						if(!s.contains(a)){
							
						result += s+"\n";
						}
						else{
							b = true;
							 
						}
						s = reader.readLine();
					}
					
					reader.close();
					
					FileWriter fW = new FileWriter(new File(txtPath.getText()));
					BufferedWriter writer = new BufferedWriter(fW);
					if(b){
						writer.write(result);
						writer.close();
						fW.close();
					
					}
					else{
						System.out.println("TextNotFound");
					}
					
					
				} catch (FileNotFoundException e1) {
					System.out.println("FileNotFound");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		
		p.add(lbPath);
		p.add(txtPath);
		p.add(lbQuery);
		p.add(txtQuery);
	
		p.add(bDel);
		
		
		add(p);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new QueryFile();
	}

}
