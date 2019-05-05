package Functions;

import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;


import Models.Coordinate;

public class PlacesFunctions {
	private static final String OPEN_CAGE_API_KEY = "16e29de3c52f47e8ad39d0dca7f47882";
	
	public static double calculateDistance(Coordinate firstCor, Coordinate secondCor) {
		final int R = 6371;
		double latDistance = Math.toRadians(secondCor.getLat() - firstCor.getLat());
		double lonDistance = Math.toRadians(secondCor.getLon() - secondCor.getLon());
		double crd = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(firstCor.getLat())) * Math.cos(Math.toRadians(secondCor.getLat()))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		double points = 2 * Math.atan2(Math.sqrt(crd),Math.sqrt(1 - crd));
		double distance = R * points;
		return distance;
	}
	
	public static Coordinate getLatLongFromAdresse(String adresse) {
		
		Coordinate coordinate = null;
		//adresse = adresse.replace(",","%2C");
		try {
			adresse = URLEncoder.encode(adresse,"UTF-8");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String url = "https://api.opencagedata.com/geocode/v1/json?q=" + adresse
				+"&countrycode=dz&key=" + OPEN_CAGE_API_KEY+"&language=fr&pretty=1";
		String jsonData = ImportantFunctions.dataToJson(url);
		try {
			JSONObject object = new JSONObject(jsonData);
			JSONArray results = object.getJSONArray("results");
			JSONObject bigConfidence = results.getJSONObject(0);
			JSONObject geometry = bigConfidence.getJSONObject("geometry");
			double lat = geometry.getDouble("lat");
			double lng = geometry.getDouble("lng");
			coordinate = new Coordinate(lat, lng);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return coordinate;
	}
        
        public static double calculatePrixLivraison(double distance){
            if(distance == 0 && distance <= 2.5){
                return 50.0;
            }else if(distance >2.5 && distance <= 8){
                return 100.0;
            }else if(distance > 8 && distance <= 15){
                return 150.0;
            }else if(distance > 15 & distance <= 20){
                return 200.0;
            }else if(distance > 20 & distance <= 25){
                return 250.0;
            }else if(distance > 25){
                return 400.0;
            }else{
                return 400.0;
            }
        }
}
