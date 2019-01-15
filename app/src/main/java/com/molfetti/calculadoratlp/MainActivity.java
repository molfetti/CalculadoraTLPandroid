package com.molfetti.calculadoratlp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();
    private static final String ARQUIVO_SAVED = "ArquivoSalvo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editCDC = findViewById(R.id.edit_CDC);
        this.mViewHolder.editSpread = findViewById(R.id.edit_BNDES);
        this.mViewHolder.editTLP = findViewById(R.id.edit_TLP);
        this.mViewHolder.edit777 = findViewById(R.id.edit_777);
        this.mViewHolder.editIPCA = findViewById(R.id.edit_IPCA);
        this.mViewHolder.textJuros = findViewById(R.id.text_Juros);
        this.mViewHolder.textFixo = findViewById(R.id.text_Fixo);
        this.mViewHolder.textVariavel = findViewById(R.id.text_Variavel);
        this.mViewHolder.Juros = findViewById(R.id.button_Juros);
        this.mViewHolder.Decomp = findViewById(R.id.button_Decomp);
        this.mViewHolder.Reset = findViewById(R.id.button_Reset);
        this.mViewHolder.Info = findViewById(R.id.button_Info);
        this.mViewHolder.textJurosAM = findViewById(R.id.text_JurosAM);
        this.mViewHolder.textIpcaAM = findViewById(R.id.text_ipcaAM);
        this.mViewHolder.textFixoAM = findViewById(R.id.text_FixoAM);
        this.mViewHolder.textTLP = findViewById((R.id.text_TLP));
        this.mViewHolder.text777 = findViewById(R.id.text_777);

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_SAVED, 0);
        if (sharedPreferences.contains("juros")){
            String sJuros = sharedPreferences.getString("juros", "0.0000");
            this.mViewHolder.textJuros.setText(sJuros);
        }
        if (sharedPreferences.contains("fixo")){
            String sFixo = sharedPreferences.getString("fixo", "0.0000");
            this.mViewHolder.textFixo.setText(sFixo);
        }
        if (sharedPreferences.contains("variavel")){
            String sVariavel = sharedPreferences.getString("variavel", "0.0000");
            this.mViewHolder.textVariavel.setText(sVariavel);
        }
        if (sharedPreferences.contains("jurosAM")){
            String sJurosAM = sharedPreferences.getString("jurosAM", "0.00");
            this.mViewHolder.textJurosAM.setText(sJurosAM);
        }
        if (sharedPreferences.contains("variavelAM")){
            String sVariavelAM = sharedPreferences.getString("variavelAM", "0.00");
            this.mViewHolder.textIpcaAM.setText(sVariavelAM);
        }
        if (sharedPreferences.contains("fixoAM")){
            String sFixoAM = sharedPreferences.getString("fixoAM", "0.00");
            this.mViewHolder.textFixoAM.setText(sFixoAM);
        }
        if (sharedPreferences.contains("taxapre")){
            String sTaxaPre = sharedPreferences.getString("taxapre", "");
            this.mViewHolder.text777.setText(sTaxaPre);
        }
        if (sharedPreferences.contains("textTlp")){
            String sTextTlp = sharedPreferences.getString("textTlp", "");
            this.mViewHolder.textTLP.setText(sTextTlp);
        }
        if (sharedPreferences.contains("cdc")){
            String sCDC = sharedPreferences.getString("cdc", "");
            this.mViewHolder.editCDC.setText(sCDC);
        }
        if (sharedPreferences.contains("spread")){
            String sSpread = sharedPreferences.getString("spread", "");
            this.mViewHolder.editSpread.setText(sSpread);
        }
        if (sharedPreferences.contains("777")){
            String s777 = sharedPreferences.getString("777", "");
            this.mViewHolder.edit777.setText(s777);
        }
        if (sharedPreferences.contains("ipca")){
            String sIPCA = sharedPreferences.getString("ipca", "");
            this.mViewHolder.editIPCA.setText(sIPCA);
        }
        if (sharedPreferences.contains("tlp")){
            String sTLP = sharedPreferences.getString("tlp", "");
            this.mViewHolder.editTLP.setText(sTLP);
        }

        this.mViewHolder.Juros.setOnClickListener(this);
        this.mViewHolder.Decomp.setOnClickListener(this);
        this.mViewHolder.Reset.setOnClickListener(this);
        this.mViewHolder.Info.setOnClickListener(this);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_SAVED, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("cdc", mViewHolder.editCDC.getText().toString());
        editor.putString("spread", mViewHolder.editSpread.getText().toString());
        editor.putString("777", mViewHolder.edit777.getText().toString());
        editor.putString("taxapre", mViewHolder.text777.getText().toString());
        editor.putString("ipca", mViewHolder.editIPCA.getText().toString());
        editor.putString("juros", mViewHolder.textJuros.getText().toString());
        editor.putString("jurosAM", mViewHolder.textJurosAM.getText().toString());
        editor.putString("tlp", mViewHolder.editTLP.getText().toString());
        editor.putString("textTlp", mViewHolder.textTLP.getText().toString());
        editor.putString("fixo", mViewHolder.textFixo.getText().toString());
        editor.putString("fixoAM", mViewHolder.textFixoAM.getText().toString());
        editor.putString("variavel", mViewHolder.textVariavel.getText().toString());
        editor.putString("variavelAM", mViewHolder.textIpcaAM.getText().toString());
        editor.commit();
    }



    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.button_Juros){

                String txtEditCDC = mViewHolder.editCDC.getText().toString();
                String txtEditSpread = mViewHolder.editSpread.getText().toString();
                String txtEdit777 = mViewHolder.edit777.getText().toString();
                String txtEditIPCA = mViewHolder.editIPCA.getText().toString();
                String txtEditTLP = mViewHolder.editTLP.getText().toString();

                float cdc;
                if (txtEditCDC.matches("")){
                    cdc = 0;
                } else{
                    cdc = Float.valueOf(this.mViewHolder.editCDC.getText().toString());
                }

                float spread;
                if (txtEditSpread.matches("")){
                    spread = 0;
                } else{
                    spread = Float.valueOf(this.mViewHolder.editSpread.getText().toString());
                }

                float taxapre;
                if (txtEdit777.matches("")){
                    taxapre = 0;
                } else{
                    taxapre = Float.valueOf(this.mViewHolder.edit777.getText().toString());
                }

                float ipca;
                if (txtEditIPCA.matches("")){
                    ipca = 0;
                } else{
                    ipca = Float.valueOf(this.mViewHolder.editIPCA.getText().toString());
                }

                float tlp;
                if (txtEditTLP.matches("")){
                    tlp = 0;
                } else{
                    tlp = Float.valueOf(this.mViewHolder.editTLP.getText().toString());
                }

            if (tlp == 0){
                float juros = (((cdc/100+1)*(spread/100+1)*(ipca/100+1)*(taxapre/100+1))-1)*100;
                this.mViewHolder.textJuros.setText(String.format(Locale.getDefault(),"%.4f", juros));
                this.mViewHolder.textJurosAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((juros/100+1),(0.0833333333)))-1)*100));
                tlp = (((ipca/100+1)*(taxapre/100+1))-1)*100;
                this.mViewHolder.textTLP.setText(String.format(Locale.getDefault(), "%.4f", tlp) + "% a.a.");
                float fixo = (((cdc/100+1)*(spread/100+1)*(taxapre/100+1))-1)*100;
                this.mViewHolder.textFixo.setText(String.format(Locale.getDefault(),"%.4f", fixo));
                this.mViewHolder.textFixoAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((fixo/100+1),(0.0833333333)))-1)*100));
                this.mViewHolder.textVariavel.setText(String.format(Locale.getDefault(),"%.4f", ipca));
                this.mViewHolder.textIpcaAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((ipca/100+1),(0.0833333333)))-1)*100));
            }else{
                float juros = (((cdc/100+1)*(spread/100+1)*(tlp/100+1))-1)*100;
                this.mViewHolder.textJuros.setText(String.format(Locale.getDefault(),"%.4f", juros));
                this.mViewHolder.textJurosAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((juros/100+1),(0.0833333333)))-1)*100));
            }
        }

        else if(id == R.id.button_Decomp){

            String txtEditCDC = mViewHolder.editCDC.getText().toString();
            String txtEditSpread = mViewHolder.editSpread.getText().toString();
            String txtEdit777 = mViewHolder.edit777.getText().toString();
            String txtEditIPCA = mViewHolder.editIPCA.getText().toString();
            String txtEditTLP = mViewHolder.editTLP.getText().toString();

            float cdc;
            if (txtEditCDC.matches("")){
                cdc = 0;
            } else{
                cdc = Float.valueOf(this.mViewHolder.editCDC.getText().toString());
            }

            float spread;
            if (txtEditSpread.matches("")){
                spread = 0;
            } else{
                spread = Float.valueOf(this.mViewHolder.editSpread.getText().toString());
            }

            float taxapre;
            if (txtEdit777.matches("")){
                taxapre = 0;
            } else{
                taxapre = Float.valueOf(this.mViewHolder.edit777.getText().toString());
            }

            float ipca;
            if (txtEditIPCA.matches("")){
                ipca = 0;
            } else{
                ipca = Float.valueOf(this.mViewHolder.editIPCA.getText().toString());
            }

            float tlp;
            if (txtEditTLP.matches("")){
                tlp = 0;
            } else{
                tlp = Float.valueOf(this.mViewHolder.editTLP.getText().toString());
            }

            if (tlp == 0){
                if (ipca == 0 && taxapre != 0){
                    this.mViewHolder.text777.setText(String.format(Locale.getDefault(),"%.4f", taxapre) + "% a.a.");
                    float fixo = (((cdc/100+1)*(spread/100+1)*(taxapre/100+1))-1)*100;
                    this.mViewHolder.textFixo.setText(String.format(Locale.getDefault(),"%.4f", fixo));
                    this.mViewHolder.textFixoAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((fixo/100+1),(0.0833333333)))-1)*100));
                    tlp = taxapre;
                    this.mViewHolder.textTLP.setText(String.format(Locale.getDefault(), "%.4f", tlp) + "% a.a.");
                    float juros = fixo;
                    this.mViewHolder.textJuros.setText(String.format(Locale.getDefault(),"%.4f", juros));
                    this.mViewHolder.textJurosAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((juros/100+1),(0.0833333333)))-1)*100));
                    this.mViewHolder.textVariavel.setText("0.0000");
                    this.mViewHolder.textIpcaAM.setText("0.00");
                } else if (taxapre == 0 && ipca != 0){
                    this.mViewHolder.textVariavel.setText(String.format(Locale.getDefault(),"%.4f", ipca));
                    this.mViewHolder.textIpcaAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((ipca/100+1),(0.0833333333)))-1)*100));
                    this.mViewHolder.text777.setText("0.0000% a.a.");
                    float fixo = (((cdc/100+1)*(spread/100+1))-1)*100;
                    this.mViewHolder.textFixo.setText(String.format(Locale.getDefault(),"%.4f", fixo));
                    this.mViewHolder.textFixoAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((fixo/100+1),(0.0833333333)))-1)*100));
                    tlp = ipca;
                    this.mViewHolder.textTLP.setText(String.format(Locale.getDefault(), "%.4f", tlp) + "% a.a.");
                    float juros = (((cdc/100+1)*(spread/100+1)*(ipca/100+1))-1)*100;
                    this.mViewHolder.textJuros.setText(String.format(Locale.getDefault(),"%.4f", juros));
                    this.mViewHolder.textJurosAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((juros/100+1),(0.0833333333)))-1)*100));
                } else if(ipca == 0 && taxapre == 0){
                    this.mViewHolder.textTLP.setText("0.0000% a.a.");
                    this.mViewHolder.text777.setText("0.0000% a.a.");
                    this.mViewHolder.textVariavel.setText("0.0000");
                    this.mViewHolder.textIpcaAM.setText("0.00");
                    float fixo = (((cdc/100+1)*(spread/100+1))-1)*100;
                    this.mViewHolder.textFixo.setText(String.format(Locale.getDefault(),"%.4f", fixo));
                    this.mViewHolder.textFixoAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((fixo/100+1),(0.0833333333)))-1)*100));
                    float juros = fixo;
                    this.mViewHolder.textJuros.setText(String.format(Locale.getDefault(),"%.4f", juros));
                    this.mViewHolder.textJurosAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((juros/100+1),(0.0833333333)))-1)*100));
                } else{
                    this.mViewHolder.textVariavel.setText(String.format(Locale.getDefault(),"%.4f", ipca));
                    this.mViewHolder.textIpcaAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((ipca/100+1),(0.0833333333)))-1)*100));
                    this.mViewHolder.text777.setText(String.format(Locale.getDefault(),"%.4f", taxapre) + "% a.a.");
                    float fixo = (((cdc/100+1)*(spread/100+1)*(taxapre/100+1))-1)*100;
                    this.mViewHolder.textFixo.setText(String.format(Locale.getDefault(),"%.4f", fixo));
                    this.mViewHolder.textFixoAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((fixo/100+1),(0.0833333333)))-1)*100));
                    tlp = (((ipca/100+1)*(taxapre/100+1))-1)*100;
                    this.mViewHolder.textTLP.setText(String.format(Locale.getDefault(), "%.4f", tlp) + "% a.a.");
                    float juros = (((cdc/100+1)*(spread/100+1)*(tlp/100+1))-1)*100;
                    this.mViewHolder.textJuros.setText(String.format(Locale.getDefault(),"%.4f", juros));
                    this.mViewHolder.textJurosAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((juros/100+1),(0.0833333333)))-1)*100));
                }

            } else {
                if (ipca == 0 && taxapre != 0){
                    ipca = (((tlp/100+1)/(taxapre/100+1))-1)*100;
                    this.mViewHolder.textVariavel.setText(String.format(Locale.getDefault(),"%.4f", ipca));
                    this.mViewHolder.textIpcaAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((ipca/100+1),(0.0833333333)))-1)*100));
                    float fixo = (((cdc/100+1)*(spread/100+1)*(taxapre/100+1))-1)*100;
                    this.mViewHolder.textFixo.setText(String.format(Locale.getDefault(),"%.4f", fixo));
                    this.mViewHolder.textFixoAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((fixo/100+1),(0.0833333333)))-1)*100));
                    float juros = (((cdc/100+1)*(spread/100+1)*(tlp/100+1))-1)*100;
                    this.mViewHolder.textJuros.setText(String.format(Locale.getDefault(),"%.4f", juros));
                    this.mViewHolder.textJurosAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((juros/100+1),(0.0833333333)))-1)*100));
                    this.mViewHolder.textTLP.setText(String.format(Locale.getDefault(), "%.4f", tlp) + "% a.a.");
                    this.mViewHolder.text777.setText(String.format(Locale.getDefault(),"%.4f", taxapre) + "% a.a.");
                }else if (taxapre == 0 && ipca != 0){
                    taxapre = (((tlp/100+1)/(ipca/100+1))-1)*100;
                    this.mViewHolder.text777.setText(String.format(Locale.getDefault(),"%.4f", taxapre) + "% a.a.");
                    float fixo = (((cdc/100+1)*(spread/100+1)*(taxapre/100+1))-1)*100;
                    this.mViewHolder.textFixo.setText(String.format(Locale.getDefault(),"%.4f", fixo));
                    this.mViewHolder.textFixoAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((fixo/100+1),(0.0833333333)))-1)*100));
                    float juros = (((cdc/100+1)*(spread/100+1)*(tlp/100+1))-1)*100;
                    this.mViewHolder.textJuros.setText(String.format(Locale.getDefault(),"%.4f", juros));
                    this.mViewHolder.textJurosAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((juros/100+1),(0.0833333333)))-1)*100));
                    this.mViewHolder.textTLP.setText(String.format(Locale.getDefault(), "%.4f", tlp) + "% a.a.");
                    this.mViewHolder.textVariavel.setText(String.format(Locale.getDefault(),"%.4f", ipca));
                    this.mViewHolder.textIpcaAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((ipca/100+1),(0.0833333333)))-1)*100));
                }else if (taxapre == 0 && ipca == 0){
                    this.mViewHolder.textTLP.setText(String.format(Locale.getDefault(), "%.4f", tlp) + "% a.a.");
                    this.mViewHolder.text777.setText("0.0000% a.a.");
                    this.mViewHolder.textVariavel.setText("0.0000");
                    this.mViewHolder.textIpcaAM.setText("0.00");
                    this.mViewHolder.textFixo.setText("INDEF.");
                    this.mViewHolder.textFixoAM.setText("0.00");
                    float juros = (((cdc/100+1)*(spread/100+1)*(tlp/100+1))-1)*100;
                    this.mViewHolder.textJuros.setText(String.format(Locale.getDefault(),"%.4f", juros));
                    this.mViewHolder.textJurosAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((juros/100+1),(0.0833333333)))-1)*100));
                }else{
                    this.mViewHolder.textTLP.setText(String.format(Locale.getDefault(), "%.4f", tlp) + "% a.a.");
                    this.mViewHolder.text777.setText(String.format(Locale.getDefault(),"%.4f", taxapre) + "% a.a.");
                    this.mViewHolder.textVariavel.setText(String.format(Locale.getDefault(),"%.4f", ipca));
                    this.mViewHolder.textIpcaAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((ipca/100+1),(0.0833333333)))-1)*100));
                    float juros = (((cdc/100+1)*(spread/100+1)*(tlp/100+1))-1)*100;
                    this.mViewHolder.textJuros.setText(String.format(Locale.getDefault(),"%.4f", juros));
                    this.mViewHolder.textJurosAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((juros/100+1),(0.0833333333)))-1)*100));
                    float fixo = (((cdc/100+1)*(spread/100+1)*(taxapre/100+1))-1)*100;
                    this.mViewHolder.textFixo.setText(String.format(Locale.getDefault(),"%.4f", fixo));
                    this.mViewHolder.textFixoAM.setText(String.format(Locale.getDefault(),"%.2f", ((Math.pow((fixo/100+1),(0.0833333333)))-1)*100));
                }
            }
        }

        else if(id == R.id.button_Reset){
            this.mViewHolder.textJuros.setText(String.format(Locale.getDefault(),"%.4f", 0.0000));
            this.mViewHolder.textFixo.setText(String.format(Locale.getDefault(),"%.4f", 0.0000));
            this.mViewHolder.textVariavel.setText(String.format(Locale.getDefault(),"%.4f", 0.0000));
            this.mViewHolder.textJurosAM.setText(String.format(Locale.getDefault(),"%.2f", 0.00));
            this.mViewHolder.textIpcaAM.setText(String.format(Locale.getDefault(),"%.2f", 0.00));
            this.mViewHolder.textFixoAM.setText(String.format(Locale.getDefault(),"%.2f", 0.00));
            this.mViewHolder.editCDC.setText("");
            this.mViewHolder.editSpread.setText("");
            this.mViewHolder.editTLP.setText("");
            this.mViewHolder.edit777.setText("");
            this.mViewHolder.editIPCA.setText("");
            this.mViewHolder.text777.setText("");
            this.mViewHolder.textTLP.setText("");
        }
        else if(id == R.id.button_Info){
            startActivity(new Intent(MainActivity.this, InfoScreen.class));
        }

    }

    private static class ViewHolder{
        EditText editCDC;
        EditText editSpread;
        EditText editTLP;
        EditText edit777;
        EditText editIPCA;
        TextView textJuros;
        TextView textFixo;
        TextView textVariavel;
        TextView textTLP;
        TextView text777;
        Button Juros;
        Button Decomp;
        Button Reset;
        Button Info;
        TextView textJurosAM;
        TextView textIpcaAM;
        TextView textFixoAM;
    }

}
