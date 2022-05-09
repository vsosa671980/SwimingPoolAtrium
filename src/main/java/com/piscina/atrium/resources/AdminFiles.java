package com.piscina.atrium.resources;

import java.io.File;
import java.io.IOException;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.piscina.atrium.models.Users;

@Component
public class AdminFiles {
	
	//Creamos un metodo para Subir archivos
	
	 public boolean saveFile(MultipartFile multipartFile,Long id){
	        boolean result = false;
	        //Obtenemos el nombre de el archivo para subir
	        String fileName  = id + "-" + multipartFile.getOriginalFilename() ;
	        //Ruta relativa donde se van a guardar los ficheros
	        String location = "/Users/vicentesosa/Documents/Programacion/Spring/SwimingPool/src/main/resources/static/images/";
	        //Creamos la ruta relativa donde se van a guardar los archivos
	        File pathFile = new File(location);
	        //Comprobamos si existe el directorio en caso que no exista lo creamos
	        if(!pathFile.exists()){
	            pathFile.mkdir();
	        }

	        //Creamos la ruta absoluta de el archivo
	        pathFile = new File(location + fileName);
	        //Guardamos el archivo en la ruta que le indicamos
	        try {
	            multipartFile.transferTo(pathFile);
	            result = true;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	
	
	//Creamos metodo para eliminar los archivos
	
	
	public boolean deleteFile(String filename) {
		
		
		
		//Creamos variable de resultado
		
		boolean result = false;
		
		
		//Indicamos la ruta relativa donde se encuentran los archivos
		String location = "/Users/vicentesosa/Documents/Programacion/Spring/SwimingPool/src/main/resources/static/images/";
        
		//Indicamos la ruta absoluta de el archivo
		
		File pathfile = new File(location + filename);
		
		//Borramos el archivo
		
		
		try {
			pathfile.delete();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	
			
		
	}

}
