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
public class medicaments {

    private int med_id;
    private String login;
    private String med_nom;
    private String med_type;
    private String date_debut;
    private String date_fin;
    private String temps;
    private String stock;
    private String rappel_stock;

    public String get_temps(){
        return temps;
    }
    
    public int get_id() {
        return med_id;
    }

    public String get_login() {
        return login;
    }

    public String get_nom_med() {
        return med_nom;
    }

    public String get_type_med() {
        return med_type;
    }

    public String get_date_debut() {
        return date_debut;
    }

    public String get_date_fin() {
        return date_fin;
    }


    public String get_stock() {
        return stock;
    }

    public String get_rappel_stock() {
        return rappel_stock;
    }

    public void set_id(int id) {
        med_id = id;
    }
    
    public void set_temps(String temps){
        this.temps = temps;
    }

    public void set_login(String login) {
        this.login = login;
    }

    public void set_nom_med(String nom_med) {
        this.med_nom = nom_med;
    }

    public void set_type_med(String med_type) {
        this.med_type = med_type;
    }

    public void set_date_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public void set_date_fin(String date_fin) {
        this.date_fin = date_fin;
    }


    public void set_stock(String stock) {
        this.stock = stock;
    }

    public void set_rappel_stock(String rappel) {
        this.rappel_stock = rappel;
    }

    public medicaments() {
        set_id(0);
        set_login(null);
        set_nom_med(null);
        set_type_med(null);
        set_date_debut(null);
        set_date_fin(null);
        set_temps(null);
        set_stock(null);
        set_rappel_stock(null);
    }

    public medicaments(String nom_med, String type_med) {
        set_nom_med(nom_med);
        set_type_med(type_med);
    }

    public medicaments(int med_id,
            String login,
            String med_nom,
            String med_type,
            String date_debut,
            String date_fin,
            String temps,
            String stock,
            String rappel_stock) {

        set_id(med_id);
        set_login(login);
        set_nom_med(med_nom);
        set_type_med(med_type);
        set_date_debut(date_debut);
        set_temps(temps);
        set_date_fin(date_fin);
        set_stock(stock);
        set_rappel_stock(rappel_stock);
    }
}
