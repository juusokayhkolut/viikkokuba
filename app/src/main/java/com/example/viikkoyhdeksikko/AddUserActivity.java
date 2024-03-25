package com.example.viikkoyhdeksikko;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddUserActivity extends AppCompatActivity {

    private EditText editFirstName, editLastName, editEmail;
    private CheckBox bcCheckBox, msCheckBox, lciCheckBox, phdCheckBox;
    private Button addUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        // Alustetaan komponentit
        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editEmail = findViewById(R.id.editEmail);
        bcCheckBox = findViewById(R.id.bcCheckBox);
        msCheckBox = findViewById(R.id.msCheckBox);
        lciCheckBox = findViewById(R.id.lciCheckBox);
        phdCheckBox = findViewById(R.id.phdCheckBox);
        addUserButton = findViewById(R.id.addUserButton);

        addUserButton.setOnClickListener(view -> {
            String firstName = editFirstName.getText().toString().trim();
            String lastName = editLastName.getText().toString().trim();
            String email = editEmail.getText().toString().trim();

            // Luodaan uusi käyttäjä kerätyillä tiedoilla
            User newUser = new User(firstName, lastName, email, ""); // Oletetaan, että tutkinto-ohjelma ei ole tässä vaiheessa relevantti
            // Lisätään valitut tutkinnot käyttäjän tietoihin
            if (bcCheckBox.isChecked()) newUser.addDegree("B.Sc.");
            if (msCheckBox.isChecked()) newUser.addDegree("M.Sc.");
            if (lciCheckBox.isChecked()) newUser.addDegree("Licenciate");
            if (phdCheckBox.isChecked()) newUser.addDegree("Doctoral degree");

            // Lisätään käyttäjä sovelluksen käyttäjälistalle
            UserStorage.getInstance().addUser(newUser);

            // Palataan edelliseen näkymään
            finish();
        });
    }
}
