package group4getLotto;

public class Main {
	public static void main(String[] args) {
		
		
		int[] list1 = {1, 5, 11 ,12, 30, 45};
		int[] list2 = {4, 15, 10 ,17, 39, 41};
		int[] list3 = {5, 35, 11 ,20, 32, 15};
		int[] list4 = {7, 13, 17 ,15, 40, 44};
		int[] list5 = {9, 15, 40 ,19, 33, 25};
		
		Rank r = new Rank(list1, list2, list3, list4, list5);
		
		System.out.print("당첨 번호: ");
		for (int i = 0; i < 6; i++) {
			System.out.print(r.getLottoMain()[i] + "   ");
		}
		System.out.println("보너스 번호: " + r.getLottoBonus());
		for (int i = 0; i < 5; i++) {
			System.out.print("맞춘 개수: " + r.getCountMain()[i] + "   ");
			System.out.print("보너스 여부: " + r.getCountBonus()[i] + "   ");
			System.out.println("등수: " + r.getRank()[i]);
		}
		System.out.println("총 당첨금: " + r.getMoney());
	}
}
