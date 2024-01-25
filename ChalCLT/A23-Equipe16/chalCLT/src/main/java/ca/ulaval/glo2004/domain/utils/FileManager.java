/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.ulaval.glo2004.domain.utils;


import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Files;

/**
 *
 * @author charlescareau
 */
public class FileManager {
    
    public static String path = "";
    
    
    public static void save_as(Serializable chal, String newpath) throws Exception
    {
    try (ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(Paths.get(newpath))))
    {
    path = newpath;
    os.writeObject(chal);
    
    }
    
    }
    
    
    public static void save(Serializable chal) throws Exception
    {
    try (ObjectOutputStream os = new ObjectOutputStream(Files.newOutputStream(Paths.get(path))))
    {
    os.writeObject(chal);
    }
    }
    
    public static Object charger_projet(String path) throws Exception
    {
    try(ObjectInputStream os = new ObjectInputStream(Files.newInputStream(Paths.get(path))))
    {
    return os.readObject();
    }
    }
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    

