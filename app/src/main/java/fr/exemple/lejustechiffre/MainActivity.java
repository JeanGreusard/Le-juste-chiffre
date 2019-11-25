package fr.exemple.lejustechiffre;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textViewPetit;
    private TextView textViewEgal;
    private TextView textViewGrand;

    private Button buttonGenerer;
    private EditText editTextNombre;
    private Button buttonVerification;
    private int nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialisation();
        click();
    }

    private void initialisation()
    {
        textViewPetit=(TextView)findViewById(R.id.textViewPetit);
        textViewEgal=(TextView)findViewById(R.id.textViewEgal);
        textViewGrand=(TextView)findViewById(R.id.textViewGrand);

        buttonGenerer=(Button)findViewById(R.id.buttonGenerer);
        editTextNombre=(EditText)findViewById(R.id.editTextNombre);
        buttonVerification=(Button)findViewById(R.id.buttonVerif);
    }

    private void click() {

        buttonGenerer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // variable ou l'on stocke une valeur àléatoire
                 nombre = 1 + (int) (Math.random() * 100);
                Toast.makeText(MainActivity.this, "" + nombre, Toast.LENGTH_SHORT).show();
                editTextNombre.setText("");
                click_btnValidation();
                textViewPetit.setVisibility(View.INVISIBLE);
                textViewEgal.setVisibility(View.INVISIBLE);
                textViewGrand.setVisibility(View.INVISIBLE);
            }
        });
    }

      private void click_btnValidation()
      {
          buttonVerification.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  String recupNombreString=editTextNombre.getText().toString();
                  //conversion String en int pour pouvoir comparer
                  int recupNombreInt=Integer.parseInt(recupNombreString);

                  if(recupNombreInt>nombre)
                  {
                      textViewPetit.setVisibility(View.VISIBLE);
                      textViewEgal.setVisibility(View.INVISIBLE);
                      textViewGrand.setVisibility(View.INVISIBLE);
                  }
                  else if(recupNombreInt<nombre)
                  {
                      textViewGrand.setVisibility(View.VISIBLE);
                      textViewEgal.setVisibility(View.INVISIBLE);
                      textViewPetit.setVisibility(View.INVISIBLE);
                  }
                  else if(recupNombreInt==nombre)
                  {
                      textViewEgal.setVisibility(View.VISIBLE);
                      textViewPetit.setVisibility(View.INVISIBLE);
                      textViewGrand.setVisibility(View.INVISIBLE);
                  }
              }
          });

      }


}
