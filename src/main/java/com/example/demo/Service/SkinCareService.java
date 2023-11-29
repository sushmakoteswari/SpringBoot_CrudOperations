package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.SkinCare;
import com.example.demo.Repository.MartRepository;

@Service
public class SkinCareService {
	
	@Autowired
	private MartRepository brepo;
	
	public void save(SkinCare s) {
		brepo.save(s);
	}
	
	public List<SkinCare> getAllItems(){
		return brepo.findAll();
		}
	
	public SkinCare getItemByID(int id) {
		return brepo.findById(id).get();
	}
	
	public void deleteById(int id) {
		brepo.deleteById(id);
	}
}
