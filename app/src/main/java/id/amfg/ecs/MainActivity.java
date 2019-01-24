package id.amfg.ecs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String strUser = getIntent().getStringExtra("user");
        Toast.makeText(this, "Welcome " + strUser.toUpperCase(), Toast.LENGTH_SHORT).show();
    }
}
