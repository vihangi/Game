

import java.util.Random;
import java.util.Scanner;
// importing packages
/* this class is used to take the input of number of players 
   */
public class Player 
{
  
    int players;

    public int getPlayers()
    {
        
        Scanner input = new Scanner(System.in);
        
        
        boolean finish = true;
        
        do
        {
            try
            {
               // taking input
                System.out.println("Enter the number of players between 3-5");
        
                players = input.nextInt();
             
                checkPlayers(players);
                System.out.println(" Total number of players : " + players);
                
                finish = false;
           }
           catch(InvalidPlayerException b)
           {
               System.out.println(b.getMessage());
               
           }
           catch(Exception e)
           {
               System.out.println("Invalid Input");
               break;
           }
           
        }while(finish == true);
        return players;
    }
      
        
        
        
    // this function is used to throw an exceptopn when the number of players are not within the range
    public void checkPlayers(int num)throws InvalidPlayerException
    {
       
        if(num>5 || num<3) 
        {
            throw new InvalidPlayerException("The number of players must range from 3 to 5");
        }
        
       
        }
        
    
        
        }
        
    
   

