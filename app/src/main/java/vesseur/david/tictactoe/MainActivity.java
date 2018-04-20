package vesseur.david.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    public int a, b, c, d, e, f, g, h, x;

    public int winsX, winsO, draws;



    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new Game();
        a = 2131165220;
        b = 2131165221;
        c = 2131165222;
        d = 2131165223;
        e = 2131165224;
        f = 2131165225;
        g = 2131165226;
        h = 2131165227;
        x = 2131165228;

        winsX = 0;
        winsO = 0;
        draws = 0;
    }
    public void resetClicked(View view){
        resetGame();
        winsX = 0;
        winsO = 0;
        draws = 0;
        ((TextView) findViewById(R.id.winsTextO)).setText("Wins O: " + String.valueOf(winsO));
        ((TextView) findViewById(R.id.winsTextX)).setText("Wins X: " + String.valueOf(winsX));
        ((TextView) findViewById(R.id.drawsText)).setText("Draws: " + String.valueOf(draws));
    }

    public void computerClicked(View view){
        CheckBox checkbox = (CheckBox) view;
        if (checkbox.isChecked()) {

            int[] coord = game.computerMove();

            int row = coord[0];
            int column = coord[1];
            Button button = (Button) findViewById(R.id.button11);
            if (row == 0 && column == 0) {
                button = findViewById(R.id.button11);
            }
            if (row == 1 && column == 0) {
                button = findViewById(R.id.button12);
            }
            if (row == 2 && column == 0) {
                button = findViewById(R.id.button13);
            }
            if (row == 0 && column == 1) {
                button = findViewById(R.id.button21);
            }
            if (row == 1 && column == 1) {
                button = findViewById(R.id.button22);
            }
            if (row == 2 && column == 1) {
                button = findViewById(R.id.button23);
            }
            if (row == 0 && column == 2) {
                button = findViewById(R.id.button31);
            }
            if (row == 1 && column == 2) {
                button = findViewById(R.id.button32);
            }
            if (row == 2 && column == 2) {
                button = findViewById(R.id.button33);
            }


            if (coord[2] == 1) {
                button.setText("X");
            }

            if (coord[2] == 2) {
                button.setText("O");
            }
        }
    }

    public void resetGame(){
        game = new Game();
        game.reset();

        Button button = (Button) findViewById(R.id.button11);
        button.setText("");
        button = findViewById(R.id.button11);
        button.setText("");
        button = findViewById(R.id.button12);
        button.setText("");
        button = findViewById(R.id.button13);
        button.setText("");
        button = findViewById(R.id.button21);
        button.setText("");
        button = findViewById(R.id.button22);
        button.setText("");
        button = findViewById(R.id.button23);
        button.setText("");
        button = findViewById(R.id.button31);
        button.setText("");
        button = findViewById(R.id.button32);
        button.setText("");
        button = findViewById(R.id.button33);
        button.setText("");
    }

    public void tileClicked(View view) {
        int row = 0, column = 0;
        int buttonid = view.getId();
        int tilecount = 0;






        int[] buttons = {a, b, c, d, e, f, g, h, x};
//        Log.d("id", String.valueOf(id));
        for (int i = 0; i < 3; i ++){
            for (int j = 0; j < 3; j++){

                if (buttons[tilecount] == buttonid){

                    row = i;
                    column = j;

                }
                tilecount += 1;
            }
        }


        Tile tile = game.draw(row, column);
        Button button = (Button) findViewById(R.id.button11);
        if (a == buttonid) {
            button = findViewById(R.id.button11);
        }
        if (b == buttonid) {
            button = findViewById(R.id.button12);
        }
        if (c == buttonid) {
            button = findViewById(R.id.button13);
        }
        if (d == buttonid) {
            button = findViewById(R.id.button21);
        }
        if (e == buttonid) {
            button = findViewById(R.id.button22);
        }
        if (f == buttonid) {
            button = findViewById(R.id.button23);
        }
        if (g == buttonid) {
            button = findViewById(R.id.button31);
        }
        if (h == buttonid) {
            button = findViewById(R.id.button32);
        }
        if (x == buttonid) {
            button = findViewById(R.id.button33);
        }



        switch(tile) {
            case CROSS:
                button.setText("X");
                ((TextView)findViewById(R.id.turnText)).setText("Turn: O");
                break;
            case CIRCLE:
                button.setText("O");
                ((TextView)findViewById(R.id.turnText)).setText("Turn: X");
                break;
            case INVALID:
                ((TextView)findViewById(R.id.turnText)).setText("invalid");
                break;
        }

        int win = game.checkWin();
        if (win == 1) {
            ((TextView) findViewById(R.id.turnText)).setText("DRAW");
            draws += 1;
//            ((TextView)findViewById(R.id.tester)).setText("hoi");
            ((TextView) findViewById(R.id.drawsText)).setText("Draws: " + String.valueOf(draws));
        }
        if (win == 2) {
            ((TextView) findViewById(R.id.turnText)).setText("X WINS");
            winsX += 1;
            ((TextView) findViewById(R.id.winsTextX)).setText("Wins X: " + String.valueOf(winsX));
        }
        if (win == 3) {
            ((TextView) findViewById(R.id.turnText)).setText("O WINS");
            winsO += 1;
            ((TextView) findViewById(R.id.winsTextO)).setText("Wins O: " + String.valueOf(winsO));
        }
        if (win != 0){
            resetGame();
        }

//            new Timer().schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    resetGame();
//                    // this code will be executed after 2 seconds
//                }
//            }, 2000);





    }

}
