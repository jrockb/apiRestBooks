package co.com.jcd.apirestbooks.backend.response;

import java.util.ArrayList;
import java.util.HashMap;

// esta clase devuelve información sobre el resultado de la operación, es general para las operaciones
public class ResponseRest {
	
	private ArrayList<HashMap<String, String>> metadata = new ArrayList<>();
	
	public ArrayList<HashMap<String, String>> getMetadata(){
		return metadata;
	}
	
	public void setMetadata(String tipo, String codigo, String date) {
		HashMap<String, String> mapa = new HashMap<>();
		mapa.put("tipo", tipo);
		mapa.put("codigo", codigo);
		mapa.put("dato", date);
		metadata.add(mapa);
	}

}
