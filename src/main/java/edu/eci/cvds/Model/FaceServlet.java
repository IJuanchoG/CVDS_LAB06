/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.Model;

import java.util.ArrayList;
import java.util.Random;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="guessBean")
@SessionScoped
@ApplicationScoped
public class FaceServlet {
    private Random r = new Random();
    private int numeroAdivinar,puntos;
    private String estado;
    private ArrayList<Integer> intentos;
    private boolean ganador;
    
    public FaceServlet(){
        restart();
    }
    
    public void guess(int numero) {
        if(!ganador & (numero > 20 || numero <= 0)  ) {
            setEstado("uy! te has descachado!\n Intenta con un número entre 1 y 20");		    	   
        }
        else if (!ganador & numero!=numeroAdivinar & puntos>0){            
            intentos.add(numero);
            setEstado("Incorrecto, Sigue intentando.");
            puntos -= 10000;
        }
        else if (puntos<=0){	    	   
            setEstado("Lo Siento! has perdido! :c");	         
        }
        else if(!ganador & numero==numeroAdivinar & puntos>=0){
            this.intentos.add(numero);
            setEstado("GANADOOOR!!!!!!\nTu puntaje es de: "+puntos+".");
            this.ganador = true;
        }
        else {
            setEstado("Puntos: "+puntos+". Pulse reiniciar para jugar con nosotros de nuevo.");
        }
    }
    
    public void restart() {
        this.numeroAdivinar = r.nextInt(20)+1;        
        this.estado = "Comencemos a jugar!";
        this.puntos = 100000;
        this.intentos = new ArrayList<>();
        this.ganador = false;
    }
    public int getNumeroAdivinar() {
        return numeroAdivinar;
    }
    public void setNumeroAdivinar(int numeroAdivinar) {
        this.numeroAdivinar = numeroAdivinar;
    }
    public int getNumeroIntentos() {
        return intentos.size();
    }
    public int getPuntos() {
        return puntos;
    }
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public ArrayList<Integer> getIntentos(){
        return intentos;
    }
}
