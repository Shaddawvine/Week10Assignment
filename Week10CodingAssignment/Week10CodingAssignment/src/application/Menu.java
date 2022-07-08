package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.DnDPlayerDao;
import entity.DnDPlayer;

public class Menu {
	
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList("Create a Player", "Show Players", "Delete Player");
	private DnDPlayerDao dndPlayerDao = new DnDPlayerDao();
	
	
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if (selection.equals("1")) {
					createPlayer();
				}
				else if (selection.equals("2")) {
					showPlayers();
				}
				else if (selection.equals("3")) {
					deletePlayer();
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("Press enter to continue.");
				scanner.nextLine();
			}while (!selection.equals("-1"));
		}
		
	private void printMenu() {
		System.out.println("Please Select an Option:\n------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void createPlayer() throws SQLException {
		System.out.println("Enter Player's first name:");
		String firstName = scanner.nextLine();
		System.out.println("Enter Player's last name:");
		String lastName = scanner.nextLine();
		System.out.println("Enter Player's Character Race:");
		String race = scanner.nextLine();
		System.out.println("Enter Player's Character Class:");
		String classes = scanner.nextLine();
		dndPlayerDao.createPlayer(firstName, lastName, race, classes);
	}
	private void showPlayers() throws SQLException {
		List<DnDPlayer> players = dndPlayerDao.showPlayers();
		for (DnDPlayer player : players) {
		System.out.println("\tPlayer ID: " + player.getId() + " Name: " + player.getFirstName() + " " + player.getLastName() + " PC Race: " + player.getRace() + " PC Class: " + player.getClasses());
		}
	}

	private void deletePlayer() throws SQLException {
		System.out.println("Enter Player Id you wish to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		dndPlayerDao.deletePlayerById(id);
	}
	
}
