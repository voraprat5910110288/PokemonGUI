
package pokemongui;


public class Hitokage extends Pokemon implements Runnable {
    private static final int maxGroupHealth = 200;
	public Hitokage(){
		super("Hitokage",
		       100 );

		this.attackSkill = PokemonSkill.getPokemonSkill("Thunder Shock");
		this.untimatedSkill = PokemonSkill.getPokemonSkill("Thunderbolt");
	}

	public void move(){
		this.run();
	}

	public void run(){
		this.reducedHealth(10);
	}

	public void walk(){
		this.reducedHealth(1);
	}
}

