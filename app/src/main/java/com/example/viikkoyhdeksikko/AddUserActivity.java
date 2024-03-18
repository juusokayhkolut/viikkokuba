package com.example.viikkoyhdeksikko;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class AddUserActivity extends AppCompatActivity {

    private EditText editFirstName, editLastName, editEmail;
    private RadioGroup radioDegreeProgram;
    private Button addUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editEmail = findViewById(R.id.editEmail);
        radioDegreeProgram = findViewById(R.id.radioDegreeProgram);
        addUserButton = findViewById(R.id.addUserButton);

        addUserButton.setOnClickListener(view -> {
            String firstName = editFirstName.getText().toString();
            String lastName = editLastName.getText().toString();
            String email = editEmail.getText().toString();
            int selectedId = radioDegreeProgram.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(selectedId);
            String degreeProgram = selectedRadioButton.getText().toString();

            User newUser = new User(firstName, lastName, email, degreeProgram);
            UserStorage.getInstance().addUser(newUser);
            finish();
        });
    }
}
