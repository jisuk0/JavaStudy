package ch11_java_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CoinMain {
	public static void main(String[] args) throws IOException, ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.println("===========코인정보 시스템입니다.===========");
		// 1. 코인 종목코드 출력
		String coinInfoUr1 = "https://api.upbit.com/v1/market/all";

		URL url = new URL(coinInfoUr1);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		// 요청 방식설정
		conn.setRequestMethod("GET");
		conn.setReadTimeout(5000); // 5초까지 기다림
		int resCode = conn.getResponseCode(); // 응답에 따른 요청 코드 리턴(200정상)
		if (resCode == 200) {
			System.out.println(resCode);
			// 실시간 스트리밍 데이터를 읽어오기
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			// 내용이 없을떄까지 담기
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response);
			// json 데이터 형태로 읽어서 객체화 하기
			JSONParser parser = new JSONParser();
			JSONArray jsonArr = (JSONArray) parser.parse(response.toString());
			for (Object object : jsonArr) {
				JSONObject obj = (JSONObject) object;
				System.out.println("market: " + obj.get("market"));
				System.out.println("kor: " + obj.get("korean_name"));
			}
			while (true) {
				System.out.println("\n 어떤 종목을 보여드릴까요?(end:q)");
				String msg = scan.nextLine();
				if (msg.equalsIgnoreCase("q")) {
					System.out.println("=======종료=======");
					break;
				}
				// 2. 해당 코인의 최저가(low), 최고가(high), 현재가(trade) 출력
				String userInput = scan.nextLine();
				System.out.println("상세 정보 =====================");
				JSONObject resultObj = getCoin(userInput);
				if (resultObj != null) {
					
					Double tradePrice = (double)resultObj.get("trade_price"); 
					Double highPrice = (double)resultObj.get("high_price"); 
					Double lowPrice = (double)resultObj.get("low_price");
					System.out.println(userInput+"의 정보입니다.");
					System.out.println("현재일자: " + resultObj.get("trade_date"));
					if (userInput.startsWith("KRW")) {
						System.out.println("현재가: " + tradePrice + "원");
						System.out.println("최고가: " + highPrice + "원");
						System.out.println("최저가: " + lowPrice + "원");
					} else if (userInput.startsWith("USDT")){
						System.out.println("현재가: " + tradePrice + "달러");
						System.out.println("최고가: " + highPrice + "달러");
						System.out.println("최저가: " + lowPrice + "달러");
					} else if (userInput.startsWith("BTC")) {
						System.out.println("현재가: " + tradePrice + "BTC");
						System.out.println("최고가: " + highPrice + "BTC");
						System.out.println("최저가: " + lowPrice + "BTC");	
					} else {
					System.out.println("해당 코인정보를 찾을수없습니다");
					}
				}
			}
		}
	}
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