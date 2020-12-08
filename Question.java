
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

 class Question{

String question;
String answer1;
String answer2;
String answer3;
String answer4;
int correctAnswer;
int point;

Question(String aQuestion, String aAnswer1, String aAnswer2,String aAnswer3, String aAnswer4, int aCorrectAnswer, int aPoint)
{
  question= aQuestion;
  answer1=aAnswer1;
  answer2=aAnswer2;
  answer3=aAnswer3;
  answer4=aAnswer4;
  correctAnswer=aCorrectAnswer;
  point=aPoint;

}

String getQuestion(){
  return question;
}

String getAnswer1(){
  return answer1;
}

String getAnswer2(){
  return answer2;
}
String getAnswer3(){
  return answer3;
}
String getAnswer4(){
  return answer4;
}

int getCorrectAnswer(){
  return correctAnswer;
}

int getPoint(){
  return point;
}


}