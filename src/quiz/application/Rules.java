package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Rules extends JFrame implements ActionListener {
    
    String name;
    JButton start, back;
    Rules(String name)
    {
        this.name= name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Welcome " + name + " to QuizNova");
        heading.setBounds(50, 20, 700, 70);
        heading.setFont(new Font("Stencil", Font.BOLD, 30));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
        
        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 400);
        rules.setFont(new Font("Tahona", Font.PLAIN, 16));
        rules.setText(
        "<html>"+ 
                "1. The quiz is open to all students interested in Space & technology topics." + "<br><br>" +
                "2. This quiz is for  individual participants only; no team entries are allowed." + "<br><br>" +
                "3. The quiz consists of 10-multiple choice questions, each will be displayed for 15 seconds." + "<br><br>" +
                "4. Each correct answers earns 1 point. There is no negative marking for wrong answers." + "<br><br>" +
                "5. If a participant fails to answer within 15 seconds, the question will marked as unanswered." + "<br><br>" +
                "6. The use of mobile phones, books, internet, or any other external resources is strictly prohibited during the quiz." + "<br><br>" +
                "7. Participants must remain attentive as the questions move automatically after the 15-second timer ends." + "<br><br>" +
                "8. Quiz master's decision are final." + "<br><br>" +
            "<html>"
        );
        add(rules);
        
        back = new JButton("Back");
        back.setBounds(250,500, 100, 30);
        back.setBackground(new Color(30,144,254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(new Color(30,144,254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        
        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==start)
        {
            setVisible(false);
            new Quiz(name);
        }
        else {
            setVisible(false);
            new Login();
        }
        {
            
        }
    }
    public static void main(String args[])
    {
        new Rules("User");
    }
}
