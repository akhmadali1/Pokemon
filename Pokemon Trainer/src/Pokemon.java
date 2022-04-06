
public class Pokemon{
	String name;
	int id;
	String TYPE = null;
	int HP = 0, EXP=0, ATT=0, DEF=0, AGL=0,LVL=1;
	public Pokemon(String name,int id) {
		super();
		this.name = name;
		this.id = id;
		if(name.equals("Bulbasaur")){
			this.HP = 45;
			this.ATT = 49;
			this.DEF = 49;
			this.AGL = 45;
			this.TYPE = "grass";
		}if(name.equals("Charmander")) {
			this.HP = 39;
			this.ATT = 52;
			this.DEF = 43;
			this.AGL = 65;
			this.TYPE = "fire";
		}if(name.equals("Squirtle")) {
			this.HP = 44;
			this.ATT = 48;
			this.DEF = 65;
			this.AGL = 43;
			this.TYPE = "water";
		}if(name.equals("Wild Poke Grass")) {
			this.HP = 40;
			this.ATT = 33;
			this.DEF = 49;
			this.AGL = 42;
			this.TYPE = "grass";
		}if(name.equals("Wild Poke Fire")) {
			this.HP = 37;
			this.ATT = 35;
			this.DEF = 51;
			this.AGL = 42;
			this.TYPE = "fire";
		}if(name.equals("Wild Poke Water")) {
			this.HP = 42;
			this.ATT = 32;
			this.DEF = 49;
			this.AGL = 41;
			this.TYPE = "water";
		}
	}
	
	public void setTYPE(String tYPE) {
		this.TYPE = tYPE;
	}

	public void setEXP(int eXP) {
		this.EXP = eXP;
	}

	public void setATT(int aTT) {
		this.ATT = aTT;
	}

	public void setDEF(int dEF) {
		this.DEF = dEF;
	}

	public void setAGL(int aGL) {
		this.AGL = aGL;
	}

	public void setLVL(int lVL) {
		this.LVL = lVL;
	}

	public void setHP(int hP) {
		this.HP = hP;
	}

	public String getTYPE() {
		return TYPE;
	}

	public int getHP() {
		return HP;
	}

	public int getEXP() {
		return EXP;
	}

	public int getATT() {
		return ATT;
	}

	public int getDEF() {
		return DEF;
	}

	public int getAGL() {
		return AGL;
	}

	public int getLVL() {
		return LVL;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Pokemon() {

	}
	
	public void attack() {
		
	}
}
