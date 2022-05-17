package com.neosmart.punkapl.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import android.widget.Toast;

import com.neosmart.punkapl.Conexion.ConexionSqlHelper;
import com.neosmart.punkapl.Conexion.Config;
import com.neosmart.punkapl.Conexion.Utilidades;
import com.neosmart.punkapl.Interface.LoginInter;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Yossune Arvez on 14,mayo,2022
 * <p>
 * Brentec
 */
public class LoginModel  implements LoginInter.Model {
    private LoginInter.Presenter presenter;
    private ContentValues values;
    private String Respuesta ="";
    public LoginModel(LoginInter.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void LoginUser(String User, String Contraseña, Context contex) {
        ConexionSqlHelper coon = new ConexionSqlHelper(contex,"BdIntercam.db",null,1);
        SQLiteDatabase db=  coon.getWritableDatabase();
        String parametros[]={"admin"};
        String campos[]={Utilidades.Usuario,Utilidades.Contrasena};
        String UsuarioValido="";
        String ContraseñaValida="";
        Cursor cursorAdmin =db.query(Utilidades.TablaUsuario,campos,Utilidades.Usuario+"=? ",parametros,null,null,null);

        if (cursorAdmin !=null){
            if (cursorAdmin.moveToFirst()){

                UsuarioValido = cursorAdmin.getString(0);
                ContraseñaValida = cursorAdmin.getString(1);
                cursorAdmin.close();
            }else {

                ContentValues values = new ContentValues();
                values.put(Utilidades.UsuarioId,1);
                values.put(Utilidades.Usuario,"admin");
                values.put(Utilidades.Contrasena,"yy7m98PdS/LxdH6XI32Z6g==");

                Long resultado =db.insert(Utilidades.TablaUsuario,Utilidades.UsuarioId,values);

                if  (resultado>0){
                    Cursor cursorAdminResgistrado =db.query(Utilidades.TablaUsuario,campos,Utilidades.Usuario+"=? ",parametros,null,null,null);
                    if (cursorAdminResgistrado !=null){
                        if (cursorAdminResgistrado.moveToFirst()){
                            UsuarioValido = cursorAdminResgistrado.getString(0);
                            ContraseñaValida = cursorAdminResgistrado.getString(1);
                            cursorAdminResgistrado.close();
                        }


                    }
                }

            }


        }
        if (!UsuarioValido.equals(User)){
            Respuesta="Usuario Incorrecto";
        }else {
            Respuesta="ok";
        }
        String contraEncriptada="";
        try
        {
             contraEncriptada=  encriptar(Contraseña);
           // Toast.makeText(contex, " contraEncriptada  " + contraEncriptada, Toast.LENGTH_SHORT).show();
        }catch (Exception ex){

        }

        if (!ContraseñaValida.trim().equals(contraEncriptada.trim())){
           // Toast.makeText(contex, " contraEncriptada  " + contraEncriptada + " ContraseñaValida  " + ContraseñaValida, Toast.LENGTH_LONG).show();
            Respuesta+=",Contraseña Incorrecto";

        }else {
            Respuesta+=",ok";
        }
      //  Toast.makeText(contex, " Respuesta" + Respuesta, Toast.LENGTH_SHORT).show();

        presenter.MostrarResultado(Respuesta);

    }


    private String encriptar (String password) throws Exception{
        SecretKeySpec secretKeySpec = generateKeyPassword (password);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec);
        byte[] datosencriptadosByte =cipher.doFinal(password.getBytes());
        String datoencriptadosString = Base64.encodeToString(datosencriptadosByte,Base64.DEFAULT);
        System.out.println (datoencriptadosString);
        return datoencriptadosString;

    }
    private SecretKeySpec generateKeyPassword (String password) throws Exception{
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte [] key=password.getBytes("UTF-8");
        key =sha.digest(key);
        SecretKeySpec secretKeySpec = new SecretKeySpec( key, "AES");
        return secretKeySpec;

    }
}
