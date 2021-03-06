package consoleView;

import zenGame.*;

import java.io.File;
import java.io.Serializable;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

/**
 * This class is used to print the game
 * @author LePors
 * @version 1.0
 */
public class PrintGameMenu implements IGameMenu, Serializable {

	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_GREEN = "\u001B[32m";
	private Square[][] grid;
	private int nbX, nbY;


	/**
	 * This method print the game menu
	 */
	public PrintGameMenu() {
		this.printFirstPage();
	}

	/**
	 * Use to print the first page on the terminal
	 */
	@Override
	public void printFirstPage() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println(ANSI_CYAN +
				" ########\\ ########\\ ##\\   ##\\      ##\\  ##\\  ######\\ ##\\   ##\\ ######\\  ######\\ ######\\ ########\\\n" +
				" \\____##  |##  _____|###\\  ## |     ## | #  | \\_##  _|###\\  ## |\\_##  _| \\_## __|\\_##  _|##  _____|\n" +
				"    ##   / ## |      ####\\ ## |     ## | \\_/    ##  | ####\\ ## |  ##  |    ## |    ##  | ## |\n" +
				"   ##   /  #####\\    ## ##\\## |     ## |        ##  | ## ##\\## |  ##  |    ## |    ##  | #####\\\n" +
				"  ##   /   ##  __|   ## \\#### |     ## |        ##  | ## \\#### |  ##  |    ## |    ##  | ##  __|\n" +
				" ##   /    ## |      ## |\\### |     ## |        ##  | ## |\\### |  ##  |    ## |    ##  | ##\n" +
				"########\\  ########\\ ## | \\## |     ########\\ ######\\ ## | \\## |######\\    ## |  ######\\ ########\\\n" +
				"\\________| \\________|\\__|  \\__|     \\________|\\______|\\__|  \\__|\\______|   \\__|  \\______|\\________|");
		System.out.println("\n" +
				"\n" + ANSI_YELLOW +
				"                =============== Bienvenue sur le jeu Zen l'Initié ===============" + ANSI_RESET);
		System.out.println("\n" +
				"\n" +
				"1 : JOUER\n" +
				"2 : REGLES\n" +
				"3 : QUITTER\n" +
				"VOTRE CHOIX : ");

