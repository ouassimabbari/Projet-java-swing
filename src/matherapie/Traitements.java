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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.UIManager.get;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Traitements extends javax.swing.JFrame {

    DefaultTableModel model;
    DefaultTableModel model5;
    public static boolean emptytable = true;
    public static boolean emptytable2 = true;
    public static int selectedrow;

    /**
     * Creates new form Traitements
     */
    public Traitements() {
        initComponents();
        populate_jTable_from_db();
        if (emptytable) {
            jPanel5.setVisible(false);
            jTextField2.setVisible(true);
        } else {
            jPanel5.setVisible(true);
            jTextField2.setVisible(false);
        }
        populate_jTable_today_from_db();
        if (emptytable2) {
            jScrollPane2.setVisible(false);
            jTextField3.setVisible(true);
        } else {
            jScrollPane2.setVisible(true);
            jTextField3.setVisible(false);
        }
    }
    
 public ArrayList<medicaments> medicaments_list_today() {
        ArrayList<medicaments> medicaments_lists = new ArrayList<medicaments>();
        String select_nom_type_med_today = "select * from meds where (login=?) and (CURDATE() between date_debut and date_fin) order by temps";
        PreparedStatement stmt;
        ResultSet rs;
        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            stmt = con.prepareStatement(select_nom_type_med_today);
            stmt.setString(1, Utilisateur.getLogin());
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                emptytable2 = false;
                medicaments med = new medicaments(rs.getInt("med_id"), rs.getString("login"), rs.getString("med_nom"), rs.getString("med_type"), rs.getString("date_debut"), rs.getString("date_fin"), rs.getString("Temps"),rs.getString("Stock"),rs.getString("rappel_stock"));
                medicaments_lists.add(med);
                count++;
            }
            if(count<1) emptytable2=true;
            
        } catch (ClassNotFoundException e1) {
            System.out.println(e1);

        } catch (SQLException e1) {

            System.out.println(e1);
        }

        return medicaments_lists;
    }
        
            public void populate_jTable_today_from_db() {
        ArrayList<medicaments> dataarray = medicaments_list_today();
        model5 = (DefaultTableModel) jTable2.getModel();
        Object[] rows = new Object[2];
        for (int i = 0; i < dataarray.size(); i++) {
            rows[0] = dataarray.get(i).get_nom_med();
            rows[1] = dataarray.get(i).get_temps();
            model5.addRow(rows);
        }
    }
       

    public static ArrayList<medicaments> medicaments_list() {
        ArrayList<medicaments> medicament_lists = new ArrayList<medicaments>();
        String select_nom_type_med = "SELECT *,COUNT(*) FROM meds where login=? GROUP by med_nom ";
        PreparedStatement stmt;
        ResultSet rs2;
        medicaments med;
        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            stmt = con.prepareStatement(select_nom_type_med);
            stmt.setString(1, Utilisateur.getLogin());
            rs2 = stmt.executeQuery();

            while (rs2.next()) {
                emptytable = false;
                med = new medicaments(rs2.getInt("med_id"), rs2.getString("login"), rs2.getString("med_nom"), rs2.getString("med_type"), rs2.getString("date_debut"), rs2.getString("date_fin"), rs2.getString("Temps"),rs2.getString("Stock"),rs2.getString("rappel_stock"));
                medicament_lists.add(med);
                count++;
            }
            if(count<1) emptytable=true;
        } catch (ClassNotFoundException e1) {
            System.out.println(e1);

        } catch (SQLException e1) {

            System.out.println(e1);
        }

        return medicament_lists;
    }

    public void populate_jTable_from_db() {
        ArrayList<medicaments> dataarray = medicaments_list();
        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(dataarray.size());
        int row = 0;
        for (medicaments data : dataarray) {
            model.setValueAt(data.get_nom_med(), row, 0);
            model.setValueAt(data.get_type_med(), row, 1);
            row++;
        }
        jTable1.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        date_deb = new javax.swing.JLabel();
        date_debut = new javax.swing.JLabel();
        date_f = new javax.swing.JLabel();
        date_fin = new javax.swing.JLabel();
        stoc = new javax.swing.JLabel();
        stock = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nom_unite = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(48, 129, 149));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Desktop\\icons\\ic_launcher_mytherapy.png")); // NOI18N
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 140));
        jButton1.setOpaque(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);

        jButton2.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Desktop\\icons\\home-3-32.png")); // NOI18N
        jButton2.setText("Accueil");
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 190, 50));
        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);

        jButton3.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Desktop\\icons\\pill-32.png")); // NOI18N
        jButton3.setText("Traitements");
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 190, 50));
        jButton3.setOpaque(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setBorderPainted(false);

        jButton4.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Desktop\\icons\\running-32.png")); // NOI18N
        jButton4.setText("Activités");
        jButton4.setBorder(null);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 190, 50));
        jButton4.setOpaque(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setBorderPainted(false);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 190, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 252, 190, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 318, 190, -1));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 190, -1));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(48, 129, 149));
        jTextField1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.setBorder(null);
        jTextField1.setOpaque(false);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 220, 50));
        jTextField1.setText("Bienvenue "+Utilisateur.getLogin());

        jButton5.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Desktop\\icons\\logout-32.png")); // NOI18N
        jButton5.setText("Deconnexion");
        jButton5.setBorder(null);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1093, 70, 180, 50));
        jButton5.setOpaque(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setBorderPainted(false);

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Desktop\\icons\\user-32.png")); // NOI18N
        jButton6.setText("Profil");
        jButton6.setBorder(null);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 70, 130, 50));
        jButton6.setOpaque(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setBorderPainted(false);

        jButton13.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Desktop\\icons\\edit-property-32.png")); // NOI18N
        jButton13.setText("Tests");
        jButton13.setBorder(null);
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 190, 50));
        jButton13.setOpaque(false);
        jButton13.setContentAreaFilled(false);
        jButton13.setBorderPainted(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jTextField2.setText("Aucun medicament n'a été ajouté pour l'instant");
        jTextField2.setBorder(null);
        jTextField2.setOpaque(false);
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 470, 80));
        jTextField2.setVisible(false);

        jScrollPane1.setBackground(new java.awt.Color(48, 129, 149));
        jScrollPane1.setBorder(null);
        jScrollPane1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N

        jTable1.setBackground(new java.awt.Color(48, 129, 149));
        jTable1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "medicament", "type"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRowHeight(30);
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTable1FocusGained(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 450, 430));
        jPanel5.setVisible(true);

        jButton7.setBackground(new java.awt.Color(48, 129, 149));
        jButton7.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Desktop\\icons\\add-32.png")); // NOI18N
        jButton7.setText("Ajouter un medicament");
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.setOpaque(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 450, 60));

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel1.setText("Liste des medicaments");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 300, 40));

        jPanel3.setBackground(new java.awt.Color(48, 129, 149));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 10, 510));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 470, 80));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jTextField3.setText("Aucun medicament pour aujourd'hui");
        jTextField3.setBorder(null);
        jTextField3.setOpaque(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel6.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 470, 80));
        jTextField3.setVisible(false);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setBackground(new java.awt.Color(48, 129, 149));
        jTable2.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "medicament", "heure"
            }
        ));
        jTable2.setRowHeight(30);
        jScrollPane2.setViewportView(jTable2);

        jPanel7.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel2.setText("Medicaments pour aujourd'hui");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 370, 30));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 580));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        date_deb.setBackground(new java.awt.Color(255, 255, 255));
        date_deb.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        date_deb.setText("A consommer entre le :");
        jPanel9.add(date_deb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 240, 50));

        date_debut.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jPanel9.add(date_debut, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 220, 50));

        date_f.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        date_f.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        date_f.setText("et :");
        jPanel9.add(date_f, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 230, 50));

        date_fin.setBackground(new java.awt.Color(255, 255, 255));
        date_fin.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jPanel9.add(date_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 210, 50));

        stoc.setBackground(new java.awt.Color(255, 255, 255));
        stoc.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        stoc.setText("Stock restant :");
        jPanel9.add(stoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 170, 50));

        stock.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jPanel9.add(stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 80, 50));

        jButton11.setBackground(new java.awt.Color(48, 129, 149));
        jButton11.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Modifier");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 150, 40));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jPanel9.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 140, 50));

        nom_unite.setBackground(new java.awt.Color(255, 255, 255));
        nom_unite.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jPanel9.add(nom_unite, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 390, 50));

        jButton12.setBackground(new java.awt.Color(48, 129, 149));
        jButton12.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Retour");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, 120, 40));

        jPanel6.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 510, 580));
        jPanel9.setVisible(false);

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 530, 580));

        jPanel8.setBackground(new java.awt.Color(48, 129, 149));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton8.setBackground(new java.awt.Color(48, 129, 149));
        jButton8.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Modifier");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 130, 50));

        jButton9.setBackground(new java.awt.Color(48, 129, 149));
        jButton9.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Afficher Details");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, 50));

        jButton10.setBackground(new java.awt.Color(48, 129, 149));
        jButton10.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Supprimer");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 50));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 450, 50));
        jPanel8.setVisible(false);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 1090, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        index i = new index();
        i.setVisible(true);
        Traitements.this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        index i = new index();
        i.setVisible(true);
        Traitements.this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Utilisateur user = new Utilisateur();
        connexion c = new connexion();
        c.setVisible(true);
        Traitements.this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        profil p = new profil();
        p.setVisible(true);
        Traitements.this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Ajoutmed a = new Ajoutmed();
        a.setVisible(true);
        Traitements.this.dispose();

// TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTable1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusGained
        jPanel8.setVisible(true);

    }//GEN-LAST:event_jTable1FocusGained

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MousePressed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        int jtableselectedrow = jTable1.getSelectedRow();
        if (jtableselectedrow == -1) {
            JOptionPane.showMessageDialog(this, "selectionnez le medicament a supprimer");
        } else {
            int choix = JOptionPane.showConfirmDialog(this, "etes vous sur de vouloir supprimer ce medicament", "confirmer", JOptionPane.YES_NO_OPTION);
            if (choix == JOptionPane.YES_OPTION) {
                String delete = "DELETE FROM meds WHERE med_nom = ?";
                String delete2 = "DELETE FROM rappel WHERE nom = ?";
                PreparedStatement stmt;
                PreparedStatement stmt2;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
                    stmt = con.prepareStatement(delete);
                    stmt2 = con.prepareStatement(delete2);
                    stmt.setString(1, medicaments_list().get(jtableselectedrow).get_nom_med());
                    stmt2.setString(1, medicaments_list().get(jtableselectedrow).get_nom_med());
                    stmt.execute();       
                    stmt2.execute(); 
                    Traitements t = new Traitements();
                    t.setVisible(true);
                    Traitements.this.dispose();

                } catch (ClassNotFoundException e1) {
                    System.out.println(e1);

                } catch (SQLException e1) {

                    System.out.println(e1);
                }
            }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Traitements t = new Traitements();
        t.setVisible(true);
        Traitements.this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int jtableselectedrow = jTable1.getSelectedRow();
        jTextField3.setVisible(false);
        jPanel7.setVisible(false);
        jPanel9.setVisible(true);
        nom_unite.setText(medicaments_list().get(jtableselectedrow).get_nom_med() + " " + medicaments_list().get(jtableselectedrow).get_type_med());
        date_debut.setText(medicaments_list().get(jtableselectedrow).get_date_debut());
        date_fin.setText(medicaments_list().get(jtableselectedrow).get_date_fin());
        stock.setText(medicaments_list().get(jtableselectedrow).get_stock());
        jLabel4.setText(medicaments_list().get(jtableselectedrow).get_type_med());
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        int jtableselectedrow = jTable1.getSelectedRow();
        
        selectedrow = jTable1.getSelectedRow();
        medicaments med = new medicaments(medicaments_list().get(jtableselectedrow).get_id(),medicaments_list().get(jtableselectedrow).get_login(),medicaments_list().get(jtableselectedrow).get_nom_med(),medicaments_list().get(jtableselectedrow).get_type_med(),medicaments_list().get(jtableselectedrow).get_date_debut(),medicaments_list().get(jtableselectedrow).get_date_fin()
        ,medicaments_list().get(jtableselectedrow).get_temps(),medicaments_list().get(jtableselectedrow).get_stock(),medicaments_list().get(jtableselectedrow).get_rappel_stock());
        modifiermed m = new modifiermed();
        m.setVisible(true);
        Traitements.this.dispose();


    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        jPanel9.setVisible(false); 
        jPanel7.setVisible(true);
