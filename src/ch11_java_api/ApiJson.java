package ch11_java_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApiJson {
	
	public static void main(String[] args) throws Exception {
		//upbit rest api 코인 종목 리스트를 제공함 get 방식에 json 데이터 형태로
		//json(Javascript Object Notation)
		//데이터를 저장하고 교환하는데 사용되는 경량 데이터 형식 속성-값 쌍으로 이루어져있음
		String coinInfoUr1 = "https://api.upbit.com/v1/market/all";
		
		URL url = new URL(coinInfoUr1);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		//요청 방식설정
		conn.setRequestMethod("GET");
		conn.setReadTimeout(5000); //5초까지 기다림
		int resCode = conn.getResponseCode(); //응답에 따른 요청 코드 리턴(200정상)
		if(resCode == 200) {
			System.out.println(resCode);
			//실시간 스트리밍 데이터를 읽어오기
			BufferedReader in =
					new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			//내용이 없을떄까지 담기
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response);
			//json 데이터 형태로 읽어서 객체화 하기
			JSONParser parser = new JSONParser();
			JSONArray jsonArr = (JSONArray) parser.parse(response.toString());
			for (Object object: jsonArr) {
				JSONObject obj = (JSONObject) object;
				System.out.println("market: " + obj.get("market"));
				System.out.println("kor: " + obj.get("korean_name"));
			}
			System.out.println("상세 정보 =====================");
			JSONObject resultObj = getCoin("KRW-BTC");
			System.out.println(resultObj.get("trade_date"));
			System.out.println(resultObj.get("trade_price"));
			
			DecimalFormat format = new DecimalFormat("#,###,##");
			System.out.println(format.format(resultObj.get("trade_price")));
		}
	}
	//input: String(코인코드)
	//output: JSONObject(해당 코인 현재정보)
	public static JSONObject getCoin(String code) throws IOException, ParseException {
		String detailURL = "https://api.upbit.com/v1/ticker?markets=" + code;
		JSONObject obj = null;
		URL url = new URL(detailURL);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		int resCode = conn.getResponseCode();
		if(resCode == 200) {
			BufferedReader in =
					new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer res = new StringBuffer();
			while((inputLine = in.readLine()) != null) {
				res.append(inputLine);
			}
			in.close();
			JSONParser parser = new JSONParser();
			JSONArray arr = (JSONArray) parser.parse(res.toString());
			obj = (JSONObject) arr.get(0);
		}
		return obj;
	}
}
