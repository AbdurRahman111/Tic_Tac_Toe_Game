package com.example.tictactoegamesarcsoftwaresit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    TextView headertext;

    int PLAYER_X = 0;
    int PLAYER_O = 1;

    int active_player = PLAYER_X;

    int[] fillpos = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

    boolean isGameActive = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        headertext=findViewById(R.id.header_text);
        headertext.setText("O's Turn");

        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);


        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);






    }

    @Override
    public void onClick(View v) {

        if (!isGameActive){

            return;}

        Button ClickButton = findViewById(v.getId());
        int ClickTag = Integer.parseInt(v.getTag().toString());

        if (fillpos[ClickTag]!=-1){

            return;
        }
        fillpos[ClickTag] = active_player;

        if (active_player == PLAYER_X){
            ClickButton.setText("O");
            ClickButton.setBackground(getDrawable(android.R.color.holo_blue_light));
            active_player = PLAYER_O;
            headertext.setText("X's Turn");
        }

        else {
            ClickButton.setText("X");
            ClickButton.setBackground(getDrawable(android.R.color.holo_green_light));
            active_player = PLAYER_X;
            headertext.setText("O's Turn");
        }

        chack_for_win();

    }

    private void chack_for_win(){

        //we will chack who has won and show this

        int[][] winningpos = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

        for(int i=0;i<8;i++){

            int val0 = winningpos[i][0];
            int val1 = winningpos[i][1];
            int val2 = winningpos[i][2];

            if (fillpos[val0] == fillpos[val1] && fillpos[val1] == fillpos[val2]){

                if (fillpos[val0] != -1){

                    isGameActive = false;
                    // wiiner declare
                    if (fillpos[val0] == PLAYER_O){

                        showDialog("X Is Winner!!");
                    }


                    else
                    {

                        showDialog("O Is Winner!!");
                    }


                }
            }


        }




    }

    private void showDialog(String winnerText){
        new AlertDialog.Builder(this)
                .setTitle(winnerText)
                .setPositiveButton("Restart The Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        restartGame();
                    }
                })
                .show();


    }

    private void restartGame(){

        active_player=PLAYER_X;
        headertext.setText("O's Turn");
        fillpos = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};

        btn0.setText("");
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");

        btn0.setBackground(getDrawable(android.R.color.holo_orange_light));
        btn1.setBackground(getDrawable(android.R.color.holo_orange_light));
        btn2.setBackground(getDrawable(android.R.color.holo_orange_light));
        btn3.setBackground(getDrawable(android.R.color.holo_orange_light));
        btn4.setBackground(getDrawable(android.R.color.holo_orange_light));
        btn5.setBackground(getDrawable(android.R.color.holo_orange_light));
        btn6.setBackground(getDrawable(android.R.color.holo_orange_light));
        btn7.setBackground(getDrawable(android.R.color.holo_orange_light));
        btn8.setBackground(getDrawable(android.R.color.holo_orange_light));

        isGameActive = true;




    }

}