package pl.edu.pb.wi;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {
    private int questionId;
    private boolean answer;

    public Question(int questionId, boolean trueAnswer) {
        this.questionId = questionId;
        this.answer = trueAnswer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public boolean IsTrueAnswer() {
        return answer;
    }
}
