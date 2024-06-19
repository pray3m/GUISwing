import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("User Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(400, 460);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel formInfo = new JLabel("Hola!  \uD83D\uDC4B\uD83C\uDFFC");

        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        JPanel emailPanel = new JPanel();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);
        emailPanel.add(emailLabel);
        emailPanel.add(emailField);

        JPanel passwordPanel = new JPanel();
        JLabel passwordLabel = new JLabel("Password: ");
        JPasswordField passwordField = new JPasswordField(20);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        JPanel genderPanel = new JPanel();
        JLabel genderLabel = new JLabel("Gender: ");

        ButtonGroup genderGroup = new ButtonGroup();

        JRadioButton male = new JRadioButton("male");
        JRadioButton female = new JRadioButton("female");
        JRadioButton others = new JRadioButton("prefer not to say");

        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(others);

        genderPanel.add(genderLabel);
        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(others);

        JPanel messagePanel = new JPanel();
        JLabel messageLabel = new JLabel("Message: ");
        JTextArea messageArea = new JTextArea("this is ...", 5, 20);
        messagePanel.add(messageLabel);
        messagePanel.add(messageArea);

        mainPanel.add(formInfo);
        mainPanel.add(namePanel);
        mainPanel.add(emailPanel);
        mainPanel.add(passwordPanel);
        mainPanel.add(genderPanel);
        mainPanel.add(messagePanel);

        JPanel buttonPanel = new JPanel();
        JButton submitBtn = new JButton();
        submitBtn.setText("Submit");

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                String selectedGender = "";
                if (male.isSelected()) {
                    selectedGender = "male";
                } else if (female.isSelected()) {
                    selectedGender = "female";
                } else if (others.isSelected()) {
                    selectedGender = "others";
                }

                String message = messageArea.getText();

                try {
                    DbOperation.createTableUserInfo();
                    DbOperation.insertUser(name, email, password, selectedGender, message);
                    DbOperation.printTableData();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                }

//                System.out.println("Name: " + name);
//                System.out.println("Email: " + email);
//                System.out.println("Password: " + password); // Password might be visible for demo
//                System.out.println("Gender: " + selectedGender);
//                System.out.println("Message: " + message);
            }
        });

        buttonPanel.add(submitBtn);

        frame.setLayout(new BorderLayout());
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
//        frame.pack();
    }
}