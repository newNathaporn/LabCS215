package Lab11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FootBallClubTest extends JFrame{
	
	JLabel name,score;
	JTextField txtName,txtScore;
	JButton add,printe;
	PriorityQueue<FootBallClub> football = new PriorityQueue<>();
	
	public FootBallClubTest() {
		JPanel p = new JPanel();
		
		name = new JLabel("Name: ");
		p.add(name);
		
		txtName = new JTextField(10);
		p.add(txtName);
		
		score = new JLabel("Score: ");
		p.add(score);
		
		txtScore = new JTextField(6);
		p.add(txtScore);
		
		add = new JButton("Add");
		p.add(add);
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int score = Integer.parseInt(txtScore.getText());
				football.add(new FootBallClub(txtName.getText(), score));
				
			}
		});
		
		printe = new JButton("Print Table");
		p.add(printe);
		printe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FootBallClub  i = football.poll();
				while ( i != null) {
					System.out.println(i);
					i = football.poll();
				}
				
			}
		});
		
		add(p);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new FootBallClubTest();
	}

}
