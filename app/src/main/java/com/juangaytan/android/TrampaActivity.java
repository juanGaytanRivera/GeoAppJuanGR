package com.juangaytan.android;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.juangaytan.android.geoapp.R;


public class TrampaActivity extends AppCompatActivity {
    private static final String EXTRA_RESPUESTA_ES_CORRECTA =
            "com.juangaytan.android.geoapp.respues_es_correcta";
    private boolean mRespuestaEsCierta;
    private TextView mTextoRespuesta;
    private Button mBotonConfirmarTrampa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trampa);

        mTextoRespuesta = (TextView) this.findViewById(R.id.texto_respuesta_trampa);
        mBotonConfirmarTrampa = (Button) this.findViewById(R.id.boton_confirmar_trampa);

        mRespuestaEsCierta = getIntent().getBooleanExtra(EXTRA_RESPUESTA_ES_CORRECTA, false);

        mBotonConfirmarTrampa.setAutoLinkMask(new.View.OnClickListener(){
            @Override
                    public void onClick(View v){
                if(mRespuestaEsCierta) {
                    mTextoRespuesta.setText(R.string.texto_boton_cierto);
                }
                else {
                    mTextoRespuesta.setText(R.string.texto_boton_falso);
                }
            }
        });
    }

    public static Intent newIntent(Context contextoDelPaquete, boolean respuestaEsCierta){
        Intent i = new Intent(contextoDelPaquete, TrampaActivity.class);
        i.putExtra(EXTRA_RESPUESTA_ES_CORRECTA, respuestaEsCierta);
        return i;
    }
}