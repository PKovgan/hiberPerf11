package com.p.k.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Blogger {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	public void setName(String name) {this.name = name;}
	public abstract String postInBlog();
	@Override
	public String toString() {return name + " posting " + postInBlog() + " in blog.";}
}
