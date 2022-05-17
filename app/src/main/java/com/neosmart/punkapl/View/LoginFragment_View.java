package com.neosmart.punkapl.View;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.neosmart.punkapl.Controller.Login_Controller;
import com.neosmart.punkapl.Interface.LoginInter;
import com.neosmart.punkapl.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment_View#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment_View extends Fragment implements LoginInter.View {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    EditText user ;
    EditText password;
    TextView text_response;
    Button btnIngresar;

    String MensajeFinal = "";
    TextInputLayout texFielUser, texFielPassword;
private LoginInter.Presenter LoginPresenter;

private boolean Camposvacios = false ;

    String CorreoIngresado;
    String PasswordIngresado;


    public LoginFragment_View() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment_View.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment_View newInstance(String param1, String param2) {
        LoginFragment_View fragment = new LoginFragment_View();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login__view, container, false);
        final View rootView = inflater.inflate(R.layout.fragment_login_view, container, false);

        user = rootView.findViewById(R.id.input_user);
        password = rootView.findViewById(R.id.input_password);
        text_response = rootView.findViewById(R.id.text_response);
        btnIngresar = rootView.findViewById(R.id.btn_signup);

        texFielUser = rootView.findViewById(R.id.texFielUser);
        texFielPassword = rootView.findViewById(R.id.texFielPassword);
        LoginPresenter= new Login_Controller( this );

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

         CorreoIngresado = user.getText().toString().trim();
         PasswordIngresado = password.getText().toString().trim();

        eventos ();

        return rootView;
    }
    public void eventos() {

        btnIngresar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    evaluar_editext();





             //   Log.d(TAG, "Usuario entrante: " +user.getText().toString()+" , "+password.getText().toString() );

            }
        } );


    }

private void evaluar_editext (){
    String users = user.getText().toString().trim();
    if (users.isEmpty()) {


        texFielUser.setError(getResources().getString(R.string.error_User));
        Camposvacios=false ;
    } else {

        texFielUser.setErrorEnabled(Boolean.FALSE);
        Camposvacios=true;


    }
    String passwor= password.getText().toString().trim();
    if (passwor.isEmpty() ) {

        texFielPassword.setError(getResources().getString(R.string.error_contrasena));

        Camposvacios=false;
    } else {
        texFielPassword.setErrorEnabled(Boolean.FALSE);
        Camposvacios=true;
    }
    if (Camposvacios){
        LoginPresenter.GenerarDatos(user.getText().toString().trim(), password.getText().toString().trim(), getContext() );

    }
}



    @Override
    public void MostrarResult(String resultado) {
        // MOSTRAR RESUKTADOS DE INGRESAR
        String respuestas[]= resultado.split(",");
       // Toast.makeText(getContext(), " " , Toast.LENGTH_SHORT).show();

        String mensaje ="";
        boolean mensajeretornado = false ;
        if (!respuestas[0].equals("ok")){
          mensaje=  "Usuario y contraseña incorrectos intente de nuevo.";
          mensajeretornado =true;
        }

        if (!respuestas[1].equals("ok")){
            mensaje=  "Usuario y contraseña incorrectos intente de nuevo.";
            mensajeretornado=true;
        }
        if (mensajeretornado){

            AlertDialog.Builder builder
                    = new AlertDialog
                    .Builder(getContext());
            builder.setMessage(mensaje);
            builder.setCancelable(false);
            builder
                    .setPositiveButton(
                            "Aceptar",
                            new DialogInterface
                                    .OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which)
                                {

                                    dialog.cancel();
                                }
                            });

            AlertDialog alertDialog = builder.create();

            alertDialog.show();
        }else {
            PrincipalFragment_View principalFragmentView= new PrincipalFragment_View();

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();//comenzamos transacción
            fragmentTransaction.replace(R.id.fragment_container, principalFragmentView);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
      //  text_response.setText(mensaje);
    }

}