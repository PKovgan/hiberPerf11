package com.p.k.entity;

import javax.persistence.Entity;

@Entity
public class Instagrammer extends Blogger{
	@Override
	public String postInBlog() {return "photo";}
}
