/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package ca.ulaval.glo2004.domain;
 
import ca.ulaval.glo2004.domain.Chalet.vueType;
import ca.ulaval.glo2004.domain.export.*;
import ca.ulaval.glo2004.gui.*;
import ca.ulaval.glo2004.domain.utils.*;
import ca.ulaval.glo2004.domain.DTO.*;
import java.awt.Point;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;
import javax.swing.JOptionPane;


/**
*
* @author 14189
*/
public class Controleur {
 
    private Chalet chalet;
    private Murs mur;
    private Chalet chaletsauvegarde;
    public Orientation murorientation = Orientation.Gauche;
    private List<ControleurObserver> observers;
    private Accessoires accessoires;
 
    public Points position;
    public String type;
    public String mur_associe;
    public Dimensions dimension;
    public boolean is_selected;
    public boolean is_valid;
    public List<Points> pointsDessus;
    public List<Accessoires> listeAccessoires;
    public List<Murs> listmurs;
    public boolean murSeul = false;
    public boolean toit = false;
    
    //private UndoRedoManager undoRedoManager;
    public ExportSTL exportSTL;

 
    public Controleur(Chalet chalet) {
        this.chalet = chalet;
        commonInitialization();
        //this.undoRedoManager = undoRedoManager;
        //this.exportSTL = exportSTL;
    }
    public Controleur() {
        chalet = new Chalet();
        accessoires = new Accessoires(position, type, dimension, mur_associe, is_selected, is_valid);
        mur = new Murs(pointsDessus, murorientation, listeAccessoires);
        commonInitialization();
    }
 
    private void commonInitialization() {
        observers = new LinkedList<ControleurObserver>();
    }
 
    public void setSensToit(SensToit sens) {
        sauvegardeAction();
        chalet.setSensToit(sens);
    }
    public SensToit getSensToit() {
       return chalet.getSensToit();
    }
    public int getAngle(){
       return chalet.getAngleToit();
    }
    public void setMurSeul(){
        murSeul = !murSeul;
    }
    
    public void setToit(){
        toit = !toit;
    }
    
    public boolean getMurSeul(){
        return this.murSeul;
    }
    public boolean getToit(){
        return this.toit;
    }
    public void setAngle(int nouvelleAngle){
        sauvegardeAction();
        chalet.setAngleToit(nouvelleAngle);
    }
    public vueType getvueCourante() {
       return chalet.getvueCourante();
    }
    public void setVueCourante(vueType vueCourante) {
        chalet.setVueCourante(vueCourante);
    }
    public Imperial getEpaisseur() {
        return chalet.getEpaisseur();
    }
    public void setEpaisseur(Imperial nouvelleEpaisseur) {
        sauvegardeAction();
        this.chalet.setEpaisseurMur(nouvelleEpaisseur);
    }
 
    public Dimensions getDimensions() {
        return chalet.getDimensions();
    }
    public void setDistanceSupp(Imperial nouvelleDistanceSupp){
        sauvegardeAction();
        this.chalet.setDistanceSupp(nouvelleDistanceSupp);
    }
    public Imperial getDistanceSupp(){
        return chalet.getDistanceSupp();
    }
    public void setDimensions(Dimensions nouvelleDimension) {
        sauvegardeAction();
        this.mur.set_chalet(this.chalet);
        this.mur.update_position_all_accessories(nouvelleDimension);
        this.chalet.setDimensions(nouvelleDimension); 
    }
    public List<Murs> dimensionsChanged() {
        return this.chalet.initialiserMurs();
    }
    public void setListMurs(List<Murs> listmurs){
        chalet.setListmurs(listmurs);
        this.mur.set_chalet(this.chalet);
        this.mur.actualiser_position_portes();
        this.mur.validate_position_all_accessories();
    }
    public List<MursDTO> getListMurs(){
        return chalet.getListmursDTO();
    }
    public Orientation getMurOrientation() {
        return murorientation;
    }
 
