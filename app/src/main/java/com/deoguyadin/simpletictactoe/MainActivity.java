package com.deoguyadin.simpletictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonReset, buttonClear, gameBoard[][];

    TextView xScoreView, oScoreView;

    boolean playerIsX;

    int xScore, oScore;

    int turns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gameBoard = new Button[3][3];
        gameBoard[1][1] = (Button) findViewById(R.id.button11);
        gameBoard[0][1] = (Button) findViewById(R.id.button01);
        gameBoard[2][1] = (Button) findViewById(R.id.button21);
        gameBoard[1][2] = (Button) findViewById(R.id.button12);
        gameBoard[1][0] = (Button) findViewById(R.id.button10);
        gameBoard[0][2] = (Button) findViewById(R.id.button02);
        gameBoard[0][0] = (Button) findViewById(R.id.button00);
        gameBoard[2][2] = (Button) findViewById(R.id.button22);
        gameBoard[2][0] = (Button) findViewById(R.id.button20);

        buttonReset = (Button) findViewById(R.id.buttonReset);
        buttonClear = (Button) findViewById(R.id.buttonClear);

        xScoreView = (TextView) findViewById(R.id.xScoreNum);
        oScoreView = (TextView) findViewById(R.id.oScoreNum);

        xScoreView.setText(String.valueOf(xScore = 0));
        oScoreView.setText(String.valueOf(oScore = 0));

        playerIsX = true;

        turns = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int loopI = i;
                final int loopJ = j;
                gameBoard[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gameBoard[loopI][loopJ].setText(playerChar());
                        gameBoard[loopI][loopJ].setEnabled(false);
                        checkForWinner("X");
                        checkForWinner("O");
                        if (++turns == 9) {
                            checkForDraw();
                        }
                    }
                });
            }
        }

        /* Reset Board */
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerIsX = true;
                turns = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        gameBoard[i][j].setText("");
                        gameBoard[i][j].setEnabled(true);
                        gameBoard[i][j].setBackgroundColor(Color.WHITE);  //0xffffffff
                    }
                }
            }
        });

        /* Clear Score */
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xScoreView.setText(String.valueOf(xScore = 0));
                oScoreView.setText(String.valueOf(oScore = 0));
            }
        });
    }

    private void checkForWinner(String player) {
        if ((gameBoard[0][0].getText().equals(player) && gameBoard[0][1].getText().equals(player) && gameBoard[0][2].getText().equals(player))
                || (gameBoard[1][0].getText().equals(player) && gameBoard[1][1].getText().equals(player) && gameBoard[1][2].getText().equals(player))
                || (gameBoard[2][0].getText().equals(player) && gameBoard[2][1].getText().equals(player) && gameBoard[2][2].getText().equals(player))
                || (gameBoard[0][0].getText().equals(player) && gameBoard[1][0].getText().equals(player) && gameBoard[2][0].getText().equals(player))
                || (gameBoard[0][1].getText().equals(player) && gameBoard[1][1].getText().equals(player) && gameBoard[2][1].getText().equals(player))
                || (gameBoard[0][2].getText().equals(player) && gameBoard[1][2].getText().equals(player) && gameBoard[2][2].getText().equals(player))
                || (gameBoard[0][0].getText().equals(player) && gameBoard[1][1].getText().equals(player) && gameBoard[2][2].getText().equals(player))
                || (gameBoard[0][2].getText().equals(player) && gameBoard[1][1].getText().equals(player) && gameBoard[2][0].getText().equals(player))) {

            turns = 0;

            if (player.equals("X")) {
                xScoreView.setText(String.valueOf(++xScore));
            } else if (player.equals("O")) {
                oScoreView.setText(String.valueOf(++oScore));
            }

            if (gameBoard[0][0].getText().equals(player) && gameBoard[0][1].getText().equals(player) && gameBoard[0][2].getText().equals(player)) {
                gameBoard[0][0].setBackgroundColor(Color.GREEN);
                gameBoard[0][1].setBackgroundColor(Color.GREEN);
                gameBoard[0][2].setBackgroundColor(Color.GREEN);
            } else if (gameBoard[1][0].getText().equals(player) && gameBoard[1][1].getText().equals(player) && gameBoard[1][2].getText().equals(player)) {
                gameBoard[1][0].setBackgroundColor(Color.GREEN);
                gameBoard[1][1].setBackgroundColor(Color.GREEN);
                gameBoard[1][2].setBackgroundColor(Color.GREEN);
            } else if (gameBoard[2][0].getText().equals(player) && gameBoard[2][1].getText().equals(player) && gameBoard[2][2].getText().equals(player)) {
                gameBoard[2][0].setBackgroundColor(Color.GREEN);
                gameBoard[2][1].setBackgroundColor(Color.GREEN);
                gameBoard[2][2].setBackgroundColor(Color.GREEN);
            } else if (gameBoard[0][0].getText().equals(player) && gameBoard[1][0].getText().equals(player) && gameBoard[2][0].getText().equals(player)) {
                gameBoard[0][0].setBackgroundColor(Color.GREEN);
                gameBoard[1][0].setBackgroundColor(Color.GREEN);
                gameBoard[2][0].setBackgroundColor(Color.GREEN);
            } else if (gameBoard[0][1].getText().equals(player) && gameBoard[1][1].getText().equals(player) && gameBoard[2][1].getText().equals(player)) {
                gameBoard[0][1].setBackgroundColor(Color.GREEN);
                gameBoard[1][1].setBackgroundColor(Color.GREEN);
                gameBoard[2][1].setBackgroundColor(Color.GREEN);
            } else if (gameBoard[0][2].getText().equals(player) && gameBoard[1][2].getText().equals(player) && gameBoard[2][2].getText().equals(player)) {
                gameBoard[0][2].setBackgroundColor(Color.GREEN);
                gameBoard[1][2].setBackgroundColor(Color.GREEN);
                gameBoard[2][2].setBackgroundColor(Color.GREEN);
            } else if (gameBoard[0][0].getText().equals(player) && gameBoard[1][1].getText().equals(player) && gameBoard[2][2].getText().equals(player)) {
                gameBoard[0][0].setBackgroundColor(Color.GREEN);
                gameBoard[1][1].setBackgroundColor(Color.GREEN);
                gameBoard[2][2].setBackgroundColor(Color.GREEN);
            } else if (gameBoard[0][2].getText().equals(player) && gameBoard[1][1].getText().equals(player) && gameBoard[2][0].getText().equals(player)) {
                gameBoard[0][2].setBackgroundColor(Color.GREEN);
                gameBoard[1][1].setBackgroundColor(Color.GREEN);
                gameBoard[2][0].setBackgroundColor(Color.GREEN);
            }

            lockBoard();
        }
    }

    private void checkForDraw() {
        if (!(gameBoard[0][0].getText().equals("") || gameBoard[0][1].getText().equals("") || gameBoard[0][2].getText().equals("")
                || gameBoard[1][0].getText().equals("") || gameBoard[1][1].getText().equals("") || gameBoard[1][2].getText().equals("")
                || gameBoard[2][0].getText().equals("") || gameBoard[2][1].getText().equals("") || gameBoard[2][2].getText().equals(""))) {

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    gameBoard[i][j].setBackgroundColor(Color.RED);
                }
            }
        }
    }

    private void lockBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j].setEnabled(false);
            }
        }
    }

    private String playerChar() {
        if (playerIsX) {
            playerIsX = false;
            return "X";
        } else{
            playerIsX = true;
            return "O";
        }
    }
}