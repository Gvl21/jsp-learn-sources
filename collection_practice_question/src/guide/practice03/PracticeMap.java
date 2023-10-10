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
		while(true) {
			System.out.print(">>");
			String info = sc.nextLine();
			if (info.equals("q")) break;
			String[] tempArr =  info.split(",");
			if(tempArr.length != 3) {
				System.out.println("다시 입력해주세요");
				continue;
			}
			String tempCity = tempArr[0].trim();
			Double tempLon = Double.parseDouble(tempArr[1].trim());
			Double tempLat = Double.parseDouble(tempArr[2].trim());
			manage.put(tempCity, new Location(tempLon,tempLat));			
		}
		System.out.println("------------------------------------");
        Set<String> keySet = manage.keySet();
        for (String key : keySet) {
            Location location = manage.get(key);
            System.out.println(key + " " + location.getLongitude() + " " + location.getLatitude() );
        }
        System.out.println("------------------------------------");
		while(true) {
			System.out.print("도시 이름 ( q는 종료 ) >> ");
			String search = sc.nextLine();
			if (search.equals("q")) break;
			if(manage.containsKey(search)) {
				Location location = manage.get(search);
				System.out.println(search + "  Location [ 경도=" + location.getLongitude() + ",  위도=" + location.getLatitude() + "]");
			} else System.out.println(search + "는(은) 없습니다.");
		
		}
	
		
		sc.close();
		
		
		System.out.println("시스템 종료");
	}

}
