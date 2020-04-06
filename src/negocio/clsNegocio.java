/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import model.clsModel;


public class clsNegocio {
    
    public String ejecutar(String nombre,boolean labor, boolean menor, boolean igual, boolean mayor){
        clsModel persona=new clsModel();
        persona.setNombre(nombre);
        persona.setLabora(labor);
        persona.setIngreso(this.getIngreso(menor, igual, mayor));
        persona.setCredito(evaluarCredito(persona));
        this.ArchivoAgregar(persona);
        return "el resultado del credito es: "+this.getCredito(persona.isCredito())+""
                + "\n el archivo se guardo en la ruta: C:\\Creditos\\creditos.txt";
    }
    
    public boolean evaluarCredito(clsModel persona){
        if(persona.isLabora()&&(persona.getIngreso().equals("1500")||persona.getIngreso().equals("mayor a 1500"))){
            return true;
        }else{
            return false;
        }
    }
    
    public String getIngreso(boolean menor,boolean igual,boolean mayor){
      String ingreso;
        if(menor){
            ingreso="menor a 1500";
        }else if(igual){
            ingreso="1500";
        }else{
            ingreso="mayor a 1500";
        }
        return ingreso;
    }
    
    public String getLabora(boolean labora){
        String laboral;
        if(labora){
           laboral="Si";
        }else{
            laboral="No";
        }
        return laboral;
    }
    
    public String getCredito(boolean credito){
        String credit;
        if(credito){
            credit="Aprobado";
        }else{
            credit="No Aprobado";
        }
        return credit;
    }
    
      public void ArchivoAgregar(clsModel persona)
    {
        try
        {
            File carpeta=new File("C:\\Creditos");
            File file=new File("C:\\Creditos\\creditos.txt");
            
            
            /*si el archivo no existe, se crea*/
            if(!file.exists())
            {
                carpeta.mkdirs();
                file.createNewFile();
            }
            //en esta linea, le mandamos por parametro si existe el archivo,lo agreaga
            FileWriter fw=new FileWriter(file,true);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write("caso: "+this.getCasos()+",");
            bw.write("Nombre:"+persona.getNombre()+",");
            bw.write("empleo: "+getLabora(persona.isLabora())+",");
            bw.write("Ingreso: "+persona.getIngreso()+",");
            bw.write("Credito: "+this.getCredito(persona.isCredito()));
            bw.write("\n");
            bw.close();
            
        }catch(IOException ioe)
        {
            System.out.println("no se ha opodido escribir en el archivo");
        }
    }
     
     public  int getCasos()
     {
         int contador=0;
         try
         {
             BufferedReader bf=new BufferedReader(new FileReader("C:\\Creditos\\creditos.txt"));
             String linea="";
             while(linea!=null)
             {
                 linea=bf.readLine();
                 contador++;
             }
             bf.close();
         }catch(FileNotFoundException e){
             System.out.println("No se encuentra el fichero");
         }catch(IOException e){
             return contador;
         }
         return contador;
     }
     
    
}
