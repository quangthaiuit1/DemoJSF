// default package
// Generated Nov 18, 2019 1:52:48 PM by Hibernate Tools 5.1.10.Final
package com.demojsf.entity;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product", catalog = "shopdan")
public class Product implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String description;
	private BigDecimal price;
	private int categoryId;
	private int producttypeId;
	private Date createdDate;
	private Date modifiedDate;
	private String createdBy;
	private String modifiedBy;
	private String imageName;
	private byte[] imageData;
	private String productcol;

	public Product() {
	}

	public Product(String name, BigDecimal price, int categoryId, int producttypeId, String imageName,
			byte[] imageData) {
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
		this.producttypeId = producttypeId;
		this.imageName = imageName;
		this.imageData = imageData;
	}

	public Product(String name, String description, BigDecimal price, int categoryId, int producttypeId,
			Date createdDate, Date modifiedDate, String createdBy, String modifiedBy, String imageName,
			byte[] imageData, String productcol) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.categoryId = categoryId;
		this.producttypeId = producttypeId;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.imageName = imageName;
		this.imageData = imageData;
		this.productcol = productcol;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "price", nullable = false, precision = 65, scale = 0)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "category_id", nullable = false)
	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "producttype_id", nullable = false)
	public int getProducttypeId() {
		return this.producttypeId;
	}

	public void setProducttypeId(int producttypeId) {
		this.producttypeId = producttypeId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", length = 26)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date", length = 26)
	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Column(name = "created_by")
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "modified_by")
	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Column(name = "image_name", nullable = false)
	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Column(name = "image_data", nullable = false)
	public byte[] getImageData() {
		return this.imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	@Column(name = "productcol", length = 45)
	public String getProductcol() {
		return this.productcol;
	}

	public void setProductcol(String productcol) {
		this.productcol = productcol;
	}

}