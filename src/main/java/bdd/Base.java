package bdd;

import org.skife.jdbi.v2.DBI;

import bdd.ami.AmiDao;
import bdd.categorie.CategorieDao;
import bdd.genre.jeu.GenreJeuDao;
import bdd.jeu.JeuDao;
import bdd.joueur.JoueurDao;
import bdd.possede.jeu.PossedeJeuDao;
import bdd.possede.trophee.PossedeTropheeDao;
import bdd.publication.PublicationDao;
import bdd.publie.PublieDao;
import bdd.trophee.TropheeDao;
import bdd.trophee_jeu.TropheeJeuDao;

public class Base {

	JoueurDao joueur;
	JeuDao jeu;
	CategorieDao cat;
	PublicationDao pub;
	TropheeDao trophee;
	PossedeJeuDao aJeu;
	PossedeTropheeDao aTrophee;
	TropheeJeuDao tj;
	AmiDao ami;
	PublieDao publie;
	GenreJeuDao catJeu;
	
	public Base(){
		App app = new App();
		DBI dbi = app.dbi;
		joueur = dbi.open(JoueurDao.class);
		jeu = dbi.open(JeuDao.class);
		cat = dbi.open(CategorieDao.class);
		pub = dbi.open(PublicationDao.class);
		trophee = dbi.open(TropheeDao.class);
		aJeu = dbi.open(PossedeJeuDao.class);
		aTrophee = dbi.open(PossedeTropheeDao.class);
		tj = dbi.open(TropheeJeuDao.class);
		ami = dbi.open(AmiDao.class);
		publie = dbi.open(PublieDao.class);
		catJeu = dbi.open(GenreJeuDao.class);
	}
	
	public void create(){
		joueur.createJoueurTable();
		jeu.createJeuTable();
		cat.createCategorieTable();
		pub.createPublicationTable();
		trophee.createTropheeTable();
		aJeu.createPossedeJeuTable();
		aTrophee.createPossedeTropheeTable();
		tj.createTropheeJeuTable();
		ami.createAmiTable();
		publie.createPublieTable();
		catJeu.createGenreJeuTable();
	}
	
	public void drop(){
		joueur.dropJoueurTable();
		jeu.dropJeuTable();
		cat.dropCategorieTable();
		pub.dropPublicationTable();
		trophee.dropTropheeTable();
		aJeu.dropPossedeJeuTable();
		aTrophee.dropJeuTable();
		tj.dropTropheeJeuTable();
		ami.dropAmiTable();
		publie.dropPublieTable();
		catJeu.dropGenreJeuTable();
	}
}
