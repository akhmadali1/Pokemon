
public class PokemonGrass extends Pokemon{
	void check(){
		if(name.equals("Bulbasaur")){
			this.HP = 45;
			this.ATT = 49;
			this.DEF = 49;
			this.AGL = 45;
			this.TYPE = "grass";
		}if(name.equals("Wild Pokemon Grass")) {
			this.HP = 40;
			this.ATT = 33;
			this.DEF = 49;
			this.AGL = 42;
			this.TYPE = "grass";
		}
	}
	@Override
	public void display(){
		System.out.println("Pokemon TYPE:" + TYPE);
		System.out.println("Info! You weak on fire but Strong on water");
		System.out.println(name + " Status");
		System.out.println("LVL:" + LVL);
		System.out.println("HP:" + HP);
		System.out.println("EXP:" + EXP);
		System.out.println("ATT:" + ATT);
		System.out.println("DEF:" + DEF);
		System.out.println("AGL:" + AGL);
	}
	public PokemonGrass() {
		// TODO Auto-generated constructor stub
	}

}
