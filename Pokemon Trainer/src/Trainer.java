import java.util.ArrayList;
import java.util.Scanner;

public class Trainer{
	Scanner sc = new Scanner(System.in);
	private ArrayList<Pokemon> poke = new ArrayList<>();
	private ArrayList<Pokemon> enemy = new ArrayList<>();
	private int check = 0;
	private int makshp = 0;
	public void addPoke(Pokemon p) {
		poke.add(p);
	}
	public void addEnemy(Pokemon p) {
		enemy.add(p);
	}
	public void heal(int n) {
		for(int i = 0; i < n;i++) {
			System.out.println(i+1 + ". " + poke.get(i).getName());
		}
		int menu = 0;
		do {
			System.out.println("Which pokemon you want heal :");
			System.out.print(">> ");
			try {
				menu = sc.nextInt();
				if(menu < 1 || menu > n) {
					throw new Exception();
				}
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Input 1-"+ n +"!");
			}
		} while (menu < 1 || menu >n);
//		int makshp = 0;
//		if(poke.get(menu-1).getName().contains("Bulbasaur")) {
//			hp = 45;
//		}if(poke.get(menu-1).getName().contains("Charmander")){
//			hp = 39;
//		}if(poke.get(menu-1).getName().contains("Squirtle")) {
//			hp = 44;
//		}if(poke.get(menu-1).getName().contains("Wild Poke Grass")) {
//			hp = 40;
//		}if(poke.get(menu-1).getName().contains("Wild Poke Fire")) {
//			hp = 37;
//		}if(poke.get(menu-1).getName().contains("Wild Poke Water")) {
//			hp = 42;
//		}
		if(check==0){
			System.out.println("Your HP is Full");
			makshp = poke.get(menu-1).getHP();
			return;
		}
		double temp = poke.get(menu-1).getHP();
		System.out.println("Your Current HP: " + temp);
		do {
			if(temp>makshp){
				System.out.println("\nHP :" + makshp);
				break;
			}
			try {
				temp = (temp+(0.2*makshp));
				System.out.print(".");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}while(temp!=makshp);
		poke.get(menu-1).setHP((int) temp);
		check = 0;
	}
	public void printstat(int n) {
		for(int i = 0; i < n;i++) {
			System.out.println(poke.get(i).getName() + " Status");
			System.out.println("LVL:" + poke.get(i).getLVL());
			System.out.println("HP:" + poke.get(i).getHP());
			System.out.println("EXP:" + poke.get(i).getEXP());
			System.out.println("ATT:" + poke.get(i).getATT());
			System.out.println("DEF:" + poke.get(i).getDEF());
			System.out.println("AGL:" + poke.get(i).getAGL());
			System.out.println("TYPE:" + poke.get(i).getTYPE());
		}
	}
	
	public void battle(int m,int n){
		check = 1;
		for(int i = 0; i < n;i++) {
			System.out.println(i+1 + ". " + poke.get(i).getName());
		}
		int menu = 0;
		do {
			System.out.println("Which pokemon you want to battle :");
			System.out.print(">> ");
			try {
				menu = sc.nextInt();
				if(menu < 1 || menu > n) {
					throw new Exception();
				}
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Input 1-"+ n +"!");
			}
		} while (menu < 1 || menu > n);
		if(poke.get(menu-1).getHP()==0){
			System.out.println("Your hp is 0 so you cant battle");
			return;
		}
		String wekcrit = null;
		if(poke.get(menu-1).getTYPE().equals("grass") && enemy.get(m-3).getTYPE().equals("fire")){
			wekcrit = "weak";
		}
		if(poke.get(menu-1).getTYPE().equals("grass") && enemy.get(m-3).getTYPE().equals("water")){
			wekcrit = "critical";
		}
		if(poke.get(menu-1).getTYPE().equals("water") && enemy.get(m-3).getTYPE().equals("grass")){
			wekcrit = "weak";
		}
		if(poke.get(menu-1).getTYPE().equals("water") && enemy.get(m-3).getTYPE().equals("fire")){
			wekcrit = "critical";
		}
		if(poke.get(menu-1).getTYPE().equals("fire") && enemy.get(m-3).getTYPE().equals("water")){
			wekcrit = "weak";
		}
		if(poke.get(menu-1).getTYPE().equals("fire") && enemy.get(m-3).getTYPE().equals("grass")){
			wekcrit = "critical";
		}else {
			wekcrit = "normal";
		}
		int hp = poke.get(menu-1).getHP();
		int hpenem = enemy.get(m-3).getHP();
		do {
			System.out.println(poke.get(menu-1).getName()+" Vs " + enemy.get(m-3).getName());
			System.out.println(hp +" Vs " + hpenem);
			if(wekcrit.equals("weak")) {
				try {
					System.out.println("Your turn");
					System.out.println("Weak");
					System.out.println("You only take " + (poke.get(menu-1).getATT() * (105-enemy.get(m-3).getDEF())/100)+ " damage to enemy");
					hpenem = hpenem - (poke.get(menu-1).getATT() * (105-enemy.get(m-3).getDEF())/100);
					Thread.sleep((poke.get(menu-1).getAGL()*10)+1000);
				} catch (InterruptedException e) {
				}
			}if(wekcrit.equals("critical")) {
				try {
					System.out.println("Your turn");
					System.out.println("Critical");
					System.out.println("Wow, you take " + (poke.get(menu-1).getATT() * (enemy.get(m-3).getDEF())/100) + " damage to enemy");
					hpenem = hpenem - (poke.get(menu-1).getATT() * (enemy.get(m-3).getDEF())/100);
					Thread.sleep((poke.get(menu-1).getAGL()*10)+1000);
				} catch (InterruptedException e) {
				}
			}if(wekcrit.equals("normal")) {
				try {
					System.out.println("Your turn");
					System.out.println("You take " + (poke.get(menu-1).getATT() * (100-enemy.get(m-3).getDEF())/100) + " damage to enemy");
					hpenem = hpenem - (poke.get(menu-1).getATT() * (100-enemy.get(m-3).getDEF())/100);
					Thread.sleep((poke.get(menu-1).getAGL()*10)+1000);
				} catch (InterruptedException e) {
				}
			}
			try {
				System.out.println("Enemy turn");
				System.out.println("You took "+ (enemy.get(m-3).getATT() * (100-poke.get(menu-1).getDEF())/100) + " damage from enemy");
				hp = hp - (enemy.get(m-3).getATT() * (100-poke.get(menu-1).getDEF())/100);
				Thread.sleep((enemy.get(m-3).getAGL()*10)+1000);
			} catch (InterruptedException e) {
			}
			if(hp<0){
				System.out.println("You Lose");
				hp = 0;
				break;
			}
			if(hpenem<0){
				System.out.println("You Win");
				hpenem = 0;
				break;
			}
		}while(true);
		poke.get(menu-1).setHP(hp);
		int maks = (int) (25 * 1.5 * poke.get(menu-1).getLVL());
		if(hpenem==0 && hp>0){
			int tempexp = 0;
			System.out.println(poke.get(menu-1).getEXP()+ " / " + maks);
			tempexp = tempexp + (int)(Math.random()*(25-5) + 5);
			System.out.println("You got "+ tempexp);
			poke.get(menu-1).setEXP(poke.get(menu-1).getEXP()+tempexp);
			System.out.println(poke.get(menu-1).getEXP()+ " / " + maks);
			if(poke.get(menu-1).getEXP()>=maks) {
				tempexp = poke.get(menu-1).getEXP() - maks;
				poke.get(menu-1).setLVL(poke.get(menu-1).getLVL()+1);
				poke.get(menu-1).setEXP(tempexp);
				poke.get(menu-1).setAGL((int) (poke.get(menu-1).getAGL()*1.5));;
				poke.get(menu-1).setATT((int) (poke.get(menu-1).getATT()*1.5));
				poke.get(menu-1).setDEF((int) (poke.get(menu-1).getDEF()+1.5));
				poke.get(menu-1).setHP((int) (makshp*1.5));
				makshp = poke.get(menu-1).getHP();
			}
		}
	}
	public Trainer() {
		// TODO Auto-generated constructor stub
	}

}
