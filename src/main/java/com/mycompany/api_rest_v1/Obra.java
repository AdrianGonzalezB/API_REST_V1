/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api_rest_v1;

import java.io.Serializable;

/**
 *
 * @author Adri
 */
public class Obra implements Serializable {
    private static final long serialVersionUID = 1L;
    int ID_OBRA; 
    String TITOL;
    String ANY;
    String MODALITAT;
    String AUTOR;

    public Obra() {
        super();
    }

    public Obra(int ID_OBRA, String TITOL, String ANY, String MODALITAT, String AUTOR) {
        super();
        this.ID_OBRA = ID_OBRA;
        this.TITOL = TITOL;
        this.ANY = ANY;
        this.MODALITAT = MODALITAT;
        this.AUTOR = AUTOR;
    }
    

    public int getID_OBRA() {
        return ID_OBRA;
    }

    public void setID_OBRA(int ID_OBRA) {
        this.ID_OBRA = ID_OBRA;
    }

    public String getTITOL() {
        return TITOL;
    }

    public void setTITOL(String TITOL) {
        this.TITOL = TITOL;
    }

    public String getANY() {
        return ANY;
    }

    public void setANY(String ANY) {
        this.ANY = ANY;
    }

    public String getMODALITAT() {
        return MODALITAT;
    }

    public void setMODALITAT(String MODALITAT) {
        this.MODALITAT = MODALITAT;
    }

    public String getAUTOR() {
        return AUTOR;
    }

    public void setAUTOR(String AUTOR) {
        this.AUTOR = AUTOR;
    }
    
    
    
    

}
