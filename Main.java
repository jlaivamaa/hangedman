import java.io.*;
import java.util.*;

class Main {
  static boolean voitto = false; //käytetään tarkastamaan onko käyttäjän kokoama sana sama kuin arvattava sana
  static Scanner input = new Scanner(System.in);
  public static void main(String args[]) throws IOException {
    do {
      String file = "sanat.txt";
      int arvaustenMaara = 5;
      Sanalista sanalista = new Sanalista(file);
      Hirsipuu hirsipuu = new Hirsipuu(sanalista, arvaustenMaara);
      String vastaus = hirsipuu.sana();
      StringBuffer sana = teeSana(vastaus);
      while(!hirsipuu.onLoppu()) {
        System.out.println("Tassa on sanasi: " + sana);
        System.out.println("Entiset arvauksesi: " + hirsipuu.arvaukset());
        System.out.println("Arvauksia jaljella: " + hirsipuu.arvauksiaOnJaljella());
        System.out.println("Tee arvaus: ");
        Character arvaus = input.next().charAt(0);
        muutaSana(vastaus, sana, arvaus);
        System.out.println(hirsipuu.arvaa(arvaus));
        System.out.println(sana);
        if(sana.toString().equals(vastaus)) {
          voitto = true;
          System.out.println("Voitit pelin!");
          break;
        }
      }
    } while(!voitto);
  }

//metodi, joka ottaa arvattavan sanan ja alustaa siitä peitetyn sanan
  public static StringBuffer teeSana(String vastaus) {
    StringBuffer sana = new StringBuffer(vastaus.length());
    for(int i = 0; i < vastaus.length(); i++) {
      sana.append('_');
    }
    return sana;
  }
//metodi, joka muuttaa peitetyn sanan oikein arvautuilla kirjaimilla
  public static void muutaSana(String vastaus, StringBuffer sana, Character arvaus) {
    for(int i = 0; i < vastaus.length(); i++) {
      if(vastaus.charAt(i) == arvaus)
        sana.setCharAt(i, arvaus);
    }
  }
}
