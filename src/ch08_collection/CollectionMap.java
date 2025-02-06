package ch08_collection;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class CollectionMap {

	public static void main(String[] args) {
		// Map 가장 많이 사용 데이터 구조중 하나
		// Key와 value 한쌍인 데이터
		HashMap<String, String>stuMap = new HashMap<>();
		//<key 문자열, value 문자열>
		stuMap.put("첫쨰", "길동");
		stuMap.put("둘쨰", "동길");
		stuMap.put("셋쨰", "길수");
		System.out.println(stuMap);
		System.out.println(stuMap.get("둘째"));
		stuMap.put("둘쨰", "동수");
		
		System.out.println(stuMap.size()); //순서는 보장하지않지만 사이즈는 가져옴
		System.out.println(stuMap.containsKey("첫째")); // 해당 key가 있으면 true
		System.out.println(stuMap.containsValue("동길")); //value가 있으면 true
		
		//map은 keySet으로 for문 사용
		Set<String> keys = stuMap.keySet();
		System.out.println(keys);
		for (String key : keys) {
			System.out.println(stuMap.get(key));
		}
		
		Set<java.util.Map.Entry<String,String>> entrySet = stuMap.entrySet();
		for(java.util.Map.Entry<String, String> entry: entrySet) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " : " + value);
		}
		
		HashMap<String, Integer> coinMap = new HashMap<>();
		coinMap.put("비트코인", 142872834);
		coinMap.put("이더리움", 34968439);
		
		for(String coin: coinMap.keySet()) {
			System.out.println(coin + " : " + coinMap.get(coin));
		}
		
		
		

	}

}
