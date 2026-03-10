package jdbc.entity;

public class Restorent {
	private long id;
	private String name;
	private String loc;
	private String fooditems;
	private String rating;
	private String des;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getFooditems() {
		return fooditems;
	}

	public void setFooditems(String fooditems) {
		this.fooditems = fooditems;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	@Override
	public String toString() {
		return "Restorent [id=" + id + ", name=" + name + ", loc=" + loc + ", fooditems=" + fooditems + ", rating="
				+ rating + ", des=" + des + "]";
	}

}
