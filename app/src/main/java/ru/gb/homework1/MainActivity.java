package ru.gb.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    private TextView greetingsTv;
    private EditText nameEt;
    private ViewGroup linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greetingsTv = findViewById(R.id.greetings_text_view);
        nameEt = findViewById(R.id.name_edit_text);
        linearLayout = findViewById(R.id.linear_layout);

        SwitchMaterial martialStatusSw = findViewById(R.id.martial_status_switch);
        CheckBox beginnerLevelCb = findViewById(R.id.level_beginner_check_box);
        CheckBox juniorLevelCb = findViewById(R.id.level_junior_check_box);
        ToggleButton backgroundTb = findViewById(R.id.switch_background_toggle_button);
        Button button = findViewById(R.id.button);
        Button buttonNextActivity = findViewById(R.id.next_activity_button);

        greetingsTv.setText(R.string.Welcome);
        final String[] martialStatus = new String[1];
        final String[] beginnerLevel = new String[1];
        final String[] juniorLevel = new String[1];
        final String[] theme = new String[1];

        beginnerLevel[0] = "unknown";
        juniorLevel[0] = "";
        martialStatus[0] = "complicated,";
        theme[0] = "any";

        martialStatusSw.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                martialStatus[0] = "married";
            } else
                martialStatus[0] = "not married";
        });

        beginnerLevelCb.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                beginnerLevel[0] = "beginner";
            } else
                beginnerLevel[0] = "";
        });

        juniorLevelCb.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                juniorLevel[0] = "junior";
            } else
                juniorLevel[0] = "";
        });

        backgroundTb.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                theme[0] = "dark";
                linearLayout.setBackgroundColor(Color.parseColor("#A5A5A5"));
                greetingsTv.setTextColor(Color.parseColor("#FFFFFF"));
            } else {
                theme[0] = "light";
                linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
                greetingsTv.setTextColor(Color.parseColor("#F45990"));
            }
        });

        button.setOnClickListener(v -> {
            greetingsTv.setText(String.format("My name is %s! I'm %s my android development level is %s %s, i like %s theme!",
                    nameEt.getText(), martialStatus[0], beginnerLevel[0], juniorLevel[0], theme[0]));
            greetingsTv.setTextSize(20);
        });

        buttonNextActivity.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        });

    }
}