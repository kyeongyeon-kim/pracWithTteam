package group4getLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

class Rank {
	private int[] countMain; // 맞춘 개수(보너스 제외)
	private int[] countBonus; // 보너스 맞춘 개수
	private String[] rank; // 순위 
	private int[] lottoMain = new int[6]; // 당첨번호(보너스 제외)
	private int lottoBonus; // 당첨번호(보너스) 
	private int money; // 총 당첨금
	private List<int[]> list = new ArrayList<>();
	
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

	
	public void startMethod(List<int[]> list) {
		countMain = new int[list.size()]; // 맞춘 개수(보너스 제외)
		countBonus = new int[list.size()]; // 보너스 맞춘 개수
		rank = new String[list.size()]; // 순위 
		
		LottoNumber lottoNumber = new LottoNumber();
		
		lottoBonus = lottoNumber.getBonusNumber();
		Iterator set2 = lottoNumber.getSet().iterator();
		int c = 0;
		while(set2.hasNext()) {
			lottoMain[c] = (int) set2.next();
			c++;
		}
		
		for (int i = 0; i < list.size(); i++) {
			countMain[i] = rankMain(list.get(i), lottoNumber);
			countBonus[i] = rankBonus(list.get(i), lottoNumber);
			
		}
		
	}
	
	public Rank(List<List<Integer>> listInt) {
		for (int i = 0; i < listInt.size(); i++) {
			int[] list_ = new int[6];
			for (int j = 0; j < 6; j++) {
				list_[j] = listInt.get(i).get(j);
			}
			list.add(list_);
		}
		startMethod(list);
		rankNumber(list.size()); // + 당첨번호 오름차순 정리
		
	}
	
	public Rank(int[]... listInt){
		for (int i = 0; i < listInt.length; i++) {
			list.add(listInt[i]);
		}
		startMethod(list);
		rankNumber(list.size()); // + 당첨번호 오름차순 정리
		
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
	
	public void rankNumber(int num) { // + 당첨번호 오름차순 정리
		Arrays.sort(lottoMain);
		
		for (int i = 0; i < num; i++) { // 순위 채우기
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