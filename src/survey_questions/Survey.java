package survey_questions;

import java.util.ArrayList;
import java.util.List;

public class Survey {
    public static void main(String[] args) {
        SurveyPreparing mySurvey = new SurveyPreparing();
        List<SurveyQuestionWithOptions> answer = mySurvey.prepSurvey(2);
        ArrayList<String> surveyAnswers = mySurvey.startSurvey(answer);
        int i=1;
        for(String a:surveyAnswers){
            System.out.println("Your answer for question "+i+++" was "+a);
        }
    }
}
