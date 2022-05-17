package com.neosmart.punkapl.Interface;

import android.content.Context;

/**
 * Created by Yossune Arvez on 14,mayo,2022
 * <p>
 * Brentec
 */
public interface LoginInter {


        interface View {
            void  MostrarResult(String resultado);
        }
        interface Presenter {
            void  MostrarResultado(String resultado);
            void GenerarDatos(String email,String password, Context context);
        }
        interface Model {
            void LoginUser(String User,String Contraseña, Context contex);
        }

}
