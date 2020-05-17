package survey_questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SurveyPreparing {
    public List<SurveyQuestionWithOptions> prepSurvey(int numberOfQuestions){
        List<SurveyQuestionWithOptions> survey =new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String question;
        String option1;
        String option2;
        String option3;
        for (int i = 0; i < numberOfQuestions; i++) {
            System.out.print("What's your question?: ");
            question=scan.nextLine();
            System.out.print("What's 1st options?: ");
            option1=scan.nextLine();
            System.out.print("What's 2nd options?: ");
            option2=scan.nextLine();
            System.out.print("What's 3rd options?: ");
            option3=scan.nextLine();
            survey.add(new SurveyQuestionWithOptions(question,option1,option2,option3));
        }
        return survey;
    }
    public ArrayList<String> startSurvey (List<SurveyQuestionWithOptions> survey){
        ArrayList<String> answer = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < survey.size(); i++) {
            System.out.println("Question "+(i+1)+": "+survey.get(i).getQuestion());
            System.out.print("a) "+survey.get(i).getOption1()+"\t");
            System.out.print("b) "+survey.get(i).getOption2()+"\t");
            System.out.println("c) "+survey.get(i).getOption3());
            System.out.print("Your answer: ");
            answer.add(scan.nextLine());
        }
        return answer;
    }
}
