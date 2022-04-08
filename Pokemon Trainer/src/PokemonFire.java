
public class PokemonFire extends Pokemon{
	void check() {
		if(name.equals("Charmander")) {
			this.HP = 39;
			this.ATT = 52;
			this.DEF = 43;
			this.AGL = 65;
			this.TYPE = "fire";
		}
		if(name.equals("Wild Pokemon Fire")) {
			this.HP = 37;
			this.ATT = 35;
			this.DEF = 51;
			this.AGL = 42;
			this.TYPE = "fire";
		}
	}
	@Override
	public void display(){
		System.out.println("Pokemon TYPE:" + TYPE);
		System.out.println("Info! You weak on water but Strong on grass");
		System.out.println(name + " Status");
		System.out.println("LVL:" + LVL);
		System.out.println("HP:" + HP);
		System.out.println("EXP:" + EXP);
		System.out.println("ATT:" + ATT);
		System.out.println("DEF:" + DEF);
		System.out.println("AGL:" + AGL);
	}
	public PokemonFire() {
		// TODO Auto-generated constructor stub
	}

}
