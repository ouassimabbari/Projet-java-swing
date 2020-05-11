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
public class rappel {
    private String login;
    private String rappel;
    private String nom;
    private String heure;
    private String date_r;
            
    public void set_date_r(String date){
        this.date_r=date;
    }        
    
        public void set_rappel(String rappel){
        this.rappel=rappel;
    }
            public String get_date(){
        return date_r;
    }
    
    public void set_login(String login){
        this.login=login;
    }
    public void set_nom(String nom){
        this.nom=nom;
    }
    public void set_heure(String heure){
        this.heure=heure;
    }
    
    public String get_rappel(){
        return rappel;
    }
    public String get_nom(){
        return nom;
    }
    public String get_heure(){
        return heure;
    }
        public String get_login(){
        return login;
    }
    
    public rappel(String rappel,
            String login,
            String nom,
            String heure,
            String date){
    this.login=login;
    this.rappel=rappel;
    this.heure=heure;
    this.nom=nom;
    this.date_r=date;
    
    }
    
    public rappel(){
    set_login("");
    set_rappel("");
    set_nom("");
    set_heure("");
    }
    
}
