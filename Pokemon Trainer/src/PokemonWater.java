
public class PokemonWater extends Pokemon{
	void check() {
		if(name.equals("Squirtle")) {
			this.HP = 44;
			this.ATT = 48;
			this.DEF = 65;
			this.AGL = 43;
			this.TYPE = "water";
		}if(name.equals("Wild Pokemon Water")) {
			this.HP = 42;
			this.ATT = 32;
			this.DEF = 49;
			this.AGL = 41;
			this.TYPE = "water";
		}
	}
	@Override
	public void display(){
		System.out.println("Pokemon TYPE:" + TYPE);
		System.out.println("Info! You weak on grass but Strong on Fire");
		System.out.println(name + " Status");
		System.out.println("LVL:" + LVL);
		System.out.println("HP:" + HP);
		System.out.println("EXP:" + EXP);
		System.out.println("ATT:" + ATT);
		System.out.println("DEF:" + DEF);
		System.out.println("AGL:" + AGL);
	}
	public PokemonWater() {
		// TODO Auto-generated constructor stub
	}

}
