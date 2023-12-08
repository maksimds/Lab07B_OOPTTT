import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class TicTacToeFrame extends JFrame
{
    JPanel Panelm, Panelt, Panelc, Panelb;
    JButton Buttonq;
    JLabel turn;

    public TicTacToeFrame()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(screenWidth * 3/4,600);
        setLocation(screenWidth / 8, (screenHeight - 600) / 2);

        setTitle("The Game of the Tic Tac Toe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        createGUI();
        setVisible(true);
    }

    private void createGUI()
    {
        Panelm = new JPanel();
        Panelt = new JPanel();
        Panelc = new JPanel();
        Panelb = new JPanel();

        Panelm.setLayout(new BorderLayout());
        Panelm.add(Panelt, BorderLayout.NORTH);
        Panelm.add(Panelc, BorderLayout.CENTER);
        Panelm.add(Panelb, BorderLayout.SOUTH);

        add(Panelm);
        createPanelt();
        createPanelg();
        createPanelb();
    }

    private void createPanelt()
    {
        turn = new JLabel("Current Player: X");
        turn.setFont(new Font(Font.SERIF, Font.PLAIN, 35));

        Panelt.add(turn);
    }
    private void createPanelg()
    {
        Panelc.setLayout(new GridLayout(3,3));

        TicTacToeBoard.createGame(Panelc);
        TicTacToeBoard.onClick(turn);

    }
    private void createPanelb()
    {
        Buttonq = new JButton("Quit");
        Buttonq.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        Buttonq.addActionListener((ActionEvent ae) -> System.exit(0));
    }
}
