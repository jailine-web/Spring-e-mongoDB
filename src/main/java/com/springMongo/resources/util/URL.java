package com.springMongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class URL {

	
	public static String decodificador(String texto) {
		
		try {
			return URLDecoder.decode(texto, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static java.util.Date convesaoDaData(String textoData, java.util.Date valorPadrao){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		try {
			return sdf.parse(textoData);
		} catch (ParseException e) {
			return valorPadrao;
		}
		
	}
}
