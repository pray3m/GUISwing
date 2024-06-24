import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutDemo extends JFrame implements ActionListener {

    private CardLayout cardLayout;
    private JPanel cards;

    public CardLayoutDemo() {

        //Initialize card layout and main cards panel
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        JPanel card1 = new JPanel();
        card1.add(new JLabel("CARD 1"));

        JPanel card2 = new JPanel();
        card2.add(new JLabel("CARD 2"));

        JPanel card3 = new JPanel();
        card3.add(new JLabel("CARD 3"));


        JButton button1 = new JButton("Go to CARD 1");
        button1.addActionListener(this);
        JButton button2 = new JButton("Go to CARD 2");
        button2.addActionListener(this);
        JButton button3 = new JButton("Go to CARD 3");
        button3.addActionListener(this);

        JPanel buttons = new JPanel();
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);

        cards.add(card1, "card1");
        cards.add(card2, "card2");
        cards.add(card3, "card3");


        add(cards, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);

        // display card1 by default
        cardLayout.show(cards, "card1");

        pack();
//        setSize(380, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Go to CARD 1":
                cardLayout.show(cards, "card1");
                break;
            case "Go to CARD 2":
                cardLayout.show(cards, "card2");
                break;
            case "Go to CARD 3":
                cardLayout.show(cards, "card3");
                break;
        }
    }

    public static void main(String[] args) {
        new CardLayoutDemo();
    }


}