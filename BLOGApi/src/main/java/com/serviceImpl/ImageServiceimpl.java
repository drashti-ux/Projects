package com.serviceImpl;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.service.ImageService;

@Service

public class ImageServiceimpl implements ImageService{
	
	

	@Override
	public String uploadImage(String path, MultipartFile file) {
		// TODO Auto-generated method stub
		String name = file.getOriginalFilename();
		String filename = System.currentTimeMillis() + "_"+name;
		
		String filepath = path+File.separator+filename;
		
		File f = new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		
		try {
			Files.copy(file.getInputStream(),Paths.get(filepath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filename;
		
	}
	

	@Override
	public InputStream getImage(String path, String filename) {
		// TODO Auto-generated method stub
		InputStream is = null;
		
		try {
			String imagepath = path+File.separator+filename;
			is = new FileInputStream(imagepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return is;
	}

}
