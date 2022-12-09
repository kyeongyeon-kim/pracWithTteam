//package group4getLotto;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//	public static void main(String[] args) {
//		
//		int[] list1 = {1, 5, 11 ,12, 30, 45};
//		int[] list2 = {4, 15, 10 ,17, 39, 41};
//		int[] list3 = {5, 35, 11 ,20, 32, 15};
//		int[] list4 = {7, 13, 17 ,15, 40, 44};
//		int[] list5 = {9, 15, 40 ,19, 33, 25};
//		// 개수 조절
//		
////		List<List<Integer>> list_ = new ArrayList<>();
////		List<Integer> lista = new ArrayList<>();
////		List<Integer> listb = new ArrayList<>();
////		for (int i = 0; i < 6; i++) {
////			lista.add(i);
////			listb.add(i);
////		}
////		Rank j = new Rank(list_); // ArrayList로 o
//		
////		int[][] listSum = new int[3][5];
////		Rank k = new Rank(listSum); // 이중배열 o
//		
//		Rank r = new Rank(list1, list2, list3, list4, list5); // 배열 따로 o
//		// 개수 조절
//		
//		
//		System.out.print("당첨 번호: ");
//		for (int i = 0; i < 6; i++) {
//			System.out.print(r.getLottoMain()[i] + "   ");
//		}
//		System.out.println("보너스 번호: " + r.getLottoBonus());
//		
//		int num = 5; // 개수 조절
//		
//		for (int i = 0; i < num; i++) {
//			System.out.print("맞춘 개수: " + r.getCountMain()[i] + "   ");
//			System.out.print("보너스 여부: " + r.getCountBonus()[i] + "   ");
//			System.out.println("등수: " + r.getRank()[i]);
//		}
//		
//		System.out.println("총 당첨금: " + r.getMoney());
//	}
//}
