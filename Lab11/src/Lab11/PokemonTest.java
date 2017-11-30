package Lab11;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PokemonTest extends JFrame {
	JLabel id,name;
	JTextField txtId,txtName;
	JButton bFire, bDragon, bAll, bHybrid;
	HashSet<Pokemon> fire = new HashSet<Pokemon>();
	HashSet<Pokemon> dragon = new HashSet<Pokemon>();
	HashSet<Pokemon> mix = new HashSet<Pokemon>(); 
	HashSet<Pokemon> fireDragon = new HashSet<Pokemon>();
	
	
	public PokemonTest() {
		JPanel p = new JPanel();
		
		id = new JLabel("Id");
		p.add(id);
		txtId = new JTextField(8);
		p.add(txtId);
		
		name = new JLabel("Name");
		p.add(name);
		txtName = new JTextField(10);
		p.add(txtName);
		
		bFire = new JButton("Add to Fire");
		p.add(bFire);
		bFire.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtId.getText());
				fire.add(new Pokemon(id,txtName.getText()));
			}
		});
		
		bDragon = new JButton("Add to Dragon");
		p.add(bDragon);
		bDragon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtId.getText());
				dragon.add(new Pokemon(id, txtName.getText()));
			}
		});
		
		bAll = new JButton("Print All");
		p.add(bAll);
		bAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					mix.addAll(fire);
					mix.addAll(dragon);
					System.out.println("Print All");
				
				for (Pokemon pokemon : mix) {
					System.out.println(pokemon.toString());
				}
			}
		});
		
		bHybrid = new JButton("Print Hybrid");
		p.add(bHybrid);
		bHybrid.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fireDragon.addAll(fire);
				fireDragon.retainAll(dragon);
				
				System.out.println("Print Hybrid");
				for (Pokemon pokemon : fireDragon) {
					System.out.println(pokemon.toString());
				}	
			}
		});
		
		add(p);
		setSize(300,150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new PokemonTest();
		
	}

}
