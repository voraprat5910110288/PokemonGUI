package pokemongui;

public class Zenigame extends Pokemon implements Swimmable{
    private static final int maxGroupHealth = 200;
        
	public Zenigame(){
		super("Zenigame",
                        100,75.14);
		this.attackSkill = PokemonSkill.getPokemonSkill("Tail Whip");
		this.untimatedSkill = PokemonSkill.getPokemonSkill("Water Pulse");
	}

       @Override
	public void move(){
		this.swim();
	}

        @Override
	public void swim(){
		this.reducedWeight(2.5);
	}
}