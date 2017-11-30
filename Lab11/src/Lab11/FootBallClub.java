package Lab11;


public class FootBallClub implements Comparable<FootBallClub>{
	private String name;
	private int score;
	
	public FootBallClub(String name,int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
	@Override
	public String toString() {
		return "Name : " + name + " " + "Score : " + score;
	}
	public int compareTo(FootBallClub o) {
		
		return -(this.score - o.score);
		//if return 1 this.score > o.score
		//if return -1 this.score < o.score
	}

	

}
