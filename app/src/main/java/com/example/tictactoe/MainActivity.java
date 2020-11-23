package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int active =0;
    int gamestate[]={2,2,2,2,2,2,2,2,2};
    int win[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameactive=true;
    public void drop(View view)
    {
        ImageView stone=(ImageView)view;
        int tap=Integer.parseInt(stone.getTag().toString());
        if(gamestate[tap]==2&& gameactive==true) {
            gamestate[tap] = active;
            stone.setTranslationY(-1500);

            if (active == 0) {
                stone.setImageResource(R.drawable.redst);
                active = 1;
            } else {
                stone.setImageResource(R.drawable.stone1);
                active = 0;
            }

            for (int[] w : win) {
                if (gamestate[w[0]] == gamestate[w[1]] && gamestate[w[2]] == gamestate[w[1]] && gamestate[w[0]] != 2) {
                    gameactive=false;
                    String winner = "";
                    if (active == 0)
                        winner = "Mind Stone(Yellow) WON!!";
                    else
                        winner = "Soul Stone(Red) WON!!";
                    Button b=(Button)findViewById(R.id.button);
                    TextView text=(TextView)findViewById(R.id.winnerid);

                    text.setText(winner);
                    b.setVisibility(view.VISIBLE);
                    text.setVisibility(view.VISIBLE);
                }
                else
                {
                    int i;
                    for( i=0;i<9;i++)
                    {
                        if(gamestate[i]!=2)
                        {
                            continue;
                        }
                        else
                        {
                            break;
                        }
                    }
                    if(i==9)
                    {
                        Button b=(Button)findViewById(R.id.button);
                        TextView text=(TextView)findViewById(R.id.winnerid);

                        text.setText("DRAW");
                        b.setVisibility(view.VISIBLE);
                        text.setVisibility(view.VISIBLE);
                    }


                }
                stone.animate().translationYBy(1500).rotation(7200).setDuration(300);
            }
        }
    }
    public void click(View view)
    {
        Button b=(Button)findViewById(R.id.button);
        TextView text=(TextView)findViewById(R.id.winnerid);
        b.setVisibility(view.INVISIBLE);
        text.setVisibility(view.INVISIBLE);
        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridlayout);

        for (int i = 0; i< gridLayout.getChildCount(); i++)
        {
            ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);
        }
        active =0;
        for(int i=0;i<9;i++)
            gamestate[i] = 2;

        gameactive=true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}