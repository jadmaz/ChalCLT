/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
 
package ca.ulaval.glo2004.domain.utils;
 
import ca.ulaval.glo2004.domain.Chalet;
import java.util.Stack;
 
 
public class UndoRedoManager {
    public static Stack<Object> arriere = new Stack<>();
    public static Stack<Object> avant = new Stack<>();
    public static Stack<Object> arriere1 = new Stack<>();
    public static Stack<Object> avant1 = new Stack<>();
    public static Stack<String> pile = new Stack<>();
    public static Stack<String> pileredo = new Stack<>();
 
    public static void sauvegardeArriere(Object chaletASauvegarder) {
        arriere.push(chaletASauvegarder);
        avant.clear();
        pile.push("chalet");
    }
    public static void sauvegardeMur(Object murASauvegarder) {
        arriere1.push(murASauvegarder);
        avant1.clear();
        pile.push("mur");
    }
 
    public static Object undo(Object chaletASauvegarder, Object murASauvegarder) {
    if (arriere.size() > 0 && pile.size() > 0 && pile.peek().equals("chalet")) {
        avant.push(chaletASauvegarder);
        pileredo.push(pile.pop());  // Pop the stack only once
        return arriere.pop();
    }
    if (arriere1.size() > 0 && pile.size() > 0 && pile.peek().equals("mur")) {
        avant1.push(murASauvegarder);
        pileredo.push(pile.pop());  // Pop the stack only once
        return arriere1.pop();
    } else {
        return null;
    }
}
 
public static Object redo(Object chaletASauvegarder, Object murASauvegarder) {
    if (pileredo.size() > 0) {
        String action = pileredo.pop();  // Store the result of pileredo.pop() in a variable
 
        if (action.equals("chalet") && avant.size() > 0) {
            arriere.push(chaletASauvegarder);
            pile.push(action);  // Push the action back onto the pile stack
            return avant.pop();
        }
        if (action.equals("mur") && avant1.size() > 0) {
            arriere1.push(murASauvegarder);
            pile.push(action);  // Push the action back onto the pile stack
            return avant1.pop();
        }
    }
    return null;
}
}