import java.util.Scanner;
import java.util.TreeSet;
/**
 *
 * @author Kealan Gifford
 *
 */
public class Vieple {

    boolean getting_characters = true;
    boolean getting_maxlength = true;
    Scanner userin = new Scanner(System.in);
    String characterString = null;
    char[] characters = null;
    int maxlength = 0;

    /** At first, I used a HashSet to remove duplicates but switched to
     * TreeSet to maintain ordering.
     */
    TreeSet<String> output = new TreeSet<>();

    /**
     * Constructor.
     */
     public Vieple(){
       setCharacterString();
       setComboLength();
       this.output = combinations(characters, output, "", maxlength);
     }

    /**
     * Gets string from user in order to carry out combination checks.
     */
     public void setCharacterString(){
       System.out.println("Enter any String of characters (no spaces):");
       while(this.getting_characters){
           this.characterString = userin.nextLine();
           if(characterString.length() > 0){
               this.characters = new char[characterString.length()];
               for(int i = 0; i < characterString.length(); i++){
                   this.characters[i] = characterString.charAt(i);
               }
               this.getting_characters = false;
           }
           else{
               System.out.println("Enter any String of characters (no spaces):");
           }
       }
     }

     /**
      * Sets max combination output string length.
      */
      public void setComboLength(){
        System.out.println("Enter max string length of combinations (>0):");
        while(this.getting_maxlength){
            this.maxlength = userin.nextInt();
            if(this.maxlength > 0){
                this.getting_maxlength = false;
            }
            else{
                System.out.println("Enter max string length of combinations(>0):");
            }
        }
      }

      /**
       * Print out the combinations, in order.
       */
      public void printCombos(){

        System.out.println("All combinations of " + this.characterString + ":");
        // print each combination string in the TreeSet
        for(String s : this.output){
            System.out.println(s);
        }
      }

    /**
     *
     * @param characters alphabet of characters to be used in generating combos
     * @param output TreeSet to store all the generated combinations
     * @param combo an individual combination (start with an empty string)
     * @param maxlength maximum length allowed for a combination string
     * @return
     */
    public TreeSet<String> combinations(char[] characters, TreeSet<String> output, String combo, int maxlength){

        // if the string combination has reached max length given
        if(combo.length() == this.maxlength){

            // System.out.println(combo);

            /**
             * printed here initially but wanted to remove the printing of
             * duplicate combinations. e.g. if the letters entered were all
             * the same ('aaaa') then it would print aaaaa, aaaaa, aaaaa ... etc
             * so simply stored the combos in a TreeSet for ordering and
             * ignoring of duplicates
             */
            output.add(combo);
            return(output);
        }

        /**
         * Otherwise keep placing each character in the given set at the start
         * of the combo string and then recurse for the rest of this combo string
         * (doing exactly the same thing but simply adding to the current combo)
        */
        for(char c : characters){
            String nextCombo = combo + c;
            combinations(characters, output, nextCombo, maxlength);
        }
       return(output);
    }

    /**
     * @param args none
     */
    public static void main(String[] args) {

      Vieple combinator = new Vieple();

      combinator.printCombos();
    }
}
