package br.com.caelum.vraptor.musicjungle.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {

	@Id
	private String name;
}