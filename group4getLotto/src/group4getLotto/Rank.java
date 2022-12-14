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
	private int[] lottoMain; // 당첨번호(보너스 제외)
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

	
	
	public Rank(List[] listInt){
		countMain = new int[5]; // 맞춘 개수(보너스 제외)
		countBonus = new int[5]; // 보너스 맞춘 개수
		rank = new String[5]; // 순위 
		LottoNumber lottoNumber = new LottoNumber();
		
		lottoBonus = lottoNumber.getBonusNumber();
		lottoMain = lottoNumber.getIntList();
		
		for (int i = 0; i < 5; i++) {
			countMain[i] = rankMain(listInt[i]);
			countBonus[i] = rankBonus(listInt[i], lottoNumber);
		}
		rankNumber(); // + 당첨번호 오름차순 정리
		
	}
	
	public int rankMain(List list) {
		int number = 0;
		for (int j = 0; j < 6; j++) {
			for (int i = 0; i < 6; i++) {
				if ((int) list.get(i) == lottoMain[j]) {
					number++;
				}
			}
		}
		return number;
	}
	
	public void rankNumber() { // + 당첨번호 오름차순 정리
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
	
	public int rankBonus(List list, LottoNumber lottoNumber) {
		int bonus = 0;
		for (int i = 0; i < 6; i++) {
			if (lottoNumber.getBonusNumber() == (int) list.get(i)) {
				bonus++;
			}
		}
		return bonus;
	}
	
}

class LottoNumber {
	private int bonusNumber;
	private int[] intList;
	
	public int getBonusNumber() {
		return bonusNumber;
	}

	public void setBonusNumber(int bonusNumber) {
		this.bonusNumber = bonusNumber;
	}

	public int[] getIntList() {
		return intList;
	}

	public void setIntList(int[] intList) {
		this.intList = intList;
	}

	public LottoNumber() {
		Random random = new Random();
		int num;
		intList = new int[6];
		
		for (int j = 0; j < 6; j++) {
			num = random.nextInt(45) + 1;
			boolean sw = true;
			for (int i = 0; i < 6; i++) {
				if (intList[i] == num) {
					sw = false;
				}
			}
			if (sw) {
				intList[j] = num;
			} else {
				j--;
			}
		}
		
		bonusNumber = 0;
		while (true) {
			num = random.nextInt(45) + 1;
			
			boolean sw = true;
			for (int i = 0; i < 6; i++) {
				if (intList[i] == num) {
					sw = false;
				}
			}
			if (sw) {
				bonusNumber = num;
			}
			if (bonusNumber > 0) {
				break;
			}
			
		}
		
		
	}
	
}