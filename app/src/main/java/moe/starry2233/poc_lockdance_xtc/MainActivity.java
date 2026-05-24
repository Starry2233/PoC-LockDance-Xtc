package moe.starry2233.poc_lockdance_xtc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(v -> {
            Intent intent = new Intent("com.xtc.dial.ACTION.SCREEN_PASSWORD_SET");
            intent.putExtra("com.xtc.dial.EXTRA.EXTRA_SCREEN_PASSWORD_SET_NEW_PWD", getString(R.string.pwd));
            sendBroadcast(intent);
            Toast.makeText(MainActivity.this, R.string.success, Toast.LENGTH_LONG).show();
        });
        Button btnClear = findViewById(R.id.button_clear);
        btnClear.setOnClickListener(v -> {
            Intent intent = new Intent("com.xtc.dial.ACTION.SCREEN_PASSWORD_RESET");
            intent.putExtra("com.xtc.dial.EXTRA.EXTRA_SCREEN_PASSWORD_SET_OLD_PWD", getString(R.string.pwd));
            sendBroadcast(intent);
            Toast.makeText(MainActivity.this, R.string.success, Toast.LENGTH_LONG).show();
        });
    }
}