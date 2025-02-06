
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
        boolean isPressed = false;

        // Affichage de résultat
        System.out.println(ENCADRE_TITRE);
        System.out.println(MESSAGE_BIENVENUE);

        do {  
            //Afficher le menu initial
            System.out.println(ENCADRE_TITRE + "\n");
            System.out.println(MESSAGE_MENU_CHOIX);
            System.out.printf("%s\n%s\n%s\n%s\n", CHOIX_UN, CHOIX_DEUX, CHOIX_TROIS, CHOIX_QUATRE);
            System.out.print("\nEntrez votre choix : ");
            choixOption = Clavier.lireByte();
            
            
            //Gérer les erreurs d'options  
            while(choixOption <= 0 || choixOption >= 5) {
                System.out.println("\nEntrée invalide !\n");
                System.out.println(MESSAGE_MENU_CHOIX);
                System.out.printf("\n%s\n%s\n%s\n%s\n", CHOIX_UN, CHOIX_DEUX, CHOIX_TROIS, CHOIX_QUATRE);
                System.out.print("\nEntrez votre choix : ");
                choixOption = Clavier.lireByte();

            }

            //Afficher les différents choix
            switch(choixOption){
                case 1:
                    System.out.println(MESSAGE_NOMBRE_VEHICULE_INVENTAIRE);
                    System.out.println("*************************************************");
                    System.out.println("Grandeur          Hybride      Électrique");
                    System.out.println("****************************************");            
                    System.out.printf("Petit %15d %15d", voituresRestantesHybridesPetites, voituresRestantesElectriquesPetites);
                    System.out.printf("\nIntermédiaire %7d %14d", voituresRestantesHybridesIntermediaires, voituresRestantesElectriquesIntermediaires);
                    System.out.printf("\nGrand %14d %15d\n\n", voituresRestantesHybridesGrandes, voituresRestantesElectriquesGrandes);
                    break;
                case 2:
                    System.out.println("Option2");
                    break;
                case 3:
                    System.out.println(MESSAGE_NOMBRE_VEHICULE_INVENTAIRE);
                    System.out.println("*************************************************");
                    System.out.println("Grandeur          Hybride      Électrique");
                    System.out.println("****************************************");            
                    System.out.printf("Petit %15d %15d", voituresLouesHybridesPetites, voituresLouesElectriquesPetites);
                    System.out.printf("\nIntermédiaire %7d %14d", voituresLouesHybridesIntermediaires, voituresLouesElectriquesIntermediaires);
                    System.out.printf("\nGrand %14d %15d\n\n", voituresLouesHybridesGrandes, voituresLouesElectriquesGrandes);
                    break;
                case 4:
                    System.out.println("Option4");
                    break;

            } 
            System.out.println("Appuyer sur <ENTREE> pour réafficher le menu...");
            Clavier.lireFinLigne();
            isPressed = true;

        }while(isPressed = true);
    }
}