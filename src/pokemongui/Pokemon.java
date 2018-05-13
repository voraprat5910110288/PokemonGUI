package pokemongui;

abstract class Pokemon{
	public final double maxHealth,maxMood;
	protected double health,weight,mood;
	protected String name;
	protected PokemonSkill attackSkill;
	protected PokemonSkill untimatedSkill;

	public Pokemon(String name, double maxHealth,double weight,double maxMood){
		this.name      = name;
		this.health    = maxHealth;
		this.maxHealth = maxHealth;
                this.weight    = weight;
                this.mood      = maxMood-10;
                this.maxMood   = maxMood;
	}
        public double getMood(){
            return this.mood;
        }
        public String getStatus(){
            if (this.mood > 80)
                 return "happy";
            else if (this.mood <30)
                 return "bad";
            else 
                 return  "impassible";
            
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
		if (this.health > this.maxHealth || this.mood > this.maxMood){
                    this.health = this.maxHealth;
	            this.mood = this.maxMood;
                }
			
                
	}

	public void attack(Pokemon rival){
		rival.injure(this.attackSkill);
	}
        
        public void moodStepUp(){
            this.mood +=1;
            if (this.mood > this.maxMood)
                this.mood = this.maxMood;

        }
	public void untimate(Pokemon rival){
		rival.injure(this.untimatedSkill);
	}

	public void injure(PokemonSkill skill){
		this.reducedHealth(10);
	}

	public void reducedHealth(double value){
		this.health -= value;
                this.mood -= value-5;   
		if(this.health < 0)
			this.health = 0;
                if(this.mood < 0)
			this.mood = 0;
 
	}
        
        public void reducedWeight(double value){
		this.weight -= value-5;
		if(this.weight <= 20)
			this.weight = 20;
	}
        
        
        abstract public void move();

}
