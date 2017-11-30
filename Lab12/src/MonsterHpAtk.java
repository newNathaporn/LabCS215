import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MonsterHpAtk extends JFrame {
	JButton open, atk;
	JTextArea txtA;
	JScrollPane scro;
	int hpN, atkN;
	HashMap<String, Monster> mon = new HashMap<>();

	public MonsterHpAtk() {

		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());

		JPanel pN = new JPanel();
		open = new JButton("Open");
		pN.add(open, BorderLayout.WEST);
		open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				File f = new File("monster.txt");
				FileReader fR;
				try {
					fR = new FileReader(f);
					BufferedReader reader = new BufferedReader(fR);
					String s = reader.readLine();
					String str = "";
					txtA.setText("");
					while (s != null) {
						String[] monster = s.split(" ");
						String name;
						int hp;
						int atk;
						name = monster[0];
						hp = Integer.parseInt(monster[1]);
						atk = Integer.parseInt(monster[2]);
						Monster monSters = new Monster(name, hp, atk);

						if (mon.containsKey(name)) {

							hpN = mon.get(name).getHp() + hp;
							atkN = mon.get(name).getAtk() + atk;
							mon.get(name).setHp(hpN);
							mon.get(name).setAtk(atkN);

						} else {
							mon.put(name, monSters);

						}
						s = reader.readLine();

					}
					for (Monster m : mon.values()) {
						txtA.append(m.toString());
					}
					reader.close();
					fR.close();

				} catch (FileNotFoundException e1) {
					System.out.println("FileNotFound");
				} catch (IOException e1) {
					System.out.println("IOException");
				}
			}
		});

		atk = new JButton("attackList");
		pN.add(atk, BorderLayout.EAST);
		atk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				File f = new File("attackSequence.txt");
				try {
					FileReader fR = new FileReader(f);
					BufferedReader bR = new BufferedReader(fR);
					String s = bR.readLine();
					txtA.setText("");
					while (s != null) {
						String[] monster = s.split(" ");
						String nameMon1;
						String nameMon2;

						nameMon1 = monster[0];
						nameMon2 = monster[1];

						if (mon.containsKey(nameMon1)) {
							int hpNew = mon.get(nameMon2).getHp() - mon.get(nameMon1).getAtk();
							if (hpNew < 0) {
								hpNew = 0;
							}
							mon.get(nameMon2).setHp(hpNew);
							txtA.append(mon.get(nameMon1).getName() + " hit " + mon.get(nameMon2).getName()
									+ " with damage " + mon.get(nameMon1).getAtk() + "\n" + mon.get(nameMon2).getName()
									+ " has hp " + hpNew + " fell to " + mon.get(nameMon2).getHp() + "\n"
									+ "----------------------------------------------------------" + "\n");
						}

						s = bR.readLine();
					}

				} catch (FileNotFoundException e1) {
					System.out.println("FileNotFoundException");
				} catch (IOException e1) {
					System.out.println("IOException");
				}

				for (Monster m : mon.values()) {
					if (m.getHp() <= 0) {
						txtA.append(m.getName() + " died." + "\n");
					} else {
						txtA.append(m.getName() + " remain Hp " + m.getHp() + "." + "\n");
					}

				}

			}
		});

		add(pN, BorderLayout.NORTH);
		txtA = new JTextArea(10, 20);
		scro = new JScrollPane(txtA);
		p.add(scro);

		p.add(pN, BorderLayout.NORTH);
		p.add(scro);
		add(p);
		// pack();
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {
		new MonsterHpAtk();

	}
}
