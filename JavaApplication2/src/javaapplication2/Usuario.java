/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.Objects;

/**
 *
 * @author ezequ
 */
public class Usuario {
    
    private String user;
    private int pass;

    //Constructores
    public Usuario() {
    }

    public Usuario(String user, int pass) {
        this.user = user;
        this.pass = pass;
    }

    //Getters and Setters
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }
    
    
    //Metodo que compara las contraseñas
    public boolean validarPassword(int contra){
        return this.pass == contra;
    }

    //Metodo que cambia la contraseña
    public void cambioPassword(String newPass) {
        try {
            int newPassword = Integer.parseInt(newPass);
            this.pass = newPassword;
        } catch (NumberFormatException e) {
            System.out.println("La contraseña no es valida.");
        }
    }
    
    //Metodo que muestra un delay
    public void delay(int mili) {
        try {
            Thread.sleep(mili);
        } catch (InterruptedException e) {
            System.out.println("Delay de " + mili + " milisegundos");
        }
    }
    
    //Metodo que compara dos usuarios
    public boolean usuariosDiferentes(Usuario u2) {
        return !this.equals(u2);
    }

    //equals and hashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.user);
        hash = 53 * hash + this.pass;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.pass != other.pass) {
            return false;
        }
        return Objects.equals(this.user, other.user);
    }
    
}
