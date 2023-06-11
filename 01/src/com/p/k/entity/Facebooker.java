package com.p.k.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "facebooker")
public class Facebooker extends Blogger {
	@Override
	public String postInBlog() {return "text";}
}
