import java.io.*;
import java.util.*;

class Sanalista {
  protected List<String> lista = null; //lista johon tallennetaan tiedoston sisältämät sanat
  protected String file; //osoittaa tiedoston nimen

  //lukee tiedoston rivi riviltä ja lisää sen listaan
  public Sanalista(String file) {
    this.lista = new ArrayList<String>();
    try {
      FileInputStream in = new FileInputStream(file);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String rivi;

      while((rivi = br.readLine())!= null) lista.add(rivi);
    }catch(Exception e) {
      System.out.println(e);
    }
  }

  public List<String> annaSanat() {
    return lista;
  }

  //En saanut sanatJoidenPituusOn ja sanaJoissaMerkit -metodeja toimimaan oikein

  /*public Sanalista sanatJoidenPituusOn(int pituus) {
    this.pituuslista = new ArrayList<String>();
    for(int i = lista.size(); i > 0; i--) {
      if(lista.get(i).length() == pituus) {
        this.pituuslista.add(i);
      }
    }
    return this.pituuslista;
  }*/

  /*public Sanalista sanaJoissaMerkit(StringBuffer mjono) {
    for(int i = lista.size(); i > 0; i--) {
      for(int j = mjono.length(); j > 0; i--) {
        if(mjono.CharAt(j) == '_') {

        }
      }
    }
    return null;
  }*/
}