		boolean loop = false;
		while (!loop) {
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();

			if (str.equals("1") || str.equals("JOUER")) {
				System.out.println("Vous avez choisi \"JOUER\"");
				loop = true;
				this.printSecondPage();
			} else if (str.equals("2") || str.equals("REGLES")) {
				System.out.println("Vous avez choisi \"REGLES\" ");
				loop = true;
				this.rulesPage();
			} else if (str.equals("3") || str.equals("QUITTER")) {
				System.out.println("Vous avez choisi \"QUITTER\" ");
				loop = true;
				exit(0);
			} else {
				System.err.println("Mauvaise valeur recommencez :");
			}
		}
	}


	/**
	 * Ask the player about the mode
	 */
	@Override
	public Mode initializeMode() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println(ANSI_CYAN +
				" ########\\ ########\\ ##\\   ##\\      ##\\  ##\\  ######\\ ##\\   ##\\ ######\\  ######\\ ######\\ ########\\\n" +
				" \\____##  |##  _____|###\\  ## |     ## | #  | \\_##  _|###\\  ## |\\_##  _| \\_## __|\\_##  _|##  _____|\n" +
				"    ##   / ## |      ####\\ ## |     ## | \\_/    ##  | ####\\ ## |  ##  |    ## |    ##  | ## |\n" +
				"   ##   /  #####\\    ## ##\\## |     ## |        ##  | ## ##\\## |  ##  |    ## |    ##  | #####\\\n" +
				"  ##   /   ##  __|   ## \\#### |     ## |        ##  | ## \\#### |  ##  |    ## |    ##  | ##  __|\n" +
				" ##   /    ## |      ## |\\### |     ## |        ##  | ## |\\### |  ##  |    ## |    ##  | ##\n" +
				"########\\  ########\\ ## | \\## |     ########\\ ######\\ ## | \\## |######\\    ## |  ######\\ ########\\\n" +
				"\\________| \\________|\\__|  \\__|     \\________|\\______|\\__|  \\__|\\______|   \\__|  \\______|\\________|" + ANSI_RESET);
		System.out.println("\n");
		Mode m = null;
		boolean loop = false;
		while (!loop) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez séléctionner le mode :\n" +
					"1 : Humain vs Humain \n" +
					"2 : Humain vs Robot");
			String str = sc.nextLine();

			if (str.equals("1") || str.equals("HumainHumain")) {
				m = Mode.HumainHumain;
				System.out.println("Vous avez choisi le mode humain vs humain");
				ZenGame zenGame = new ZenGame("Yanis", "Enzo", Mode.HumainHumain, this, GraphicType.Console);
				loop = true;
			} else if (str.equals("2") || str.equals("HumainRobot")) {
				System.out.println("Vous avez choisi le mode humain vs robot");
				m = Mode.HumainRobot;
				ZenGame zenGame = new ZenGame("Yanis", "Enzo", Mode.HumainRobot, this, GraphicType.Console);
				loop = true;
			} else {
				System.err.println("Mauvaise valeur recommencez :");
			}
		}
		return m;
	}

	/**
	 * Use to print the second page on the terminal
	 */
	@Override
	public void printSecondPage() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
		System.out.println(ANSI_CYAN +
				" ########\\ ########\\ ##\\   ##\\      ##\\  ##\\  ######\\ ##\\   ##\\ ######\\  ######\\ ######\\ ########\\\n" +
				" \\____##  |##  _____|###\\  ## |     ## | #  | \\_##  _|###\\  ## |\\_##  _| \\_## __|\\_##  _|##  _____|\n" +
				"    ##   / ## |      ####\\ ## |     ## | \\_/    ##  | ####\\ ## |  ##  |    ## |    ##  | ## |\n" +
				"   ##   /  #####\\    ## ##\\## |     ## |        ##  | ## ##\\## |  ##  |    ## |    ##  | #####\\\n" +
				"  ##   /   ##  __|   ## \\#### |     ## |        ##  | ## \\#### |  ##  |    ## |    ##  | ##  __|\n" +
				" ##   /    ## |      ## |\\### |     ## |        ##  | ## |\\### |  ##  |    ## |    ##  | ##\n" +
				"########\\  ########\\ ## | \\## |     ########\\ ######\\ ## | \\## |######\\    ## |  ######\\ ########\\\n" +
				"\\________| \\________|\\__|  \\__|     \\________|\\______|\\__|  \\__|\\______|   \\__|  \\______|\\________|" + ANSI_RESET);

		System.out.println("\n" +
				"\n" +
				"1 : NOUVELLE PARTIE\n" +
				"2 : CHARGER\n" +
				"3 : RETOUR\n" +
				"VOTRE CHOIX : ");

		boolean loop = false;
		while (!loop) {
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();

			if (str.equals("1") || str.equals("NOUVELLE PARTIE")) {
				System.out.println("Vous avez choisi \"NOUVELLE PARTIE\"");
				this.initializeMode();
				loop = true;
			} else if (str.equals("2") || str.equals("CHARGER")) {
				System.out.println("Vous avez choisi \"CHARGER\" ");
				this.loadPage();
				loop = true;

			} else if (str.equals("3") || str.equals("RETOUR")) {
				System.out.println("Vous avez choisi \"RETOUR\" ");
				loop = true;
				this.printFirstPage();
			} else {
				System.err.println("Mauvaise valeur recommencez :");
			}
		}
	}

	/**
	 * Display the grid page
	 */
	@Override
	public void gamePage(Square[][] grid, GameManager gameManager) {
		this.grid = grid;
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}

		System.out.println(
				"\n" +
						"\n" +
						"            0       1       2       3       4       5       6       7       8       9       10\n" +
						"     +-------------------------------------------------------------------------------------+");
		for (int i = 10; i >= 0; i--) {
			System.out.print(i + " | ");
			for (int j = 0; j < 11; j++) {
				if(this.grid[i][j].getCharType() == '.') {
					System.out.print("       " + this.grid[i][j].getCharType());
				} else if(this.grid[i][j].getCharType() == 'B') {
					System.out.print("       " + ANSI_CYAN + this.grid[i][j].getCharType() + ANSI_RESET);
				} else if(this.grid[i][j].getCharType() == 'N') {
					System.out.print("       " + ANSI_YELLOW +this.grid[i][j].getCharType() + ANSI_RESET);
				} else if(this.grid[i][j].getCharType() == 'Z') {
					System.out.print("       " + ANSI_GREEN +this.grid[i][j].getCharType() + ANSI_RESET);
				}

			}
			System.out.println(" | " + i);
			System.out.println("  |                                                                                          |");
		}
		System.out.println("	  +-------------------------------------------------------------------------------------+");
		System.out.println("           0       1       2       3       4       5       6       7       8       9       10");
	}

	/**
	 * Display the rules page
	 */
	@Override
	public void rulesPage() {
		System.out.println("LES REGLES :");
		System.out.println("But du jeu : le vainqueur est le premier joueur qui réussit à former une chaîne continue avec la totalité de " +
				"\nses pions se trouvant encore sur le plateau, y compris le \"Z\", si celui-ci est encore en jeu.\n" +
				"Début de partie : chaque joueur choisit une couleur.\n" +
				"Les pions sont disposés sur le plateau selon une figure imposée.\n" +
				"Déroulement de la partie : chaque joueur déplace à son tour un pion de sa couleur ou le \"Z\" en respectant 4 règles très simples.\n" +
				"Règle n°1 : les pions se déplacent en ligne droite dans n'importe quelle direction. " +
				"\nTout pion doit toujours se déplacer d'autant de cases qu'il y a de pions sur la ligne de déplacement choisie (horizontale ou verticale ou diagonale)." +
				"\nTous les pions sont pris en compte y compris le pion déplacé.\n" +
				"Règle n°2 : tout pion peut passer par-dessus un ou plusieurs pions de sa couleur, mais jamais par-dessus ceux de son adversaire.\n" +
				"Règle n°3 : tout pion peut capturer un pion adverse en se plaçant sur la case occupée par le pion pris en respectant la règle n°1. " +
				"\nCelui-ci est alors définitivement retiré du jeu.\n" +
				"Règle n°4 : à chaque coup, le \"Z\" pion commun à tous les joueurs peut être soit blanc soit noir selon l'intérêt de celui qui joue.\n" +
				"Il se déplace comme les autres pions, mais peut aussi être pris.\n" +
				"Pour 4 joueurs (2 par équipe) : deux joueurs d'une même équipe jouent avec les 12 pions noirs, et les deux autres avec les 12 pions blancs.\n" +
				"La partie se déroule comme précédemment.");
		System.out.println("\n" +
				"\n" +
				"1 : RETOUR\n" +
				"VOTRE CHOIX : ");

		boolean loop = false;
		try {
			while (!loop) {
				Scanner sc = new Scanner(System.in);
				String str = sc.nextLine();

				if (str.equals("1") || str.equals("RETOUR")) {
					System.out.println("Vous avez choisi \"RETOUR\"");
					this.printFirstPage();
					loop = true;
				} else {
					System.err.println("Mauvaise valeur recommencez :");
				}
			}
		} catch (Exception ex){}
	}

	/**
	 * Use to print the load page on the terminal
	 */
	@Override
	public void loadPage() {

		File repertoire = new File("./data/saves/");

		int i;
		String [] fileList = repertoire.list();
		for (i = 0; i < fileList.length; i++) {
			System.out.println(i + ".  "+ fileList[i]);
		}

		boolean loop = false;
		System.out.println("Entrer \"r\" pour retour ou le numéro de partie à charger");
		System.out.println("CHARGER VOTRE PARTIE :");
		while (!loop) {
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();

			if (str.equals("r") || str.equals("RETOUR")) {
				System.out.println("Vous avez choisi \"RETOUR\" ");
				this.printSecondPage();
				loop = true;
			} else {
				//ZenGame zenGame = new ZenGame("Yanis","Enzo",null,null,null);
				//		zenGame.loadGame(fileList[parseInt(str)]);
				System.out.println("Vous avez choisi  "+fileList[parseInt(str)]);
				GameManager gameManager = new GameManager("./data/saves/"+fileList[parseInt(str)]);
				//zenGame.loadGame(fileList[parseInt(str)]);
				loop = true;
			}
		}
	}

	/**
	 * End game page
	 */
	@Override
	public void endGamePage() {
		System.out.println("=== LA PARTIE EST FINI ===");
		System.out.println("\n" +
				"\n" +
				"1 : MENU PRINCIPAL\n" +
				"2 : QUITTER\n" +
				"VOTRE CHOIX : ");

		boolean loop = false;
		while (!loop) {
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();

			if (str.equals("1") || str.equals("MENU PRINCIPAL")) {
				System.out.println("Vous avez choisi \"MENU PRINCIPAL\"");
				this.printFirstPage();
				loop = true;
			} else if (str.equals("2") || str.equals("QUITTER")) {
				System.out.println("Vous avez choisi \"QUITTER\" ");
				loop = true;
				exit(0);
			} else {
				System.err.println("Mauvaise valeur recommencez :");
			}
		}
	}

	/**
	 * ASK the coordinate
	 * @return The coordinate
	 */
	@Override
	public int[] askCoordinate(){
		int[] ret = new int[2];

		Scanner sc = new Scanner(System.in);
		System.out.println("Séléctionnez votre pion :");
		System.out.println("Donnez votre coordonnées en y :");
		ret[0] = sc.nextInt();
		System.out.println("Donnez votre coordonnées en x :");
		ret[1] = sc.nextInt();

		return ret;
	}
}