import java.util.*;
public class Main {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Pokemon> poke = new ArrayList();
	static Trainer train = new Trainer();
	static int count = 0;
	private void makeTrainer(){
		poke.add(new Pokemon("Bulbasaur", 1));
		poke.add(new Pokemon("Charmander",2));
		poke.add(new Pokemon("Squirtle",3));
		poke.add(new Pokemon("Wild Poke Grass",4));
		poke.add(new Pokemon("Wild Poke Fire",5));
		poke.add(new Pokemon("Wild Poke Water",6));
		train.addEnemy(poke.get(3));
		train.addEnemy(poke.get(4));
		train.addEnemy(poke.get(5));
		int menu = 0;
		do {
			System.out.println("Hello Trainer, please choose your pokemon");
			System.out.println("1. Bulbasaur");
			System.out.println("2. Charmander");
			System.out.println("3. Squirtle");
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
				train.addPoke(poke.get(0));
				System.out.println("You choose " + poke.get(0).getName());
				sc.nextLine();
				count++;
				break;
			}if(menu == 2) {
				train.addPoke(poke.get(1));
				System.out.println("You choose " + poke.get(1).getName());
				sc.nextLine();
				count++;
				break;
			}if(menu == 3) {
				train.addPoke(poke.get(2));
				System.out.println("You choose " + poke.get(2).getName());
				sc.nextLine();
				count++;
				break;
			}
		}while(true);
	}
	
	private void train() {
		int rand = (int) (Math.random() * (6-3)) + 3;
		System.out.println("You found "+poke.get(rand).getName());
		train.printstat(count);
		train.battle(rand, count);
	}
	
	private void heal() {
		train.heal(count);
	}
	public Main() {
		int menu = 0;
		makeTrainer();
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
		new Main();
	}

}
