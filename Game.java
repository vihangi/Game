// importing packages
import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.lang.*;
// this is main class where player class properties are inherited
public class Game extends Player 
{
   //declaring variables that can be used in all functions
    public String s="";
    public ArrayList<String> player1 = new ArrayList<String>();
    public ArrayList<String> player2 = new ArrayList<String>();
    public ArrayList<String> player3 = new ArrayList<String>();
    public ArrayList<String> player4 = new ArrayList<String>();
    public ArrayList<String> player5 = new ArrayList<String>();
    public ArrayList<String> deck = new ArrayList<String>();
    public double setcategory =0;
    public String scategory = "";
    public int skip =1 ;
    public int totalskip = 0;
    public int s1=0;
    public int s2=0;
    public int s3=0;
    public int s4=0;
    public int s5=0;
    public int set =0;
    public int high=0;
    public String cardcategory[] = {"Hardness", "Gravity","Cleavage","Crustal","EcoValue"};
    public int category ;  
    public String crustal[] = {"ultratrace" , "trace","low","moderate", "high","very high"};
    public String economic[] = {"trivial" , "low","moderate", "high","very high", "I'm rich!"};
    public String cleavage[] = {"none" , "poor/none" , "1 poor", "2 poor","1 good","1 good/1 poor","2 good",
        "3 good","1 perfect","1 perfect/1 good","1 perfect/2 good","2 perfect/1 good","3 perfect","4 perfect","6 perfect"};
    public String supertrump[] ={"Supertrump card,Petrologist,Crustal", "Supertrump card,Gemmologist,Hardness",
        "Supertrump card,Miner,EcoValue" ,"Supertrump card,Mineralogist,Cleavage",
        "Supertrump card,Geophysicist,Gravity,Magnetite","Supertrump card,Geologist,any"};
    // this function is used to call all the functions
    public void main(String[] arg)
    {
        System.out.println(" Welcome to Mineral SuperTrumps");
        // getting the number of players
        int participants =super.getPlayers();
       
        //this is to call the get cards function which intialises the cards from the file and stores it into array list
        getCards(participants);
        int c=1;
        int r = 0;
        
        
                
        while(true)
        {
            int n ;
            
            
            //checking if any player has lost all cards
            if(player1.size()-1<0 )
            {
                System.out.println("Player 1 wins");
                break;
            }
            else if(player2.size()-1<0)
            {
                 System.out.println("Player 2 wins");
                break;
            }
            else if(player3.size()-1<0)
            {
                 System.out.println("Player 3 wins");
                break;
            }
            else if(player4.size()-1<0 && participants == 4)
            {
                 System.out.println("Player 4 wins");
                break;
            }
            else if(player5.size()-1<0 && participants == 5)
            {
                 System.out.println("Player 5 wins");
                break;
            }
            else 
            {
                
                    r=0;
                    
                    System.out.println("                                                    Round " + c);
                        System.out.println("");
                    //this is change the sequence if all the players have skipped
                    if(totalskip == participants)
                    {
                        s1=0;
                        s2=0;
                        s3=0;
                        s4=0;
                        s5=0;
                    }
                    //player1
                    
                        while(s1==0 )
                        {
                        if(totalskip == participants && skip ==1)
                         {
                             totalskip =0;
                             r=1;
                            }
                            else if(totalskip == participants)
                            {
                                break;
                            }
                            else if(c==1)
                            {
                                r=1 ;
                            }
                            else
                            {
                                r=0;
                            }
                         
                          
                        
                        System.out.println("                                                    Player 1                        ");
                      
                        System.out.println();
                            
                        displayCards(player1);
                        
                         
                       
                        n = SettingRound(player1,1,participants,r);
                       //removing cards from the deck if the player has not been skipped 
                       if(s1 ==0 || r>1 )
                       {
                           if(high==0)
                           {
                               
                               deck.add(player1.get(n-1));
                               player1.remove(n-1);
                               
                                System.out.println("");
                            }
                       }
                       
                       break;
                    }
                    //player 2
                    while(s2==0)
                    {
                      System.out.println();
                         if(totalskip == participants && skip==2)
                         {
                             totalskip =0;
                             r=1;
                            }
                            else if(totalskip == participants)
                            {
                                break;
                            }
                            else
                            {
                                r=0;
                            }
                       
                        //player 2
                        System.out.println("                                                    Player 2                    ");
                         
                        displayCards(player2);
                        
                        n = SettingRound(player2,2,participants ,r);
                        if( s2 ==0 || r>1)
                        {
                            if(high==0)
                           {
                            deck.add(player2.get(n-1));
                            player2.remove(n-1);
                        }
                        }
                        
                        break;
                    }
                    //player 3
                    while(s3==0)
                    {
                       
                        // player 3
                        System.out.println("                                                    Player 3                    ");
                        System.out.println();
                        
                         if(totalskip == participants && skip==3)
                         {
                             totalskip =0;
                             r=1;
                            }
                            else if(totalskip == participants)
                            {
                                break;
                            }
                            else
                            {
                                r=0;
                            }
                        //displaying the cards
                            displayCards(player3);
                            
                        n = SettingRound(player3,3,participants,r);
                        if(s3 ==0 || r>1)
                        {
                            if(high==0)
                           {
                            deck.add(player3.get(n-1));
                            player3.remove(n-1);
                        }
                        }
                        break;
                    }
                    //player 4
                    while (s4==0)
                    {
                        if(participants == 4 || participants == 5 || skip == 5)
                        {
                            System.out.println("                                                    Player 4                    ");
                            System.out.println();
                                if(totalskip == participants && skip ==4)
                             {
                                 totalskip =0;
                                 r=1;
                                }
                                else if(totalskip == participants)
                            {
                                break;
                            }
                            else
                            {
                                r=0;
                            }
                            displayCards(player4);
                            n = SettingRound(player4,4,participants,r);
                            if(s4 ==0 || r>1)
                            {
                                if(high==0)
                           {
                                deck.add(player4.get(n-1));
                                player4.remove(n-1);
                            }
                            }
                        }
                        break;
                    }
                    //player 5
                    while(s5==0 )
                    {
                        if(participants == 5)
                        {
                            System.out.println("                                                    Player 5                    ");
                            System.out.println();
                            if(totalskip == participants && skip==5)
                            {
                             totalskip =0;
                             r=1;
                            }
                             else if(totalskip == participants)
                            {
                                break;
                            }
                            else
                            {
                                r=0;
                            }
                            displayCards(player5);
                            n = SettingRound(player5,5,participants,r);
                            if(s5==0 || r>1)
                            {
                                if(high==0)
                           {
                                deck.add(player5.get(n-1));
                                player5.remove(n-1);
                            }
                            }
                        }
                        break;
                    }
                    
                        c++;
                    
            }
           
                    
                
            }
            
        
        
        
        
    }
    //this function is used when a supertrump card is played
    public int getSuperTrump(String name)
    {
        int j=0;
        int r = 5;
        //checking the card 
        while(cardcategory[j].compareTo(name)!=0 && j<cardcategory.length)
        {
            j++;
        }
        if(j==3)
        {
            
            System.out.println(" Category set to Crustal Abundance");
        }
        else if(j==0)
        {
            
            System.out.println(" Category set to Hardness ");
            
        }
        else if(j==4)
        {
            
            System.out.println(" Category set to Economic Value");
        }
        else if(j==2)
        {
            
            System.out.println(" Category set to Cleavage");
        }
        else if(j==1)
        {
            
            System.out.println("Category set to specific gravity");
            
        }
        else 
        {
            r=1;
        }
        category = j+1;
         return r;   
    }
    //getCards is used to import from the file and store it in arrays
    public void getCards(int num)
    {
        
        int i=0;
        int j= 0;
        try(BufferedReader br = new BufferedReader(new FileReader("card.txt")))
        {
            //cards imported from the file
            while ((s =br.readLine()) != null)
            {
                
                deck.add (i,s.toString());
                
                i++;
                
                
            }
            Random rand = new Random();
            i=0;
            // adding supertrump cards to the deck
            while(i< supertrump.length)
            {
                deck.add(supertrump[i]);
                i++;
            }
            
            // cards shuffled
            Collections.shuffle(deck.subList(0, deck.size()-1));
            System.out.println(" Deck size " +deck.size());
            
            
           
            
            // cards assigned to each players
            
               
                            i=0;
                            //player1
                           while(i<8)
                            {
                                player1.add(deck.get(i));
                               deck.remove(i);
                              
                                i++;
                                
                            }
                           i=0;
                           //player2
                           while(i<8)
                            {
                                
                                player2.add(deck.get(i));
                                deck.remove(i);
                                i++;
                                
                                
                               
                            }
                            i=0;
                            //player 3
                            while(i<8)
                            {
                                player3.add(deck.get(i));
                                deck.remove(i);
                                i++;
                                
                            }
                        //player 4
                        if(num == 4 || num == 5)
                        {
                           i=0;
                            while(i<8)
                            {
                                player4.add(deck.get(i));
                                deck.remove(i);
                                i++;
                                
                            }
                        }
                    //player 5
                        if(num == 5)
                        {
                            i=0;
                            while(i<8)
                            {
                                player5.add(deck.get(i));
                                deck.remove(i);
                                i++;
                                
                            }
                    }
                  
                   
                    
                    
               
            
            }  
        
        catch(IOException exc)
        {
            System.out.println("IO Error" + exc);
        }
        
            
          
                    
                    
             
       
        
        
        }
    //displaying the cards in a table format
        public static void displayCards(ArrayList<String> cards)
    {
        int i=0;
        int y= 0;
        int j=0;
        System.out.println("Name                Hardness             Gravity             Cleavage              Crustal              EcoValue");
        
        while(j<cards.size())
            {
                                                 
            System.out.println();
            
            String b = cards.get(j);
            
           
        
            //displaying cards
            String[] p = b.split(",", b.length());
            
            for(i=0 ; i<p.length; i++)
            {
                System.out.print(p[i]);
                for(int k=(20-p[i].length()) ; k>=0; k--)
                {
                    System.out.print(" ");
                    
                }
                
            }
            
            j++;
           
          }
    }
   //this is to set the category and accept the card number
    public int SettingRound(ArrayList<String> c, int playerno ,int totalp , int round)
    {
        Scanner sn = new Scanner(System.in);
        int cardnumber=0;
        System.out.println();
        //error checking
        while(true)
        {
            try
            {
                System.out.println("");
                System.out.println("Please enter the card number ? ");
                cardnumber = sn.nextInt();
                
                if(playerno==1)
               {
                   if(cardnumber-1 > player1.size())
                   {
                       System.out.println(" The number is beyond the number of cards on the deck ");
                       
                    }
                    else
                    {
                        break;
                    }
                }
                else if(playerno==2)
                {
                    if(cardnumber-1 > player2.size())
                   {
                       System.out.println(" The number is beyond the number of cards on the deck ");
                       
                    }
                    else
                    {
                        break;
                    }
                }
                else if(playerno==3)
                {
                    if(cardnumber-1 > player3.size())
                   {
                       System.out.println(" The number is beyond the number of cards on the deck ");
                       
                    }
                    else
                    {
                        break;
                    }
                }
                else if(playerno== 4)
                {
                    if(cardnumber-1 > player4.size())
                   {
                       System.out.println(" The number is beyond the number of cards on the deck ");
                       
                    }
                    else
                    {
                        break;
                    }
                }
                else if(playerno==5)
                {
                    if(cardnumber-1 > player5.size())
                   {
                       System.out.println(" The number is beyond the number of cards on the deck ");
                       
                    }
                    else
                    {
                        break;
                    }
                }
                else
                {
                    break;
                }
               
               
            }
            catch(Exception e)
            {
            
               System.out.println(" Please enter a valid number ");
               
                
            }
            
        
        }
        String[] s = (c.get(cardnumber-1)).split(",");
        
        
        double m=0;
           
        //check if its a supertrump card
        if(s[0].toString().compareTo("Supertrump card")==0)
                {
                    round = getSuperTrump(s[2].toString());
                    
                    if(round ==5)
                    {
                                
                                try
                                {
                                    
                                    System.out.println("");
                                    //return false;
                                    totalskip = 0;
                                    s1= 0;
                                    s2=0;
                                    s3=0;
                                    s4=0;
                                    if(playerno == 1)
                                    {
                                        deck.add(player1.get(cardnumber-1));
                                        player1.remove(cardnumber-1);
                                        
                                        displayCards(player1);
                                    }
                                    else if(playerno == 2)
                                    {
                                        deck.add(player2.get(cardnumber-1));
                                        player2.remove(cardnumber-1);
                                          
                                        displayCards(player2);
                                    }
                                    else if(playerno == 3)
                                    {
                                        deck.add(player3.get(cardnumber-1));
                                        player3.remove(cardnumber-1);
                                        
                                        displayCards(player3);
                                    }
                                    else if(playerno == 4)
                                    {
                                        deck.add(player4.get(cardnumber-1));
                                        player4.remove(cardnumber-1);
                                        displayCards(player4);
                                    }
                                    else if(playerno == 5)
                                    {
                                        deck.add(player5.get(cardnumber-1));
                                        player5.remove(cardnumber-1);
                                        displayCards(player5);
                                    }
                                    else{}
                                    System.out.println("");
                                    System.out.println("Please enter the card number ? ");
                                    cardnumber = sn.nextInt();
                                    
                                    s = (c.get(cardnumber-1)).split(",");
                                    System.out.println(" The chosen category weight is  " + s[category] +" , " + cardcategory[category-1]);
                                     if (category==1 || category ==2 )
                                        {
                                            
                                            setcategory = Double.parseDouble(s[category]);
                                            
                                        }
                                        else if(category == 3 || category ==4 | category ==5)
                                        {
                                            scategory = s[category].toString() ;
                                        }
                                        else
                                        {
                                            System.out.println("invalid");
                                        }
                                    if(playerno == 1)
                                    {
                                        deck.add(player1.get(cardnumber-1));
                                        player1.remove(cardnumber-1);
                                        
                                        
                                    }
                                    else if(playerno == 2)
                                    {
                                        deck.add(player2.get(cardnumber-1));
                                        player2.remove(cardnumber-1);
                                          
                                        
                                    }
                                    else if(playerno == 3)
                                    {
                                        deck.add(player3.get(cardnumber-1));
                                        player3.remove(cardnumber-1);
                                        
                                     
                                    }
                                    else if(playerno == 4)
                                    {
                                        deck.add(player4.get(cardnumber-1));
                                        player4.remove(cardnumber-1);
                                        
                                    }
                                    else if(playerno == 5)
                                    {
                                        deck.add(player5.get(cardnumber-1));
                                        player5.remove(cardnumber-1);
                                        
                                    }
                                }
                                catch(Exception e)
                                {
                                
                                   System.out.println(" Please enter a valid number ");
                                }
                            
                            
                    }
                    
                }
                
                
       //intialising or setting category
        else if( round ==1 || totalskip>=totalp)
        {
            high=0;
            category = getcategory();
            System.out.println(" The chosen category weight is  " + s[category]);
            System.out.println("");
            System.out.println(s[0] + " , " +cardcategory[category-1] + " , "+ s[category]);
            System.out.println("");
            set = category;
            if (category==1 || category ==2 )
            {
                
                setcategory = Double.parseDouble(s[category]);
                
            }
            else if(category == 3 || category ==4 | category ==5)
            {
                scategory = s[set].toString() ;
            }
            else
            {
                System.out.println("invalid");
            }
           
            
        }
        //for first two categories which is numeric
        else if(category ==1 || category == 2 )
        {
            if(round!=5 )
            {
            if(playerno==1)
                {
                    
                    setcategory = getHigherValue(setcategory, category , player1, cardnumber,1);
                    
            }
            if(playerno==2)
                {
                    
                    //m = Double.parseDouble([category]);
                    //System.out.println("m  " + m );
                    setcategory = getHigherValue(setcategory, category , player2, cardnumber,2);
                    
            }
            if(playerno==3)
                {
                setcategory = getHigherValue(setcategory, category , player3, cardnumber,3);
                
            }
            if(playerno==4)
                {
                setcategory = getHigherValue(setcategory, category , player4, cardnumber,4);
                
            }
            if(playerno==5)
                {
                setcategory = getHigherValue(setcategory, category , player5, cardnumber,5);
                
            }
          }
        }
        //for the other categories which is comparing strings
        else if(category == 3 || category== 4 || category == 5 )
        {
            if(round!=5 )
            {
            if(playerno==1)
                {
                    
                    scategory = getCleavage( category , player1, cardnumber,1,scategory);
                    
            }
            if(playerno==2)
                {
                    
                    
                    scategory = getCleavage(category , player2, cardnumber,2,scategory);
                    
            }
            if(playerno==3)
                {
                scategory = getCleavage(category , player3, cardnumber,3,scategory);
                
            }
            if(playerno==4)
                {
                scategory = getCleavage( category , player4, cardnumber,4,scategory);
                
            }
            if(playerno==5)
                {
                scategory = getCleavage(category , player5, cardnumber,5,scategory);
                
            }
        
           }
        }
        
        else
        {
          
        }
        
        return cardnumber;
    }
   //getting the category menu 
    public int getcategory()
    {
        Scanner sn = new Scanner (System.in);
        System.out.println();
            System.out.println(" Setting the round");
            //checking if the input is valid or not
            while(true)
            {
                try
                {
                    
                    System.out.println("");
                    System.out.println(" Please choose the category with the highest weight(enter number)");
                    System.out.println(" 1. hardness");
                    System.out.println(" 2. gravity ");
                    System.out.println(" 3. cleavage");
                    System.out.println(" 4. crustal ");
                    System.out.println(" 5. EcoValue");
                    category = sn.nextInt();
                    if(category <= 0 || category> 5)
                    {
                        System.out.println("Invalid option");
                    }
                    else
                    {
                        break;
                    }
                    
                }
                catch(Exception e)
                {
                    System.out.println(" Invalid Category");
                }
            }
            
          
            return category;
    }
    //checking if the card entered is of higher value if its a string
    public String getCleavage(int index,ArrayList<String> play , int cardno , int playerno, String value1)
    {
         String[] s = (play.get(cardno-1)).split(",");
         Scanner sn = new Scanner(System.in);
         String p1= "";
         String p2 = "";
         p2 = value1;
         int input =0 ;
          p1 =s[index].toString();
          int i =0;
          int count =0;
          high = 0;
          //to compare using index finding out the index values
          if(index == 3)
          {
                  while(p1.equals(cleavage[i])== false )
                  {
                                          
                    i++;
                                          
                  }
                   while(p2.equals(cleavage[count])== false )
                              {
                                  count++;
                                  
                                }
          }
          else if(index == 4)
          {
          
              while(p1.equals(crustal[i])== false  )
                {
                    i++;
                                      
                  }
              while(p2.equals(crustal[count])== false )
                              {
                                  count++;
                                  
                                }
                }
                else 
                {
                     while(p1.equals(economic[i])== false )
                              {
                                  i++;
                                  
                                }
                      while(p2.equals(economic[count])== false)
                              {
                                  count++;
                                  
                                }
                }
                               
                              
             //comparing and checking                  
                               
              while(i<=count && input!=100)
              {
                  
                       System.out.println("Enter a card number with a higher value or press 100 to pick a card from the deck(skip a turn)");
                       input = sn.nextInt();
                       if(input == 100)
                       {
                           System.out.println(" picking up a card, skipping a turn");
                           setpass(playerno);
                           totalskip = totalskip + 1;
                           i= count ;
                           p1=p2;
                           high++;
                           break;
                        }
                        else
                        {
                           s= (play.get(input-1)).split(",");
                           p1 =s[index].toString();
                           System.out.println(p1);
                           i=0;
                           count = 0;
                           high=2;
                               if(index == 3)
                                  {
                                          while(p1.equals(cleavage[i])== false )
                                          {
                                                                  
                                            i++;
                                                                  
                                          }
                                           while(p2.equals(cleavage[count])== false )
                                                      {
                                                          count++;
                                                          
                                                        }
                                  }
                                  else if(index == 4)
                                  {
                                  
                                      while(p1.equals(crustal[i])== false  )
                                        {
                                            i++;
                                                              
                                          }
                                      while(p2.equals(crustal[count])== false )
                                                      {
                                                          count++;
                                                          
                                                        }
                                        }
                                        else 
                                        {
                                             while(p1.equals(economic[i])== false)
                                                      {
                                                          i++;
                                                          
                                                        }
                                              while(p2.equals(economic[count])== false)
                                                      {
                                                          count++;
                                                          
                                                        }
                                        }
                                
                               p1 =s[index];
                               System.out.println(s[0] + " , "+cardcategory[index-1]+" , " + p1);  
                               
                           }
                  
                }
                     if(high>=0 && input!=100)
                             {
                                 if (playerno==1)
                                       {
                                           deck.add(player1.get(index-1));
                                           player1.remove(index-1);
                                               
                                           System.out.println("");
                                        }
                                        else if (playerno==2)
                                       {
                                           deck.add(player2.get(index-1));
                                           player2.remove(index-1);
                                               
                                           System.out.println("");
                                        }
                                        else if (playerno==3)
                                       {
                                           deck.add(player3.get(index-1));
                                           player3.remove(index-1);
                                               
                                           System.out.println("");
                                        }
                                        else if (playerno==4)
                                       {
                                           deck.add(player4.get(index-1));
                                           player4.remove(index-1);
                                               
                                           System.out.println("");
                                        }
                                        else if (playerno==5)
                                       {
                                           deck.add(player5.get(index-1));
                                           player5.remove(index-1);
                                               
                                           System.out.println("");
                                        }
                                        else
                                        {
                                            System.out.println("invalid");
                                        }
                                        
                                }
                        
                  System.out.println("");
                  System.out.println("place card which has a higher weight than " + p1); 
                  return p1;
        }
      //checking for higher value if its numeric 
          public double getHigherValue(double value, int indexCategory , ArrayList<String> player, int no, int playerno)
        {
           String[] s = (player.get(no-1)).split(",");
           Scanner sn = new Scanner(System.in);
           int input=0;
           double p = 0;
           
               
                p =Double.parseDouble(s[indexCategory]);
               
              high=0;
               //checking and validating
               while(value>=p && input!=100)
               {
                        
                       System.out.println("Enter a card number with a higher value or press 100 to pick a card from the deck(skip a turn)");
                       input = sn.nextInt();
                       if(input == 100)
                       {
                           
                           System.out.println(" picking up a card, skipping a turn");
                           setpass(playerno);
                           totalskip = totalskip + 1;
                           p= value ;
                           high++;
                           break;
                           
                        }
                        else
                        {
                           high++;
                           String[]  y= (player.get(input-1)).split(",");
                           p =Double.parseDouble(y[indexCategory]);
                           System.out.println(y[0]+" , "+cardcategory[indexCategory-1]+" , " + p);
                            
                                   
                        }
                   }  
                  if(high>0 && input!=100)
                             {
                                 if (playerno==1)
                                       {
                                           deck.add(player1.get(input-1));
                                           player1.remove(input-1);
                                               
                                           System.out.println("");
                                        }
                                        else if (playerno==2)
                                       {
                                           deck.add(player2.get(input-1));
                                           player2.remove(input-1);
                                               
                                           System.out.println("");
                                        }
                                        else if (playerno==3)
                                       {
                                           deck.add(player3.get(input-1));
                                           player3.remove(input-1);
                                               
                                           System.out.println("");
                                        }
                                        else if (playerno==4)
                                       {
                                           deck.add(player4.get(input-1));
                                           player4.remove(input-1);
                                               
                                           System.out.println("");
                                        }
                                        else if (playerno==5)
                                       {
                                           deck.add(player5.get(input-1));
                                           player5.remove(input-1);
                                               
                                           System.out.println("");
                                        }
                                        else
                                        {
                                            System.out.println("invalid");
                                        }
                                        
                                }
                System.out.println("");
             
                System.out.println("place card which has a higher weight than " + p);  
               
            
            return p;
        }
       //when the user chooses to pass this function is enabled to do so and add a card int the players deck
        public void setpass(int playerno )
        {
            
            if(playerno==1)
            {
                player1.add(deck.get(0));
                deck.remove(0);
                skip =1 ;
                s1=1;
                
            }
            else if(playerno == 2)
            {
                player2.add(deck.get(0));
                deck.remove(0);
                skip =2 ;
                s2=2;
                
            }
            else if(playerno == 3)
            {
                player3.add(deck.get(0));
                deck.remove(0);
                skip = 3;
                s3=3;
                
            }
            else if(playerno == 4)
            {
                player4.add(deck.get(0));
                deck.remove(0);
                skip = 4;
                s4=4;
               
            }
            else if(playerno==5)
            {
                player5.add(deck.get(0));
                deck.remove(0);
                skip = 5;
                s5=5;
                
            }
            else
            {
                
            }
            
            
            
            
        }
       
}