if(emptytable2){jTextField3.setVisible(true);}// TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int jtableselectedrow = jTable1.getSelectedRow();
        selectedrow = jTable1.getSelectedRow();
        medicaments med = new medicaments(medicaments_list().get(jtableselectedrow).get_id(),medicaments_list().get(jtableselectedrow).get_login(),medicaments_list().get(jtableselectedrow).get_nom_med(),medicaments_list().get(jtableselectedrow).get_type_med(),medicaments_list().get(jtableselectedrow).get_date_debut(),medicaments_list().get(jtableselectedrow).get_date_fin()
        ,medicaments_list().get(jtableselectedrow).get_temps(),medicaments_list().get(jtableselectedrow).get_stock(),medicaments_list().get(jtableselectedrow).get_rappel_stock());
        modifiermed m = new modifiermed();
        m.setVisible(true);
        Traitements.this.dispose();       // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
Activites a = new Activites();
a.setVisible(true);
Traitements.this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
Test t = new Test();
t.setVisible(true);
Traitements.this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Traitements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Traitements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Traitements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Traitements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Traitements().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date_deb;
    private javax.swing.JLabel date_debut;
    private javax.swing.JLabel date_f;
    private javax.swing.JLabel date_fin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel nom_unite;
    private javax.swing.JLabel stoc;
    private javax.swing.JLabel stock;
    // End of variables declaration//GEN-END:variables
}
