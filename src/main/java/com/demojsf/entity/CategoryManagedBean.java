package com.demojsf.entity;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "categoryManagedBean")	
public class CategoryManagedBean {

	@PostConstruct
	public void innit() {
		CategoryModel categoryModel = new CategoryModel();
		this.categorys = categoryModel.findAll();
	}

	private List<Category> categorys;

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setProducts(List<Category> categorys) {
		this.categorys = categorys;
	}

	
}