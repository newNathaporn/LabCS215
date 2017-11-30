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
import javax.swing.JTextField;

public class Personal extends JFrame{
	JLabel lName,lId;
	JTextField txtName,txtId;
	JButton btnOpen,btnSave;
	JFileChooser open,save;
	FileInputStream fi;
	ObjectInputStream is;
	FileOutputStream fo;
	ObjectOutputStream os;
	Person p;
	
	public Personal() {
	
		setTitle("Person Test");
		JPanel pN = new JPanel();
		lName = new JLabel("Name");
		txtName = new JTextField(10);
		
		lId = new JLabel("Id");
		txtId = new JTextField(10);
		pN.add(lName);
		pN.add(txtName);
		pN.add(lId);
		pN.add(txtId);
		
		add(pN,BorderLayout.NORTH);
		JPanel pS = new JPanel();
		btnOpen = new JButton("Open");
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
								Person o = (Person)is.readObject();
								
								
								txtName.setText(o.getName());
								txtId.setText(o.getId());
								
								
							} catch (EOFException e1) {
								//System.out.println("End of file");
								break;
							} catch (ClassNotFoundException e1) {
								System.out.println("ClassNotFoundException");
							
							}
						}
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
		btnSave = new JButton("Save");
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
						String str = txtName.getText();
						String id = txtId.getText();
						//String[] txt = str.split("\n");
						
						p = new Person(str, id);
						os.writeObject(p);
						
						

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
		
		pS.add(btnOpen);
		pS.add(btnSave);
		
		add(pS,BorderLayout.SOUTH);
		
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Personal();
	}

}
