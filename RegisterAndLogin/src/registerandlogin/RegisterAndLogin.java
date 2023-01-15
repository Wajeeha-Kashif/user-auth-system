/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registerandlogin;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;

import java.io.File;

/**
 *
 * @author Wajeeha Kashsif
 */
public class RegisterAndLogin extends JFrame implements ActionListener{

    JFrame f;
    JLabel Heading,Name, Password, Gender, Address, Phone,NewName, NewPass;
    JTextField Nametxt, Passwordtxt, NewNametxt, NewPasstxt;
    JButton Login, Register, ChangeName, ChangePassword, loginButton, registerButton, updateName, loginAgain, updatePass, back;
    
    static String encryptDecrypt(String inputString)
    {
        // Define XOR key
        // Any character value will work
        char xorKey = 'P';
  
        // Define String to store encrypted/decrypted String
        String outputString = "";
  
        // calculate length of input string
        int len = inputString.length();
  
        // perform XOR operation of key
        // with every caracter in string
        for (int i = 0; i < len; i++) 
        {
            outputString = outputString + 
            Character.toString((char) (inputString.charAt(i) ^ xorKey));
        }
  
        //System.out.println(outputString);
        return outputString;
    }
    
    public void homePage(){

        ImageIcon iconA = new ImageIcon("back.jpeg");
        //getContentPane().setBackground(new Color(20,37,64));
        Image image = iconA.getImage(); // transform it
        Image newimg = image.getScaledInstance(850, 500,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        iconA = new ImageIcon(newimg);

        setContentPane(new JLabel(iconA));
        
        Heading = new JLabel("WHAT DO YOU WANT TO CHOOSE");
        Heading.setBounds(130, 20, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));

        Login = new JButton("Login");
        Login.setBounds(230, 100, 140, 20);
        Login.addActionListener(this);
        
        Register = new JButton("Register");
        Register.setBounds(230, 200, 140, 20);
        Register.addActionListener(this);
        
        setLayout(null);

        //Add components to the JFrame
        add(Heading);
        add(Login);
        add(Register);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        
    }
    
    public void login(){

        getContentPane().removeAll();
        getContentPane().repaint();
        
        Heading = new JLabel("Insert Details to Login");
        Heading.setBounds(130, 20, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));

        Name = new JLabel("Enter Username:");
        Name.setBounds(20, 90, 100, 20);
        Name.setForeground(Color.white);
        Nametxt = new JTextField(20);
        Nametxt.setBounds(130, 90, 200, 20);

        Password = new JLabel("Enter Password");
        Password.setForeground(Color.white);
        Password.setBounds(20, 120, 100, 20);
        Passwordtxt = new JTextField(50);
        Passwordtxt.setBounds(130, 120, 200, 20);

        loginButton = new JButton("Login");
        loginButton.setBounds(400, 300, 100, 20);
        loginButton.addActionListener(this);
        
        back = new JButton("Back");
        back.setBounds(50, 400, 100, 20);
        back.addActionListener(this);
       
        setLayout(null);

