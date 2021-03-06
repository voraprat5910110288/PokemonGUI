package pokemongui;

public class Zenigame extends Pokemon implements Swimmable{
    private static final int maxGroupHealth = 200;
    private static  double maxMood = 100;    
	public Zenigame(){
		super("Zenigame",
                       maxGroupHealth,40,maxMood);
		this.attackSkill = PokemonSkill.getPokemonSkill("Tailwhip");
		this.untimatedSkill = PokemonSkill.getPokemonSkill("Waterpulse");
	}

       @Override
	public void move(){
		this.swim();
                moodStepUp();
                moodStepUp();
	}

        @Override
	public void swim(){
		
                this.reducedWeight(10);
	}
}