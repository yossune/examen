package com.neosmart.punkapl.Model;

/**
 * Created by Yossune Arvez on 14,mayo,2022
 * <p>
 * Brentec
 */
public class Usuario {
    private String cUsuario;
    private String cContraseña;
    private int UsuarioId;
    public Usuario() {
        this.cUsuario = "";
        this.cContraseña = "";
    }

    public int getUsuarioId() {
        return UsuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        UsuarioId = usuarioId;
    }

    public void setcUsuario(String cUsuario) {
        this.cUsuario = cUsuario;
    }

    public void setcContraseña(String cContraseña) {
        this.cContraseña = cContraseña;
    }

    public String getcUsuario() {
        return cUsuario;
    }

    public String getcContraseña() {
        return cContraseña;
    }

}
