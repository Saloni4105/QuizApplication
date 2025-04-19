package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener{
    
    String questions[][]= new String[10][5];
    String answers[][]= new String[10][2];
    String useranswers[][]= new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score=0;
    
    String name;
    
    Quiz(String name)
    {
        this.name= name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);
        
        qno= new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);
        
        question= new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        add(question);
        
        questions[0][0] = "Who is the Father of Indian Space Program?";
        questions[0][1] = "Satish Dhawan";
        questions[0][2] = "Vikram Sarabhai";
        questions[0][3] = "Vikrant Ramakrishnan";
        questions[0][4] = "A.P.J. Abdul kalam";

        questions[1][0] = "When was Pluto removed from the list of planets?";
        questions[1][1] = "2000";
        questions[1][2] = "2003";
        questions[1][3] = "2006";
        questions[1][4] = "2008";

        questions[2][0] = "Which type of star is the Sun classified?";
        questions[2][1] = "A-type star";
        questions[2][2] = "F-type star";
        questions[2][3] = "K-type star";
        questions[2][4] = "G2 V star";

        questions[3][0] = "Who was the first to suggest the idea of an artificial satellite?";
        questions[3][1] = "Johannes Kepler";
        questions[3][2] = "Galileo Galilei";
        questions[3][3] = "Sir Issac Newton";
        questions[3][4] = "Leonardo da Vinci";

        questions[4][0] = "The number of terrestrial planet in the Solar system-";
        questions[4][1] = "6";
        questions[4][2] = "4";
        questions[4][3] = "2";
        questions[4][4] = "8";

        questions[5][0] = "In which galaxy was a black hole discovered in the year 2017?";
        questions[5][1] = "M87";
        questions[5][2] = "NGC 1300";
        questions[5][3] = "IC 1101";
        questions[5][4] = "Comet";

        questions[6][0] = "Which planet's axis is almost parallel to its orbital plane, making it spin nearly on its side?";
        questions[6][1] = "Jupiter";
        questions[6][2] = "Saturn";
        questions[6][3] = "Uranus";
        questions[6][4] = "Venus";

        questions[7][0] = "The largest moon in our Solar system has an atmosphere that is denser than the atmosphere of Mars?";
        questions[7][1] = "Europa";
        questions[7][2] = "Callisto";
        questions[7][3] = "Titan";
        questions[7][4] = "Ganymede";

        questions[8][0] = "What is Black hole?";
        questions[8][1] = "A star that gives off light";
        questions[8][2] = "A region of space with strong gravity where even light can't escape";
        questions[8][3] = "A comet made of dark matter";
        questions[8][4] = "A planet with a very thick atmosphere";

        questions[9][0] = "Which planet has the largest volcano in the solar system, named Olympus Mons?";
        questions[9][1] = "Earth";
        questions[9][2] = "Venus";
        questions[9][3] = "Mars";
        questions[9][4] = "Jupiter";
        
        answers[0][1] = "Vikram Sarabhai";
        answers[1][1] = "2006";
        answers[2][1] = "G2 V star";
        answers[3][1] = "Sir Issac Newton";
        answers[4][1] = "4";
        answers[5][1] = "M87";
        answers[6][1] = "Uranus";
        answers[7][1] = "Titan";
        answers[8][1] = "A region of space with strong gravity where even light can't escape";
        answers[9][1] = "Mars";
        
        opt1= new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add (opt1);
        
        opt2= new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add (opt2);
        
        opt3= new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add (opt3);
        
        opt4= new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add (opt4);
        
        groupoptions= new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next= new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        submit= new JButton("Submit");
        submit.setBounds(1100, 630, 200, 40);
        submit.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==next)
        {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if(groupoptions.getSelection()==null)
            {
                useranswers[count][0] = "";
            }
            else
            {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            if(count == 8)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            
            count++;
            start(count);
        }
        else if(ae.getSource()==lifeline)
        {
            if(count==2 || count==4 || count==6 || count==8 || count==9)
            {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            }
            else
            {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        }
        else if (ae.getSource()== submit)
        {
            ans_given =1;
            if(groupoptions.getSelection()==null)
            {
                useranswers[count][0] = "";
            }
                else
                {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
               for(int i=0; i<useranswers.length;i++)
               {
                   if(useranswers[i][0].equals(answers[i][1]))
                   {
                       score +=10;
                   }
                   else
                   {
                       score +=0;
                   }
               }
               setVisible(false);
               new Score(name, score);
               
        }
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        
        String time ="Time left : " + timer + " seconds"; //30
        g.setColor(Color.RED);
        g.setFont(new Font("Times New Roman", Font.BOLD, 20));
        
        
        if(timer > 0)
        {
            g.drawString(time, 1100, 500);
        }
        else
        {
            g.drawString("Times Up!!", 1100, 500);
        }
        
        timer--;
        
        try
        {
            Thread.sleep(1000);
            repaint();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        if(ans_given==1)
        {
            ans_given=0;
            timer = 15;
        }
        else if(timer < 0)
        {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            
            if (count==0)
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count==9) //submit button
            {
                if(groupoptions.getSelection()==null)
            {
                useranswers[count][0] = "";
            }
                else
                {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
               for(int i=0; i<useranswers.length;i++)
               {
                   if(useranswers[i][0].equals(answers[i][1]))
                   {
                       score +=10;
                   }
                   else
                   {
                       score +=0;
                   }
               }
               setVisible(false);
               new Score(name, score);
            }
            else
            {
                if(groupoptions.getSelection()==null)
            {
                useranswers[count][0] = "";
            }
            else
            {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            count++;
            start(count);
            }
            
            
        }
    }
    
    public void start(int count)
    {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    public static void main(String[] args)
    {
        new Quiz("User");
    }
}
