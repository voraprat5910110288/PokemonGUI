package pokemongui;

public class Secrets extends Pokemon implements Runnable {
       private static final int maxGroupHealth = 500;

    public Secrets(String name, double maxHealth, double weight,double mood) {
        super(name, maxHealth, weight,mood);
    }
	public  Secrets(){
		super("Voraprat",
		      maxGroupHealth,80,30);

		this.attackSkill = PokemonSkill.getPokemonSkill("Scratch");
		this.untimatedSkill = PokemonSkill.getPokemonSkill("GrainAmmunition");
	}

	public void move(){
		this.run();
               	}

	public void run(){
		this.reducedHealth(10); 
                this.reducedWeight(10);

	}

    @Override
    public void walk() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	
}

