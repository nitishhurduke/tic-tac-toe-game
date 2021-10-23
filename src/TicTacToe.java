import java.util.Scanner;

class Board {
	private char[][] board = new char[3][3];

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

}

class Players {
	private String player1;
	private String Player2;

	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	public String getPlayer2() {
		return Player2;
	}

	public void setPlayer2(String player2) {
		Player2 = player2;
	}

}

public class TicTacToe {

	Scanner sc = new Scanner(System.in);
	Players players = new Players();
	Board board = new Board();

	public void setPlayersDetails() {
		System.out.print("Enter Player 1 Name : ");
		players.setPlayer1(sc.nextLine());
		System.out.print("Enter Player 2 Name : ");
		players.setPlayer2(sc.nextLine());
	}

	public void initialiseBoard() {
		char[][] newBoard = board.getBoard();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				newBoard[i][j] = '-';
			}
		}
		board.setBoard(newBoard);
		System.out.println(
				"Here you go " + players.getPlayer1() + " & " + players.getPlayer2() + "...Lets Begin the Game...");

	}

	public void gamePlay() {
		boolean turns = true;

		while (!win()) {
			if (turns) {
				turns = player1Turn();
			} else {
				turns = player2Turn();
			}
		}
	}

	public boolean win() {

		char[][] newBoard = board.getBoard();
		boolean atleastOneDash = false;
		aa: for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (newBoard[i][j] == '-') {
					atleastOneDash = true;
					break aa;
				} else {
					atleastOneDash = false;
				}

			}
		}
		if (atleastOneDash) {
			if (newBoard[0][0] != '-' && newBoard[0][0] == newBoard[0][1] && newBoard[0][1] == newBoard[0][2]) // 1st
																												// column
			{
				if (newBoard[0][0] == 'X') {
					System.out.println("\nCongratulations...." + players.getPlayer1() + " wins");
				} else {
					System.out.println("\nCongratulations...." + players.getPlayer2() + " wins");
				}
				printBoard();
				return true;
			} else if (newBoard[1][0] != '-' && newBoard[1][0] == newBoard[1][1] && newBoard[1][1] == newBoard[1][2])// 2nd
																														// column
			{
				if (newBoard[1][0] == 'X') {
					System.out.println("\nCongratulations...." + players.getPlayer1() + " wins");
				} else {
					System.out.println("\nCongratulations...." + players.getPlayer2() + " wins");
				}
				printBoard();
				return true;
			} else if (newBoard[2][0] != '-' && newBoard[2][0] == newBoard[2][1] && newBoard[2][1] == newBoard[2][2])// 3rd
																														// column
			{
				if (newBoard[2][0] == 'X') {
					System.out.println("\nCongratulations...." + players.getPlayer1() + " wins");
				} else {
					System.out.println("\nCongratulations...." + players.getPlayer2() + " wins");
				}
				printBoard();
				return true;
			} else if (newBoard[0][0] != '-' && newBoard[0][0] == newBoard[1][1] && newBoard[1][1] == newBoard[2][2])// 1st
																														// diagonal
			{
				if (newBoard[0][0] == 'X') {
					System.out.println("\nCongratulations...." + players.getPlayer1() + " wins");
				} else {
					System.out.println("\nCongratulations...." + players.getPlayer2() + " wins");
				}
				printBoard();
				return true;
			} else if (newBoard[2][0] != '-' && newBoard[2][0] == newBoard[1][1] && newBoard[1][1] == newBoard[0][2])// 2nd
																														// diagonal
			{
				if (newBoard[2][0] == 'X') {
					System.out.println("\nCongratulations...." + players.getPlayer1() + " wins");
				} else {
					System.out.println("\nCongratulations...." + players.getPlayer2() + " wins");
				}
				printBoard();
				return true;
			} else if (newBoard[0][0] != '-' && newBoard[0][0] == newBoard[1][0] && newBoard[1][0] == newBoard[2][0])// 1st
																														// row
			{
				if (newBoard[0][0] == 'X') {
					System.out.println("\nCongratulations...." + players.getPlayer1() + " wins");
				} else {
					System.out.println("\nCongratulations...." + players.getPlayer2() + " wins");
				}
				printBoard();
				return true;
			} else if (newBoard[0][1] != '-' && newBoard[0][1] == newBoard[1][1] && newBoard[1][1] == newBoard[2][1])// 2nd
																														// row
			{
				if (newBoard[0][1] == 'X') {
					System.out.println("\nCongratulations...." + players.getPlayer1() + " wins");
				} else {
					System.out.println("\nCongratulations...." + players.getPlayer2() + " wins");
				}
				printBoard();
				return true;
			} else if (newBoard[0][2] != '-' && newBoard[0][2] == newBoard[1][2] && newBoard[1][2] == newBoard[2][2])// 3rd
																														// row
			{
				if (newBoard[0][2] == 'X') {
					System.out.println("\nCongratulations...." + players.getPlayer1() + " wins");
				} else {
					System.out.println("\nCongratulations...." + players.getPlayer2() + " wins");
				}
				printBoard();
				return true;
			} else {
				printBoard();
				return false;
			}
		} else {
			System.out.println("Game  tied...");
			System.exit(0);
			return true;
		}
	}

	public boolean player1Turn() {

		System.out.println(players.getPlayer1() + "'s Turn(X) -->");
		System.out.print("  Enter row number : ");
		int row = sc.nextInt();
		System.out.print("  Enter Column number: ");
		int coloumn = sc.nextInt();
		char[][] newBoard = board.getBoard();
		if (newBoard[row - 1][coloumn - 1] == '-') {
			newBoard[row - 1][coloumn - 1] = 'X';
			board.setBoard(newBoard);
			return false;

		} else {
			System.out.println("Place " + row + "x" + coloumn + " Already Marked...choose another place");
			return true;
		}
	}

	public boolean player2Turn() {

		System.out.println(players.getPlayer2() + "'s Turn(O) -->");
		System.out.print("  Enter row number : ");
		int row = sc.nextInt();
		System.out.print("  Enter Column number: ");
		int coloumn = sc.nextInt();
		char[][] newBoard = board.getBoard();
		if (newBoard[row - 1][coloumn - 1] == '-') {
			newBoard[row - 1][coloumn - 1] = 'O';
			board.setBoard(newBoard);
			return true;

		} else {
			System.out.println("Place " + (row - 1) + "x" + (coloumn - 1) + " Already Marked...choose another place");
			return false;
		}
	}

	public void printBoard() {
		System.out.println();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(" " + board.getBoard()[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {

		TicTacToe ttt = new TicTacToe();
		ttt.setPlayersDetails();
		ttt.initialiseBoard();
		ttt.gamePlay();
	}
}