        //Add components to the JFrame
        add(Heading);
        add(Name);
        add(Nametxt);
        add(Password);
        add(Passwordtxt);
        add(loginButton);
        add(back);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
    }
    
    public void register(){

        getContentPane().removeAll();
        getContentPane().repaint();
        
        Heading = new JLabel("Insert Details to Register");
        Heading.setBounds(130, 20, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));

        Name = new JLabel("Enter Username:");
        Name.setBounds(20, 90, 100, 20);
        Name.setForeground(Color.white);
        Nametxt = new JTextField(20);
        Nametxt.setBounds(130, 90, 200, 20);

        Password = new JLabel("Enter Password");
        Password.setForeground(Color.white);
        Password.setBounds(20, 120, 100, 20);
        Passwordtxt = new JTextField(50);
        Passwordtxt.setBounds(130, 120, 200, 20);

        registerButton = new JButton("Register");
        registerButton.setBounds(400, 300, 100, 20);
        registerButton.addActionListener(this);
        
        back = new JButton("Back");
        back.setBounds(50, 400, 100, 20);
        back.addActionListener(this);

        setLayout(null);

        //Add components to the JFrame
        add(Heading);
        add(Name);
        add(Nametxt);
        add(Password);
        add(Passwordtxt);
        add(registerButton);
        add(back);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
    }
    
    public void changeUsername()
    {
        getContentPane().removeAll();
        getContentPane().repaint();
        
        Heading = new JLabel("Enter new username");
        Heading.setBounds(250, 20, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));
        
        NewName = new JLabel("UserName:");
        NewName.setBounds(20, 60, 120, 20);
        NewName.setForeground(Color.white);
        NewNametxt = new JTextField(20);
        NewNametxt.setBounds(130, 60, 200, 20);
        
        updateName = new JButton("Update");
        updateName.setBounds(230, 100, 140, 20);
        updateName.addActionListener(this);

        
        add(Heading);
        add(NewName);
        add(NewNametxt);
        add(updateName);
    }
    
    public void changePassword()
    {
        getContentPane().removeAll();
        getContentPane().repaint();
        
        Heading = new JLabel("Enter new password");
        Heading.setBounds(250, 20, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));
        
        NewPass = new JLabel("Password:");
        NewPass.setBounds(20, 60, 120, 20);
        NewPass.setForeground(Color.white);
        NewPasstxt = new JTextField(20);
        NewPasstxt.setBounds(130, 60, 200, 20);
        
        updatePass = new JButton("Update");
        updatePass.setBounds(230, 100, 140, 20);
        updatePass.addActionListener(this);

        
        add(Heading);
        add(NewPass);
        add(NewPasstxt);
        add(updatePass);
    }
    
    public void welcome()
    {
        getContentPane().removeAll();
        getContentPane().repaint();
        
        Heading = new JLabel("WELCOME");
        Heading.setBounds(250, 20, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));
        
        ChangeName = new JButton("Change Username");
        ChangeName.setBounds(230, 200, 140, 20);
        ChangeName.addActionListener(this);
        
        ChangePassword = new JButton("Change Password");
        ChangePassword.setBounds(230, 300, 140, 20);
        ChangePassword.addActionListener(this);
        
        back = new JButton("Back");
        back.setBounds(50, 400, 100, 20);
        back.addActionListener(this);

        add(Heading);
        add(ChangeName);
        add(ChangePassword);
        add(back);
    }
    
    public void registerSuccessfull()
    {
        getContentPane().removeAll();
        getContentPane().repaint();
        
        Heading = new JLabel("Registered Successfully!!");
        Heading.setBounds(230, 160, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));
               
        back = new JButton("Back");
        back.setBounds(50, 400, 100, 20);
        back.addActionListener(this);
        
        add(Heading);
        add(back);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
    }
    
    public void usernameChangedSuccessfull()
    {
        getContentPane().removeAll();
        getContentPane().repaint();
        
        Heading = new JLabel("Username changed successfully!!");
        Heading.setBounds(230, 160, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));
               
        back = new JButton("Back");
        back.setBounds(50, 400, 100, 20);
        back.addActionListener(this);
        
        add(Heading);
        add(back);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
    }
    
    public void passwordChangedSuccessfull()
    {
        getContentPane().removeAll();
        getContentPane().repaint();
        
        Heading = new JLabel("Password changed successfully!!");
        Heading.setBounds(230, 160, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));
               
        back = new JButton("Back");
        back.setBounds(50, 400, 100, 20);
        back.addActionListener(this);
        
        add(Heading);
        add(back);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
    }
    
    public void alreadyExists()
    {
        getContentPane().removeAll();
        getContentPane().repaint();
        
        Heading = new JLabel("Username already exists!");
        Heading.setBounds(200, 160, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));
        
        Register = new JButton("Register Again");
        Register.setBounds(300, 220, 140, 20);
        Register.addActionListener(this);
        
        add(Heading);
        add(Register);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
    }
    
    public void invalidUsername()
    {
        getContentPane().removeAll();
        getContentPane().repaint();
        
        Heading = new JLabel("Username should not be more than 20 characters!");
        Heading.setBounds(200, 160, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));
        
        Register = new JButton("Register Again");
        Register.setBounds(300, 220, 140, 20);
        Register.addActionListener(this);
        
        add(Heading);
        add(Register);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
    }
    
    public void invalidPassword()
    {
        getContentPane().removeAll();
        getContentPane().repaint();
        
        Heading = new JLabel("Password should be between 4 to 10 characters long!");
        Heading.setBounds(200, 160, 500, 25);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));
        
        Register = new JButton("Register Again");
        Register.setBounds(300, 220, 140, 20);
        Register.addActionListener(this);
        
        add(Heading);
        add(Register);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
    }
    
     public void invalidUsernameOrPassword()
    {
        getContentPane().removeAll();
        getContentPane().repaint();
        
        Heading = new JLabel("Invalid Username or Password!!");
        Heading.setBounds(230, 160, 500, 20);
        Heading.setForeground(Color.white);
        Heading.setFont(new Font("Serif", Font.BOLD, 20));
        
        Login = new JButton("Login Again");
        Login.setBounds(300, 220, 140, 20);
        Login.addActionListener(this);
        
        add(Heading);
        add(Login);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
    }
    
    //@Override
    public void actionPerformed(ActionEvent e) {
        Object choice = e.getSource();
        if(choice==back)
        {
          homePage();  
        }
        if(choice==Login)
        {
          login();  
        }
        if(choice==Register)
        {           
          register();  
        }
        if(choice == loginButton)
        {
            try {

                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                String url="jdbc:ucanaccess://Database2.accdb";
                Connection con=DriverManager.getConnection(url);
                String sql3 = "Select * FROM Table1 WHERE UserName=? AND Password=?";
                PreparedStatement statement3 = con.prepareStatement(sql3);

                statement3.setString(1, Nametxt.getText());
                statement3.setString(2, encryptDecrypt(Passwordtxt.getText()));
                ResultSet rs = statement3.executeQuery();
                if(rs.next()){
                    welcome();
                }
                else
                   invalidUsernameOrPassword();

                //Create Exception Handler
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        
        if(choice==ChangeName)
        {
           changeUsername();
        }
        if(choice==updateName)
        {
         try {

                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                String url="jdbc:ucanaccess://Database2.accdb";
                Connection con=DriverManager.getConnection(url);
                String sql = "UPDATE Table1 SET UserName=? WHERE UserName=?";

                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, NewNametxt.getText());
                statement.setString(2, Nametxt.getText());

                int rowsInserted = statement.executeUpdate();
                System.out.println(rowsInserted);

                if (rowsInserted > 0)
                    //System.out.println("Username changed successfully!");
                    usernameChangedSuccessfull();

                //Create Exception Handler
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if(choice==ChangePassword)
        {
         changePassword();  
        }
        if(choice==updatePass)
        {
         try {

                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                String url="jdbc:ucanaccess://Database2.accdb";
                Connection con=DriverManager.getConnection(url);
                String sql = "UPDATE Table1 SET Password=? WHERE UserName=? AND Password=?";

                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, encryptDecrypt(NewPasstxt.getText()));
                statement.setString(2, Nametxt.getText());
                statement.setString(3, encryptDecrypt(Passwordtxt.getText()));

                int rowsInserted = statement.executeUpdate();
                System.out.println(rowsInserted);

                if (rowsInserted > 0)
                   // System.out.println("Password changed successfully!");
                    passwordChangedSuccessfull();

                //Create Exception Handler
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        
        if(choice == registerButton)
        {
                String name= Nametxt.getText();
                String pass= Passwordtxt.getText();
                if(name.length()>20)
                {
                 invalidUsername();   
                }
                else if(pass.length()<4 || pass.length()>10)
                {
                    invalidPassword();
                }
                else{
                try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                String url="jdbc:ucanaccess://Database2.accdb";
                Connection con=DriverManager.getConnection(url);
                String sql = "INSERT INTO Table1 (UserName, Password) VALUES (?, ?)";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, Nametxt.getText());
                statement.setString(2, encryptDecrypt(Passwordtxt.getText()));

                int rowsInserted = statement.executeUpdate();

                if (rowsInserted > 0)
                    //System.out.println("A new user is registered successfully!");
                    registerSuccessfull();

                //Create Exception Handler
            } catch (Exception ex) {
                System.out.println(ex);
                alreadyExists();
            }
          }
        }
    }
    
    RegisterAndLogin()
    {
        homePage();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new RegisterAndLogin();
    }
    
}
