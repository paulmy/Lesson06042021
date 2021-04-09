package ru.samsung.lesson06042021;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText[] ipedit, maskedit, lanedit;
    Button ipcalc;
    int[] tempip, tempmask, templan;
    TextView tvlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ipcalc = findViewById(R.id.ipcalc);
        ipcalc.setOnClickListener(this);
        tvlan = findViewById(R.id.tvlan);

        tempip = new int[4];
        tempmask = new int[4];
        templan = new int[4];

        ipedit = new EditText[4];
        maskedit = new EditText[4];
        lanedit = new EditText[4];

        ipedit[0] = findViewById(R.id.ip0);
        ipedit[1] = findViewById(R.id.ip1);
        ipedit[2] = findViewById(R.id.ip2);
        ipedit[3] = findViewById(R.id.ip3);
        maskedit[0] = findViewById(R.id.mask0);
        maskedit[1] = findViewById(R.id.mask1);
        maskedit[2] = findViewById(R.id.mask2);
        maskedit[3] = findViewById(R.id.mask3);
        lanedit[0] = findViewById(R.id.lan0);
        lanedit[1] = findViewById(R.id.lan1);
        lanedit[2] = findViewById(R.id.lan2);
        lanedit[3] = findViewById(R.id.lan3);

    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < tempip.length; i++) {
            try {
                for (int j = 0; j < ipedit.length; j++) {
                    if (ipedit[i].getText().equals("")) {
                        Toast.makeText(getApplicationContext(), "Ошибка ввода", Toast.LENGTH_LONG).show();
                    }
                }
                if (Integer.parseInt(ipedit[i].getText().toString()) > 255 || Integer.parseInt(ipedit[i].getText().toString()) < 0) {
                    Toast.makeText(getApplicationContext(), "Ошибка ввода", Toast.LENGTH_LONG).show();
                } else
                    tempip[i] = Integer.parseInt(ipedit[i].getText().toString());
            } catch (Exception e) {

            }

        }
        for (int i = 0; i < tempmask.length; i++) {
            try {
                for (int j = 0; j < maskedit.length; j++) {
                    if (maskedit[i].getText().equals("")) {
                        Toast.makeText(getApplicationContext(), "Ошибка ввода", Toast.LENGTH_LONG).show();
                    }
                }
                if (Integer.parseInt(maskedit[i].getText().toString()) > 255 || Integer.parseInt(maskedit[i].getText().toString()) < 0) {
                    Toast.makeText(getApplicationContext(), "Ошибка ввода", Toast.LENGTH_LONG).show();
                    maskedit[i].setText("255");
                } else
                    tempmask[i] = Integer.parseInt(maskedit[i].getText().toString());
            } catch (Exception e) {
            }
        }

       /* for (int i = 0; i < lanedit.length; i++) {
            lanedit[i].setText("" + (tempip[i] & tempmask[i]));
        }*/
        for (int i = 0; i < lanedit.length; i++) {
            templan[i] = tempip[i] & tempmask[i];

            lanedit[i].setText("" + (templan[i] ^ tempip[i]));
            tvlan.append(templan[i] + ".");
        }

        //Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
    }
}