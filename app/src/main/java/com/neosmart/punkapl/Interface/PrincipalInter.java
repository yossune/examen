package com.neosmart.punkapl.Interface;

import android.content.Context;

import com.neosmart.punkapl.Model.Cerveza;

import java.util.List;

/**
 * Created by Yossune Arvez on 15,mayo,2022
 * <p>
 * Brentec
 */
public interface PrincipalInter {

    interface View {

        void MostrarList(String resultado,List<Cerveza> body);
    }
    interface Presenter {

        void MostrarList(String resultado,List<Cerveza> body);
        void GenerarDatos();
    }
    interface Model {
        void ReadData();
    }

}
