package com.example.seccion07.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.seccion07.Fragments.DataFragment;
import com.example.seccion07.Fragments.DetailsFragment;
import com.example.seccion07.R;

public class MainActivity extends AppCompatActivity implements DataFragment.DataListener {

    private boolean isMultiPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void sendData(String text) {
        /* Llmar al metodo renderizarTexto en el DetailsFragment
            pasando el texto que recibamos por parametro en este mismo metodo */

        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.detailsFragment);
        detailsFragment.renderText(text);
    }

    private void setMultiPanel(){
        isMultiPanel = (getSupportFragmentManager().findFragmentById(R.id.detailsFragment) != null);
    }
}
