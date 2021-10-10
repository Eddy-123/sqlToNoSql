package Converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operation_Update {
	String sql = "";
	public Operation_Update(String sql) {
		this.sql = sql;
	}
	public String convertir_en_json() {
		String sql = this.sql;
		String json = "";
		
		//String json = "db.users.update({first_name: \"Eddy\"},{$set: {age: \"23\"}},{multi: true});";
	    json = sql.replace(";", "");
	    json = json.replaceAll("UPDATE\\s([^<]*)SET", "db.$1.update({\\$set:{");
	    json = json.replaceAll("=", ":");
	    json = json.replaceFirst("WHERE", "}, {");
	    
	    String[] words=json.split("\\(");//splits the string based on whitespace  
	    String update_statement = words[0], set = words[1].split(",")[0], condition = words[1].split(",")[1];
	    condition = condition + "}";
	  
	    json = update_statement + "(" + condition + "," + set + "});";	    
	    
	    json = json.replaceFirst("AND", "}, {");
	    json = json.replaceFirst("OR", "}, {");
		//System.out.println("Fonction Convertir en json de opération update");
		return json;
	}
}
