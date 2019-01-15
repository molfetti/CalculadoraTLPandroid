package com.molfetti.calculadoratlp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoScreen extends AppCompatActivity implements View.OnClickListener{

    private InfoView infoViewHolder = new InfoView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_screen);

        this.infoViewHolder.Voltar = findViewById(R.id.button_voltar);

        this.infoViewHolder.Voltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.button_voltar){

            onBackPressed();
        }

    }

    private static class InfoView{
        Button Voltar;
    }

}

