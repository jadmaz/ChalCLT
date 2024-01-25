/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ca.ulaval.glo2004.gui;

import ca.ulaval.glo2004.domain.Controleur;
import ca.ulaval.glo2004.domain.DTO.AccessoiresDTO;
import ca.ulaval.glo2004.domain.Orientation;
import ca.ulaval.glo2004.domain.SensToit;
import ca.ulaval.glo2004.domain.drawer.AfficheurDessus;
import ca.ulaval.glo2004.domain.drawer.AfficheurMur;
import ca.ulaval.glo2004.domain.utils.Dimensions;
import ca.ulaval.glo2004.domain.utils.Imperial;
import ca.ulaval.glo2004.gui.listeners.AffichageDessusAction;
import ca.ulaval.glo2004.gui.listeners.AffichageMurAction;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import ca.ulaval.glo2004.domain.utils.Points;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author 14189
 *
 */
public class MainWindow extends javax.swing.JFrame {
    private boolean travailEnregistre = false;
    private static boolean showGrid = false;
    public Controleur controller;
    private MainWindow outer;
    public Orientation orientation;
    public SensToit senstoit;
    public SelectMode selectmode;
    public Point actualMousePoint;
    public Points point;
    public Dimensions dimensions;
    public String type;
    public String mur_associe;
    public Boolean is_selected;
    public Imperial n_hauteur;
    public Imperial n_largeur;
    public Imperial hauteurM;
    public Imperial longueur;
    public Imperial profondeur;
    public Imperial epaisseur;
    public Boolean is_valid;
    public Imperial point_x;
    public Imperial point_y;
    public boolean isDragging = false;
    public boolean drag = false;
    public Dimensions dimensions_affiche;
    public enum vueType {
        Dessus, Facade, Arriere, Gauche, Droite
    };
    
    
    public enum SelectMode {
		SELECT, ADD
	}

