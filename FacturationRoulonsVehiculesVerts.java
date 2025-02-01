
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
        final String NOM_ENTREPRISE = "Roulons les Véhicules Verts (RVV)";
        final String MESSAGE_BIENVENUE = "Bienvenue dans le système de facturation de " + NOM_ENTREPRISE;
        final String ENCADRE_TITRE = "---------------------------------------------------------------------------------";
        final String ENCADRE_SOUS_TIRE = "-----------------------------------------------------------";
        final String MESSAGE_MENU_CHOIX = "*** Menu de choix ***";
        final String CHOIX_UN = "1. Afficher l'inventaire des véhicules";
        final String CHOIX_DEUX = "2. Facturer la location d’un véhicule";
        final String CHOIX_TROIS = "3. Afficher le nombre de véhicules hybrides et électriques loués";
        final String CHOIX_QUATRE = "4. Quitter le programme";
        final String ADRESSE_ENTREPRISE = "1500 rue Matata, Hakuna, Québec Y0Z 6Y7" ;
        final String TELEPHONE_ENTREPRISE = "438 222-1111";
        final String MESSAGE_NOMBRE_VEHICULE_INVENTAIRE = "Nombre de véhicules disponibles dans l'inventaire";
        
        

        
        // Déclaration de variables
        byte choixOption;
        int voituresLouesHybridesPetites = 0;
        int voituresRestantesHybridesPetites = 12;
        int voituresLouesHybridesIntermediaires = 0;
        int voituresRestantesHybridesIntermediaires = 10;
        int voituresRestantesHybridesGrandes = 8; // Assuming a value
        int voituresRestantesElectriquesPetites = 6; // Assuming a value
        int voituresRestantesElectriquesIntermediaires = 5; // Assuming a value
        
        
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
    
    
        do{
            
            System.out.println(ENCADRE_SOUS_TIRE);
            System.out.println(NOM_ENTREPRISE);
            System.out.println("Adresse :       " + ADRESSE_ENTREPRISE);
            System.out.println("Téléphone :     " + TELEPHONE_ENTREPRISE);
            System.out.println("Date et Heure : " + "26-01-2025 11:25:04");
            System.out.println(ENCADRE_SOUS_TIRE+ "\n");
            
            System.out.println(MESSAGE_NOMBRE_VEHICULE_INVENTAIRE);
            System.out.println("*************************************************");
            System.out.println("Grandeur          Hybride      Électrique");
            System.out.println("****************************************");            
            System.out.printf("\nGrand %d %d", voituresRestantesHybridesGrandes, voituresRestantesHybridesGrandes);
            System.out.printf("\nPetit %d %d", voituresRestantesHybridesPetites, voituresRestantesElectriquesPetites);
            System.out.printf("\nIntermédiaire %d %d", voituresRestantesHybridesIntermediaires, voituresRestantesElectriquesIntermediaires);
        
        
        }while(choixOption > 0 && choixOption <= 4);
    
    
    
    
    }      
        
}
