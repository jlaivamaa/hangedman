import java.util.*;
import java.io.*;

class Hirsipuu {
  private Sanalista sanalista;
  protected int arvaustenMaara;
  protected String arvattavaSana;
  private List<Character> arvauslista = new ArrayList<Character>();

  public Hirsipuu(Sanalista sanalista, int arvaustenMaara) {
    this.sanalista = sanalista;
    this.arvaustenMaara = arvaustenMaara;
    Random random = new Random();
    this.arvattavaSana = sanalista.lista.get(random.nextInt(sanalista.lista.size())); //arpoo listasta satunnaisesti yhden sanan
  }

//palauttaa arvatun kirjaimen totuusarvon ja lisää sen arvauslistaan
  public boolean arvaa(Character merkki) {
    if(arvattavaSana.indexOf(merkki) != -1) {
      arvauslista.add(merkki);
      return true;
    } else {
      arvauslista.add(merkki);
      this.arvaustenMaara -= 1;
      return false;
    }
  }
//palauttaa arvauslistan sisällön
  public List<Character> arvaukset() {
    return this.arvauslista;
  }
//palauttaa jäljellä olevien arvauksien määrän
  public int arvauksiaOnJaljella() {
   return this.arvaustenMaara;
  }
//palauttaa arvattavan sanan peittelemättömänä
  public String sana() {
   return this.arvattavaSana;
  }
//palauttaa totuusarvon riippuen siitä onko arvauksia jäljellä
  public boolean onLoppu() {
   if(this.arvaustenMaara == 0) {
     System.out.println("Havisit pelin!");
     return true;
   } else {
     return false;
   }
  }
}
