package com.example.viikkoyhdeksikko;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListUserInTextViewActivity extends AppCompatActivity {

    private TextView textViewSavedUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user_in_text_view);

        textViewSavedUsers = findViewById(R.id.textViewSavedUsers);

        StringBuilder sb = new StringBuilder();
        for (User user : UserStorage.getInstance().getUsers()) {
            sb.append(user.getFirstName()).append(" ")
                    .append(user.getLastName()).append("\n")
                    .append(user.getEmail()).append("\n")
                    .append(user.getDegreeProgram()).append("\n\n");
        }

        textViewSavedUsers.setText(sb.toString());
    }
}
