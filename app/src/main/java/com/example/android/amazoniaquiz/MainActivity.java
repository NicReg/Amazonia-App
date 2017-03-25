package com.example.android.amazoniaquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.amazoniaquiz.R.string.first_question_text;

public class MainActivity extends AppCompatActivity {

    // Tracks the number of right answers in the Quiz
    int rightAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void getScoreOfQuiz(View v) {
        /**
         * In the next line the rightAnswers variable is setup to 0 ones the Get Score Quiz is clicked
         * otherwise if you redo the quiz a second time the percentage will get added to the one in the
         * previous quiz.
         */
        rightAnswers = 0;
        /**
         * Reviews that answers Peru and Suriname are checked in question 1 to increase the score variable.
         * Shows messages about getting the answers right or not indicating right answer if not.
         */
        CheckBox firstQuestionFirstAnswerPeru = (CheckBox) findViewById(R.id.first_question_answer_peru);
        CheckBox firstQuestionSecondAnswerSuriname = (CheckBox) findViewById(R.id.first_question_answer_suriname);
        CheckBox firstQuestionThirdAnswerChile = (CheckBox) findViewById(R.id.first_question_answer_chile);
        CheckBox firstQuestionFourthAnswerParaguay = (CheckBox) findViewById(R.id.first_question_answer_paraguay);
        Boolean hasPeruChecked = firstQuestionFirstAnswerPeru.isChecked();
        Boolean hasSurinameChecked = firstQuestionSecondAnswerSuriname.isChecked();
        Boolean hasChileChecked = firstQuestionThirdAnswerChile.isChecked();
        Boolean hasParaguayChecked = firstQuestionFourthAnswerParaguay.isChecked();
        if (hasPeruChecked && hasSurinameChecked) {
            if (hasChileChecked || hasParaguayChecked) {
                String firstQuestionWrong = getResources().getString(R.string.first_question_wrong_message);
                TextView focusFirstQuestion = (TextView) findViewById(R.id.first_question);
                focusFirstQuestion.requestFocus();
                Toast.makeText(this, firstQuestionWrong, Toast.LENGTH_SHORT).show();
            } else {
                rightAnswers += +1;
                String firstQuestionRight = getResources().getString(R.string.first_question_right_message);
                TextView focusFirstQuestion = (TextView) findViewById(R.id.first_question);
                focusFirstQuestion.requestFocus();
                Toast.makeText(this, firstQuestionRight, Toast.LENGTH_SHORT).show();
            }
        } else {
            String firstQuestionWrong = getResources().getString(R.string.first_question_wrong_message);
            TextView focusFirstQuestion = (TextView) findViewById(R.id.first_question);
            focusFirstQuestion.requestFocus();
            Toast.makeText(this, firstQuestionWrong, Toast.LENGTH_SHORT).show();
        }
        /**
         * As the result from the editText is an string it is checked in question 2 before doing anything as if it is
         * empty the app will crash. So if checked empty the toast message is showed indicating answer is
         * wrong. In case the field is answer such answer is reviewed and in case of being the right one
         * the score counter is increase in one. The answer cant be negative or text as property for the
         * view is set to inputType="number". Right number answer is displayed if user doesn't.
         */
        EditText valueEditTextQuestionTwoNumber = (EditText) findViewById(R.id.editText_question_two);
        String countries = valueEditTextQuestionTwoNumber.getText().toString();
        if (!countries.isEmpty ()) {
            int numberOfCountries = Integer.parseInt(valueEditTextQuestionTwoNumber.getText().toString());
            if (numberOfCountries == 7) {
                rightAnswers += +1;
                String secondQuestionRight = getResources().getString(R.string.second_question_right_message);
                Toast.makeText(this, secondQuestionRight, Toast.LENGTH_SHORT).show();
            } else {
                String secondQuestionWrong = getResources().getString(R.string.second_question_wrong_message);
                Toast.makeText(this, secondQuestionWrong, Toast.LENGTH_SHORT).show();
            }
        } else {
            String secondQuestionWrong = getResources().getString(R.string.second_question_wrong_message);
            Toast.makeText(this, secondQuestionWrong, Toast.LENGTH_SHORT).show();
        }
        /**
         * Reviews that right radio button in question 3 is selected. Message indicating the right
         * answer is displayed if the radio button selected is not the right answer.
         */
        RadioButton toucanRightAnswer = (RadioButton) findViewById(R.id.third_radio_button_toucan);
        if (toucanRightAnswer.isChecked()) {
            rightAnswers += +1;
            String thirdQuestionRight = getResources().getString(R.string.third_question_right_message);
            Toast.makeText(this, thirdQuestionRight, Toast.LENGTH_SHORT).show();
        } else {
            String thirdQuestionWrong = getResources().getString(R.string.third_question_wrong_message);
            Toast.makeText(this, thirdQuestionWrong, Toast.LENGTH_SHORT).show();
        }
        /**
         * Reviews that right radio button in question 4 is selected, if so score counter is increase in one.
         * Message indicating the right answer is displayed if the radio button selected is not the right answer.
         */
        RadioButton orellanaRightAnswer = (RadioButton) findViewById(R.id.fourth_radio_button_francisco_orellana);
        if (orellanaRightAnswer.isChecked()) {
            rightAnswers += +1;
            String fourthQuestionRight = getResources().getString(R.string.fourth_question_right_message);
            Toast.makeText(this, fourthQuestionRight, Toast.LENGTH_SHORT).show();
        } else {
            String fourthQuestionWrong = getResources().getString(R.string.fourth_question_wrong_message);
            Toast.makeText(this, fourthQuestionWrong, Toast.LENGTH_SHORT).show();
        }
        /**
         * Reviews that right radio button in question 5 is selected, if so score counter is increase in one.
         * Message indicating the right answer is displayed if the radio button selected is not the right answer.
         */
        RadioButton brazilRightAnswer = (RadioButton) findViewById(R.id.fifth_question_radio_button_brazil);
        if (brazilRightAnswer.isChecked()) {
            rightAnswers += +1;
            String fifthQuestionRight = getResources().getString(R.string.fifth_question_right_message);
            Toast.makeText(this, fifthQuestionRight, Toast.LENGTH_SHORT).show();
        } else {
            String fifthQuestionWrong = getResources().getString(R.string.fifth_question_wrong_message);
            Toast.makeText(this, fifthQuestionWrong, Toast.LENGTH_SHORT).show();
        }
        /**
         * Reviews that three check buttons have been selected in the 6 question as all of them are right.
         * If so the score counter is increase by one. In case of not right answers been selected a message
         * indicating so is showed including the right answers.
         */
        CheckBox firstAnswerSixthQuestion = (CheckBox) findViewById(R.id.sixth_question_answer_lamia_shark);
        CheckBox secondAnswerSixthQuestion = (CheckBox) findViewById(R.id.sixth_question_answer_river_dolphin);
        CheckBox thirdAnswerSixthQuestion = (CheckBox) findViewById(R.id.sixth_question_answer_manati);
        Boolean hasSharkChecked = firstAnswerSixthQuestion.isChecked();
        Boolean hasDolphinChecked = secondAnswerSixthQuestion.isChecked();
        Boolean hasManatiChecked = thirdAnswerSixthQuestion.isChecked();
        if (hasSharkChecked && hasDolphinChecked && hasManatiChecked) {
            rightAnswers += +1;
            String sixthQuestionRight = getResources().getString(R.string.sixth_question_right_message);
            Toast.makeText(this, sixthQuestionRight, Toast.LENGTH_SHORT).show();
        } else {
            String sixthQuestionWrong = getResources().getString(R.string.sixth_question_wrong_message);
            Toast.makeText(this, sixthQuestionWrong, Toast.LENGTH_SHORT).show();
        }
        /**
         * Reviews that right radio button in question 7 is selected, if so score counter is increase in one.
         * Message indicating the right answer is displayed if the radio button selected is not the right answer.
         */
        RadioButton noRightAnswer = (RadioButton) findViewById(R.id.seven_question_radio_button_no);
        if (noRightAnswer.isChecked()) {
            rightAnswers += +1;
            String seventhQuestionRight = getResources().getString(R.string.seventh_question_right_message);
            Toast.makeText(this, seventhQuestionRight, Toast.LENGTH_SHORT).show();
        } else {
            String seventhQuestionWrong = getResources().getString(R.string.seventh_question_wrong_message);
            Toast.makeText(this, seventhQuestionWrong, Toast.LENGTH_SHORT).show();
        }
        /**
         * Reviews that right radio button in question 8 is selected, if so score counter is increase in one.
         * Message indicating the right answer is displayed if the radio button selected is not the right answer.
         */
        RadioButton scarletMacawRightAnswer = (RadioButton) findViewById(R.id.eighth_third_radio_button_scarlet_macaw);
        if (scarletMacawRightAnswer.isChecked()) {
            rightAnswers += +1;
            String eighthQuestionRight = getResources().getString(R.string.eighth_question_right_message);
            TextView focusEighthQuestion = (TextView) findViewById(R.id.eighth_question);
            focusEighthQuestion.requestFocus();
            Toast.makeText(this, eighthQuestionRight, Toast.LENGTH_SHORT).show();
        } else {
            String eighthQuestionWrong = getResources().getString(R.string.eighth_question_wrong_message);
            TextView focusEighthQuestion = (TextView) findViewById(R.id.eighth_question);
            focusEighthQuestion.requestFocus();
            Toast.makeText(this, eighthQuestionWrong, Toast.LENGTH_SHORT).show();
        }
        /**
         * As the result from the editText is an string it is checked in question 9 before doing anything as if it is
         * empty the app will crash. So if checked empty the toast message is showed indicating answer is
         * wrong. In case the field is answer such answer is reviewed and in case of being the right one,
         * which is 20 but it have being left as between 17 and 23 to be a little bit less strict on answer,
         * the score counter is increase in one. The answer cant be negative or text as property for the
         * view is set to inputType="number". Right number answer is displayed if user doesn't.
         */
        EditText valueEditTextQuestionNineNumber = (EditText) findViewById(R.id.editText_question_nine);
        String percentageOfOxygen = valueEditTextQuestionNineNumber.getText().toString();
        if (!percentageOfOxygen.isEmpty()) {
            int Oxygen = Integer.parseInt(valueEditTextQuestionNineNumber.getText().toString());
            if (Oxygen > 16 && Oxygen < 24) {
                rightAnswers += +1;
                String ninthQuestionRight = getResources().getString(R.string.ninth_question_right_message);
                Toast.makeText(this, ninthQuestionRight, Toast.LENGTH_SHORT).show();
            } else {
                String ninthQuestionWrong = getResources().getString(R.string.ninth_question_wrong_message);
                Toast.makeText(this, ninthQuestionWrong, Toast.LENGTH_SHORT).show();
            }
        } else {
            String ninthQuestionWrong = getResources().getString(R.string.ninth_question_wrong_message);
            Toast.makeText(this, ninthQuestionWrong, Toast.LENGTH_SHORT).show();
        }
        /**
         * Reviews that right radio button in question 10 is selected, if so score counter is increase in one.
         * Message indicating the right answer is displayed if the radio button selected is not the right answer.
         */
        RadioButton fiftyFiveRightAnswer = (RadioButton) findViewById(R.id.tenth_question_radio_button_55);
        if (fiftyFiveRightAnswer.isChecked()) {
            rightAnswers += +1;
            String tenthQuestionRight = getResources().getString(R.string.tenth_question_right_message);
            Toast.makeText(this, tenthQuestionRight, Toast.LENGTH_SHORT).show();
        } else {
            String tenthQuestionWrong = getResources().getString(R.string.tenth_question_wrong_message);
            Toast.makeText(this, tenthQuestionWrong, Toast.LENGTH_SHORT).show();
        }
        /**
         * This shows a toast message indicating the percentage of questions answered correctly.
         */
        String finalScoreMessage = getResources().getString(R.string.button_score_quiz_final_message);
        Toast.makeText(this, (finalScoreMessage + (rightAnswers * 10)) + "%", Toast.LENGTH_LONG).show();
    }

