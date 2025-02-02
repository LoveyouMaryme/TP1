
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
        int voituresLouesHybridesGrandes = 0;
        int voituresRestantesHybridesGrandes = 3;
        int voituresLouesElectriquesPetites = 0;
        int voituresRestantesElectriquesPetites = 11;
        int voituresLouesElectriquesIntermediaires = 0;
        int voituresRestantesElectriquesIntermediaires = 9;
        int voituresLouesElectriquesGrandes = 0;
        int voituresRestantesElectriquesGrandes = 5;
        String entreeButton = "";
        
        
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
            
            if (choixOption == 1) {
                            
                System.out.println(MESSAGE_NOMBRE_VEHICULE_INVENTAIRE);
                System.out.println("*************************************************");
                System.out.println("Grandeur          Hybride      Électrique");
                System.out.println("****************************************");            
                System.out.printf("Petit %15d %15d", voituresRestantesHybridesPetites, voituresRestantesElectriquesPetites);
                System.out.printf("\nIntermédiaire %7d %14d", voituresRestantesHybridesIntermediaires, voituresRestantesElectriquesIntermediaires);
                System.out.printf("\nGrand %14d %15d\n\n", voituresRestantesHybridesGrandes, voituresRestantesElectriquesGrandes);
                
                System.out.print("Appuyer sur <ENTREE> pour réafficher le menu...\n");   
                entreeButton = Clavier.lireString();
            
            
                        };
                      
            
         } while ((choixOption > 0 && choixOption <= 4 )|| entreeButton == "\n");
    
    
    
    
    };      
        
};