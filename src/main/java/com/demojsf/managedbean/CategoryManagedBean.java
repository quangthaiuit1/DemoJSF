package com.demojsf.managedbean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.demojsf.entity.*;
import com.demojsf.model.*;

@SessionScoped
@ManagedBean(name = "categoryManagedBean")
public class CategoryManagedBean {

	private List<Category> categorys;

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

	public CategoryManagedBean() {
		CategoryModel categoryModel = new CategoryModel();
		this.categorys = categoryModel.findAll();
	}

}