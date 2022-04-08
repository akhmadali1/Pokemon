import java.util.ArrayList;
import java.util.Scanner;

public class Program {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Pokemon> poke = new ArrayList<>();
	static ArrayList<Pokemon> enemy = new ArrayList<>();
	static int makshp = 0;
	static int count = 0;
	private void newTrain() {
 		int choose = 0;
 		do {
 			System.out.println("Hello Trainer, please choose your pokemon");
			System.out.println("1. Bulbasaur");
			System.out.println("2. Charmander");
			System.out.println("3. Squirtle");
			System.out.print(">> ");
			try {
				choose = sc.nextInt();
				if(choose < 1 || choose > 3) {
					throw new Exception();
				}
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Input 1-3!");
			}
 			if(choose==1) {
 				PokemonGrass pokemon= new PokemonGrass();
 		 		pokemon.name= "Bulbasaur";
 		 		pokemon.check();
 		 		poke.add(pokemon);
 			}if(choose==2) {
 				PokemonFire pokemon= new PokemonFire();
 		 		pokemon.name= "Charmander";
 		 		pokemon.check();
 		 		poke.add(pokemon);
 			}if(choose==3) {
 				PokemonWater pokemon= new PokemonWater();
 		 		pokemon.name= "Squirtle";
 		 		pokemon.check();
 		 		poke.add(pokemon);
 			}
 		}while(choose< 1 || choose >3);
 		makshp = poke.get(0).getHP();
 		count++;
 		System.out.println("You choose " + poke.get(0).getName());
 		poke.get(0).display();
 		sc.nextLine();
 		PokemonFire pokemon3= new PokemonFire();
	 	pokemon3.name= "Wild Pokemon Fire";
	 	pokemon3.check();
	 	enemy.add(pokemon3);
	 	PokemonGrass pokemon1= new PokemonGrass();
	 	pokemon1.name= "Wild Pokemon Grass";
	 	pokemon1.check();
	 	enemy.add(pokemon1);
	 	PokemonWater pokemon2= new PokemonWater();
	 	pokemon2.name= "Wild Pokemon Water";
	 	pokemon2.check();
	 	enemy.add(pokemon2);
	}
	
