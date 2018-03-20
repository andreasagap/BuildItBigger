package andreas.androidlibraryjoke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {
    public final static String Tag = "joke";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        String joke = getIntent().getStringExtra(Tag);
        TextView textViewJoke = (TextView) findViewById(R.id.textview_joke);
        if(joke!=null){
            textViewJoke.setText(joke);
        }
        else {
            textViewJoke.setText(R.string.error);
        }

    }
}
