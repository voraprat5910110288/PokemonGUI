package pokemongui;

public class Zenigame extends Pokemon implements Swimmable{
    private static final int maxGroupHealth = 200;
        
	public Zenigame(){
		super("Zenigame",
                       maxGroupHealth,40,30);
		this.attackSkill = PokemonSkill.getPokemonSkill("TailWhip");
		this.untimatedSkill = PokemonSkill.getPokemonSkill("WaterPulse");
	}

       @Override
	public void move(){
		this.swim();
	}

        @Override
	public void swim(){
		
                this.reducedWeight(10);
	}
}