    public void setMurOrientation(Orientation nouvelleOrientation) {
        this.murorientation = nouvelleOrientation;
        this.chalet.setOrientation(nouvelleOrientation);
    }
    public void export(String path,Controleur c) {

        
        try {
        exportSTL = new ExportBrut(path);
        exportSTL.generateSTL(chalet, c);

        JOptionPane.showMessageDialog(null, "Le projet a été exporté avec succès.", "Exportation STL", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception e) {
        
        JOptionPane.showMessageDialog(null, "Erreur lors de l'exportation du projet.", "Erreur d'Exportation STL", JOptionPane.ERROR_MESSAGE);
    } 
     

        exportSTL = new ExportBrut(path);
        exportSTL.generateSTL(chalet,c);             

  }
 
 

    public boolean valider_position_accessoire(Accessoires acc)
    {
    return chalet.valider_position_accessoire(acc);
    }

    public void set_distance_validation(Imperial imperial)
    {
    sauvegardeAction();
    chalet.set_distance_validation(imperial);
    mur.set_chalet(this.chalet);
    mur.set_distance_supp(imperial);
 
    }
 
    
    public Imperial get_distance_validation()
        {
    return chalet.get_distance_validation();
    }
    public void addItem(Points mousePoints, String type, Dimensions dimensions, String mur_associe, boolean is_selected, boolean is_valid) {
        sauvegardeMurAction();
        Accessoires item = null;
        if (type.equals("porte")) {
            item = new Portes(mousePoints,"porte", dimensions, mur_associe, is_selected, is_valid);
            chalet.actualiser_position_porte(item);
            if(chalet.valider_position_accessoire(item) && mur.valider_position_accessoire_acc(item))
            {
                item.set_valid();
            }
        }
        else if (type.equals("fenetre")) {
            item = new Fenetres(mousePoints, "fenetre", dimensions, mur_associe, is_selected, is_valid);
            if(chalet.valider_position_accessoire(item) && mur.valider_position_accessoire_acc(item))
            {
                item.set_valid();
            }
        }
        mur.addAccessoire(item);
    }
    public List<MursDTO> getListMursDTO()
    {
       return chalet.getListmursDTO();
    }
    public void updateMursDTO(){
        chalet.updateMursDTOList();
    }

 
    public List<AccessoiresDTO> getAccList()
    {
        return mur.getAccList();
    }
    public void setDimensionsAcc(Dimensions dimensions)
    {
      accessoires.setDimensionsAcc(dimension);
    }
    public Dimensions getDimensionsAcc()
    {
    return accessoires.getDimensionsAcc();
    }
    public void set_acc_type(String type)
    {
    accessoires.set_acc_type(type);
    }
    public String get_acc_type()
    {
    return accessoires.gettype();
    }
    public void setMursAssocie(String mur_associe)
    {
    accessoires.setMursAssocie(mur_associe);
    }
    public String getMurAssocie()
    {
    return accessoires.getMurAssocie();
    }
 
public void is_contained(Points point) {
    AccessoiresDTO selectedAccessory = null;
    for (AccessoiresDTO acc : getAccList()) {
        if (acc.isContained(point)) {
            selectedAccessory = acc;
        } else {
            acc.set_selected(false);
        }
    }
 
    if (selectedAccessory != null) {
        selectedAccessory.set_selected(true);
    }
}
 
public void deleteSelectedAccessories() {
    sauvegardeMurAction();
    mur.set_chalet(this.chalet);
    mur.deleteSelectedAccessories();
}
 
public void update_selected_accessory(Dimensions dimensions)
{   
    sauvegardeMurAction();
    mur.set_chalet(this.chalet);
    mur.updateDimensionsForSelectedAccessories(dimensions);
}
 
public Dimensions get_selected_acc_dimensions()
{
return mur.get_selected_acc_dimensions();
}
 
 
public void update_position_selected_accessory(Points point)
{
    sauvegardeMurAction();
    mur.set_chalet(this.chalet);
    mur.update_position_selected_accessories(point);
}
 
public void update_position_selected_accessory_dragged(Points point)
{
    mur.set_chalet(this.chalet);
    mur.update_position_selected_accessory_dragged(point);
}
 
public Points get_selected_acc_position()
{
return mur.get_selected_acc_position();
}
 
 
    public void sauvegardeAction() {
        try {
            UndoRedoManager.sauvegardeArriere(this.chalet.deepCopy());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void sauvegardeMurAction() {
        try {
            UndoRedoManager.sauvegardeMur(this.mur.deepCopy());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
public void undo() throws IOException, ClassNotFoundException {
    System.out.println("Taille de la pile arriere avant undo : " + UndoRedoManager.arriere.size());
    System.out.println("Taille de la pile arriere avant undo : " + UndoRedoManager.arriere1.size());
 
    Object ancienObjet = UndoRedoManager.undo(this.chalet.deepCopy(), this.mur.deepCopy());
    if (ancienObjet instanceof Chalet) {
        this.chalet = (Chalet) ancienObjet;
    } else if (ancienObjet instanceof Murs) {
        this.mur = (Murs) ancienObjet;
    }
}
public void redo() throws IOException, ClassNotFoundException {
    Object ancienObjet = UndoRedoManager.redo(this.chalet.deepCopy(), this.mur.deepCopy());
    if (ancienObjet instanceof Chalet) {
        this.chalet = (Chalet) ancienObjet;
    } else if (ancienObjet instanceof Murs) {
        this.mur = (Murs) ancienObjet;
    }
    }
public Dimensions get_concerned_object_dimensions(Points mousepoint)
{
return chalet.get_concerned_wall_dimension_topview(mousepoint);
}
 
public void save_as(String chemin) throws Exception
{
FileManager.save_as(new Save(this.chalet, this.mur, chemin), chemin);
}
 
public void charger_projet(String path) throws Exception
{
this.chalet = ((Save) FileManager.charger_projet(path)).getChalet();
this.mur = ((Save) FileManager.charger_projet(path)).getMurs();
FileManager.path = ((Save) FileManager.charger_projet(path)).getPath();
}
 
public String get_chemin()
{
return FileManager.path;
}
 
public void save()  throws Exception
{
FileManager.save(new Save(this.chalet, this.mur, FileManager.path));
}
 
}
    /*
    public Murs[] getMurs() {
        // return chalet.getMurs();  getMurs() dans la classe Chalet aussi
    }
    public void initialiserChalet(){}
    public void affichageDessus(){}
    public void affichageMurs(){}
    public void setAccessoire() {}
    public void afficheAccessoire() {}
    public void voirAccessoire() {}
    public void SélectionnerAccessoire() {}
    public void modifierAccessoire() {}
    public void deleteAccessoire() {}
    public void deplacerAccessoire() {}
    public void redimensionnerAccessoire() {}

     */