    public MainWindow() {
        initComponents(); 

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
                confirmAndClose();
                    
                }
            
        });
            
            
        exporter.setToolTipText("Exportation du fichier stl");
        newfile.setToolTipText("Ouvrir un nouveau projet");
        load.setToolTipText("Ouvrir un projet existant");
        save_as.setToolTipText("Enregistrer le projet");
        grid.setToolTipText("Afficher la grille");
        quit.setToolTipText("Quitter");
        undo.setToolTipText("Undo");
        redo.setToolTipText("Redo");



        selectmode = SelectMode.SELECT;
        actualMousePoint = new Point();
        controller = new Controleur();
        dimension_epaisseur.setText("Épaisseur: " + Imperial.toString(controller.getEpaisseur()));
        dimension_epaisseurc.setText("Épaisseur: " + Imperial.toString(controller.getEpaisseur()));
        dimension_l.setText("Longueur: ");
        dimension_lc.setText("Longueur: ");
        dimension_h.setText("Hauteur: ");
        dimension_hc.setText("Hauteur: ");
        dimension_p.setText("Profondeur: ");
        dimension_pc.setText("Pronfondeur: ");
        controller.setMurOrientation(Orientation.Dessus);
        setSize(1500, 600);
        ImageIcon originalIcon1 = new ImageIcon(getClass().getResource("/images/add11.png"));
    Image img1 = originalIcon1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    ImageIcon resizedIcon1 = new ImageIcon(img1);
    this.newfile.setIcon(resizedIcon1);

    ImageIcon originalIcon2 = new ImageIcon(getClass().getResource("/images/charger.png"));
    Image img2 = originalIcon2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    ImageIcon resizedIcon2 = new ImageIcon(img2);
    this.load.setIcon(resizedIcon2);

    ImageIcon originalIcon3 = new ImageIcon(getClass().getResource("/images/sauvegarder.png"));
    Image img3 = originalIcon3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    ImageIcon resizedIcon3 = new ImageIcon(img3);
    this.save_as.setIcon(resizedIcon3);

    ImageIcon originalIcon4 = new ImageIcon(getClass().getResource("/images/export2.png"));
    Image img4 = originalIcon4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    ImageIcon resizedIcon4 = new ImageIcon(img4);
    this.exporter.setIcon(resizedIcon4);

    ImageIcon originalIcon5 = new ImageIcon(getClass().getResource("/images/undo16.png"));
    Image img5 = originalIcon5.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    ImageIcon resizedIcon5 = new ImageIcon(img5);
    this.undo.setIcon(resizedIcon5);

    ImageIcon originalIcon6 = new ImageIcon(getClass().getResource("/images/redo13.png"));
    Image img6 = originalIcon6.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    ImageIcon resizedIcon6 = new ImageIcon(img6);
    this.redo.setIcon(resizedIcon6);

    ImageIcon originalIcon7 = new ImageIcon(getClass().getResource("/images/exit.png"));
    Image img7 = originalIcon7.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    ImageIcon resizedIcon7 = new ImageIcon(img7);
    this.quit.setIcon(resizedIcon7);

    ImageIcon originalIcon8 = new ImageIcon(getClass().getResource("/images/grille.png"));
    Image img8 = originalIcon8.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    ImageIcon resizedIcon8 = new ImageIcon(img8);
        this.grid.setIcon(resizedIcon8);
        this.gridpanel.setBackground(Color.gray);

        this.grid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainWindow.showGrid = !MainWindow.showGrid;
                gridpanel.repaint();
            }
        });

        Dessus.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
                int selectedIndex = sourceTabbedPane.getSelectedIndex();
                if (selectedIndex == 0) { // Supposons que l'index 0 est pour AfficheurDessus
                    System.out.println("Onglet AfficheurDessus sélectionné");
                    drawingPanel.setCurrentDrawer(new AfficheurDessus(outer));
                    controller.setMurOrientation(Orientation.Dessus);
                } else if (selectedIndex == 1) { // Supposons que l'index 1 est pour AfficheurMur
                    System.out.println("Onglet AfficheurMur sélectionné");
                    drawingPanel.setCurrentDrawer(new AfficheurMur(outer));
                    controller.setMurOrientation(Orientation.Facade);
                }
                drawingPanel.repaint(); // Appeler repaint pour redessiner le panel
            }
        });
        
        Facade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setMurOrientation(Orientation.Facade);
                orientation = Orientation.Facade;
            }
        });

        Droite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setMurOrientation(Orientation.Droite);
                orientation = Orientation.Droite;
            }
        });

        Gauche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
 
                controller.setMurOrientation(Orientation.Gauche);
                orientation = Orientation.Gauche;
            }
        });

        Arriere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setMurOrientation(Orientation.Arriere);
                orientation = Orientation.Arriere;
            }
        });
        


    }
    
     private void confirmAndClose() {
         if (!travailEnregistre) {
            int choix = JOptionPane.showConfirmDialog(
                this,
                "Voulez-vous enregistrer votre travail avant de quitter ?",
                "Enregistrer le travail",
                JOptionPane.YES_NO_OPTION
            );

            if (choix == JOptionPane.YES_OPTION) {
                enregistrerSous();
            }
        } else {
            int choix = JOptionPane.showConfirmDialog(
                this,
                "Voulez-vous enregistrer votre dernière modification avant de quitter ?",
                "Enregistrer le travail",
                JOptionPane.YES_NO_OPTION
            );

            if (choix == JOptionPane.YES_OPTION) {
                enregistrer();
            }
        }

        fermerFenetre();
         
    }

         
     
     public SelectMode getmode()
     {
     return this.selectmode;
     }
    
    public void enregistrerSous() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setCurrentDirectory(new java.io.File(".")); // Commence dans le répertoire courant
    fileChooser.setDialogTitle("Enregistrer sous"); // Titre de la boîte de dialogue
    fileChooser.setApproveButtonText("Enregistrer"); // Texte sur le bouton d'enregistrement

    // Filtre de fichier pour afficher uniquement les répertoires et fichiers .ser
    fileChooser.setFileFilter(new FileNameExtensionFilter("Fichiers sérialisés (*.ser)", "ser"));

    if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        String filePath = selectedFile.getAbsolutePath();


        if (!filePath.endsWith(".ser")) {
            filePath += ".ser";
        }

        try {
            
            controller.save_as(filePath); 


            JOptionPane.showMessageDialog(null, "Projet enregistré avec succès.");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'enregistrement du projet.");
        }
    }
        travailEnregistre = true;

}
    
    public void enregistrer() {
    String path = controller.get_chemin(); // Récupère le chemin actuel
    if (!Objects.equals(path, "")) {
        // Chemin existant, tente d'enregistrer le projet à ce chemin
        try {
            controller.save(); // Enregistre le projet
            JOptionPane.showMessageDialog(null, "Projet enregistré avec succès.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'enregistrement du projet.");
            System.out.println(e);
        }
    } else {
        // Pas de chemin existant, ouvre JFileChooser pour choisir un chemin
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File(".")); 
        fileChooser.setDialogTitle("Enregistrer sous");
        fileChooser.setApproveButtonText("Enregistrer");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Fichiers sérialisés (*.ser)", "ser"));

        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            
            // Ajoute l'extension .ser si nécessaire
            if (!filePath.endsWith(".ser")) {
                filePath += ".ser";
            }

            try {
                controller.save_as(filePath); // Enregistre le projet au nouveau chemin
                JOptionPane.showMessageDialog(null, "Projet enregistré avec succès.");
                travailEnregistre = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'enregistrement du projet.");
                System.out.println(e);
            }
        }
    }
        

}

      private void fermerFenetre() {
        dispose(); 
    }
    
    public Orientation getOrientation(){
        return this.orientation;
    }
    
    public SelectMode getselectmode(){
        return selectmode;
    }
    
    public void setOrientation(){
        controller.murorientation = this.orientation;
    }
    
    public String getItemType() {
		return type;
	}
    public String getMurAssocie()
    {
    return mur_associe;
    }
    
    public boolean is_selected()
    {
    return is_selected;
    }
    
    public Imperial get_nouv_hauteur()
    {
    return n_hauteur;
    }
    
    public void set_nouv_hauteur(Imperial hauteur)
    {
    this.n_hauteur = hauteur;
    }
    
    public Imperial get_nouv_largeur()
    {
    return n_largeur;
    }
    
    public void set_nouv_largeur(Imperial largeur)
    {
    this.n_largeur = largeur;
    }
    
    
    public void set_nouv_x(Imperial point_x)
    {
    this.point_x = point_x;
    }
    
    public void set_nouv_y(Imperial point_y)
    {
    this.point_y = point_y;
    }
    
    public Imperial get_nouv_x()
    {
    return this.point_x;
    }
    
    public Imperial get_nouv_y()
    {
    return this.point_y;
    }
    
    public void set_drag(boolean bool)
    {
    this.drag = bool;
    }
    
    public boolean get_drag()
    {
    return this.drag;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        gridpanel = new javax.swing.JPanel();
        Dessus = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        dimension_h = new javax.swing.JLabel();
        dimension_l = new javax.swing.JLabel();
        dimension_p = new javax.swing.JLabel();
        dimension_epaisseur = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Facade = new javax.swing.JButton();
        Arriere = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        Droite = new javax.swing.JButton();
        Gauche = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        largeur = new javax.swing.JTextField();
        hauteur = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel25 = new javax.swing.JLabel();
        distance_validation = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        position_y = new javax.swing.JTextField();
        position_x = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        dimension_lc = new javax.swing.JLabel();
        dimension_pc = new javax.swing.JLabel();
        dimension_hc = new javax.swing.JLabel();
        dimension_epaisseurc = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        murSeul = new javax.swing.JCheckBox();
        newfile = new javax.swing.JButton();
        load = new javax.swing.JButton();
        save_as = new javax.swing.JButton();
        undo = new javax.swing.JButton();
        redo = new javax.swing.JButton();
        quit = new javax.swing.JButton();
        exporter = new javax.swing.JButton();
        grid = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        drawingPanel = new ca.ulaval.glo2004.gui.Panels.drawingPanel(this);
        jTextField7 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(215, 175, 99));

        Dessus.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                DessusStateChanged(evt);
            }
        });
        Dessus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DessusMouseClicked(evt);
            }
        });

        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Dimension du chalet:");

        jLabel5.setText("Epaisseur");

        jLabel3.setText("Longueur");

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextField4InputMethodTextChanged(evt);
            }
        });
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Hauteur");

        jLabel6.setText("Angle du toit");

        jLabel4.setText("Profondeur");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel18.setText("pouces");

        jLabel19.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel19.setText("pouces");

        jLabel20.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel20.setText("pouces");

        jLabel21.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel21.setText("pouces");

        jLabel22.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel22.setText("°");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel23.setText("pouces");

        jLabel24.setText("Distance supplémentaire");

        jLayeredPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTextField6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTextField3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTextField4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTextField5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel22, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel23, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel24, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(60, 60, 60)
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(83, 83, 83)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton3.setText("Valider");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nord", "Sud", "Est", "Ouest" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Orientation du toit");

        dimension_h.setText("Hauteur:");

        dimension_l.setText("Longueur:");

        dimension_p.setText("Profondeur:");

        dimension_epaisseur.setText("Épaisseur:");

        jLabel32.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel32.setText("Dimensions du panneau brut:");

        jCheckBox1.setText("Toit");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(62, 62, 62)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(117, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel32))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dimension_h, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dimension_epaisseur, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dimension_l, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dimension_p, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jCheckBox1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(155, 155, 155))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(22, 22, 22)
                        .addComponent(jButton3))
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addGap(24, 24, 24)
                .addComponent(dimension_h)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dimension_l)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dimension_p)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dimension_epaisseur)
                .addGap(118, 118, 118))
        );

        Dessus.addTab("Dessus", jPanel5);

        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel8.setText("Sélectionnez quel côté vous voulez :");

        Facade.setText("Facade");
        Facade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacadeActionPerformed(evt);
            }
        });

        Arriere.setText("Arriere");
        Arriere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArriereActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel9.setText("Accessoires");

        Droite.setText("Droite");
        Droite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DroiteActionPerformed(evt);
            }
        });

        Gauche.setText("Gauche");
        Gauche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GaucheActionPerformed(evt);
            }
        });

        jButton1.setText("Valider position");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Éditer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel10.setText("Configuration :");

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel11.setText("Largeur");

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel15.setText("Hauteur");

        largeur.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                largeurInputMethodTextChanged(evt);
            }
        });
        largeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                largeurActionPerformed(evt);
            }
        });

        hauteur.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                hauteurInputMethodTextChanged(evt);
            }
        });
        hauteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hauteurActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel16.setText("pouces");

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel17.setText("pouces");

        jButton6.setText("Supprimer");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        buttonGroup9.add(jToggleButton1);
        jToggleButton1.setSelected(true);
        jToggleButton1.setText("Fenêtre");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        buttonGroup9.add(jToggleButton2);
        jToggleButton2.setText("Porte");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Select");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Add");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel25.setText("Distance validation");

        distance_validation.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                distance_validationInputMethodTextChanged(evt);
            }
        });
        distance_validation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distance_validationActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel26.setText("pouces");

        jLabel27.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel27.setText("Coordonnée x");

        position_y.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                position_yInputMethodTextChanged(evt);
            }
        });
        position_y.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                position_yActionPerformed(evt);
            }
        });

        position_x.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                position_xInputMethodTextChanged(evt);
            }
        });
        position_x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                position_xActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel28.setText("pouces");

        jLabel29.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel29.setText("pouces");

        jLabel30.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel30.setText("Coordonnée y");

        jButton4.setText("Réinitialiser la vue");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        dimension_lc.setText("Longueur:");

        dimension_pc.setText("Profondeur:");

        dimension_hc.setText("Hauteur:");

        dimension_epaisseurc.setText("Épaisseur:");

        jLabel31.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel31.setText("Dimensions du panneau brut:");

        murSeul.setText("Mur seul");
        murSeul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                murSeulActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(largeur, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(hauteur, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(distance_validation, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel17))))
                        .addGap(26, 26, 26))
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(position_x, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel28))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(position_y, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel29)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(Facade)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Arriere)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Droite)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Gauche))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(jButton6))
                            .addComponent(jLabel25))
                        .addGap(124, 124, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel31))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jButton4)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(murSeul)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dimension_epaisseurc, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dimension_hc, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                .addComponent(dimension_lc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dimension_pc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(33, 33, 33))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Arriere)
                    .addComponent(Droite)
                    .addComponent(Gauche)
                    .addComponent(Facade, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jRadioButton1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(position_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jRadioButton2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jToggleButton2)
                            .addComponent(position_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dimension_hc)
                    .addComponent(jLabel31))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dimension_lc)
                    .addComponent(murSeul))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dimension_pc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(dimension_epaisseurc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(largeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(hauteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(distance_validation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(1, 1, 1)
                .addComponent(jButton6)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        Dessus.addTab("Coté", jPanel4);

        newfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newfileActionPerformed(evt);
            }
        });

        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadActionPerformed(evt);
            }
        });

        save_as.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_asActionPerformed(evt);
            }
        });

        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });

        redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoActionPerformed(evt);
            }
        });

        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });

        exporter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exporterActionPerformed(evt);
            }
        });

        grid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gridActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(121, 88, 23));
        jLabel12.setText("Fichier");

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(121, 88, 23));
        jLabel13.setText("Édition");

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(121, 88, 23));
        jLabel14.setText("Exportation");

        drawingPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        drawingPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                drawingPanelMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                drawingPanelMouseMoved(evt);
            }
        });
        drawingPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                drawingPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                drawingPanelMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                drawingPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                drawingPanelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout drawingPanelLayout = new javax.swing.GroupLayout(drawingPanel);
        drawingPanel.setLayout(drawingPanelLayout);
        drawingPanelLayout.setHorizontalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 921, Short.MAX_VALUE)
        );
        drawingPanelLayout.setVerticalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );

        jTextField7.setToolTipText("");
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel33.setText("Dimension de la grille");

        jSlider1.setMaximum(480);
        jSlider1.setMinimum(48);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(newfile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(load)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(save_as))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel12)))
                        .addGap(173, 173, 173)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 364, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addGap(137, 137, 137))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel33)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel13)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(undo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(redo)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(grid)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                        .addComponent(exporter)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(quit)
                                        .addGap(121, 121, 121))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(drawingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(gridpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Dessus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33))
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(load, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(save_as, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(redo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exporter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(grid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(undo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(gridpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(drawingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Dessus)
                .addContainerGap())
        );

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

    private void undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoActionPerformed
        // TODO add your handling code here:
        try {
                controller.undo();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        set_drag(false);
        drawingPanel.repaint();
        
    }//GEN-LAST:event_undoActionPerformed

    private void save_asActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_asActionPerformed
 Object[] options = {"Enregistrer", "Enregistrer sous", "Annuler"};
    
    int choix = JOptionPane.showOptionDialog(this,  
        "Choisissez une option",  
        "Enregistrer",  
        JOptionPane.YES_NO_CANCEL_OPTION,  
        JOptionPane.QUESTION_MESSAGE,  
        null,  
        options,  
        options[0]);  

     
    switch (choix) {
        case JOptionPane.YES_OPTION:
             
            enregistrer();
            break;
        case JOptionPane.NO_OPTION:
             
            enregistrerSous();
            break;
        case JOptionPane.CANCEL_OPTION:
            
            break;
        default:
            break;
    }

    }//GEN-LAST:event_save_asActionPerformed

    private void redoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoActionPerformed
        // TODO add your handling code here:
        try {
                controller.redo();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        drawingPanel.repaint();
    }//GEN-LAST:event_redoActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String selectedDirection = (String) jComboBox1.getSelectedItem();

        if ("Nord".equals(selectedDirection)) {
            controller.setSensToit(senstoit.Facade_arriere);
            System.out.println("Code pour la direction Nord");
        } else if ("Sud".equals(selectedDirection)) {
            controller.setSensToit(senstoit.Arriere_facade);
            System.out.println("Code pour la direction Sud");
        } else if ("Est".equals(selectedDirection)) {
            controller.setSensToit(senstoit.Droite_gauche);
            System.out.println("Code pour la direction Est");
        } else if ("Ouest".equals(selectedDirection)) {
            controller.setSensToit(senstoit.Gauche_droite);
            System.out.println("Code pour la direction Ouest");
        }
        controller.setListMurs(controller.dimensionsChanged());
        drawingPanel.repaint();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void drawingPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanel1MousePressed
        
    }//GEN-LAST:event_drawingPanel1MousePressed

    private void FacadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacadeActionPerformed
        controller.setMurOrientation(Orientation.Facade);
        drawingPanel.resetZoomAndView();

    }//GEN-LAST:event_FacadeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    
    Imperial new_x = get_nouv_x();
    Imperial new_y = get_nouv_y();

    
    System.out.println("New Height: " + new_x + ", New Width: " + new_y);

    
    if (new_x != null || new_y != null)
    {
        
        if(new_x == null)
        {
        new_x = controller.get_selected_acc_position().getX();
        }
        if(new_y == null)
        {
        new_y = controller.get_selected_acc_position().getY();
        }
        Points nouv_point = new Points(new_x, new_y);
        controller.update_position_selected_accessory(nouv_point);
    } 
    else {
        System.out.println("Invalid dimensions provided");
    }

    drawingPanel.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

    Imperial profondeur = new Imperial(0, 0, 0);
    Imperial newHeight = get_nouv_hauteur();
    Imperial newWidth = get_nouv_largeur();

    
    System.out.println("New Height: " + newHeight + ", New Width: " + newWidth);

    
    if (newHeight != null || newWidth != null) {
        if(newHeight == null)
        {
        newHeight = controller.get_selected_acc_dimensions().getHauteur();
        }
        if(newWidth == null)
        {
        newWidth = controller.get_selected_acc_dimensions().getLongueur();
        }
        Dimensions nouv_dimensions = new Dimensions(newHeight, newWidth, profondeur);
        controller.update_selected_accessory(nouv_dimensions);
    } else {
        System.out.println("Invalid dimensions provided");
    }

    drawingPanel.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void largeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_largeurActionPerformed
        String input_text = largeur.getText();
        Imperial nouv_largeur = Imperial.fromString(input_text);
        if(!input_text.isEmpty())
        {
        set_nouv_largeur(nouv_largeur);
        }
        else
        {
        set_nouv_largeur(controller.get_selected_acc_dimensions().getLongueur());
        }
    }//GEN-LAST:event_largeurActionPerformed

    private void hauteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hauteurActionPerformed
        String input_text = hauteur.getText();
        Imperial nouv_hauteur = Imperial.fromString(input_text);
        if(!input_text.isEmpty())
        {
        set_nouv_hauteur(nouv_hauteur);
        }
        else
        {
        set_nouv_hauteur(controller.get_selected_acc_dimensions().getHauteur());
        }
        
    }//GEN-LAST:event_hauteurActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        controller.deleteSelectedAccessories();
        drawingPanel.repaint();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void drawingPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMousePressed

    Point mousePoint = evt.getPoint();

    // Adjust mouse coordinates based on zoom and translation
    double adjustedX = (mousePoint.x - drawingPanel.getOffsetX()) / drawingPanel.getZoomFactor();
    double adjustedY = (mousePoint.y - drawingPanel.getOffsetY()) / drawingPanel.getZoomFactor();

    // Convert adjusted coordinates to Imperial Points
    Points imperialPoint = Points.fromPixelsToImperial((int) adjustedX, (int) adjustedY);

    point = imperialPoint;
    if (this.getselectmode() == SelectMode.ADD) {
        String type = controller.get_acc_type();
        dimensions = controller.getDimensionsAcc();
        Orientation murOrientation = controller.getMurOrientation();

        // Set mur_associe based on murOrientation
        mur_associe = murOrientation.toString().toLowerCase();

        controller.addItem(point, type, dimensions, mur_associe, is_selected = false, is_valid = false);
        drawingPanel.repaint();
    } else if (this.getselectmode() == SelectMode.SELECT) {
        controller.is_contained(point);
        drawingPanel.repaint();
    }
    set_drag(false);
    }//GEN-LAST:event_drawingPanelMousePressed

    private void largeurInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_largeurInputMethodTextChanged
       
    }//GEN-LAST:event_largeurInputMethodTextChanged

    private void hauteurInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_hauteurInputMethodTextChanged
        
    }//GEN-LAST:event_hauteurInputMethodTextChanged

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        controller.set_acc_type("fenetre");
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        controller.set_acc_type("porte");
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void ArriereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArriereActionPerformed
       controller.setMurOrientation(Orientation.Arriere);
        drawingPanel.resetZoomAndView();

    }//GEN-LAST:event_ArriereActionPerformed

    private void DroiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DroiteActionPerformed
        controller.setMurOrientation(Orientation.Droite);
        drawingPanel.resetZoomAndView();

    }//GEN-LAST:event_DroiteActionPerformed

    private void GaucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GaucheActionPerformed
        controller.setMurOrientation(Orientation.Gauche);
        drawingPanel.resetZoomAndView();

    }//GEN-LAST:event_GaucheActionPerformed

    private void DessusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DessusMouseClicked
    
    }//GEN-LAST:event_DessusMouseClicked

    private void DessusStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_DessusStateChanged
        drawingPanel.resetZoomAndView();
        
    }//GEN-LAST:event_DessusStateChanged

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked

    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel5MouseClicked

    private void exporterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exporterActionPerformed

    
    

    
        String chemin = ""; // Remplacez par le chemin correct

        
        controller.export( chemin,controller);

        
    


    }//GEN-LAST:event_exporterActionPerformed

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked

    }//GEN-LAST:event_jButton6MouseClicked

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        selectmode = SelectMode.SELECT;
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        selectmode = SelectMode.ADD;
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        String input_text = jTextField1.getText();
        Imperial nouv_Hauteur = Imperial.fromString(input_text);
        controller.setDimensions(new Dimensions(nouv_Hauteur,
                controller.getDimensions().getLongueur(),
                controller.getDimensions().getProfondeur()
        ));
        controller.setListMurs(controller.dimensionsChanged());
        drawingPanel.repaint();

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        String input_text = jTextField3.getText();
        Imperial nouv_Longueur = Imperial.fromString(input_text);
        controller.setDimensions(new Dimensions(controller.getDimensions().getHauteur(),
                nouv_Longueur,
                controller.getDimensions().getProfondeur()
        ));
        controller.setListMurs(controller.dimensionsChanged());
        drawingPanel.repaint();

    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField4InputMethodTextChanged

    }//GEN-LAST:event_jTextField4InputMethodTextChanged

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        String input_text = jTextField4.getText();
        Imperial nouv_Profondeur = Imperial.fromString(input_text);
        controller.setDimensions(new Dimensions(controller.getDimensions().getHauteur(),
                controller.getDimensions().getLongueur(),
                nouv_Profondeur
        ));
        controller.setListMurs(controller.dimensionsChanged());
        drawingPanel.repaint();

    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        String input_text = jTextField5.getText();
        Imperial nouv_Epaisseur = Imperial.fromString(input_text);
        controller.setEpaisseur(nouv_Epaisseur);
        controller.setListMurs(controller.dimensionsChanged());
        dimension_epaisseur.setText("Épaisseur: " + Imperial.toString(controller.getEpaisseur()));
        dimension_epaisseurc.setText("Épaisseur: " + Imperial.toString(controller.getEpaisseur()));
        drawingPanel.repaint();
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        String input_text = jTextField2.getText();
        Imperial nouv_Distance = Imperial.fromString(input_text);
        controller.setDistanceSupp(nouv_Distance);
        controller.setListMurs(controller.dimensionsChanged());
        drawingPanel.repaint();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void distance_validationInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_distance_validationInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_distance_validationInputMethodTextChanged

    private void distance_validationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distance_validationActionPerformed
        String input_text = distance_validation.getText();
        Imperial nouv_dist = Imperial.fromString(input_text);
        controller.set_distance_validation(nouv_dist);
        drawingPanel.repaint();
    }//GEN-LAST:event_distance_validationActionPerformed

    private void position_yInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_position_yInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_position_yInputMethodTextChanged

    private void position_yActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_position_yActionPerformed
        // TODO add your handling code here:
        String input_text = position_y.getText();
        Imperial nouv_pos_y = Imperial.fromString(input_text);
        if(!input_text.isEmpty())
        {
        set_nouv_y(nouv_pos_y);
        }
        else
        {
        set_nouv_y(controller.get_selected_acc_position().getY());
        }
    }//GEN-LAST:event_position_yActionPerformed

    private void position_xInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_position_xInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_position_xInputMethodTextChanged

    private void position_xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_position_xActionPerformed
                  // TODO add your handling code here:
        String input_text = position_x.getText();
        Imperial nouv_pos_x = Imperial.fromString(input_text);
        if(!input_text.isEmpty())
        {
        set_nouv_x(nouv_pos_x);
        }
        else
        {
        set_nouv_x(controller.get_selected_acc_position().getX());
        }
          
    }//GEN-LAST:event_position_xActionPerformed


    private void newfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newfileActionPerformed
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            MainWindow newWindow = new MainWindow();
            newWindow.setVisible(true);
        }
            });
    }//GEN-LAST:event_newfileActionPerformed

    private void drawingPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMouseDragged
        // TODO add your handling code here:
      if (!isDragging && getmode() == SelectMode.SELECT) {
        controller.sauvegardeMurAction(); // Save initial state at the start of dragging
        isDragging = true;
    }
    set_drag(true);
    }//GEN-LAST:event_drawingPanelMouseDragged

    private void drawingPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMouseReleased
        // TODO add your handling code here:
    if (get_drag()) {
        isDragging = false;
        drawingPanel.repaint();
    }
        
    }//GEN-LAST:event_drawingPanelMouseReleased

    private void drawingPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMouseMoved
        // TODO add your handling code here:
        if(get_drag() == true)
        {
        Point mousePoint = evt.getPoint();
    // Ajustez les coordonnées de la souris en fonction du zoom et de la translation
        double adjustedX = (mousePoint.x - drawingPanel.getOffsetX()) / drawingPanel.getZoomFactor();
        double adjustedY = (mousePoint.y - drawingPanel.getOffsetY()) / drawingPanel.getZoomFactor();
    // Convertissez les coordonnées ajustées en Points impériaux
        Points imperialPoint = Points.fromPixelsToImperial((int) adjustedX, (int) adjustedY);
        controller.update_position_selected_accessory_dragged(imperialPoint);
        }
        
        else
        {
        Point mousePoint = evt.getPoint();
    // Ajustez les coordonnées de la souris en fonction du zoom et de la translation
        double adjustedX = (mousePoint.x - drawingPanel.getOffsetX()) / drawingPanel.getZoomFactor();
        double adjustedY = (mousePoint.y - drawingPanel.getOffsetY()) / drawingPanel.getZoomFactor();
    // Convertissez les coordonnées ajustées en Points impériaux
        Points imperialPoint = Points.fromPixelsToImperial((int) adjustedX, (int) adjustedY);
        dimensions_affiche = controller.get_concerned_object_dimensions(imperialPoint);
        if(dimensions_affiche != null)
        {
        Imperial l = dimensions_affiche.getLongueur();
        String longueur_ = Imperial.toString(l);
        Imperial h = dimensions_affiche.getHauteur();
        String hauteur_ = Imperial.toString(h);
        Imperial p = dimensions_affiche.getProfondeur();
        String profondeur_ = Imperial.toString(p);
        dimension_l.setText("Longueur: " + longueur_);
        dimension_h.setText("Hauteur: " + hauteur_);
        dimension_p.setText("Profondeur: " + profondeur_);
        dimension_lc.setText("Longueur: " + longueur_);
        dimension_hc.setText("Hauteur: " + hauteur_);
        dimension_pc.setText("Profondeur: " + profondeur_);
        }
        }
        
    }//GEN-LAST:event_drawingPanelMouseMoved

    private void drawingPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_drawingPanelMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        drawingPanel.resetZoomAndView();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void drawingPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawingPanelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_drawingPanelMouseEntered

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
    String input_text = jTextField6.getText();
    int nouv_Angle = Integer.parseInt(input_text);
    controller.setAngle(nouv_Angle);
    drawingPanel.repaint();
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadActionPerformed
        travailEnregistre = true;
                
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File(".")); // Start in current directory
        fileChooser.setDialogTitle("Open Project"); // Title of the dialog
        fileChooser.setApproveButtonText("Open"); // Text on the open button

        // File filter to only show .ser files
        fileChooser.setFileFilter(new FileNameExtensionFilter("Serialized Files (*.ser)", "ser"));

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            try {
                // Assuming 'openProject' is a method in your controller to open the project
                 controller.charger_projet(filePath);
                 drawingPanel.repaint();// Open the project from the specified path
                JOptionPane.showMessageDialog(null, "Project opened successfully.");
            } catch (Exception e) {
                // Display error message
                JOptionPane.showMessageDialog(null, "Error occurred while opening the project.");
                System.out.println(e); // Optional: print stack trace to the console
            }
        }
    }//GEN-LAST:event_loadActionPerformed

    private void gridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gridActionPerformed
    drawingPanel.setShowGrid(!drawingPanel.isShowingGrid());
    }//GEN-LAST:event_gridActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed

        String newGridSize = jTextField7.getText();
        Imperial imp = Imperial.fromString(newGridSize);
        int val = imp.toPixel();
        
        if (val > 0) {
            drawingPanel.setGridSize(val);
            jSlider1.setValue(val);
        } 
        
        else {
JOptionPane.showMessageDialog(this, "Veuillez entrer un nombre valide.");  }      
        
    
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed

      if (!travailEnregistre) {
    int choix = JOptionPane.showConfirmDialog(
        this,
        "Voulez-vous enregistrer votre travail avant de quitter ?",
        "Enregistrer le travail",
        JOptionPane.YES_NO_CANCEL_OPTION
    );

    if (choix == JOptionPane.YES_OPTION) {
        enregistrerSous();
        fermerFenetre();
    } else if (choix == JOptionPane.CANCEL_OPTION) {
        return;
    } else {
        fermerFenetre();
    }
} else {
    int choix = JOptionPane.showConfirmDialog(
        this,
        "Voulez-vous enregistrer votre dernière modification avant de quitter ?",
        "Enregistrer le travail",
        JOptionPane.YES_NO_CANCEL_OPTION
    );

    if (choix == JOptionPane.YES_OPTION) {
        enregistrer();
        fermerFenetre();
    } else if (choix == JOptionPane.CANCEL_OPTION) {
        return;
    } else {
        fermerFenetre();
    }
}

