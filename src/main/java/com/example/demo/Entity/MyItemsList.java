package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cart")
public class MyItemsList {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;

private String name;
private int count;
private double price;

public MyItemsList(int id, String name, int count, double price) {
	super();
	this.id = id;
	this.name = name;
	this.count = count;
	this.price = price;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public MyItemsList() {
	super();
}

}
