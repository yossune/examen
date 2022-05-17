package com.neosmart.punkapl.Controller;


import com.neosmart.punkapl.Interface.PrincipalInter;
import com.neosmart.punkapl.Model.Cerveza;
import com.neosmart.punkapl.Model.LoginModel;
import com.neosmart.punkapl.Model.PrincipalModel;

import java.util.List;

/**
 * Created by Yossune Arvez on 15,mayo,2022
 * <p>
 * Brentec
 */
public class Principal_Controller implements PrincipalInter.Presenter {

    private PrincipalInter.View LogView;
    private PrincipalInter.Model LogModel;

    public Principal_Controller(PrincipalInter.View logView) {
        LogView = logView;
        LogModel = new PrincipalModel(this);
    }


    @Override
    public void MostrarList(String resultado, List<Cerveza> body) {
        if(LogView!=null){
            LogView.MostrarList( resultado, body );
        }
    }

    @Override
    public void GenerarDatos() {
        if (LogView!=null){
            System.out.println("***********  LogView!=null");
            LogModel.ReadData();

        }
    }
}
