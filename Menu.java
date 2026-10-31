package com.tap.model;
import java.sql.Timestamp;

public class Menu {
	private int MenuID;
	private int RestaurantID;
	private String ItemName;
	private String Description;
	private double Price;
	private boolean IsAvailable;
	private String Category;
	private Timestamp CreatedAt;
	private Timestamp UpdatedAt;
	private Timestamp DeletedAt;
	private String imagePath;

	public Menu() {
	}

	public Menu(int RestaurantID, String ItemName, String Description, double Price, boolean IsAvailable,
			String Category, String imagePath) {
		super();
		this.RestaurantID = RestaurantID;
		this.ItemName = ItemName;
		this.Description = Description;
		this.Price = Price;
		this.IsAvailable = IsAvailable;
		this.Category = Category;
		this.imagePath = imagePath;
	}

	public int getMenuID() {
		return MenuID;
	}

	public void setMenuID(int MenuID) {
		this.MenuID = MenuID;
	}

	public int getRestaurantID() {
		return RestaurantID;
	}

	public void setRestaurantID(int RestaurantID) {
		this.RestaurantID = RestaurantID;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String ItemName) {
		this.ItemName = ItemName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double Price) {
		this.Price = Price;
	}

	public boolean IsAvailable() {
		return IsAvailable;
	}

	public void setIsAvailable(boolean IsAvailable) {
		this.IsAvailable = IsAvailable;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String Category) {
		this.Category = Category;
	}

	public Timestamp getCreatedAt() {
		return CreatedAt;
	}

	public void setCreatedAt(Timestamp CreatedAt) {
		this.CreatedAt = CreatedAt;
	}

	public Timestamp getUpdatedAt() {
		return UpdatedAt;
	}

	public void setUpdatedAt(Timestamp UpdatedAt) {
		this.UpdatedAt = UpdatedAt;
	}

	public Timestamp getDeletedAt() {
		return DeletedAt;
	}

	public void setDeletedAt(Timestamp DeletedAt) {
		this.DeletedAt = DeletedAt;
	}
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Menu [MenuID=" + MenuID + ", RestaurantID=" + RestaurantID + ", ItemName=" + ItemName + ", Description="
				+ Description + ", Price=" + Price + ", IsAvailable=" + IsAvailable + ", Category=" + Category
				+ ", CreatedAt=" + CreatedAt + ", UpdatedAt=" + UpdatedAt + ", DeletedAt=" + DeletedAt + ", imagePath="
				+ imagePath + "]";
	}

	

}
