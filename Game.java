import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;
import javax.swing.*;
//imports all the items we need for what were using 
//statrt class and implements actionlistener 
public class Game implements ActionListener {
  JTextField fieldName; // declars are input textfield for user
  // declares all our varaibles
  JButton buttonAnswer1, buttonAnswer2, buttonAnswer3, buttonAnswer4,buttonNext; 
   int points=0;
   int questionNum= 0;
   JLabel jlabName, jlabQuestion,jlabCorrect, jlabuserPoints, jlabvalue; 

    //declares are ArrayList and input our txtfile
    static ArrayList<Question> Questions;
     static String filename = "trivia.txt";
     static FileReader myFile;
     // starts a aray list to store are buttons for next questions 
     JButton[] buttonA = new JButton[4];
     
     //Method to change questions and correct answers 
     public void nextQuestion(int question){     
    jlabQuestion.setText(Questions.get(question).getQuestion());
    jlabuserPoints.setText("point" + Integer.toString(Questions.get(question).getPoint()));
    buttonAnswer1.setText(Questions.get(question).getAnswer1());
    buttonAnswer2.setText(Questions.get(question).getAnswer2());
    buttonAnswer3.setText(Questions.get(question).getAnswer3());
    buttonAnswer4.setText(Questions.get(question).getAnswer4());

   
  }
     

    
    // start of object 

   Game(){
    
      JFrame frame = new JFrame("Group 7 Great Trivia Game!"); //adds are frame
      // Specify FlowLayout for the layout manager. 
      frame.setLayout(new FlowLayout()); 
      // Give the frame an initial size. 
      frame.setSize(800, 550); 
      // Create a text field. 
      fieldName = new JTextField(10); 
      // Set the action commands for the text field. 
      fieldName.setActionCommand("myTF");
       //declares are buttons 
       buttonAnswer1 = new JButton("A"); 
       buttonAnswer2 = new JButton("B");
       buttonAnswer3 = new JButton("C");
       buttonAnswer4 = new JButton("D");
       buttonNext= new JButton("Continue");
    
       //addes each button to our ArrayList
        buttonA[1] = buttonAnswer1;
        buttonA[2] = buttonAnswer2;
        buttonA[3] = buttonAnswer3;
        buttonA[4] = buttonAnswer4;
       // add of ActionListener for each varible 
      buttonAnswer1.addActionListener(this);
      buttonAnswer2.addActionListener(this);
      buttonAnswer3.addActionListener(this);
      buttonAnswer4.addActionListener(this);
      buttonNext.addActionListener(this);
      fieldName.addActionListener(this);

      //adds our lablels 
      jlabName = new JLabel("Whats Your Name?"); 
       // labels comes from our arraylist 
       jlabQuestion= new JLabel("");
       jlabCorrect = new JLabel("");
       jlabvalue= new JLabel("");
       jlabuserPoints= new JLabel("Score: " + points);

         //adds to frame
      frame.add(jlabName);
      frame.add(jlabuserPoints);
      frame.add(fieldName);
       frame.add (jlabQuestion);
       frame.add(jlabvalue);
       frame.add(buttonAnswer1);
       frame.add(buttonAnswer2);
       frame.add(buttonAnswer3);
       frame.add(buttonAnswer4);
       frame.add (buttonNext);
       frame.add(jlabCorrect);
      // Display the frame. 
      frame.setVisible(true);
       
         
      Questions = new ArrayList<Question>();
       filename = "trivia.txt";
       // sets arraylist data to question class 
       String question= "", answer1 = "", answer2 = "",answer3 = "",answer4= "",correctAnswer="",  point="";

       // start of our try and catch 
      try {
     myFile = new FileReader(filename);
     BufferedReader reader = new BufferedReader(myFile); 
     //reads through trivia file line 
     while (reader.ready()) {
     question = reader.readLine();
     answer1 = reader.readLine();
     answer2= reader.readLine();
     answer3= reader.readLine();
     answer4= reader.readLine();
     correctAnswer= reader.readLine();
      point= reader.readLine();
      // makes new questiion obeject for each question in trivia file 
    Question theQuestion = new Question(question,answer1,answer2,answer3,answer4, Integer.parseInt(correctAnswer), Integer.parseInt(point))     ;;
    Questions.add(theQuestion);
      }
     reader.close();
    } 
    catch (IOException exception) {
    System.out.println("An error occurred: " + exception);

   }
   }

// start of actionPerformed to check answer and questions 
public void actionPerformed(ActionEvent ae) {
  //get value of correct answer and store in a variable for comparison
   String correctAns = buttonA[Questions.get(questionNum).getCorrectAnswer()-1].getText()
    if(ae.getActionCommand().equals("myTF")){
      String user = fieldName.getText(); 
        //welcome user with name from textfield
      jlabName.setText("Welcome, " + user);
      //uses method to get next question 
      nextQuestion(questionNum);
      
    }
    
    else if(ae.getActionCommand().equals(correctAns)){
      jlabCorrect.setText("You Got it!, please Click Continue");
      score = points + Questions.get(nextQuestion).getValue();
      jlabScore.setText("Score: "+ points);
      jlabCorrect.setVisible(true);
    }
     // if it is correct answer add points, if not user hits countie to try again 
    
    else if(ae.getActionCommand().equals("Continue")){
      if(nextQuestion < Questions.size()-1) {
        nextQuestion++;
       buttonA (nextQuestion);
        jlabCorrect.setVisible(false);
      }
       else if(nextQuestion == Questions.size()-1){
        jlabWelcome.setText("Thats it! Thanks for playing");
        jlabScore.setText("You Scored: " + points  + " points! Nice!"); 
        jlabScore.setVisible(true);
           
      }
    }
    else if(!ae.getActionCommand().equals(correctAns)) {
      jlabCorrect.setText("That's not Correct, please click Continue");
      jlabCorrect.setVisible(true);
    }


    
  }

}

