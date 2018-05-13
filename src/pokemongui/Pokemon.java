package pokemongui;

abstract class Pokemon{
	public final double maxHealth;
	protected double health,weight,mood;
	protected String name;
	protected PokemonSkill attackSkill;
	protected PokemonSkill untimatedSkill;

	public Pokemon(String name, double maxHealth,double weight,double mood){
		this.name = name;
		this.health = maxHealth;
		this.maxHealth = maxHealth;
                this.weight = weight;
                this.mood = mood;
	}
        public double getMood(){
            return this.mood;
        }
        public double getWeight(){
            return this.weight;
        }

	public double getHealth(){
		return this.health;
	}

	public String getName(){
		return this.name;
	}
	
	public void eat(Berry berry){
		this.health += berry.getRestoreValue();
                this.mood += berry.getRestoreValue();
		if(this.health > this.maxHealth)
			this.health = this.maxHealth;
	}

	public void attack(Pokemon rival){
		rival.injure(this.attackSkill);
	}

	public void untimate(Pokemon rival){
		rival.injure(this.untimatedSkill);
	}

	public void injure(PokemonSkill skill){
		this.reducedHealth(10);
	}

	public void reducedHealth(double value){
		this.health -= value;
		if(this.health < 0)
			this.health = 0;
	}
        
        public void reducedWeight(double value){
		this.weight -= value-5;
		if(this.weight <= 20)
			this.weight = 20;
	}
        abstract public void move();

}
