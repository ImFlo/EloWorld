package bdd.ami;

public class Ami {
	private int idJoueur1;
	private int idJoueur2;


	public Ami(int idJoueur1, int idJoueur2) {
		this.idJoueur1 = idJoueur1;
		this.idJoueur2 = idJoueur2;
	}

	public Ami() {
		
	}
	
	public int getIdJoueur1() {
		return idJoueur1;
	}

	public void setIdJoueur1(int idJoueur1) {
		this.idJoueur1 = idJoueur1;
	}
	
	public int getIdJoueur2() {
		return idJoueur2;
	}

	public void setIdJoueur2(int idJoueur2) {
		this.idJoueur2 = idJoueur2;
	}
	
	public boolean equals(Object u) {
		return (idJoueur1 == ((Ami) u).getIdJoueur1() && idJoueur2 == ((Ami) u).getIdJoueur2());
	}

	public String toString() {
		return idJoueur1 + ": " + idJoueur2;
	}

}
