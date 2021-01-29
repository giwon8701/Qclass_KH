package com.test04;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MTest01 {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();

		for (int i = 111; i < 116; i++) {
			// map.put(k, v);
			map.put(i, i + "abc");
		}
		System.out.println(map);
		System.out.println(map.get(111));
		map.put(111, "115abc");
		System.out.println(map);
		
		prn(map);
	}
	
	public static void prn(Map<Integer, String> map) {
		Collection<String> values = map.values();
		System.out.println(values);
		
		Set<Integer> keys = map.keySet();
		System.out.println(keys);
		
		// Entry : K와 V를 같이 관리
		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
		// Entry<K,v>라는 객체들을 Set으로 관리하겠다.
		// Map은 k를 통해서 v를 가지고 올 수 있음. (map.get(k) -> value)
		// Entry는 k와 v를 각각 가지고 올 수 있음. (entry.getKey(), entry.getValue())
		
		for (Entry<Integer, String> entry : entrySet) {
			System.out.printf("%d : %s\n", entry.getKey(), entry.getValue());
		}
		
	}

}