    public void tryQuizAgain(View v) {
        /**
         * From this point all the code is referring to reset all the values in the quiz to null so you
         * can redo it again, otherwise the previous answers will be still there.
         */

        /**
         * This code reset all the answers to null in question 1 so the user can start the quiz again from scratch.
         */
        CheckBox questionOneAnswerOne = (CheckBox) findViewById(R.id.first_question_answer_peru);
        questionOneAnswerOne.setChecked(false);
        CheckBox questionOneAnswerTwo = (CheckBox) findViewById(R.id.first_question_answer_suriname);
        questionOneAnswerTwo.setChecked(false);
        CheckBox questionOneAnswerThree = (CheckBox) findViewById(R.id.first_question_answer_chile);
        questionOneAnswerThree.setChecked(false);
        CheckBox questionOneAnswerFour = (CheckBox) findViewById(R.id.first_question_answer_paraguay);
        questionOneAnswerFour.setChecked(false);
        /**
         * This code reset all the answers to null in question 2 so the user can start the quiz again from scratch.
         */
        EditText edittextAnswerSecondQuestion = (EditText) findViewById(R.id.editText_question_two);
        edittextAnswerSecondQuestion.setText("");
        /**
         * This code reset all the answers to null in question 3 so the user can start the quiz again from scratch.
         */
        RadioButton questionThreeAnswersOne = (RadioButton) findViewById(R.id.third_radio_button_toucan);
        questionThreeAnswersOne.setChecked(false);
        RadioButton questionThreeAnswersTwo = (RadioButton) findViewById(R.id.third_radio_button_macaws);
        questionThreeAnswersTwo.setChecked(false);
        RadioButton questionThreeAnswersThree = (RadioButton) findViewById(R.id.third_radio_button_hoatzin);
        questionThreeAnswersThree.setChecked(false);
        /**
         * This code reset all the answers to null in question 4 so the user can start the quiz again from scratch.
         */
        RadioButton questionFourAnswerOne = (RadioButton) findViewById(R.id.fourth_radio_button_francisco_pizarro);
        questionFourAnswerOne.setChecked(false);
        RadioButton questionFourAnswersTwo = (RadioButton) findViewById(R.id.fourth_radio_button_francisco_orellana);
        questionFourAnswersTwo.setChecked(false);
        RadioButton questionFourAnswersThree = (RadioButton) findViewById(R.id.fourth_radio_button_hernan_cortes);
        questionFourAnswersThree.setChecked(false);
        /**
         * This code reset all the answers to null in question 5 so the user can start the quiz again from scratch.
         */
        RadioButton questionFiveAnswerOne = (RadioButton) findViewById(R.id.fifth_question_radio_button_peru);
        questionFiveAnswerOne.setChecked(false);
        RadioButton questionFiveAnswerTwo = (RadioButton) findViewById(R.id.fifth_question_radio_button_brazil);
        questionFiveAnswerTwo.setChecked(false);
        RadioButton questionFiveAnswerThree = (RadioButton) findViewById(R.id.fifth_question_radio_button_colombia);
        questionFiveAnswerThree.setChecked(false);
        /**
         * This code reset all the answers to null in question 6 so the user can start the quiz again from scratch.
         */
        CheckBox questionSixAnswerOne = (CheckBox) findViewById(R.id.sixth_question_answer_lamia_shark);
        questionSixAnswerOne.setChecked(false);
        CheckBox questionSixAnswerTwo = (CheckBox) findViewById(R.id.sixth_question_answer_river_dolphin);
        questionSixAnswerTwo.setChecked(false);
        CheckBox questionSixAnswerThree = (CheckBox) findViewById(R.id.sixth_question_answer_manati);
        questionSixAnswerThree.setChecked(false);
        /**
         * This code reset all the answers to null in question 7 so the user can start the quiz again from scratch.
         */
        RadioButton questionSevenAnswerYes = (RadioButton) findViewById(R.id.seven_question_radio_button_yes);
        questionSevenAnswerYes.setChecked(false);
        RadioButton questionSevenAnswerNo = (RadioButton) findViewById(R.id.seven_question_radio_button_no);
        questionSevenAnswerNo.setChecked(false);
        /**
         * This code reset all the answers to null in question 8 so the user can start the quiz again from scratch.
         */
        RadioButton quetionSevenAnswerOne = (RadioButton) findViewById(R.id.eighth_third_radio_button_mealy_parrot);
        quetionSevenAnswerOne.setChecked(false);
        RadioButton quetionSevenAnswerTwo = (RadioButton) findViewById(R.id.eighth_third_radio_button_masked_trogon);
        quetionSevenAnswerTwo.setChecked(false);
        RadioButton quetionSevenAnswerThree = (RadioButton) findViewById(R.id.eighth_third_radio_button_scarlet_macaw);
        quetionSevenAnswerThree.setChecked(false);
        /**
         * This code reset all the answers to null in question 9 so the user can start the quiz again from scratch.
         */
        EditText edittextAnswerNinethQuestion = (EditText) findViewById(R.id.editText_question_nine);
        edittextAnswerNinethQuestion.setText("");
        /**
         * This code reset all the answers to null in question 10 so the user can start the quiz again from scratch.
         */
        RadioButton questionTenAnswerOne = (RadioButton) findViewById(R.id.tenth_question_radio_button_75);
        questionTenAnswerOne.setChecked(false);
        RadioButton questionTenAnswerTwo = (RadioButton) findViewById(R.id.tenth_question_radio_button_55);
        questionTenAnswerTwo.setChecked(false);
        RadioButton questionTenAnswerThree = (RadioButton) findViewById(R.id.tenth_question_radio_button_45);
        questionTenAnswerThree.setChecked(false);
        /**
         * This code will sent the focus to the beginning of the app after resetting all the questions.
         */
        ScrollView mainScrollView = (ScrollView)findViewById(R.id.scrollview_covering_app);
        mainScrollView.fullScroll(ScrollView.FOCUS_UP);
    }
}