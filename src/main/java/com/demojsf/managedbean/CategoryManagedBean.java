package com.demojsf.managedbean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import com.demojsf.entity.Category;
import com.demojsf.model.CategoryModel;


@ManagedBean(name = "categoryManagedBean")
@RequestScoped
public class CategoryManagedBean {
	private String name;
	private List<Category> categorys;
	private List<Category> listCategory ;
	private Category selectedCategory ;
	private Category category; 
	private int id;
	
	public CategoryManagedBean() {
		category = new Category();
		setSelectedCategory(new Category());
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}


	public void addCategory() {
		CategoryModel categoryModel = new CategoryModel();
		categoryModel.addCategory(this.name);
		System.out.println("Đã Add");
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Information", "Thêm thành công .");  
		PrimeFaces.current().dialog().showMessageDynamic(message);
	}
	public String returnIndex() {
		return "index.xhtml?faces-redirect=true";
	}
	public List<Category> findAll(){
		CategoryModel categoryModel = new CategoryModel();
		this.listCategory = categoryModel.findAll();
		return listCategory;
	}
	public void viewUpdateCategory(int categoryId) {
        Map<String,Object> options = new HashMap<String, Object>();
        this.id = categoryId;
        options.put("resizable", false);
        PrimeFaces.current().dialog().openDynamic("updateCategory", options, null);
    }
	public void updateCategory() {
		CategoryModel categoryModel = new CategoryModel();
		categoryModel.updateCategory(this.selectedCategory.getName(),this.selectedCategory.getId());
		System.out.println("Đã sửa xong");
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Update", "Cập nhật thành công.");  
		PrimeFaces.current().dialog().showMessageDynamic(message);
	}
	public void deleteCategory(int id) {
		CategoryModel categoryModel = new CategoryModel();
		categoryModel.deleteCategory(id);
		System.out.println("Đã xóa xong");
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete", "Xóa thành công .");  
		PrimeFaces.current().dialog().showMessageDynamic(message);
	}
	public Category findById(int categoryId) {
		CategoryModel categoryModel = new CategoryModel();
		this.category = categoryModel.findById(categoryId);
		return this.category;
	}
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public Category getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(Category selectedCategory) {
		this.selectedCategory = selectedCategory;
	}


}