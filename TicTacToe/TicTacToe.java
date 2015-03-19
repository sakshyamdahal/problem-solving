import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	private static final int X = 1, O = -1; // players
	private static final int EMPTY = 0;
	private static final int BOARD_LENGTH = 3;
	private int[][] board = new int[BOARD_LENGTH][BOARD_LENGTH]; // game board
	private int player; // current player
	private String opponent; // human || computer
	private Scanner input;
	
	// keep track of available moves
	private ArrayList<Integer> availableMoves = new ArrayList<Integer>();

	// constructor
	public TicTacToe()
	{
		clearBoard(board);
		input = new Scanner(System.in);
		
		for (int i = 0; i < 9; i++)
			availableMoves.add(i);
		
	}

	// clears the board
	public void clearBoard(int[][] board)
	{
		for(int i = 0; i < BOARD_LENGTH; i++)
		{
			for (int j = 0; j < BOARD_LENGTH; j++)
			{
				board[i][j] = EMPTY;
			}
		}

		player = X;
	}
	
	/* starts game */
	public void gameStart()
	{
		// human vs computer or human vs human
		do
		{
			System.out.println("Play Against? Human or Computer");
			opponent = input.next().toLowerCase();
		}
		while(!opponent.equals("computer") && !opponent.equals("human"));
		
		gameStart(board);
	}

	/* starts a game */
	public void gameStart(int[][] board)
	{
		int numMoves = 9;
		int winner = 0;
		int move;

		// until the board is filled
		for (int i = 0; i < numMoves; i++)
		{
			// print the board
			System.out.println(toString());

			move = getMove(player, board);
			
			// the move is used no longer available
			availableMoves.remove(availableMoves.indexOf(move));
			
			executeMove(move, player, board);
			player = - player; // change player	

			// print the board after the move
			System.out.println(toString());
			
			// check if the game is won
			if (i >= 3)
			{
				winner = winner(board);
				if (winner == X || winner == O)
				{
					if (winner == X)
						System.out.println("Player1 \"X\" wins");
					else
						System.out.println("Player2 Computer  \"O\" wins");
					return;
				}
			}
		}
		
		
		System.out.println("\n******It's a tie...********");
	}

	/* execute a certain move for a player in a board */
	public void executeMove(int move, int player, int[][] board)
	{
		for (int i = 0; i < BOARD_LENGTH; i++)
			for (int j = 0; j < BOARD_LENGTH; j++)
				if (i * 3 + j == move)
					board[i][j] = player;
	}

	/* get the next move either for a player or computer */
	public int getMove(int player, int[][] baord)
	{
		int move;

		if (player == X || (player == O && opponent.equals("human")))
		{
			do
			{
				if (player == X)
					System.out.println("Player1 move (i)");
				else
					System.out.println("Player2 move (i)");

				move = input.nextInt();
				
			}
			while(inValidMove(move));


		}
		else 
		{
			System.out.println("Computer's turn!!!");
			move = computerMove(board);
		}

		return move;

	}

	/* check if move is invalid */
	public boolean inValidMove(int move)
	{
		if (availableMoves.contains(move))
			return false;
		return true;
	}

	/* check if someone won */
	public boolean isWin(int player, int[][] board)
	{
		int i, j;
		int value;
		// check rows
		for (i = 0; i < BOARD_LENGTH; i++)
		{
			value = 0;
			for(j = 0; j < BOARD_LENGTH; j++)
			{
				value += board[i][j];
			}

			if (value == player * 3)
				return true;
		}

		// check columns
		for (i = 0; i < BOARD_LENGTH; i++)
		{
			value = 0;
			for (j = 0; j < BOARD_LENGTH; j++)
			{
				value += board[j][i];
			}

			if (value == player * 3)
				return true;
		}

		// check diagonals
		if ((board[0][0] + board[1][1] + board[2][2] == player*3)
				|| (board[2][0] + board[1][1] + board[0][2] == player * 3))
			return true;

		return false;
	}

	/* who is the winner in a given board */
	public int winner(int[][] baord)
	{
		if (isWin(X, board))
			return X;
		else if (isWin(O, board))
			return O;
		else
			return 0;

	}

	/* string representation of a board */
	public String toString()
	{
		StringBuilder stringBoard = new StringBuilder();
		int lineLength;

		for (int i = 0; i < BOARD_LENGTH; i++)
		{
			lineLength = 0;
			for (int j = 0; j < BOARD_LENGTH; j++)
			{
				stringBoard.append("|");
				lineLength++;

				switch(board[i][j])
				{
				case X: stringBoard.append("X"); lineLength += 1; break;
				case O: stringBoard.append("O"); lineLength += 1; break;
				case EMPTY: stringBoard.append(String.format("(%d)", i*3 + j)); lineLength += 3; break;
				}
			}
			stringBoard.append("|");
			lineLength++;

			stringBoard.append("\n");
			for (int k = 0; k < lineLength; k++)
				stringBoard.append("-");
			stringBoard.append("\n");
		}

		return stringBoard.toString();
	}
	
	/* get the next move for computer */
	public int computerMove(int[][] board)
	{
		Random random = new Random();
		@SuppressWarnings("unchecked")
		ArrayList<Integer> moves = (ArrayList<Integer>) availableMoves.clone();
		
		// make computer win
		int compWin = moveToWin(board, O, moves);
		if (compWin >= 0)
			return compWin;
		
		// don't let player win
		int playWin = moveToWin(board, X, moves);
		if (playWin >= 0)
			return playWin;
		
		// TODO
		// next move so that player doesn't win in other move
		
		// use any available move
		return availableMoves.get(random.nextInt(availableMoves.size()));
	}
	
	/* a move required for a player to win in a board */
	public int moveToWin(int[][] board, int player, ArrayList<Integer> movesAvailable)
	{
		int[][] boardCopy;
		for (int move : movesAvailable)
		{
			boardCopy = copyBoard(board);
			executeMove(move, player,boardCopy);
			{
				if (isWin(player, boardCopy))
					return move;
			}
		}
		
		/* if not available return -1 */
		return -1;
	}
	
	/* make a copy of the board */
	public int[][] copyBoard(int[][] board)
	{
		int[][] newBoard = new int[board.length][board.length];
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board.length; j++)
			{
				newBoard[i][j] = board[i][j];
			}
		}
		return newBoard;
	}
	

	/* lets get started */
	public static void main(String[] args)
	{
		TicTacToe g1 = new TicTacToe();
		g1.gameStart();
	}

}
