package com.tickks;

import java.util.Random;

public class FactFactory {

  String[] faktet = {"A quarter has 119 grooves on its edge, a dime has one less groove"
                     ,"Mark Twain didn't graduate from school","Slugs have 4 noses",
                      "The State of Florida is bigger than England"
                     ,"Ants stretch when they wake up in the morning"
                     ,"More people use blue toothbrushes than red ones"
                     ,"If you want something done ask someone busy"
                     ,"The first oranges weren’t orange"
                     ,"Scotland has 421 words for “snow\""
                     ,"Peanuts aren’t technically nuts"
                     ,"Armadillo shells are bulletproof"
                     ,"The longest English word is 189,819 letters long"
                     ,"Octopuses lay 56,000 eggs at a time"
                     ,"Blue whales eat half a million calories in one mouthful"
                     ,"Kleenex tissues were originally intended for gas masks"
                     ,"The American flag was designed by a high school student"
                     ,"Thanks to 3D printing, NASA can basically “email” tools to astronauts"
                     ,"The U.S. government saved every public tweet from 2006 through 2017"};


  public String getFact(){
    Random r = new Random();
    int random = r.nextInt(faktet.length);
    String randomFact = faktet[random];

    return randomFact;
  }
}
