package com.neosmart.punkapl.Controller;

import android.content.Context;

import com.neosmart.punkapl.Interface.LoginInter;
import com.neosmart.punkapl.Model.LoginModel;

/**
 * Created by Yossune Arvez on 14,mayo,2022
 * <p>
 * Brentec
 */
public class Login_Controller implements LoginInter.Presenter {

    private LoginInter.View LogView;
    private LoginInter.Model LogModel;

    public Login_Controller(LoginInter.View logView) {
        LogView = logView;
        LogModel = new LoginModel(this);
    }

    @Override
    public void MostrarResultado(String resultado) {
        if(LogView!=null){
            LogView.MostrarResult( resultado );
        }


    }

    @Override
    public void GenerarDatos(String email, String password, Context context) {
        if (LogView!=null){
            LogModel.LoginUser( email,password ,context);

        }
    }



}
