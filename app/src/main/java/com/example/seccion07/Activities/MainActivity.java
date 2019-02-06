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

        setMultiPanel();
    }

    @Override
    public void sendData(String text) {
        /* Llmar al metodo renderizarTexto en el DetailsFragment
            pasando el texto que recibamos por parametro en este mismo metodo */

        if (isMultiPanel){
            DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
            detailsFragment.renderText(text);
        }else {
            Intent intent = new Intent(this, DetailsActivity.class);
            // Envia string a la nueva activity
            intent.putExtra("text", text);
            startActivity(intent);
        }
    }

    private void setMultiPanel(){
        isMultiPanel = (getSupportFragmentManager().findFragmentById(R.id.detailsFragment) != null);
    }
}
