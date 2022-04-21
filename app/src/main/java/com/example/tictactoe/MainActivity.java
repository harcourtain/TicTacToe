package com.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//  Player Representation
//    0 - x
//    1 - 0
    boolean gameActive=true;
    int activePlayer=0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
//    state Meaning
//            0 -X
//            1- O
//            2-null
int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},
                        {0,3,6},{1,4,7},{2,5,8},
                        {0,4,8},{2,4,6}};
int count=0;
    public void playerTap(View view){
        ImageView img=(ImageView) view;
        int tappedImage=Integer.parseInt(img.getTag().toString());
        if(!gameActive) gameReset();
        if(gameState[tappedImage]==2 && gameActive){
            gameState[tappedImage]=activePlayer;
            if(activePlayer==0){
                img.setImageResource(R.drawable.o);
                activePlayer=1;
            }else{ img.setImageResource(R.drawable.x);
            activePlayer=0;}
            count++;
        }
        if(count==9) gameReset();
        for(int[] winPos:winningPositions){
            if(gameState[winPos[0]]==gameState[winPos[1]] &&
                    gameState[winPos[1]]==gameState[winPos[2]]
                    &&gameState[winPos[0]]!=2){
                if(gameState[winPos[0]]==0) Toast.makeText(this,"O Wins The Game",Toast.LENGTH_SHORT).show();
                else Toast.makeText(this,"X Wins The Game",Toast.LENGTH_SHORT).show();
                gameReset();
            }
        }

    }

    private void gameReset() {
        gameActive=true;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }
        count=0;
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}