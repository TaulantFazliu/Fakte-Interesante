package com.tickks;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class FactFactory {

  private Context context;
  public static final String FILE_NAME = "ALL_FACTS";
  public static final String KEY = "FACTS";

  private String[] faktet = {"A quarter has 119 grooves on its edge, a dime has one less groove"
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

  private static ArrayList<String> newFaktet;
  private final SharedPreferences sharedPreferences;


  public FactFactory(Context context) {
    this.context = context;

    sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);

    Set<String> savedFacts = sharedPreferences.getStringSet(KEY, null);

    if (savedFacts == null || savedFacts.size() == 0) {
      sharedPreferences
              .edit()
              .putStringSet(KEY, getFactsAsSet(faktet))
              .apply();
    }
    savedFacts = sharedPreferences.getStringSet(KEY, null);


    newFaktet = getFactsAsArrayList(savedFacts);

   /* if (newFaktet.size() == 0) {
      for (String fact : faktet) {
        newFaktet.add(fact);
      }
    }*/
  }

  private ArrayList<String> getFactsAsArrayList(Set<String> savedFacts) {
    ArrayList<String> facts = new ArrayList<>();
    for (String fact : savedFacts) {
      facts.add(fact);
    }
    return facts;
  }

  private Set<String> getFactsAsSet(String[] newFaktet) {
    Set<String> set = new HashSet<>();
    for (int i = 0; i < newFaktet.length; i++) {
      set.add(newFaktet[i]);
    }
    return set;
  }

  public ArrayList<String> getFaktet() {
    Set<String> savedFacts = sharedPreferences.getStringSet(KEY, null);


    newFaktet = getFactsAsArrayList(savedFacts);

    return newFaktet;
  }

  public String getFact() {
    Random r = new Random();
    int random = r.nextInt(getFaktet().size());
    String randomFact = getFaktet().get(random);

    return randomFact;
  }

  public void addFact(String newFact) {
    Set<String> stringSet = sharedPreferences.getStringSet(KEY, null);
    stringSet.add(newFact);
    sharedPreferences.edit().clear().apply();
    sharedPreferences.edit().putStringSet(KEY, stringSet).apply();
    newFaktet = getFactsAsArrayList(stringSet);
  }

  public void delete(String factToDelete) {
    Set<String> stringSet = sharedPreferences.getStringSet(KEY, null);
    sharedPreferences.edit().clear().apply();
    for (String fact : stringSet) {
      if (fact.equals(factToDelete)) {
        stringSet.remove(fact);
        break;
      }
    }
    sharedPreferences.edit().putStringSet(KEY, stringSet).apply();

  }

  public void updateFact(String oldFact, String newFact) {
    Set<String> stringSet = sharedPreferences.getStringSet(KEY, null);
    sharedPreferences.edit().clear().apply();

    for (String fact : stringSet) {
      if (fact.equals(oldFact)) {
        stringSet.remove(fact);
        stringSet.add(newFact);
        break;
      }
    }
    sharedPreferences.edit().putStringSet(KEY, stringSet).apply();

  }
}
