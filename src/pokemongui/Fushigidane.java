package pokemongui;
public class Fushigidane extends Pokemon implements Runnable {
       private static final int maxGroupHealth = 200;
	public  Fushigidane(){
		super("Fushigidane",
		      80,45.00);

		this.attackSkill = PokemonSkill.getPokemonSkill("Scratch");
		this.untimatedSkill = PokemonSkill.getPokemonSkill("GrainAmmunition");
	}

	public void move(){
		this.run();
	}

	public void run(){
		this.reducedWeight(1.5);
	}

	public void walk(){
		this.reducedWeight(0.5);
	}
}
