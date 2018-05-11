/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemongui;

public class Zenigame extends Pokemon implements Swimmable{
    private static final int maxGroupHealth = 200;
        
	public Zenigame(){
		super("Zenigame",
                        100);
		this.attackSkill = PokemonSkill.getPokemonSkill("Tail Whip");
		this.untimatedSkill = PokemonSkill.getPokemonSkill("Water Pulse");
	}

       @Override
	public void move(){
		this.swim();
	}

        @Override
	public void swim(){
		this.reducedHealth(10);
	}
}