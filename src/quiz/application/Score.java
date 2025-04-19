package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {
    
    Score(String name, int score)
    {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Score2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(330, 280, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(30, 300, 300, 250);
        add(image);
        
        JLabel heading= new JLabel("Thank You " + name + " for playing this quiz");
        heading.setBounds(50, 30, 700, 70);
        heading.setFont(new Font("Stencil", Font.PLAIN, 32));
        add(heading);
        
        JLabel lblscore= new JLabel("Your score is "+ score);
        lblscore.setBounds(280, 200, 300, 30);
        lblscore.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(lblscore);
        
        JButton submit= new JButton("Play again");
        submit.setBounds(320, 270, 120, 30);
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
       setVisible(false);
       new Login();
    }
    public static void main(String args[])
    {
        new Score("User", 0);
    }
}
