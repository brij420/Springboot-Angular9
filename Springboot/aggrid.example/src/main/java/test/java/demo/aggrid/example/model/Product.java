package test.java.demo.aggrid.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

    private long id;
    private String city;
    private String start_date;
    private String end_date;
    private String price;
    private String status;
    private String color;
 
    public Product() {
  
    }
 
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
 
    @Column(name = "city", nullable = false)
    public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}

	 @Column(name = "start_date", nullable = false)
	public String getStart_date() {
		return start_date;
	}


	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	@Column(name = "end_date", nullable = false)
	public String getEnd_date() {
		return end_date;
	}


	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	@Column(name = "price", nullable = false)
	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}

	@Column(name = "status", nullable = false)
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "color", nullable = false)
	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	@Override
    public String toString() {
        return "Employee [id=" + id + ", city=" + city + ", color=" + color + ", status=" + status + ", price=" + price
       + "]";
    }
 
}