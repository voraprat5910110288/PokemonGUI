package pokemongui;


public class Hitokage extends Pokemon implements Runnable {
    private static final int maxGroupHealth = 200;
    private static final double maxMood = 100;
	public Hitokage(){
		super("Hitokage",
		       maxGroupHealth,40,maxMood);

		this.attackSkill = PokemonSkill.getPokemonSkill("Crash");
		this.untimatedSkill = PokemonSkill.getPokemonSkill("Fired");
	}

	public void move(){
		this.run();
	}

	public void run(){
                this.reducedWeight(10);
	}

    @Override
    public void walk() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}




