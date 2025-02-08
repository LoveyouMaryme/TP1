
/**
 * Write a description of class FacturationRoulonsVehiculesVerts here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

// Importing LocalDateTime and DateTimeFormatter 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        
            // Constants for vehicle types
        final String GRAND_H = "H";
        final String PETIT_H = "h";
        final String GRAND_E = "E";
        final String PETIT_E = "e";
        
            // Constants for vehicle sizes
        final String GRAND_P = "P";
        final String PETIT_P = "p";
        final String GRAND_I = "I";
        final String PETIT_I = "i";
        final String GRAND_G = "G";
        final String PETIT_G = "g";
        
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM:SS");
        

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
        String choixOptionTypeVoiture;
        String choixOptionGrandeurVoiture;
        int maxJoursLocation = 30;
        int minJoursLocation = 0;
        int choixJoursLocation;
        
        
        
        LocalDateTime now = LocalDateTime.now();
        String formattedString = now.format(FORMATTER);
        

        // Affichage de résultat
        System.out.println(ENCADRE_TITRE);
        System.out.println(MESSAGE_BIENVENUE);

        do {  
            //Afficher le menu initial
            System.out.println(ENCADRE_TITRE + "\n");
            System.out.println(MESSAGE_MENU_CHOIX+ "\n");
            System.out.printf("%s\n%s\n%s\n%s\n", CHOIX_UN, CHOIX_DEUX, CHOIX_TROIS, CHOIX_QUATRE);
            System.out.print("\nEntrez votre choix : ");
            choixOption = Clavier.lireByte();
            
            
            //Gérer les erreurs d'options  
            while(choixOption <= 0 || choixOption >= 5) {
                System.out.println("Entrée invalide !\n");
                System.out.println(MESSAGE_MENU_CHOIX);
                System.out.printf("%s\n%s\n%s\n%s\n", CHOIX_UN, CHOIX_DEUX, CHOIX_TROIS, CHOIX_QUATRE);
                System.out.print("\nEntrez votre choix : ");
                choixOption = Clavier.lireByte();

            }
            
            System.out.println("\n-----------------------------------------------------------");
            System.out.println(NOM_ENTREPRISE);
            System.out.println("Adresse :       " + ADRESSE_ENTREPRISE);
            System.out.println("Téléphone :     " + TELEPHONE_ENTREPRISE);
            System.out.println("Date et Heure : " + formattedString );
            System.out.println("-----------------------------------------------------------\n");
            
            //Afficher les différents choix
            switch(choixOption){
                case 1:
                    System.out.println(MESSAGE_NOMBRE_VEHICULE_INVENTAIRE);
                    System.out.println("*************************************************");
                    System.out.println("Grandeur          Hybride      Électrique");
                    System.out.println("****************************************");            
                    System.out.printf("Petit %15d %15d", voituresRestantesHybridesPetites, voituresRestantesElectriquesPetites);
                    System.out.printf("\nIntermédiaire %7d %15d", voituresRestantesHybridesIntermediaires, voituresRestantesElectriquesIntermediaires);
                    System.out.printf("\nGrand %15d %15d\n\n", voituresRestantesHybridesGrandes, voituresRestantesElectriquesGrandes);
                    System.out.println("-----------------------------------------------------------");
                    break;
                case 2:
                    System.out.println("Entrez le type du véhicule à louer");
                    System.out.print("(H ou h pour Hybride, et E ou e pour Électrique) :    ");
                    choixOptionTypeVoiture = Clavier.lireString().toLowerCase();
    
                    
                    while( !choixOptionTypeVoiture.equals(PETIT_H) && !choixOptionTypeVoiture.equals(PETIT_E)){
                       System.out.println("\nEntrée invalide !\n");
                       System.out.println("Entrez le type du véhicule à louer");
                       System.out.print("(H ou h pour Hybride, et E ou e pour Électrique) :    ");
                       choixOptionTypeVoiture = Clavier.lireString().toLowerCase();
                       
                    }
                    
                    System.out.println("\nEntrez la grandeur du véhicule à louer");
                    System.out.print("(P ou p pour Petit, I ou i pour Intermédiaire, et G ou g pour Grand) :    ");
                    choixOptionGrandeurVoiture = Clavier.lireString().toLowerCase();
                    
                    while(!choixOptionGrandeurVoiture.equals(PETIT_P) && !choixOptionGrandeurVoiture.equals(PETIT_I) && !choixOptionGrandeurVoiture.equals(PETIT_G) ){
                       System.out.println("\nEntrée invalide !\n");
                       System.out.println("Entrez la grandeur du véhicule à louer");
                       System.out.println("(P ou p pour Petit, I ou i pour Intermédiaire, et G ou g pour Grand) :    ");
                       choixOptionTypeVoiture = Clavier.lireString().toLowerCase();
                       
                    }
                    
                    if(choixOptionTypeVoiture.equals(PETIT_H)){
                        if(choixOptionGrandeurVoiture.equals(PETIT_P)){
                            System.out.print(voituresRestantesHybridesPetites);
                        }else if(choixOptionGrandeurVoiture.equals(PETIT_I)){
                            System.out.print(voituresRestantesHybridesPetites);
                        }else if(choixOptionGrandeurVoiture.equals(PETIT_G)){
                            System.out.print(voituresRestantesHybridesPetites);
                        }
                    }else if((choixOptionTypeVoiture.equals(PETIT_E))){
                        if(choixOptionGrandeurVoiture.equals(PETIT_P)){
                            System.out.print(voituresRestantesHybridesPetites);
                        }else if(choixOptionGrandeurVoiture.equals(PETIT_I)){
                            System.out.print(voituresRestantesHybridesPetites);
                        }else if(choixOptionGrandeurVoiture.equals(PETIT_G)){
                            System.out.print(voituresRestantesHybridesPetites);
                        }
                    }
                    
                    System.out.println(" véhicules de ce type et de cette grandeur sont disponibles !");
                    
                    System.out.println("Entrez le nombre de jours de location");
                    System.out.print("(supérieur à 0 et inférieur ou égal à 30) :    ");
                    choixJoursLocation = Clavier.lireInt();
                    
                    while(choixJoursLocation < minJoursLocation || choixJoursLocation >= 30){
                       System.out.println("\nEntrée invalide !\n");
                       System.out.println("Entrez le nombre de jours de location");
                       System.out.print("(supérieur à 0 et inférieur ou égal à 30) :    ");
                       choixJoursLocation = Clavier.lireInt();
                       
                    }
                    
                    break;
                case 3:
                    System.out.println(MESSAGE_NOMBRE_VEHICULE_INVENTAIRE);
                    System.out.println("*************************************************");
                    System.out.println("Grandeur          Hybride      Électrique");
                    System.out.println("****************************************");            
                    System.out.printf("Petit %15d %15d", voituresLouesHybridesPetites, voituresLouesElectriquesPetites);
                    System.out.printf("\nIntermédiaire %7d %14d", voituresLouesHybridesIntermediaires, voituresLouesElectriquesIntermediaires);
                    System.out.printf("\nGrand %14d %15d\n\n", voituresLouesHybridesGrandes, voituresLouesElectriquesGrandes);
                    System.out.println("-----------------------------------------------------------");
                    break;
                case 4:
                    System.out.println("Option4");
                    break;

            } 
            // people can add a stupid letter here for nothing; what can I do
            System.out.println("\n\nAppuyer sur <ENTREE> pour réafficher le menu...");
            Clavier.lireFinLigne();
            isPressed = true;

        }while(isPressed = true);
    }
}