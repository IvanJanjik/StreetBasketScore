package ivanjanjikj.basketscore;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;



import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    // Team A variables

    public TextView teamAscore;
    public Button teamAplus;
    public Button teamAminus;
    public int scoreA;

    // Reset

    public Button restartButton;

    // Team B variables

    public TextView teamBscore;
    public Button teamBplus;
    public Button teamBminus;
    public int scoreB;

    // Stopwatch variables

    private long seconds = 0L, timeInMilliseconds = 0L, timeSwapBuff = 0L, updateTime = 0L;
    public Button start_button,stop_button;
    public TextView txtTimer;
    Handler customHandler = new Handler();

    Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {

            timeInMilliseconds = SystemClock.uptimeMillis()-seconds;
            updateTime = timeSwapBuff+ timeInMilliseconds;
            int secs = (int) (updateTime/1000);
            int mins = secs/60;
            secs%=60;
            int milliseconds= (int) (updateTime%1000);
            txtTimer.setText(String.format("%02d",mins)+ ":" +String.format("%02d",secs));
            customHandler.postDelayed(this,0);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Seting media player

        // default button sounds
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.swish);
        final MediaPlayer bb = MediaPlayer.create(this, R.raw.back_board);
        final MediaPlayer rh = MediaPlayer.create(this, R.raw.restart_horn);
        // reading score sounds
        final MediaPlayer zero = MediaPlayer.create(this, R.raw.zero);
        final MediaPlayer one = MediaPlayer.create(this, R.raw.one);
        final MediaPlayer two = MediaPlayer.create(this, R.raw.two);
        final MediaPlayer three = MediaPlayer.create(this, R.raw.three);
        final MediaPlayer four = MediaPlayer.create(this, R.raw.four);
        final MediaPlayer five = MediaPlayer.create(this, R.raw.five);
        final MediaPlayer six = MediaPlayer.create(this, R.raw.six);
        final MediaPlayer seven = MediaPlayer.create(this, R.raw.seven);
        final MediaPlayer eight = MediaPlayer.create(this, R.raw.eight);
        final MediaPlayer nine = MediaPlayer.create(this, R.raw.nine);
        final MediaPlayer ten = MediaPlayer.create(this, R.raw.ten);
        final MediaPlayer eleven = MediaPlayer.create(this, R.raw.eleven);
        final MediaPlayer twelve = MediaPlayer.create(this, R.raw.twelve);
        final MediaPlayer thirteen = MediaPlayer.create(this, R.raw.thirteen);
        final MediaPlayer fourteen = MediaPlayer.create(this, R.raw.fourteen);
        final MediaPlayer fiveteen = MediaPlayer.create(this, R.raw.fiveteen);
        final MediaPlayer sixteen = MediaPlayer.create(this, R.raw.sixteen);
        final MediaPlayer seventeen = MediaPlayer.create(this, R.raw.seventeen);
        final MediaPlayer eighteen = MediaPlayer.create(this, R.raw.eighteen);
        final MediaPlayer nineteen = MediaPlayer.create(this, R.raw.nineteen);
        final MediaPlayer twenty = MediaPlayer.create(this, R.raw.twenty);
        final MediaPlayer twenty_one = MediaPlayer.create(this, R.raw.twenty_one);


        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // giving Buttons a methods to do !!!
                switch (view.getId()) {
                    case R.id.teamAminus:
                        if (scoreA != 0) {
                            minusScoreA();
                            bb.start();
                            // adding delay to reading score of teams
                            // for team A
                            new Timer().schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    switch (scoreA) {
                                        case 1:
                                            one.start();
                                            break;
                                        case 2:
                                            two.start();
                                            break;
                                        case 3:
                                            three.start();
                                            break;
                                        case 4:
                                            four.start();
                                            break;
                                        case 5:
                                            five.start();
                                            break;
                                        case 6:
                                            six.start();
                                            break;
                                        case 7:
                                            seven.start();
                                            break;
                                        case 8:
                                            eight.start();
                                            break;
                                        case 9:
                                            nine.start();
                                            break;
                                        case 10:
                                            ten.start();
                                            break;
                                        case 11:
                                            eleven.start();
                                            break;
                                        case 12:
                                            twelve.start();
                                            break;
                                        case 13:
                                            thirteen.start();
                                            break;
                                        case 14:
                                            fourteen.start();
                                            break;
                                        case 15:
                                            fiveteen.start();
                                            break;
                                        case 16:
                                            sixteen.start();
                                            break;
                                        case 17:
                                            seventeen.start();
                                            break;
                                        case 18:
                                            eighteen.start();
                                            break;
                                        case 19:
                                            nineteen.start();
                                            break;
                                        case 20:
                                            twenty.start();
                                            break;
                                        case 21:
                                            twenty_one.start();
                                            break;
                                        default:
                                            // for 0
                                            zero.start();
                                            break;
                                    }
                                }
                            }, 500);

                            // adding delay to reading score of teams
                            // for team B
                            new Timer().schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    switch (scoreB) {
                                        case 1:
                                            one.start();
                                            break;
                                        case 2:
                                            two.start();
                                            break;
                                        case 3:
                                            three.start();
                                            break;
                                        case 4:
                                            four.start();
                                            break;
                                        case 5:
                                            five.start();
                                            break;
                                        case 6:
                                            six.start();
                                            break;
                                        case 7:
                                            seven.start();
                                            break;
                                        case 8:
                                            eight.start();
                                            break;
                                        case 9:
                                            nine.start();
                                            break;
                                        case 10:
                                            ten.start();
                                            break;
                                        case 11:
                                            eleven.start();
                                            break;
                                        case 12:
                                            twelve.start();
                                            break;
                                        case 13:
                                            thirteen.start();
                                            break;
                                        case 14:
                                            fourteen.start();
                                            break;
                                        case 15:
                                            fiveteen.start();
                                            break;
                                        case 16:
                                            sixteen.start();
                                            break;
                                        case 17:
                                            seventeen.start();
                                            break;
                                        case 18:
                                            eighteen.start();
                                            break;
                                        case 19:
                                            nineteen.start();
                                            break;
                                        case 20:
                                            twenty.start();
                                            break;
                                        case 21:
                                            twenty_one.start();
                                            break;
                                        default:
                                            // for 0
                                            zero.start();
                                            break;
                                    }
                                }
                            }, 2000);
                        }
                        break;

                    case R.id.teamAplus:
                        plusScoreA();
                        mp.start();
                        // adding delay to reading score of teams
                        // for team A
                        new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {
                                switch (scoreA) {
                                    case 1:
                                        one.start();
                                        break;
                                    case 2:
                                        two.start();
                                        break;
                                    case 3:
                                        three.start();
                                        break;
                                    case 4:
                                        four.start();
                                        break;
                                    case 5:
                                        five.start();
                                        break;
                                    case 6:
                                        six.start();
                                        break;
                                    case 7:
                                        seven.start();
                                        break;
                                    case 8:
                                        eight.start();
                                        break;
                                    case 9:
                                        nine.start();
                                        break;
                                    case 10:
                                        ten.start();
                                        break;
                                    case 11:
                                        eleven.start();
                                        break;
                                    case 12:
                                        twelve.start();
                                        break;
                                    case 13:
                                        thirteen.start();
                                        break;
                                    case 14:
                                        fourteen.start();
                                        break;
                                    case 15:
                                        fiveteen.start();
                                        break;
                                    case 16:
                                        sixteen.start();
                                        break;
                                    case 17:
                                        seventeen.start();
                                        break;
                                    case 18:
                                        eighteen.start();
                                        break;
                                    case 19:
                                        nineteen.start();
                                        break;
                                    case 20:
                                        twenty.start();
                                        break;
                                    case 21:
                                        twenty_one.start();
                                        break;
                                    default:
                                        // for 0
                                        zero.start();
                                        break;
                                }
                            }
                        }, 1500);

                        // adding delay to reading score of teams
                        // for team B
                        new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {
                                switch (scoreB) {
                                    case 1:
                                        one.start();
                                        break;
                                    case 2:
                                        two.start();
                                        break;
                                    case 3:
                                        three.start();
                                        break;
                                    case 4:
                                        four.start();
                                        break;
                                    case 5:
                                        five.start();
                                        break;
                                    case 6:
                                        six.start();
                                        break;
                                    case 7:
                                        seven.start();
                                        break;
                                    case 8:
                                        eight.start();
                                        break;
                                    case 9:
                                        nine.start();
                                        break;
                                    case 10:
                                        ten.start();
                                        break;
                                    case 11:
                                        eleven.start();
                                        break;
                                    case 12:
                                        twelve.start();
                                        break;
                                    case 13:
                                        thirteen.start();
                                        break;
                                    case 14:
                                        fourteen.start();
                                        break;
                                    case 15:
                                        fiveteen.start();
                                        break;
                                    case 16:
                                        sixteen.start();
                                        break;
                                    case 17:
                                        seventeen.start();
                                        break;
                                    case 18:
                                        eighteen.start();
                                        break;
                                    case 19:
                                        nineteen.start();
                                        break;
                                    case 20:
                                        twenty.start();
                                        break;
                                    case 21:
                                        twenty_one.start();
                                        break;
                                    default:
                                        // for 0
                                        zero.start();
                                        break;
                                }
                            }
                        }, 3000);

                        break;
                    case R.id.teamBminus:
                        if (scoreB != 0) {
                            minusScoreB();
                            bb.start();
                            // adding delay to reading score of teams
                            // for team A
                            new Timer().schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    switch (scoreA) {
                                        case 1:
                                            one.start();
                                            break;
                                        case 2:
                                            two.start();
                                            break;
                                        case 3:
                                            three.start();
                                            break;
                                        case 4:
                                            four.start();
                                            break;
                                        case 5:
                                            five.start();
                                            break;
                                        case 6:
                                            six.start();
                                            break;
                                        case 7:
                                            seven.start();
                                            break;
                                        case 8:
                                            eight.start();
                                            break;
                                        case 9:
                                            nine.start();
                                            break;
                                        case 10:
                                            ten.start();
                                            break;
                                        case 11:
                                            eleven.start();
                                            break;
                                        case 12:
                                            twelve.start();
                                            break;
                                        case 13:
                                            thirteen.start();
                                            break;
                                        case 14:
                                            fourteen.start();
                                            break;
                                        case 15:
                                            fiveteen.start();
                                            break;
                                        case 16:
                                            sixteen.start();
                                            break;
                                        case 17:
                                            seventeen.start();
                                            break;
                                        case 18:
                                            eighteen.start();
                                            break;
                                        case 19:
                                            nineteen.start();
                                            break;
                                        case 20:
                                            twenty.start();
                                            break;
                                        case 21:
                                            twenty_one.start();
                                            break;
                                        default:
                                            // for 0
                                            zero.start();
                                            break;
                                    }
                                }
                            }, 500);

                            // adding delay to reading score of teams
                            // for team B
                            new Timer().schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    switch (scoreB) {
                                        case 1:
                                            one.start();
                                            break;
                                        case 2:
                                            two.start();
                                            break;
                                        case 3:
                                            three.start();
                                            break;
                                        case 4:
                                            four.start();
                                            break;
                                        case 5:
                                            five.start();
                                            break;
                                        case 6:
                                            six.start();
                                            break;
                                        case 7:
                                            seven.start();
                                            break;
                                        case 8:
                                            eight.start();
                                            break;
                                        case 9:
                                            nine.start();
                                            break;
                                        case 10:
                                            ten.start();
                                            break;
                                        case 11:
                                            eleven.start();
                                            break;
                                        case 12:
                                            twelve.start();
                                            break;
                                        case 13:
                                            thirteen.start();
                                            break;
                                        case 14:
                                            fourteen.start();
                                            break;
                                        case 15:
                                            fiveteen.start();
                                            break;
                                        case 16:
                                            sixteen.start();
                                            break;
                                        case 17:
                                            seventeen.start();
                                            break;
                                        case 18:
                                            eighteen.start();
                                            break;
                                        case 19:
                                            nineteen.start();
                                            break;
                                        case 20:
                                            twenty.start();
                                            break;
                                        case 21:
                                            twenty_one.start();
                                            break;
                                        default:
                                            // for 0
                                            zero.start();
                                            break;
                                    }
                                }
                            }, 2000);
                        }
                        break;
                    case R.id.teamBplus:
                        plusScoreB();
                        mp.start();
                        // adding delay to reading score of teams
                        // for team A
                        new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {
                                switch (scoreA) {
                                    case 1:
                                        one.start();
                                        break;
                                    case 2:
                                        two.start();
                                        break;
                                    case 3:
                                        three.start();
                                        break;
                                    case 4:
                                        four.start();
                                        break;
                                    case 5:
                                        five.start();
                                        break;
                                    case 6:
                                        six.start();
                                        break;
                                    case 7:
                                        seven.start();
                                        break;
                                    case 8:
                                        eight.start();
                                        break;
                                    case 9:
                                        nine.start();
                                        break;
                                    case 10:
                                        ten.start();
                                        break;
                                    case 11:
                                        eleven.start();
                                        break;
                                    case 12:
                                        twelve.start();
                                        break;
                                    case 13:
                                        thirteen.start();
                                        break;
                                    case 14:
                                        fourteen.start();
                                        break;
                                    case 15:
                                        fiveteen.start();
                                        break;
                                    case 16:
                                        sixteen.start();
                                        break;
                                    case 17:
                                        seventeen.start();
                                        break;
                                    case 18:
                                        eighteen.start();
                                        break;
                                    case 19:
                                        nineteen.start();
                                        break;
                                    case 20:
                                        twenty.start();
                                        break;
                                    case 21:
                                        twenty_one.start();
                                        break;
                                    default:
                                        // for 0
                                        zero.start();
                                        break;
                                }
                            }
                        }, 1500);

                        // adding delay to reading score of teams
                        // for team B
                        new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {
                                switch (scoreB) {
                                    case 1:
                                        one.start();
                                        break;
                                    case 2:
                                        two.start();
                                        break;
                                    case 3:
                                        three.start();
                                        break;
                                    case 4:
                                        four.start();
                                        break;
                                    case 5:
                                        five.start();
                                        break;
                                    case 6:
                                        six.start();
                                        break;
                                    case 7:
                                        seven.start();
                                        break;
                                    case 8:
                                        eight.start();
                                        break;
                                    case 9:
                                        nine.start();
                                        break;
                                    case 10:
                                        ten.start();
                                        break;
                                    case 11:
                                        eleven.start();
                                        break;
                                    case 12:
                                        twelve.start();
                                        break;
                                    case 13:
                                        thirteen.start();
                                        break;
                                    case 14:
                                        fourteen.start();
                                        break;
                                    case 15:
                                        fiveteen.start();
                                        break;
                                    case 16:
                                        sixteen.start();
                                        break;
                                    case 17:
                                        seventeen.start();
                                        break;
                                    case 18:
                                        eighteen.start();
                                        break;
                                    case 19:
                                        nineteen.start();
                                        break;
                                    case 20:
                                        twenty.start();
                                        break;
                                    case 21:
                                        twenty_one.start();
                                        break;
                                    default:
                                        // for 0
                                        zero.start();
                                        break;
                                }
                            }
                        }, 3000);
                        break;
                }

            }
        };


        // geting references of view method
        // Team A
        teamAscore = (TextView) findViewById(R.id.teamAscore);
        teamAplus = (Button) findViewById(R.id.teamAplus);
        teamAplus.setOnClickListener(clickListener);


        teamAminus = (Button) findViewById(R.id.teamAminus);
        teamAminus.setOnClickListener(clickListener);

        // Reset + Reset Stopwatch
        restartButton = (Button) findViewById(R.id.restartButton);
        restartButton.setOnClickListener(clickListener);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seconds = 0L;
                timeInMilliseconds = 0L;
                timeSwapBuff = 0L;
                updateTime = 0L;
                seconds = SystemClock.uptimeMillis();
                customHandler.postDelayed(updateTimerThread,0);
                initScoreA();
                initScoreB();
                rh.start();

            }
        });

        // Team B
        teamBscore = (TextView) findViewById(R.id.teamBscore);
        teamBplus = (Button) findViewById(R.id.teamBplus);
        teamBplus.setOnClickListener(clickListener);
        teamBminus = (Button) findViewById(R.id.teamBminus);
        teamBminus.setOnClickListener(clickListener);


        // stopwatch

        start_button = (Button) findViewById(R.id.start_button);
        stop_button = (Button) findViewById(R.id.stop_button);
        txtTimer = (TextView) findViewById(R.id.stopwatch);

        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seconds = SystemClock.uptimeMillis();
                customHandler.postDelayed(updateTimerThread,0);

            }
        });

        stop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeSwapBuff+=timeInMilliseconds;
                customHandler.removeCallbacks(updateTimerThread);
            }
        });

        // Start logic :

        initScoreA();
        initScoreB();

    }



    // initial score method for team A
    public synchronized void initScoreA() {
        scoreA = 0;
        teamAscore.setText(scoreA + "");
    }


    // initial score method for team B
    public synchronized void initScoreB() {
        scoreB = 0;
        teamBscore.setText(scoreB + "");
    }

    // Team A increment method
    public synchronized void plusScoreA() {
        if (scoreA < 21) {
            if (scoreA == 20 && scoreB == 20) {
                scoreA = 19;
                scoreB = 19;
                teamAscore.setText(scoreA + "");
                teamBscore.setText(scoreB + "");
            } else {
                scoreA++;
                teamAscore.setText(scoreA + "");
            }
        }
    }

    // Team B increment method
    public synchronized void plusScoreB() {
        if (scoreB < 21) {
            if (scoreA == 20 && scoreB == 20) {
                scoreA = 19;
                scoreB = 19;
                teamAscore.setText(scoreA + "");
                teamBscore.setText(scoreB + "");
            } else {
                scoreB++;
                teamBscore.setText(scoreB + "");
            }
        }
    }

    // Team A decrement method
    public synchronized void minusScoreA() {
        scoreA--;
        teamAscore.setText(scoreA + "");
    }

    // Team B increment method
    public synchronized void minusScoreB() {
        scoreB--;
        teamBscore.setText(scoreB + "");
    }




}


