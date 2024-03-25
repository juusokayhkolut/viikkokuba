package com.example.viikkoyhdeksikko;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    // Luodaan uusi näkymä (kutsutaan layout managerin toimesta)
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        return new UserViewHolder(itemView);
    }

    // Korvaa näkymän sisältö (kutsutaan layout managerin toimesta)
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.textFirstName.setText(user.getFirstName());
        holder.textLastName.setText(user.getLastName());
        holder.textEmail.setText(user.getEmail());
        holder.textDegreeProgram.setText(user.getDegreeProgram());
        String degreesText = String.join(", ", user.getDegrees());
        holder.textUserDegrees.setText(degreesText);
    }

    // Palauttaa kokonaisdatan määrän (kutsutaan layout managerin toimesta)
    @Override
    public int getItemCount() {
        return userList.size();
    }

    // Tarjoaa viitteen yksittäisiin näkymiin (custom view holder)
    public static class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView textFirstName, textLastName, textEmail, textDegreeProgram, textUserDegrees;

        public UserViewHolder(View view) {
            super(view);
            textFirstName = view.findViewById(R.id.textFirstName);
            textLastName = view.findViewById(R.id.textLastName);
            textEmail = view.findViewById(R.id.textEmail);
            textDegreeProgram = view.findViewById(R.id.textDegreeProgram);
            textUserDegrees = view.findViewById(R.id.textUserDegrees);
        }
    }
}

