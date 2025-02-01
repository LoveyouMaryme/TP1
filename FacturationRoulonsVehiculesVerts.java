
/**
 * Write a description of class FacturationRoulonsVehiculesVerts here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FacturationRoulonsVehiculesVerts
{
    public static void main(String [] args)
    
    {
        // Déclaration de constantes
        final String MESSAGE_BIENVENUE = "Bienvenue dans le système de facturation de Roulons des véhicules verts (RVV)";
        final String ENCADRE_TITRE = "---------------------------------------------------------------------------------";
        final String MESSAGE_MENU_CHOIX = "*** Menu de choix ***";
        final String CHOIX_UN = "1. Afficher l'inventaire des véhicules";
        final String CHOIX_DEUX = "2. Facturer la location d’un véhicule";
        final String CHOIX_TROIS = "3. Afficher le nombre de véhicules hybrides et électriques loués";
        final String CHOIX_QUATRE = "4. Quitter le programme";
        
        

        
        // Déclaration de variables
        byte choixOption;
        
        // Affichage de résultat
        System.out.println(ENCADRE_TITRE);
        System.out.println(MESSAGE_BIENVENUE);
        System.out.println(ENCADRE_TITRE + "\n");
        System.out.printf("%s\n%s\n%s\n%s\n", CHOIX_UN, CHOIX_DEUX, CHOIX_TROIS, CHOIX_QUATRE);
        System.out.print("\nEntrez votre choix : ");
        choixOption = Clavier.lireByte();
        
            while(choixOption <= 0 || choixOption >= 5) {
        
            System.out.println("\nEntrez invalide !\n");
        
            System.out.printf("\n%s\n%s\n%s\n%s\n", CHOIX_UN, CHOIX_DEUX, CHOIX_TROIS, CHOIX_QUATRE);
            System.out.print("\nEntrez votre choix : ");
            choixOption = Clavier.lireByte();
        
    
        
        
        }
    }
}
