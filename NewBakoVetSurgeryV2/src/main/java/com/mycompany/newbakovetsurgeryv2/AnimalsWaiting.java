package com.mycompany.newbakovetsurgeryv2;


import java.util.ArrayList;

/** 
 *  
 *  @author Bako
 *  
 */

public class AnimalsWaiting  
{
    private ArrayList<Animal> animalsToBeSeen;
    public final int MAX;
        
    /** Constructor initialises the empty motorbike list and sets the maximum list size 
     *  @param   maxIn The maximum number of motorbikes in the list
     */
    public AnimalsWaiting(int maxIn)
    {
        animalsToBeSeen = new ArrayList<>();
        MAX = maxIn;
    }
	
    /** Adds a new Motorbike to the list
     *  @param  myAnimal The Bike to add
     *  @return Returns true if the bike was added successfully and false otherwise
     */
    
    //you should be able to make similar code to delete bike, search for bikes etc
    public boolean addAnimal(Animal myAnimal)
    {
        if(!isFull())
        {
            animalsToBeSeen.add(myAnimal);
            return true;
        }
        else
        {
            return false;
        }
    }
        


   /** Reports on whether or not the list is empty
     *  @return Returns true if the list is empty and false otherwise
     */
    public boolean isEmpty()
    {
        return animalsToBeSeen.isEmpty();
    }
	
    /** Reports on whether or not the list is full
     *  @return Returns true if the list is full and false otherwise
     */	
    public boolean isFull()
    {
        return animalsToBeSeen.size()== MAX;
    }
        
    /** Gets the total number of motorbikes 
     *  @return Returns the total number of motorbikes currently in the list 
     */
    public int getTotal()
    {       
        return animalsToBeSeen.size();
    }
      
     /** Reads the bike at the given position in the list
     *  @param      positionIn The position of the bike in the list
     *  @return     Returns the bike at the  position in the list
     *              or null if no bike at that logical position
     */
    public Animal getTheAnimal(int positionIn)
    {
        if (positionIn < 0 || positionIn >= getTotal()) // check for valid position
        {
            return null; // no object found at given position
        }
        else
        {
            // remove one frm logical poition to get ArrayList position
            return animalsToBeSeen.get(positionIn);
        }
    }
    
     /** Outputs all the bikes in the list
     *  @return     Returns all the bikes and owners in the list in an easy to read format
     */
    
    public String displayTheAnimals()
    {
      String output = "\n";  
      for (int counter = 0; counter < animalsToBeSeen.size(); counter++) { 
          output += animalsToBeSeen.get(counter).ownerGivName + "\t" + animalsToBeSeen.get(counter).ownerSurname;
          output += "\n" + animalsToBeSeen.get(counter).animalID + "\t" + animalsToBeSeen.get(counter).species + "\t" + animalsToBeSeen.get(counter).animalName; 	
          output += "\n\n";
      } 
        return output;
    }
}

