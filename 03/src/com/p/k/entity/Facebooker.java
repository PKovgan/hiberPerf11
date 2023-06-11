package com.p.k.entity;

import javax.persistence.Entity;

@Entity
public class Facebooker extends Blogger {
	@Override
	public String postInBlog() {return "text";}
}
