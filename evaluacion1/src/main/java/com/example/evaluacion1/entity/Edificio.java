package com.example.evaluacion1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="edificios")
public class Edificio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String denominacion;
	private byte nPlantas;
	private String calle;
	private boolean habitable;
	private char tipo;
	
	public Edificio(Long id, String denominacion, byte nPlantas, String calle, boolean habitable, char tipo) {
		this.id = id;
		this.denominacion = denominacion;
		this.nPlantas = nPlantas;
		this.calle = calle;
		this.habitable = habitable;
		this.tipo = tipo;
	}

	public Edificio() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public byte getnPlantas() {
		return nPlantas;
	}

	public void setnPlantas(byte nPlantas) {
		this.nPlantas = nPlantas;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public boolean isHabitable() {
		return habitable;
	}

	public void setHabitable(boolean habitable) {
		this.habitable = habitable;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
	
}
