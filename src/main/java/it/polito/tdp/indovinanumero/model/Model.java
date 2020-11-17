package it.polito.tdp.indovinanumero.model;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;

public class Model {

	private final int NMAX = 100;
	private final int TMAX = 8;
	private int segreto;
	private int tentativiFatti;
	private boolean inGioco;
	
	private Set<Integer> t;
	
	public Model() {
		this.inGioco  = false;
		this.tentativiFatti = 0;
		
	}
	
	public void nuovaPartita() {
		
		//GESTIONE INZIO NUOVA PARTITA
    	this.segreto = (int)(Math.random() * NMAX) +1;
    	this.tentativiFatti = 0;
    	this.inGioco = true;
    	this.t = new HashSet<Integer>();
    	
	}
	
	public int tentativo(int tentativo) {
		
		//CONTROLLO SE LA APRTITA E' EFFETTIVAMENTE IN CORSO
		if(!inGioco) {
			throw new IllegalStateException("La partita è già terminata\n");
		}
		
		//CONTROLLO INPUT-numero nell'intervallo 1-100
		if(tentativo < 1 || tentativo > NMAX) {
			throw new InvalidParameterException("Devi inserire un numero tra 1 ed "+NMAX);
		}
		
    	this.tentativiFatti ++;
    	this.t.add(tentativo);
    	
    	if(this.tentativiFatti == TMAX) {
    		this.inGioco = false;
    	}
    	
    	if(tentativo == this.segreto) {
    		this.inGioco = false;
    		return 0;
    		
    	}
    	
    	if(tentativo < this.segreto)
    		return -1;
    	else
    		return 1;
	}
	
	public int getTMAX() {
		// TODO Auto-generated method stub
		return this.TMAX;
	}

	public int getTentativiFatti() {
		// TODO Auto-generated method stub
		return this.tentativiFatti;
	}

	
}
