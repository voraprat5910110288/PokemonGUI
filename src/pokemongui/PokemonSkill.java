package pokemongui;

public class PokemonSkill{
	private String name;
	private float damage;

	public PokemonSkill(String name, float damage){
		this.name = name;
		this.damage = damage;
	}

	public String getName(){
		return this.name;
	}

	public float getDamage(){
		return this.damage;
	}

	public static PokemonSkill getPokemonSkill(String name){
		PokemonSkill skill = null;
		switch(name.toLowerCase()){
			case "crash":
				skill = new PokemonSkill("Crash", 10);
				break;
			case "fired":
				skill = new PokemonSkill("Fired", 20);
				break;
			case "scratch":
				skill = new PokemonSkill("Scratch", 10);
				break;
			case "grainammunition":
				skill = new PokemonSkill("Grainammunition", 20);
				break;
                        case "tailwhip":
				skill = new PokemonSkill("Tailwhip", 10);
				break;
                        case "waterpulse":
				skill = new PokemonSkill("Waterpulse", 20);
				break;
                                      
		}		return skill;
	}
}