	private void train(){
		for(int i = 0; i < count;i++) {
			System.out.println(i+1 + ". " + poke.get(i).getName());
		}
		int menu = 0;
		do {
			System.out.println("Which pokemon you want to battle :");
			System.out.print(">> ");
			try {
				menu = sc.nextInt();
				if(menu < 1 || menu > count) {
					throw new Exception();
				}
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Input 1-"+ count +"!");
			}
		} while (menu < 1 || menu > count);
		if(poke.get(menu-1).getHP()==0){
			System.out.println("Your hp is 0 so you cant battle");
			return;
		}
			System.out.println(poke.get(menu-1).getName() + " Status");
			System.out.println("LVL:" + poke.get(menu-1).getLVL());
			System.out.println("HP:" + poke.get(menu-1).getHP());
			System.out.println("EXP:" + poke.get(menu-1).getEXP());
			System.out.println("ATT:" + poke.get(menu-1).getATT());
			System.out.println("DEF:" + poke.get(menu-1).getDEF());
			System.out.println("AGL:" + poke.get(menu-1).getAGL());
			System.out.println("TYPE:" + poke.get(menu-1).getTYPE());

		int rand = (int) (Math.random() * (3 - 0) + 0);
		System.out.println("You Found " + enemy.get(rand).getName());
		sc.nextLine();
		String wekcrit = null;
		if(poke.get(menu-1).getTYPE().equals("grass") && enemy.get(rand).getTYPE().equals("fire")){
			wekcrit = "weak";
		}
		else if(poke.get(menu-1).getTYPE().equals("grass") && enemy.get(rand).getTYPE().equals("water")){
			wekcrit = "critical";
		}
		if(poke.get(menu-1).getTYPE().equals("water") && enemy.get(rand).getTYPE().equals("grass")){
			wekcrit = "weak";
		}
		else if(poke.get(menu-1).getTYPE().equals("water") && enemy.get(rand).getTYPE().equals("fire")){
			wekcrit = "critical";
		}
		if(poke.get(menu-1).getTYPE().equals("fire") && enemy.get(rand).getTYPE().equals("water")){
			wekcrit = "weak";
		}
		else if(poke.get(menu-1).getTYPE().equals("fire") && enemy.get(rand).getTYPE().equals("grass")){
			wekcrit = "critical";
		}else {
			wekcrit = "normal";
		}
		int hp = poke.get(menu-1).getHP();
		int hpenem = enemy.get(rand).getHP();
		do {
			System.out.println(poke.get(menu-1).getName()+" Vs " + enemy.get(rand).getName());
			System.out.println(hp +" Vs " + hpenem);
			if(wekcrit.equals("weak")) {
				try {
					System.out.println("Your turn");
					System.out.println("Weak");
					System.out.println("You only take " + (poke.get(menu-1).getATT() * (105-enemy.get(rand).getDEF())/100)+ " damage to enemy");
					hpenem = hpenem - (poke.get(menu-1).getATT() * (105-enemy.get(rand).getDEF())/100);
					Thread.sleep((poke.get(menu-1).getAGL()*10)+1000);
				} catch (InterruptedException e) {
				}
			}if(wekcrit.equals("critical")) {
				try {
					System.out.println("Your turn");
					System.out.println("Critical");
					System.out.println("Wow, you take " + (poke.get(menu-1).getATT() * (enemy.get(rand).getDEF())/100) + " damage to enemy");
					hpenem = hpenem - (poke.get(menu-1).getATT() * (enemy.get(rand).getDEF())/100);
					Thread.sleep(((100-poke.get(menu-1).getAGL())*10)+1000);
				} catch (InterruptedException e) {
				}
			}if(wekcrit.equals("normal")) {
				try {
					System.out.println("Your turn");
					System.out.println("You take " + (poke.get(menu-1).getATT() * (100-enemy.get(rand).getDEF())/100) + " damage to enemy");
					hpenem = hpenem - (poke.get(menu-1).getATT() * (100-enemy.get(rand).getDEF())/100);
					Thread.sleep(((100-poke.get(menu-1).getAGL())*10)+1000);
				} catch (InterruptedException e) {
				}
			}
			try {
				System.out.println("Enemy turn");
				System.out.println("You took "+ (enemy.get(rand).getATT() * (100-poke.get(menu-1).getDEF())/100) + " damage from enemy");
				hp = hp - (enemy.get(rand).getATT() * (100-poke.get(menu-1).getDEF())/100);
				Thread.sleep(((100-enemy.get(rand).getAGL())/10)+1000);
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
		int maks = (int) (25 * 1.5 * (poke.get(menu-1).getLVL()+0.5));
		if(hpenem==0 && hp>0){
			int tempexp = 0;
			System.out.println(poke.get(menu-1).getEXP()+ " / " + maks);
			tempexp = tempexp + (int)(Math.random()*(25-5) + 5);
			System.out.println("You got "+ tempexp);
			poke.get(menu-1).setEXP(poke.get(menu-1).getEXP()+tempexp);
			System.out.println(poke.get(menu-1).getEXP()+ " / " + maks);
			int getPoke = (int) (Math.random() * (20 - 0) + 0);
			if(getPoke>=0 && getPoke<=3){
				int pokenem = (int) (Math.random() * (3 - 1) + 1);
				if(pokenem==1) {
	 				PokemonGrass pokemon= new PokemonGrass();
	 		 		pokemon.name= "Bulbasaur";
	 		 		pokemon.check();
	 		 		poke.add(pokemon);
	 		 		System.out.println("You got Bulbasaur");
	 		 		count++;
	 			}if(pokenem==2) {
	 				PokemonFire pokemon= new PokemonFire();
	 		 		pokemon.name= "Charmander";
	 		 		pokemon.check();
	 		 		poke.add(pokemon);
	 		 		System.out.println("You got Charmender");
	 		 		count++;
	 			}if(pokenem==3) {
	 				PokemonWater pokemon= new PokemonWater();
	 		 		pokemon.name= "Squirtle";
	 		 		pokemon.check();
	 		 		poke.add(pokemon);
	 		 		System.out.println("You got Squirtle");
	 		 		count++;
	 			}
	 			sc.nextLine();
			}
			if(poke.get(menu-1).getEXP()>=maks) {
				tempexp = poke.get(menu-1).getEXP() - maks;
				poke.get(menu-1).setLVL(poke.get(menu-1).getLVL()+1);
				poke.get(menu-1).setEXP(tempexp);
				poke.get(menu-1).setAGL((int) (poke.get(menu-1).getAGL()*1.15));
				poke.get(menu-1).setATT((int) (poke.get(menu-1).getATT()*1.25));
				poke.get(menu-1).setDEF((int) (poke.get(menu-1).getDEF()+0.5));
				poke.get(menu-1).setHP((int) (makshp*1.35));
				makshp = poke.get(menu-1).getHP();
				for(int i = 0; i < enemy.size();i++) {
					enemy.get(i).setLVL(enemy.get(i).getLVL()+1);
					enemy.get(i).setAGL((int) (enemy.get(i).getAGL()*1.15));
					enemy.get(i).setATT((int) (enemy.get(i).getATT()*1.15));
					enemy.get(i).setDEF((int) (enemy.get(i).getDEF()+0.5));
					enemy.get(i).setHP((int) (makshp*1.05));
				}
			}
		}
	}
	
	private void heal() {
		for(int i = 0; i < count ;i++) {
			System.out.println(i+1 + ". " + poke.get(i).getName());
		}
		int menu = 0;
		do {
			System.out.println("Which pokemon you want heal :");
			System.out.print(">> ");
			try {
				menu = sc.nextInt();
				if(menu < 1 || menu > count) {
					throw new Exception();
				}
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Input 1-"+ count +"!");
			}
		} while (menu < 1 || menu >count);
		if(poke.get(menu-1).getHP()==makshp){
			System.out.println("Your HP is Full");
			return;
		}
		double temp = poke.get(menu-1).getHP();
		System.out.println("Your Current HP: " + temp);
		do {
			if(temp>makshp){
				break;
			}
			try {
				temp = (temp+(0.2*makshp));
				System.out.print(".");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}while(temp!=makshp);
		System.out.println("\nHP :" + makshp);
		poke.get(menu-1).setHP(makshp);
	}
	
	private void printEnem(){
		System.out.println("Info Enemy:");
		for(int i = 0; i < enemy.size();i++) {
			System.out.println(enemy.get(i).getName() + " Status");
			System.out.println("LVL:" + enemy.get(i).getLVL());
			System.out.println("HP:" + enemy.get(i).getHP());
			System.out.println("EXP:" + enemy.get(i).getEXP());
			System.out.println("ATT:" + enemy.get(i).getATT());
			System.out.println("DEF:" + enemy.get(i).getDEF());
			System.out.println("AGL:" + enemy.get(i).getAGL());
			System.out.println("TYPE:" + enemy.get(i).getTYPE());
		}
	}
	public Program() {
		newTrain();
		printEnem();
		int menu = 0;
		do {
			System.out.println("Pokemon Trainer By Ali, Axcel, Niko and Julio");
			System.out.println("1. Training");
			System.out.println("2. Heal");
			System.out.println("3. Exit");
			System.out.print(">> ");
			try {
				menu = sc.nextInt();
				if(menu < 1 || menu > 3) {
					throw new Exception();
				}
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Input 1-3!");
			}
			if(menu == 1) {
				train();
			}if(menu == 2) {
				heal();	
			}
		}while(menu!=3);
	}
	

	public static void main(String[] args) {
		new Program();

	}

}
