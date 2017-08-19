package com.example.liongate.geoquiz2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {


    public static final String EXTRA_ANSWER_IS_TRUE = "com.geo.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "com.geo.answer_shown";

    private boolean mAnswerIsTrue;
    private Button mShowAnswerButton;
    private TextView mAnswerTextView;

    public static Intent newIntent(Context packageContext,boolean answerIsTrue){

        Intent intent = new Intent(packageContext,CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE,answerIsTrue);

        return intent;

    }

    public static boolean wasAnswerShown(Intent intent) {

        return intent.getBooleanExtra(EXTRA_ANSWER_SHOWN,false);
    }

    private void setAnswerShownResult(boolean isAnswerShown) {

        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN,isAnswerShown);
        setResult(RESULT_OK,data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);

        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);

        mShowAnswerButton = (Button)findViewById(R.id.showAnswerButton);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAnswerTextView.setText(""+mAnswerIsTrue);

                setAnswerShownResult(true);
            }
        });

    }
}
