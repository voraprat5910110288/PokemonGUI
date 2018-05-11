package pokemongui;

public class Hitokage extends Pokemon implements Runnable {
    private static final int maxGroupHealth = 200;
	public Hitokage(){
		super("Hitokage",
		       100,80.52);
		this.attackSkill = PokemonSkill.getPokemonSkill("Crash");
		this.untimatedSkill = PokemonSkill.getPokemonSkill("Fired");
	}

	public void move(){
		this.run();
	}

	public void run(){
		this.reducedWeight(0.5);
	}
        
        

	public void walk(){
		this.reducedWeight(1);
	}
}

