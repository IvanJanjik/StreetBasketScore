package ivanjanjikj.basketscore;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    Button startBtn, resultBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        startBtn = (Button) findViewById(R.id.start_button);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivityForResult(intent,0);
            }
        });

        resultBtn = (Button) findViewById(R.id.results_button);
        resultBtn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ResultsActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}

