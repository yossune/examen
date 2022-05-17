package com.neosmart.punkapl;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.neosmart.punkapl.View.LoginFragment_View;

public class MainActivity extends AppCompatActivity {

    public MainActivity() {

        super( R.layout.activity_main );

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LoginFragment_View Login = new LoginFragment_View();

        if (savedInstanceState == null) {

          getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragment_container, Login)
                    .addToBackStack(null)
                    .commit();




        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_configuracion, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean valorfinal = false;
        switch (item.getItemId()) {

            case R.id.menu_salir:
                valorfinal=true;
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getBaseContext());
                builder1.setTitle("Aviso");
                builder1.setMessage("¿Deseas salir de la aplicación?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                               finish();
                            }
                        });

                builder1.setNegativeButton(
                        "Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

                break;
        }
        return valorfinal;
    }
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }
}