package com.joaorosa.aulapedrapapeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

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

    }

    public void selectStone(View view) {
        checkWinner("Pedra");
    }


    public void selectScissors(View view) {
        checkWinner("Tesoura");
    }

    public void selectPaper(View view) {
        checkWinner("Papel");
    }


    private String generateChoiceRandomApp() {

        String[] options = {"Pedra", "Papel", "Tesoura"};
        int randomNumber = new Random().nextInt(3);//0 1 2

        ImageView imagemApp = findViewById(R.id.image_App);

        String appChoice = options[randomNumber];

        switch (appChoice) {
            case "Pedra":
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }

        return appChoice;
    }


    private void checkWinner(String userChoice) {
        System.out.println("Item clicado: " + userChoice);
        String appChoice = generateChoiceRandomApp();
        TextView textResult = findViewById(R.id.text_result);


        if (
                (appChoice == "Pedra" && userChoice == "Tesoura") ||
                (appChoice == "Papel" && userChoice == "Pedra") ||
                (appChoice == "Tesoura" && userChoice == "Papel")
        ){
            textResult.setText("Você perdeu :(");
        } else if (
                (userChoice == "Pedra" && appChoice == "Tesoura") ||
                (userChoice == "Papel" && appChoice == "Pedra") ||
                (userChoice == "Tesoura" && appChoice == "Papel")
        ){
            textResult.setText("Você ganhou! :)");
        }
        else{
            textResult.setText("Empatamos ;)");
        }

    }

}