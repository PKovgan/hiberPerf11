package com.p.k.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "insta")
public class Instagrammer extends Blogger{
	@Override
	public String postInBlog() {return "photo";}
}
