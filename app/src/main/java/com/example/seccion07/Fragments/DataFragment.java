package com.example.seccion07.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.seccion07.R;

public class DataFragment extends Fragment {

    private EditText textData;
    private Button btnSend;
    private DataListener callback;

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback = (DataListener) context;
        }catch (Exception e){

            throw new ClassCastException(context.toString() + "should implement DataListener");
            // Para mandar error al log
           // Log.i(e.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_data, container, false);
        //Logica para capturar los elementos de la UI

        textData =  view.findViewById(R.id.editTextData);
        btnSend =  view.findViewById(R.id.buttonSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToSend = textData.getText().toString();
                callback.sendData(textToSend);
            }
        });

        return view;
    }

    /*private void sendText(String text){


    }*/

    public interface DataListener{
        void sendData(String text);
    }
}