dispose();  
        
    }//GEN-LAST:event_quitActionPerformed

    private void murSeulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_murSeulActionPerformed
        controller.setMurSeul();
        drawingPanel.repaint();
    }//GEN-LAST:event_murSeulActionPerformed


    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        controller.setToit();
        drawingPanel.repaint();
    }//GEN-LAST:event_jCheckBox1ActionPerformed

     private void updateTextFieldFromSlider() {
    int sliderValue = jSlider1.getValue();
    Imperial imp = Imperial.fromPixel(sliderValue);
    jTextField7.setText(Imperial.toString(imp));
}

private void updateDrawingPanelFromSlider() {
   
        int sliderValue = jSlider1.getValue();
        Imperial imp = Imperial.fromPixel(sliderValue);
        int val = imp.toPixel();

        if (val > 0) {
            drawingPanel.setGridSize(val);
            jTextField7.setText(Imperial.toString(imp));
        } 
             
    } 

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
    updateTextFieldFromSlider();  
    updateDrawingPanelFromSlider();  

    int sliderValue = jSlider1.getValue();
    Imperial imp = Imperial.fromPixel(sliderValue);
    int val = imp.toPixel();
    
    if (val > 0) {
        drawingPanel.setGridSize(val);
       }
    }//GEN-LAST:event_jSlider1StateChanged

   

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Arriere;
    private javax.swing.JTabbedPane Dessus;
    private javax.swing.JButton Droite;
    private javax.swing.JButton Facade;
    private javax.swing.JButton Gauche;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JLabel dimension_epaisseur;
    private javax.swing.JLabel dimension_epaisseurc;
    private javax.swing.JLabel dimension_h;
    private javax.swing.JLabel dimension_hc;
    private javax.swing.JLabel dimension_l;
    private javax.swing.JLabel dimension_lc;
    private javax.swing.JLabel dimension_p;
    private javax.swing.JLabel dimension_pc;
    private javax.swing.JTextField distance_validation;
    public ca.ulaval.glo2004.gui.Panels.drawingPanel drawingPanel;
    private javax.swing.JButton exporter;
    private javax.swing.JButton grid;
    private javax.swing.JPanel gridpanel;
    private javax.swing.JTextField hauteur;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JTextField largeur;
    private javax.swing.JButton load;
    private javax.swing.JCheckBox murSeul;
    private javax.swing.JButton newfile;
    private javax.swing.JTextField position_x;
    private javax.swing.JTextField position_y;
    private javax.swing.JButton quit;
    private javax.swing.JButton redo;
    private javax.swing.JButton save_as;
    private javax.swing.JButton undo;
    // End of variables declaration//GEN-END:variables
}
