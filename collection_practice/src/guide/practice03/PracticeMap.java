package guide.practice03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PracticeMap {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		/**
		 * 도시별 경도 위도를 저장할 map 객체
		 */
		Map<String,Location> manage = new HashMap<>();
		
		System.out.println("도시, 경도, 위도를 한번에 입력해주세요.(q는 입력완료)");
		
		// 코드 작성
		
		while(true)
		{
			System.out.print(">> ");
			// 도시이름, 경도, 위도
			String strs = sc.nextLine();
			if(strs.equals("q")) break;
			// [도시이름][경도][위도]
			String[] s = strs.split(",");
			if(s.length != 3) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			// 도시이름
			String city = s[0].trim();
			// 경도
			String lon = s[1].trim();
			// 위도
			String lat = s[2].trim();
			
			double longitude = Double.parseDouble(lon);
			double latitude = Double.parseDouble(lat);
			
			Location location = new Location(longitude, latitude);
			manage.put(city, location);
		} // end while
		System.out.println("--------------------------------------");
		Set<String> keySet = manage.keySet();
		for(String k : keySet) {
			Location l = manage.get(k);
			System.out.printf("%s %.1f, %.1f %n",k,l.getLongitude(),l.getLatitude());
		} // 등록한 정보 출력 end
		System.out.println("--------------------------------------");
		while(true) {
			System.out.println("도시이름 (q는 종료) >> ");
			String city = sc.next();
			if(city.equals("q")) break;
			if(manage.containsKey(city)) {
				// 동일한 도시이름이 key값으로 존재
				Location l = manage.get(city);
				System.out.println(city + " " + l);
			} else System.out.println(city + "는(은) 없습니다.");
		}
		
		
		System.out.println("시스템 종료");
	}

}
