package ForFun.YearA.Lists.StudyAvia.Swing;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class LoginWindow extends JFrame {
private JTextField usernameTextField;
private JPasswordField passwordField;
private JLabel feedBack;

public static final String USERNAME = "ABC";
public static final String PASSWORD = "123";

    public LoginWindow(){
        this.setSize(500,500);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Login");
        createUsernameField();
        createPasswordField();
        createLoginButton();
        createFeedback();


        this.setVisible(true);
    }

    private void createUsernameField(){
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setForeground(Color.CYAN);
        usernameLabel.setBounds(40,20,100,25);
        usernameLabel.setOpaque(true);
        this.add(usernameLabel);

        this.usernameTextField = new JTextField();
        this.usernameTextField.setBounds(usernameLabel.getX()+usernameLabel.getWidth()+20 , usernameLabel.getY() , 180 , 25);
        this.add(usernameTextField);
        //if(this.usernameTextField.getText().equals("ABC")){
            System.out.println();
        //}
    }

    private void createPasswordField(){
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setForeground(Color.CYAN);
        passwordLabel.setBounds(40,80,100,25);
        passwordLabel.setOpaque(true);
        this.add(passwordLabel);

        this.passwordField = new JPasswordField();
        this.passwordField.setBounds(passwordLabel.getX()+passwordLabel.getWidth()+20 , passwordLabel.getY() , 180 , 25);
        this.add(passwordField);
    }

    private void createLoginButton(){
        JButton loginButton = new JButton("Login");
        loginButton.setBounds((usernameTextField.getX()+passwordField.getX()/4), 120 ,100 , 30);
        this.add(loginButton);
        loginButton.addActionListener((event)->{
            String username = this.usernameTextField.getText();
            String password = new String(this.passwordField.getPassword());
            System.out.println(password);
            if(username.equals(USERNAME) && password.equals(PASSWORD)){
                this.feedBack.setText("Connected");
                this.feedBack.setForeground(Color.GREEN);
            }
            else{
                this.feedBack.setText("Username or password not match");
                this.feedBack.setForeground(Color.RED);
            }
        });
    }

    private void createFeedback(){
        this.feedBack = new JLabel("");
        this.feedBack.setBounds(40, 130 , 200 , 25);
        this.add(feedBack);
    }
}
