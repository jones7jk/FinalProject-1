import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;
import javax.swing.*;

Public class Game implements ActionListener {
  JTextField fieldName; 
  JButton buttonAnswer1, buttonAswer2, buttonAnswer3, buttonAnswer4; 
   int points=0;
   int questionNum= 0;
   JLabel jlabName, jlabQuestion,jlabCorrect, jlabuserPoints, jlabvalue; 


    static ArrayList<Question> Questions;
     static String filename = "trivia.txt";
     static FileReader myFile;
     // to get the correct answer 
     JButton[] buttonA = new JButton[4];
     
     //changing questions
     public void nextQuestion(int question){     
    jlabQuestion.setText(Questions.get(question).getQText());
    jlabuserPoints.setText("point" + Integer.toString(Questions.get(question).getPoint()));
    buttonAnswer1.setText(Questions.get(question).getAnswer1());
    buttonAnswer2.setText(Questions.get(question).getAnswer2());
    buttonAnswer3.setText(Questions.get(question).getAnswer3());
    buttonAnswer4.setText(Questions.get(question).getAnswer4());

   
  }
     

    
    

   Game(){
    
      JFrame frame = new JFrame("Group 7 Great Trivia Game!"); 
      // Specify FlowLayout for the layout manager. 
      frame.setLayout(new FlowLayout()); 
      // Give the frame an initial size. 
      frame.setSize(800, 550); 
      // Create a text field. 
      fieldName = new JTextField(10); 
      // Set the action commands for the text field. 
      fieldName.setActionCommand("myTF");

       buttonAnswer1 = new JButton("A"); 
       buttonAnswer2 = new JButton("B");
       buttonAnswer3 = new JButton("C");
       buttonAnswer4 = new JButton("D");
       buttonNext= new JButton("Continue");
    
      
        buttonA[0] = buttonAnswer1;
        buttonA[1] = buttonAnswer2;
        buttonA[2] = buttonAnswer3;
        buttonA[3] = buttonAnswer4;
       
      buttonAnswer1.addActionListener(this);
      buttonAnswer2.addActionListener(this);
      buttonAnswer3.addActionListener(this);
      buttonAnswer4.addActionListener(this);
      buttonNext.addActionListener(this);
      fieldName.addActionListener(this);


      jlabName = new JLabel("Whats Your Name?"); 
       buttonEnter = new JButton("Enter");
       jlabQuestion= new JLabel("");
       jlabCorrect = new JLabel("");
       jlabvalue= new JLabel("");
       jlabuserPoints= new JLabel("Score: " + points);


      frame.add(jlabName);
      frame.add(jlabuserPoints);
      frame.add(fieldName);
       frame.add (jlabQuestion);
       rame.add(jlabvalue);
       frame.add(buttonAnswer1);
       frame.add(buttonAnswer2);
       frame.add(buttonAnswer3);
       frame.add(buttonAnswer4);
       frame.add (buttonNext);
       frame.add(jlabCorrect);
       


    
      

      
      // Display the frame. 
      frame.setVisible(true);
       jlabQuestion.setVisible(false);
       jlabuserPoints.setVisible(false);
       jlabScore.setVisible(false);
       buttonAnswer1.setVisible(false);
       buttonAnswer2.setVisible(false);
       buttonAnswer3.setVisible(false);
       buttonAnswer4.setVisible(false);
       buttonNext.setVisible(false);
       jlabCorrect.setVisible(false);
    


      questions = new ArrayList<Question>();
       filename = "trivia.txt";
       String question= "", answer1 = "", answer2 = "",answer3 = "",answer4= "",correctAnswer="",  point="";


      try {
     myFile = new FileReader(filename);
     BufferedReader reader = new BufferedReader(myFile);
     while (reader.ready()) {
     question = reader.readLine();
     answer1 = reader.readLine();
     answer2= reader.readLine();
     answer3= reader.readLine();
     answer4= reader.readLine();
     correctAnswer= reader.readLine();
      point= reader.readLine();
    Question aQuestion = new Question(question,answer1,answer2,answer3,answer4, Integer.parseInt(correctAnswer), Integer.parseInt(point))     ;Questions.add(theQuestion);
    questions.add(aQuestion);
      }
     reader.close();
    } 
    catch (IOException exception) {
    System.out.println("An error occurred: " + exception);

   }
   }


public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand().equals("myTF")){
      //welcome user with name from textfield
      String user = fieldName.getText();
      jlabWelcome.setText("Welcome, " + user);
      //call method to get question
      getQ(questionNum);
      //hide textbox and bring up questions/ answer choices
      jlabScore.setVisible(true);
      fieldName.setVisible(false);
      jlabQuestion.setVisible(true);
      jlabuserPoints.setVisible(true);
      buttonAnswer1.setVisible(true);
      buttonAnswer2.setVisible(true);
      buttonAnswer3.setVisible(true);
      buttonAnswer4.setVisible(true);
      buttonNext.setVisible(true);
      jlabCorrect.setVisible(false);
    }
    //get value of correct answer and store in a variable for comparison
    //String correctAns = buttons[questions.get(curQuestion).getCorrect()-1].getText();
    //Shows next question once the next question button is pressed
    //if the correct answer is clicked, show the follow label that says you got it correct. Following this: also add the points to your score
     String correctAns = buttonA[questions.get(questionNum).getCorrect()-1].getText();

    if(!ae.getActionCommand().equals(correctAns)) {
      jlabCorrect.setText("That's not Correct, please click Next Question.");
      jlabCorrect.setVisible(true);
    }
    if(ae.getActionCommand().equals("Continue")){
      questionNum++;
      getQ(questionNum);
      jlabCorrect.setVisible(false);
      if(questionNum == questions.size()){
      jlabName.setText("Thats it! Thanks for playing");
      jlabScore.setText("You Scored: " + points + " points! Nice!");       
      }
    }
    if(ae.getActionCommand().equals("myTF")){
    jlabCorrect.setText(""); 
    }
    else if(ae.getActionCommand().equals(correctAns)){
      jlabCorrect.setText("You Got it!, please Click Next Question!");
      score = points + questions.get(questionNum).getPoint();
      jlabScore.setText("Score: "+ points);
      jlabCorrect.setVisible(true);
    }     


    //If the answer selected is incorrect, show the following text and don't give any points

    // Ends game after all questions are answered and gives the user their score
    
    
    else if(ae.getActionCommand().equals("Continue") && questionNum == questions.size()){
      jlabName.setText("Thats it! Thanks for playing");
      jlabScore.setText("You Scored: " + points + " points! Nice!");
      jlabScore.setVisible(true);
      Name.setVisible(false);
      jlabQuestion.setVisible(false);
      jlabuserPoints.setVisible(false);
      buttonAnswer1.setVisible(false);
      buttonAnswer2.setVisible(false);
      buttonAnswer3.setVisible(false);
      buttonAnswer4.setVisible(false);
      buttonNext.setVisible(false);
      jlabCorrect.setVisible(false);
    } 
  }

}

