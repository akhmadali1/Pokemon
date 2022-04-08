
public class Pokemon {
	String name,TYPE;
	int HP = 0, EXP=0, ATT=0, DEF=0, AGL=0,LVL=0;
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		this.TYPE = tYPE;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		this.HP = hP;
	}
	public int getEXP() {
		return EXP;
	}
	public void setEXP(int eXP) {
		this.EXP = eXP;
	}
	public int getATT() {
		return ATT;
	}
	public void setATT(int aTT) {
		this.ATT = aTT;
	}
	public int getDEF() {
		return DEF;
	}
	public void setDEF(int dEF) {
		this.DEF = dEF;
	}
	public int getAGL() {
		return AGL;
	}
	public void setAGL(int aGL) {
		this.AGL = aGL;
	}
	public int getLVL() {
		return LVL;
	}
	public void setLVL(int lVL) {
		this.LVL = lVL;
	}
	public void display() {
		System.out.println(name + " Status");
		System.out.println("LVL:" + LVL);
		System.out.println("HP:" + HP);
		System.out.println("EXP:" + EXP);
		System.out.println("ATT:" + ATT);
		System.out.println("DEF:" + DEF);
		System.out.println("AGL:" + AGL);
		System.out.println("TYPE:" + TYPE);
	}
	public Pokemon() {
		// TODO Auto-generated constructor stub
	}

}
