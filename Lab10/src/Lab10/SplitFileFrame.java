package Lab10;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class SplitFileFrame extends JFrame {

	private JTextField numTosFil, outFileFil;
	private JButton browseBtn, splitBtn;
	private File file;
	private JFileChooser chooser;

	public SplitFileFrame() {
		this.chooser = new JFileChooser();
		this.numTosFil = new JTextField(12);
		this.numTosFil.setBorder(new TitledBorder("Num to Split"));
		this.outFileFil = new JTextField(12);
		this.outFileFil.setBorder(new TitledBorder("Output File Name"));
		this.browseBtn = new JButton("Browse");
		this.browseBtn.addActionListener(e -> browseFile());
		this.splitBtn = new JButton("Split");
		this.splitBtn.addActionListener(e -> splitToFile());
		JPanel cenPanel = new JPanel(new GridLayout(1, 2));
		JPanel btnPanel = new JPanel();
		cenPanel.add(numTosFil);
		cenPanel.add(outFileFil);
		btnPanel.add(browseBtn);
		btnPanel.add(splitBtn);
		this.add(cenPanel);
		this.add(btnPanel, BorderLayout.SOUTH);
		this.setTitle("Split File");
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void browseFile() {
		int check = this.chooser.showOpenDialog(this);
		if (check == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		}
	}

	private void splitToFile() {
		String numStr = numTosFil.getText().trim();
		String fileOutStr = outFileFil.getText().trim();
		int check = 0;
		if (numStr.equals("")) {
			JOptionPane.showMessageDialog(this, "please enter number to split", "Error", JOptionPane.ERROR_MESSAGE);
			check++;
		}
		if (fileOutStr.equals("")) {
			JOptionPane.showMessageDialog(this, "please enter output file name", "Error", JOptionPane.ERROR_MESSAGE);
			check++;
		}
		if (file == null) {
			JOptionPane.showMessageDialog(this, "please select file", "Error", JOptionPane.ERROR_MESSAGE);
			check++;
		}
		if (check == 0) {
			int cut = Integer.parseInt(numStr);
			long fileSize = file.length();
			long cutNum = fileSize / cut;
			File fileArr[] = new File[cut];
			byte[] tempByte = new byte[(int) cutNum];
			for (int i = 0; i < fileArr.length; i++) {
				fileArr[i] = new File(fileOutStr + (i + 1));
			}
			try (RandomAccessFile raf = new RandomAccessFile(file, "r");) {
				for (int i = 0; i < cut; i++) {
					raf.read(tempByte);
					RandomAccessFile raf2 = new RandomAccessFile(fileArr[i], "rw");
					raf2.write(tempByte);
				}

			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void main(String[] args) {
		new SplitFileFrame();
	}

}
