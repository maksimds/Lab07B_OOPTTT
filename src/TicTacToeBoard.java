import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeBoard
{
    private static TicTacToeTile[][] board = new TicTacToeTile[3][3];
    private static int Movenum = 0;
    private static String contender = "X";
    public static void createGame(JPanel game) {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++) {
                board[row][col] = new TicTacToeTile(row, col);
                board[row][col].setText(" ");
                board[row][col].setFont(new Font(Font.SERIF, Font.PLAIN, 30));
                Movenum++;
                game.add(board[row][col]);
            }
    }
    public static boolean restartGame()
    {
        int dialogButton = JOptionPane.showConfirmDialog(null, "Want to play the again?", "Terminate Game?", JOptionPane.YES_NO_OPTION);
        if (dialogButton == JOptionPane.YES_NO_OPTION) {
            TicTacToeGame.clearBoard();
            for(int row = 0; row < 3; row++)
                for(int col = 0; col < 3; col++) {
                    board[row][col].setText(" ");
                }
        }
        else {
            System.exit(0);
        }
        return false;
    }
    public static void onClick(JLabel game) {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++) {
                board[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        TicTacToeTile contender = (TicTacToeTile) e.getSource();

                        if (!contender.getText().isBlank()) {
                            JOptionPane.showMessageDialog(null, "Illegal Move. Choose an empty square");
                            return;

                        }
                        else
                        {
                            contender.setText(String.valueOf(TicTacToeBoard.contender));
                            TicTacToeGame.updateGame(String.valueOf(TicTacToeBoard.contender), contender.getRow(), contender.getCol());

                            Movenum++;
                            updateContender(game);

                            if (Movenum >= 5)
                            {
                                winGame(game);
                            }
                            if (Movenum >= 7)
                            {
                                tieGame();
                            }
                        }
                    }
                });
            }
    }
    private static void tieGame() {
        if (TicTacToeGame.isTie())
        {
            JOptionPane.showMessageDialog(null, "Tie game!");
            restartGame();
        }
    }
    private static void winGame(JLabel game) {
        if (TicTacToeGame.isWin(contender))
        {
            JOptionPane.showMessageDialog(null, "Player " + contender + " " + "wins!");
            restartGame();

            contender = "X";
            game.setText("Current Player: X");
        }
    }
    public static void updateContender(JLabel game)
    {
        if (contender == "X")
        {
            contender = "O";
        }
        else
        {
            contender = "X";
        }
        game.setText("Current Player: " + contender);
    }


}