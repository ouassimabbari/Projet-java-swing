/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matherapie;

/**
 *
 * @author user
 */
public class Activités {
    private int activite_id;
    private String login;
    private String type_activite;
    private String nom_activite;
    private String date_activite;
    private String heure_activite;
    
    
    public int getId(){
        return activite_id;
    }
    
    public String getLogin(){
        return login;
    }    
    
    public String getType(){
        return type_activite;
    }
    
    public String getNom(){
        return nom_activite;
    }
    
    public String getDate(){
        return date_activite;
    }
    
    public String getHeure(){
        return heure_activite;
    }
    
    public void setId(int id){
        this.activite_id = id;
    }
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public void setType(String type){
        this.type_activite = type;
    }
    
    public void setNom(String nom){
        this.nom_activite = nom;
    }
    
    public void setDate(String date){
        this.date_activite = date;
    }
    
    public void setHeure(String heure){
        this.heure_activite = heure;
    }
    
    public Activités() {
        setId(0);
        setLogin(null);
        setType(null);
        setNom(null);
        setDate(null);
        setHeure(null);
    }
    
    public Activités(int id,
            String login,
            String type,
            String nom,
            String date,
            String heure) {

        setId(id);
        setLogin(login);
        setType(type);
        setNom(nom);
        setDate(date);
        setHeure(heure);
    }
}

    

