package Converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Choisir_Operation {
	public String sql;
	
	public Choisir_Operation(String sql) {
		this.sql = sql;
	}
	
	public String executer_operation() {
		String json = "";

		/* 	DETECTER OPERATION CREATE 	*/
		Pattern pattern = Pattern.compile("CREATE", Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(this.sql);
	    boolean matchFound = matcher.find();
	    if(matchFound) {
	    	Operation_Create operation_create = new Operation_Create(this.sql);
	    	json = operation_create.convertir_en_json(); 
	    }
		
	    /* 	DETECTER OPERATION INSERT 	*/
		pattern = Pattern.compile("INSERT", Pattern.CASE_INSENSITIVE);
	    matcher = pattern.matcher(this.sql);
	    matchFound = matcher.find();
	    if(matchFound) {
	    	Operation_Insert operation_insert = new Operation_Insert(this.sql);
	    	json = operation_insert.convertir_en_json(); 
	    }
		
	    /* 	DETECTER OPERATION UPDATE 	*/
		pattern = Pattern.compile("UPDATE", Pattern.CASE_INSENSITIVE);
	    matcher = pattern.matcher(this.sql);
	    matchFound = matcher.find();
	    if(matchFound) {
	    	Operation_Update operation_update = new Operation_Update(this.sql);
	    	json = operation_update.convertir_en_json(); 
	    }
		

	    /* 	DETECTER OPERATION DELETE 	*/
		pattern = Pattern.compile("DELETE", Pattern.CASE_INSENSITIVE);
	    matcher = pattern.matcher(this.sql);
	    matchFound = matcher.find();
	    if(matchFound) {
	    	Operation_Delete operation_delete = new Operation_Delete(this.sql);
	    	json = operation_delete.convertir_en_json(); 
	    }
		
	    
		return json;
	}
}
