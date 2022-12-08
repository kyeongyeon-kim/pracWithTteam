package prac;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

class Rank {
	private int[] countMain = new int[5]; // 맞춘 개수(보너스 제외)
	private int[] countBonus = new int[5]; // 보너스 맞춘 개수
	private String[] rank = new String[5]; // 순위 
	private int[] lottoMain = new int[6]; // 당첨번호(보너스 제외)
	private int lottoBonus; // 당첨번호(보너스) 
	private int money; // 총 당첨금
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int[] getCountBonus() {
		return countBonus;
	}
	
	public void setCountBonus(int[] countBonus) {
		this.countBonus = countBonus;
	}
	
	public int[] getLottoMain() {
		return lottoMain;
	}
	
	public void setLottoMain(int[] lottoMain) {
		this.lottoMain = lottoMain;
	}
	
	public int getLottoBonus() {
		return lottoBonus;
	}
	
	public void setLottoBonus(int lottoBonus) {
		this.lottoBonus = lottoBonus;
	}
	
	public int[] getCountMain() {
		return countMain;
	}

	public void setCountMain(int[] count) {
		this.countMain = count;
	}

	public String[] getRank() {
		return rank;
	}

	public void setRank(String[] rank) {
		this.rank = rank;
	}

	public Rank(int[] list1, int[] list2, int[] list3, int[] list4, int[] list5){
		LottoNumber lottoNumber = new LottoNumber();
		
		lottoBonus = lottoNumber.getBonusNumber();
		Iterator set2 = lottoNumber.getSet().iterator();
		int c = 0;
		while(set2.hasNext()) {
			lottoMain[c] = (int) set2.next();
			c++;
		}
		
		
		countMain[0] = rankMain(list1, lottoNumber);
		countBonus[0] = rankBonus(list1, lottoNumber);
		countMain[1] = rankMain(list2, lottoNumber);
		countBonus[1] = rankBonus(list2, lottoNumber);
		countMain[2] = rankMain(list3, lottoNumber);
		countBonus[2] = rankBonus(list3, lottoNumber);
		countMain[3] = rankMain(list4, lottoNumber);
		countBonus[3] = rankBonus(list4, lottoNumber);
		countMain[4] = rankMain(list5, lottoNumber);
		countBonus[4] = rankBonus(list5, lottoNumber);
		
		Arrays.sort(lottoMain);
		
		for (int i = 0; i < 5; i++) { // 순위 채우기
			switch (countMain[i]) {
				case 3:
					rank[i] = "5등";
					money += 5000;
					break;
				case 4:
					rank[i] = "4등";
					money += 50000;
					break;
				case 5:
					if (countBonus[i] == 1) {
						rank[i] = "2등";
						money += 66000000;
						break;
					}
					rank[i] = "3등";
					money += 1500000;
					break;
				case 6:
					rank[i] = "1등";
					money += 1600000000;
					break;
				default:
					rank[i] = "꽝";
					break;
			}
		}
		
	}
	// 임시배열로 생성자 테스트
	public static void main(String[] args) {
		int[] list1 = new int[] {1, 2, 3, 4, 5, 6};
		int[] list2 = new int[] {1, 2, 3, 4, 5, 6};
		int[] list3 = new int[] {1, 2, 3, 4, 5, 6};
		int[] list4 = new int[] {1, 2, 3, 4, 5, 6};
		int[] list5 = new int[] {1, 2, 3, 4, 5, 6};
		Rank r = new Rank(list1, list2, list3, list4, list5);
	}
	
	public int rankMain(int[] list, LottoNumber lottoNumber) {
		Iterator<Integer> set2 = lottoNumber.getSet().iterator(); 
		int number = 0;
		while (set2.hasNext()) {
			int a = (int) set2.next();
			for (int i = 0; i < 6; i++) {
				if (list[i] == a) {
					number++;
				}
			}
		}
		return number;
	}
	
	public int rankBonus(int[] list, LottoNumber lottoNumber) {
		int bonus = 0;
		for (int i = 0; i < 6; i++) {
			if (lottoNumber.getBonusNumber() == list[i]) {
				bonus++;
			}
		}
		return bonus;
	}
	
}

class LottoNumber {
	private int bonusNumber;
	private Set<Integer> set;
	
	public int getBonusNumber() {
		return bonusNumber;
	}

	public void setBonusNumber(int bonusNumber) {
		this.bonusNumber = bonusNumber;
	}

	public Set<Integer> getSet() {
		return set;
	}

	public void setSet(Set<Integer> set) {
		this.set = set;
	}

	public LottoNumber() {
		Random random = new Random();
		int num;
		
		set = new HashSet<>();
		Iterator<Integer> set2;
		while(true) {		num = random.nextInt(45) + 1;
			set2 = set.iterator();
			boolean sw = true;
			while(set2.hasNext()) {
				if(set2.next() == num) {
					sw = false;
				}
			}
			if (sw) {
				set.add(num);
			}
			if (set.size() == 6) {
				break;
			}
		}
		num = 0;
		set2 = set.iterator();
		while (set2.hasNext()) {
			num = random.nextInt(45) + 1;
			boolean sw = true;
			if (set2.next() == num) {
				sw = false;
			}
			if (sw) {
				bonusNumber = num;
				break;
			}
		}
	}
	
}