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
			case "Crash":
				skill = new PokemonSkill("Crash", 10);
				break;
			case "Fired":
				skill = new PokemonSkill("Fired", 15);
				break;
			case "Scratch":
				skill = new PokemonSkill("Scratch", 10);
				break;
			case "GrainAmmunition":
				skill = new PokemonSkill("GrainAmmunition", 20);
				break;
                        case "Tail Whip":
				skill = new PokemonSkill("Tail Whip", 12);
				break;
                        case "Water Pulse":
				skill = new PokemonSkill("Water Pulse", 20);
				break;
                                                
		}
		return skill;
	}
}

