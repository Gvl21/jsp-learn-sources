package guide.practice01;

import java.util.Scanner;
import java.util.TreeSet;

public class SetExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 코드 작성
		/*
		TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
			// alt + s + v
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				//return o1-o2;	// 오름차순
				return o2-o1;	// 내림차순
			}
		});
*/
		TreeSet<Integer> set = new TreeSet<>((o1,o2)->{
			return o2-o1;
		});
		
		
		
		
		
		System.out.println("wjdtn~``323322323");
		
		while(true) {
			int n = sc.nextInt();
			if(n==-1) break;
			set.add(n);
		}
		if(set.isEmpty()) {
			System.out.println("저장된 값이 없습니다.");
			System.out.println("시스템 종료");
			// 트리셋
			sc.close();
			return;
		}
		int max = set.last();
		int min = set.first();
		System.out.println(set);
		System.out.println("최소값 : " + min);
		System.out.println("최대값 : " + max);
		System.out.println("시스템 종료");
		
		
	}

}
