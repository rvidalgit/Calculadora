package br.com.rodrigovidal.projetocalculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraActivity extends AppCompatActivity {

    private TextView Txt_Visor;
    private String AppName;
    private Double num1=0., num2=0., result=0.;
    private String sinal;

    public void onClickGeneric(View v) {
        Log.d(AppName,"onclick" );
        //remove o zero ao começar a calcular
        if (Txt_Visor.getText().toString()=="0"){
            Txt_Visor.setText(null);
        }

        String s = Txt_Visor.getText().toString();
        Button Botao= (Button) v;
        String Value= Botao.getText().toString();
        Log.d(AppName,">>>botao clicado: ".concat(Value));
        Txt_Visor.setText(s.concat(Value));
    }

    public void onClickLimpar(View v) {
        Log.d(AppName,">>>Limpar clicado<<<" );
        Txt_Visor= (TextView) findViewById(R.id.TxtVisor);
        Txt_Visor.setText("0");
        num1=0.; num2=0.; result=0.;
        sinal=null;
    }

    public void onClickSinal(View v){
        String s = Txt_Visor.getText().toString();
        Button Botao= (Button) v;
        sinal = Botao.getText().toString();
        Log.d(AppName,">>>sinal clicado: ".concat(sinal));
        Txt_Visor.setText(s.concat(sinal));
    }

    public void onClickCalcula(View v){
        String s = Txt_Visor.getText().toString();
        if (s!="0"&&s.length()>2){
            try {
                int posicao  = s.indexOf(sinal);
                Log.d(AppName,">>>posicao sinal [" + posicao + "] e sinal igual " + sinal);
                Double num1 = Double.parseDouble(s.substring(0, posicao));
                Log.d(AppName,">>>valor num1 " + num1);
                Double num2 = Double.parseDouble(s.substring(posicao+1, s.length()));
                Log.d(AppName,">>>valor num2 " + num2);

                    if (s.charAt(posicao)=='+'){
                        result = num1+num2;
                        Log.d(AppName,">>>resultado da soma " + result);
                    }else if (s.charAt(posicao)=='-'){
                        result = num1-num2;
                        Log.d(AppName,">>>resultado da subtracao " + result);
                    }else if (s.charAt(posicao)=='X'){
                        result = num1*num2;
                        Log.d(AppName,">>>resultado da multiplicacao " + result);
                    }else if (s.charAt(posicao)=='/'){
                        result = num1/num2;
                        Log.d(AppName,">>>resultado da divisao " + result);
                    }

                Txt_Visor.setText(s.concat("=" + result.toString()));

            }catch (Exception e){
                e.printStackTrace();
                Toast.makeText(CalculadoraActivity.this, "Não foi possível calcular!", Toast.LENGTH_SHORT).show();
            }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora2);
        Txt_Visor= (TextView) findViewById(R.id.TxtVisor);
        Txt_Visor.setText("0");
        AppName=  getResources().getString(R.string.app_name);
        Log.d(AppName,">>>Activity criada<<<" );
 }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(AppName,">>>OnResume chamado<<<" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(AppName,">>>OnDestroy chamado<<<" );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(AppName,">>>OnStart chamado<<<" );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(AppName,">>>OnPause chamado<<<" );
    }
}
