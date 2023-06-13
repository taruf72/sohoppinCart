package com.shopingcart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopingcart.entity.ProductCategory;
import com.shopingcart.entity.ProductDetails;
import com.shopingcart.entity.SaveAllData;
import com.shopingcart.entity.SubProductCategeory;
import com.shopingcart.repository.ProductCategoryRepository;
import com.shopingcart.repository.ProductDetailsRepository;
import com.shopingcart.repository.SubCategoryProductRepository;

@Service
public class SaveAllServiceImpl implements SaveAllService {
	@Autowired
	private ProductCategoryRepository proCatRepo;
	@Autowired
	private SubCategoryProductRepository subProRepo;
	@Autowired
	private ProductDetailsRepository proDetailsRepo;
	
	
	
	

	@Override
	public void saveAllRecord(SaveAllData saveAll) {

	
		ProductCategory findByCatName = proCatRepo.findByCatName(saveAll.getCatName());
		SubProductCategeory findBySubCatName = subProRepo.findBySubCatName(saveAll.getSubCatName());
		ProductDetails proDet=new ProductDetails();
		ProductCategory proCat=new ProductCategory();
		SubProductCategeory subProCat=new SubProductCategeory();
		
		
		if(findByCatName==null && findBySubCatName==null) {
			System.out.println("error-0");
			proCat.setCatName(saveAll.getCatName());
			proCatRepo.save(proCat);
			
			subProCat.setSubCatName(saveAll.getSubCatName());
			subProCat.setCatRefId(proCat.getCatId());
			subProRepo.save(subProCat);
			
			proDet.setCatRefId(proCat.getCatId());
			proDet.setSubCatRefId(subProCat.getSubCatId());
			proDet.setProName(saveAll.getProName());
			proDet.setProPrice(saveAll.getProPrice());
			
			proDetailsRepo.save(proDet);
			
		}
		
		if(findByCatName!=null && findBySubCatName==null)
		{
			
			System.out.print("error-1");
			proCat.setCatName(saveAll.getCatName());
			proCatRepo.save(proCat);
			
			subProCat.setSubCatName(saveAll.getSubCatName());
			subProCat.setCatRefId(findByCatName.getCatId());
			subProRepo.save(subProCat);
			
		proDet.setCatRefId(findByCatName.getCatId());
		proDet.setSubCatRefId(subProCat.getSubCatId());
		proDet.setProName(saveAll.getProName());
		proDet.setProPrice(saveAll.getProPrice());
		
		proDetailsRepo.save(proDet);
		System.out.println("error-2");
		}
		

		else  {
			System.out.println("error-3");
			proCat.setCatName(saveAll.getCatName());
			proCatRepo.save(proCat);
			
			subProCat.setSubCatName(saveAll.getSubCatName());
			subProCat.setCatRefId(proCat.getCatId());
			subProRepo.save(subProCat);
			
			proDet.setCatRefId(proCat.getCatId());
			proDet.setSubCatRefId(subProCat.getSubCatId());
			proDet.setProName(saveAll.getProName());
			proDet.setProPrice(saveAll.getProPrice());
			
			proDetailsRepo.save(proDet);
		}
		
	}

}
