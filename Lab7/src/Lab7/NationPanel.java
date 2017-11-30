package Lab7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NationPanel extends JPanel implements MouseListener{
	private JLabel helloLabel;
	private JTextField nationText;
	private JButton helloBtn;
        public NationPanel(){
           helloLabel = new JLabel("Select Nation");
           nationText = new JTextField(9);
           helloBtn = new JButton("Say Hello");
           helloBtn.setActionCommand("say hello");
           helloBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(helloBtn.getActionCommand().equals("say hello"))
				{
					if(nationText.getText().equals("China"))
					{
					    helloLabel.setText("Ni Hao");
					}
					else if(nationText.getText().equals("Japan"))
					{
						helloLabel.setText("Konichiwa");
					}
					else if(nationText.getText().equals("France"))
					{
						helloLabel.setText("Bonjour");
					}
					else if(nationText.getText().equals("Italy"))
					{
						helloLabel.setText("Ciao");
					}
					else if(nationText.getText().equals("English"))
					{
						helloLabel.setText("Hello");
					}
					else
					{
						try {
							throw new NationException();
						} catch (NationException e) {
							 e.getMessage();
						}
					}
				}
				
			}
        	   
           });
           this.add(nationText);
           this.add(helloBtn);
           this.add(helloLabel);
        }
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}
