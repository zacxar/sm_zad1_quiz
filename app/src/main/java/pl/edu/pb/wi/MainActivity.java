package pl.edu.pb.wi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionTextView;
    private int currentIndex = 0;

    private Question[] questions = new Question[] {
            new Question(R.string.q_1, true),
            new Question(R.string.q_2, true),
            new Question(R.string.q_3, false),
            new Question(R.string.q_4, true),
            new Question(R.string.q_5, true),
            new Question(R.string.q_6, false),
            new Question(R.string.q_7, true),
            new Question(R.string.q_8, false),
            new Question(R.string.q_9, true),
            new Question(R.string.q_10, false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        nextButton = findViewById(R.id.next_button);
        questionTextView = findViewById(R.id.question_text_view);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                CheckAnswerCorrectness(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                CheckAnswerCorrectness(false);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                currentIndex = (currentIndex + 1) % questions.length;
                SetNextQuestion();
            }
        });
        SetNextQuestion();
    }

    private void SetNextQuestion() {
        questionTextView.setText(questions[currentIndex].getQuestionId());
    }

    private void CheckAnswerCorrectness(boolean userAnswer) {
        boolean correctAnswer = questions[currentIndex].IsTrueAnswer();
        int resultMessageId = 0;

        if(userAnswer == correctAnswer)
            resultMessageId = R.string.correct_answer;
        else
            resultMessageId = R.string.incorrect_answer;

        Toast.makeText(this, resultMessageId, Toast.LENGTH_SHORT).show();
    }
}