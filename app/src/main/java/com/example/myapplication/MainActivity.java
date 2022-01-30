package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.ui.login.LoginActivity;
import com.example.myapplication.ui.login.LogoutActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    TextView txt;
    TextView win;
    TextView total;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    FirebaseUser user;

    //int clicks = 0;
    int compChoice = 0;
    int playerChoice = 0;
    int wins = 0;
    int games = 0;

    //final int Rock = 0;
    //final int Paper = 1;
    //final int Scissors = 2;

    String[] names = {"Rock", "Paper", "Scissors"};
    //names.put(0, "Rock");

    /*public void playerRock(View view) {
        playerChoice =Rock;
        calculate();
    }

    public void playerPaper(View view) {
        playerChoice = Paper;
        calculate();
    }

    public void playerScissors(View view) {
        playerChoice = Scissors;
        calculate();
    }

    private void calculate() {

    }*/




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //final boolean[] clicked = {false};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.texty);
        win = (TextView) findViewById(R.id.wins);
        total = (TextView) findViewById(R.id.games);
        button0 = (Button) findViewById(R.id.buttonRock);
        button1 = (Button) findViewById(R.id.buttonPaper);
        button2 = (Button) findViewById(R.id.buttonScissors);
        button3 = (Button) findViewById(R.id.buttonLogin);
        button4 = (Button) findViewById(R.id.buttonSignout);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            button3.setEnabled(false);
            button3.setVisibility(View.INVISIBLE);
        } else {
            button4.setEnabled(false);
            button4.setVisibility(View.INVISIBLE);
            //now what
        }


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*clicks++;
                if (clicks == 1) txt.setText("You clicked the button 1 time");
                else txt.setText("You clicked the button " + clicks + " times");*/
                
                playerChoice = 0;
                calculate();
                //clicked[0] = true;
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerChoice = 1;
                calculate();
                //clicked[0] = true;

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerChoice = 2;
                //clicked[0] = true;
                calculate();

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LogoutActivity.class));
            }
        });


;
    }

    public void setCompChoice() {
        compChoice = (int)(Math.random()*3);
    }

    public void calculate() /*throws InterruptedException */{
        games++;
        total.setText("Total games: " + games);
        setCompChoice();
        //if (clicked[0]) {
        button0.setEnabled(false);
        button1.setEnabled(false);
        button2.setEnabled(false);
        //txt.setText("ligma");
        if (playerChoice == compChoice) {
            txt.setText("You and computer chose " +
                    names[playerChoice] + ". You drew!");
        } else if (playerChoice - compChoice == 1 || playerChoice - compChoice == -2) {
            txt.setText("You chose " +
                    names[playerChoice] + ". Computer chose " +
                    names[compChoice] + ". You won!");
            wins++;
            win.setText("Wins: " + wins);
        } else {
            txt.setText("You chose " +
                    names[playerChoice] + ". Computer chose " +
                    names[compChoice] + ". You lost!");
        }
        //wait(10);

        button0.setEnabled(true);
        button1.setEnabled(true);
        button2.setEnabled(true);


    }



}