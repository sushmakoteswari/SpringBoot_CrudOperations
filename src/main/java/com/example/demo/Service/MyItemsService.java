package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.MyItemsList;
import com.example.demo.Repository.MyItemsRepository;

@Service
public class MyItemsService {

	@Autowired
	private MyItemsRepository myitems;

	public void saveMyItem(MyItemsList items) {

		myitems.save(items);
	}

	public List<MyItemsList> getAllMyItems() {
		return myitems.findAll();
	}
	
	public void deletebyId(int id) {
		myitems.deleteById(id);
	}

}
