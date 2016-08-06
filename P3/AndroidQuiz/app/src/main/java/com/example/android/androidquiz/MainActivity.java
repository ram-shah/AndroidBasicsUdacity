package com.example.android.androidquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitAnswers(View view) {
        int q1AnswerCorrect = R.id.q1_option2;
        int q2AnswerCorrect = R.id.q2_option3;
        int q3AnswerCorrect = R.id.q3_option1;
        int q4AnswerCorrect = R.id.q4_option4;
        String q7AnswerCorrect = getString(R.string.text_2005);

        int correctAnswersCount = 0; // Keeps count of the correct answers

        // Check if question 1 was answered correctly
        RadioGroup radioGroupQ1 = (RadioGroup) findViewById(R.id.q1_radio_group);

        int q1AnswerSelected = radioGroupQ1.getCheckedRadioButtonId();

        if (q1AnswerSelected == q1AnswerCorrect) {
            correctAnswersCount += 1;
        }

        // Check if question 2 was answered correctly
        RadioGroup radioGroupQ2 = (RadioGroup) findViewById(R.id.q2_radio_group);

        int q2AnswerSelected = radioGroupQ2.getCheckedRadioButtonId();

        if (q2AnswerSelected == q2AnswerCorrect) {
            correctAnswersCount += 1;
        }

        // Check if question 3 was answered correctly
        RadioGroup radioGroupQ3 = (RadioGroup) findViewById(R.id.q3_radio_group);

        int q3AnswerSelected = radioGroupQ3.getCheckedRadioButtonId();

        if (q3AnswerSelected == q3AnswerCorrect) {
            correctAnswersCount += 1;
        }

        // Check if question 4 was answered correctly
        RadioGroup radioGroupQ4 = (RadioGroup) findViewById(R.id.q4_radio_group);

        int q4AnswerSelected = radioGroupQ4.getCheckedRadioButtonId();

        if (q4AnswerSelected == q4AnswerCorrect) {
            correctAnswersCount += 1;
        }

        // Check if question 5 was answered correctly
        CheckBox q5_option1 = (CheckBox) findViewById(R.id.q5_option1_check_box);
        CheckBox q5_option2 = (CheckBox) findViewById(R.id.q5_option2_check_box);
        CheckBox q5_option3 = (CheckBox) findViewById(R.id.q5_option3_check_box);
        CheckBox q5_option4 = (CheckBox) findViewById(R.id.q5_option4_check_box);

        if (q5_option1.isChecked() && q5_option2.isChecked() && q5_option3.isChecked() && q5_option4.isChecked()) {
            correctAnswersCount += 1;
        }

        // Check if question 6 was answered correctly
        CheckBox q6_option1 = (CheckBox) findViewById(R.id.q6_option1_check_box);
        CheckBox q6_option2 = (CheckBox) findViewById(R.id.q6_option2_check_box);
        CheckBox q6_option3 = (CheckBox) findViewById(R.id.q6_option3_check_box);
        CheckBox q6_option4 = (CheckBox) findViewById(R.id.q6_option4_check_box);

        if (q6_option1.isChecked() && q6_option2.isChecked() && !q6_option3.isChecked() && !q6_option4.isChecked()) {
            correctAnswersCount += 1;
        }

        // Check if question 7 was answered correctly
        EditText q7EditText = (EditText) findViewById(R.id.q7_edit_text);
        String year = q7EditText.getText().toString();

        if (year.equals(q7AnswerCorrect)) {
            correctAnswersCount += 1;
        }

        // Display the result message
        if (correctAnswersCount <= 3) {
            Toast.makeText(this, getString(R.string.result_msg1, correctAnswersCount), Toast.LENGTH_LONG).show();
        }
        else if (correctAnswersCount <= 6) {
            Toast.makeText(this, getString(R.string.result_msg2, correctAnswersCount), Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, getString(R.string.result_msg3, correctAnswersCount), Toast.LENGTH_LONG).show();
        }

    }
}
