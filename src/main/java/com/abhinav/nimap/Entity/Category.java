package com.abhinav.nimap.Entity;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "catogeries")
@Getter
@Setter
@NoArgsConstructor
public class Category {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;
	
	
	private String categoryType;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	private List<Product> product = new ArrayList<>();
	

}
