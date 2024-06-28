import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CounterFrame extends JFrame {

    // Declaring the variables
    private JPanel panelNorth;
    private JPanel panelEast;
    private JPanel panelWest;
    private JPanel panelSouth;
    private JPanel panelCenter;
    private JLabel titleLabel;
    private JLabel counterLabel;
    private JButton plusButton;
    private JButton minusButton;
    private JButton resetButton;
    private int count;

    public CounterFrame() {

        // TODO : Fill in the blanks
        this.setTitle("The Counter GUI"); // sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of appliaction
        this.setResizable(true); // makes the frame resizeable
        this.setSize(500, 500); // sets the x-dimension and y-dimension of frame

        // Initializing the JPanels
        panelNorth = new JPanel();
        panelEast = new JPanel();
        panelWest = new JPanel();
        panelSouth = new JPanel();
        panelCenter = new JPanel();

        // Using the BorderLayout for the Frame and Center, East, and West Panel
        this.setLayout(new BorderLayout());
        panelCenter.setLayout(new BorderLayout());
        panelEast.setLayout(new BorderLayout());
        panelWest.setLayout(new BorderLayout());

        // Feel free to customize these colors
        panelNorth.setBackground(Color.WHITE);
        panelCenter.setBackground(Color.GRAY);
        panelSouth.setBackground(Color.WHITE);

        // Initializing and setting the titleLabel
        // TODO : Fill in the blanks
        titleLabel = new JLabel();
        titleLabel.setText("The Counter GUI");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 50)); // Feel free to customize the font

        // Initializing and setting the counterLabel
        // TODO : Fill in the blanks
        counterLabel = new JLabel();
        counterLabel.setText(String.valueOf(count)); // Clue : use the 'count' variable
        counterLabel.setHorizontalAlignment(JLabel.CENTER);
        counterLabel.setVerticalAlignment(JLabel.CENTER);
        counterLabel.setFont(new Font("Serif", Font.PLAIN, 50)); // Feel free to customize the font

        // Initializing the JButtons
        // TODO : Fill in the blanks
        plusButton = new JButton("+");
        minusButton = new JButton("-");
        resetButton = new JButton("RESET");

        plusButton.setFont(new Font("Arial", Font.PLAIN, 50)); // Feel free to customize the font
        plusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                counterLabel.setText(String.valueOf(count++));

            }
        });

        minusButton.setFont(new Font("Arial", Font.PLAIN, 50)); // Feel free to customize the font
        minusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count--;
                if (count < 0) {
                    count = 0;
                }
                counterLabel.setText(String.valueOf(count));
            }
        });

        resetButton.setFont(new Font("Arial", Font.PLAIN, 25)); // Feel free to customize the font
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count = 0;
                counterLabel.setText(String.valueOf(count));

            }
        });

        // TODO : Add the right labels and titles to the corresponding panel
        panelNorth.add(titleLabel);
        panelEast.add(plusButton);
        panelWest.add(minusButton);
        panelSouth.add(resetButton);
        panelCenter.add(counterLabel);

        // TODO : Add the right panels into the right layout position
        this.add(panelNorth, BorderLayout.PAGE_START);
        this.add(panelEast, BorderLayout.LINE_END);
        this.add(panelWest, BorderLayout.LINE_START);
        this.add(panelSouth, BorderLayout.PAGE_END);
        this.add(panelCenter, BorderLayout.CENTER);

        this.setVisible(true); // Making the frame visible
    }
}
