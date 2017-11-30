
public class Monster {

	public String name;
	public int hp;
	public int atk;

	public Monster(String name, int hp, int atk) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public int getAtk() {
		return atk;
	}

	@Override
	public String toString() {
		return name + " hp =" + hp + ", atk =" + atk + "\n";
	}

}
