
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
        final float ASSURANCE_HYBRIDE_PETIT = 13.50f;
        final float ASSURANCE_HYBRIDE_INTERMEDIAIRE = 14.50f;
        final float ASSURANCE_HYBRIDE_GRAND = 15.50f;
        final float ASSURANCE_ELECTRIQUE_PETIT = 12.50f;
        final float ASSURANCE_ELECTRIQUE_INTERMEDIAIRE = 12.75f;
        final float ASSURANCE_ELECTRIQUE_GRAND = 13.25f;
        final float LOCATION_HYBRIDE_PETIT = 55.75f;
        final float LOCATION_HYBRIDE_INTERMEDIAIRE = 60.25f;
        final float LOCATION_HYBRIDE_GRAND = 65.50f;
        final float LOCATION_ELECTRIQUE_PETIT = 45.50f;
        final float LOCATION_ELECTRIQUE_INTERMEDIAIRE = 50.50f;
        final float LOCATION_ELECTRIQUE_GRAND = 55.25f;
        
        
            // Constants for vehicle types
        final String PETIT_H = "h"; //change name disgusting
        final String PETIT_E = "e";
        
            // Constants for vehicle sizes
      
        final String PETIT_P = "p";
        final String PETIT_I = "i";
        final String PETIT_G = "g";
        
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM:SS");
        final int MAXJOURSLOCATION = 30;
        final int MINJOURSLOCATION = 0;
        
        final String ASSURANCE_OUI = "oui";
        final String ASSURANCE_NON = "non";
        
        final String PETIT_D = "d";
        final String PETIT_C = "c";
        
        

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
        
        int choixJoursLocation;
        String prenomLocataire;
        String nomLocataire;
        String telephoneLocataire;
        String permisConduiteLocataire;
        String modePaiement;
        String choixAssurance;
        int nombreFacture = 0;
        
        
        
        
        LocalDateTime now = LocalDateTime.now();
        String tempsFormate = now.format(FORMATTER);
        String dateLocation = now.format(FORMATTER);
        String dateRetour;
        float sousTotalLocation;
        
        

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
            System.out.println("Date et Heure : " + tempsFormate );
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
                    
                    while(choixJoursLocation < MINJOURSLOCATION|| choixJoursLocation >= MAXJOURSLOCATION){
                       System.out.println("\nEntrée invalide !\n");
                       System.out.println("Entrez le nombre de jours de location");
                       System.out.print("(supérieur à 0 et inférieur ou égal à 30) :    ");
                       choixJoursLocation = Clavier.lireInt();
                       
                    }
                    
                    System.out.print("Entrez le prénom du locataire :    \n");
                    prenomLocataire = Clavier.lireString();
                    System.out.print("Entrez le nom du locataire :    \n");
                    nomLocataire = Clavier.lireString();
                    System.out.print("Entrez le numéro de téléphone du locataire :    \n");
                    telephoneLocataire = Clavier.lireString();
                    System.out.print("Entrez le numéro de permis de conduire du locataire :    \n");
                    permisConduiteLocataire = Clavier.lireString();
                    
                    System.out.println("Entrez le mode de paiement");
                    System.out.println("(D ou d pour Débit, C ou c pour Crédit):");
                    modePaiement = Clavier.lireString().toLowerCase();
                    
                    while( !modePaiement.equals(PETIT_D) && !modePaiement.equals(PETIT_C)){
                       System.out.println("\nEntrée invalide !\n");
                       System.out.println("Entrez le mode de paiement");
                       System.out.println("(D ou d pour Débit, C ou c pour Crédit):    ");
                       modePaiement = Clavier.lireString().toLowerCase();
                       
                    }
                    
                    
                    System.out.println("Désirez-vous prendre l'assurance");
                    System.out.println("(O ou o pour Oui, N ou n pour Non) ? :    ");
                    choixAssurance = Clavier.lireString().toLowerCase();
                    
                    while( !choixAssurance.equals(ASSURANCE_OUI) && !choixAssurance.equals(ASSURANCE_NON)){
                       System.out.println("\nEntrée invalide !\n");
                       System.out.println("Entrez le mode de paiement");
                       System.out.println("(D ou d pour Débit, C ou c pour Crédit):");
                       choixAssurance = Clavier.lireString().toLowerCase();
                       
                    }
                    
                    
                    System.out.println("\n-----------------------------------------------------------");
                    System.out.println(NOM_ENTREPRISE);
                    System.out.println("Adresse :       " + ADRESSE_ENTREPRISE);
                    System.out.println("Téléphone :     " + TELEPHONE_ENTREPRISE);
                    System.out.println("Date et Heure : " + tempsFormate );
                    nombreFacture++;
                    System.out.println("Facture No :    " + nombreFacture);
                    System.out.println("-----------------------------------------------------------\n");
                    
                    System.out.println("Prénom et nom : " +  prenomLocataire + " " + nomLocataire);
                    System.out.println("Téléphone : " + telephoneLocataire);
                    System.out.println("Permis de conduire : " + permisConduiteLocataire);
                    
                    System.out.print("\nType de véhicule : ");
                    if(choixOptionTypeVoiture.equals(PETIT_H)){
                        System.out.println("Hybride");
                    }else{
                        System.out.println("Électrique");
                        }
                    System.out.print("Grandeur du véhicule : ");
                    if(choixOptionGrandeurVoiture.equals(PETIT_P)){
                        System.out.println("Petit");
                    }else if(choixOptionGrandeurVoiture.equals(PETIT_I)){
                        System.out.println("Intermédiaire");
                    }else{
                        System.out.println("Grand");
                        }
                    
                    System.out.println("\nNombre de jours de location : " + choixJoursLocation);
                    System.out.println("Date de location : " + tempsFormate);
                    dateRetour = now.plusDays(choixJoursLocation).format(FORMATTER);
                    System.out.println("Date de retour   : " +  dateRetour);
                    
                    System.out.printf("Mode de paiement : ");
                    if(modePaiement.equals(PETIT_D)){
                        System.out.println("Débit");
                    }else{
                        System.out.println("Crédit");
                        }
                    
                        
                    System.out.print("Prix de la location par jour       ");
                    if(choixOptionTypeVoiture.equals(PETIT_H)){
                        if(choixOptionGrandeurVoiture.equals(PETIT_P)){
                            System.out.printf("%d$", LOCATION_HYBRIDE_PETIT);
                            sousTotalLocation = LOCATION_HYBRIDE_PETIT * choixJoursLocation;
                            System.out.printf("\nMontant de la location              %d$", sousTotalLocation);
                        }else if(choixOptionGrandeurVoiture.equals(PETIT_I)){
                            System.out.printf("%d$", LOCATION_HYBRIDE_INTERMEDIAIRE);
                            sousTotalLocation = LOCATION_HYBRIDE_PETIT * choixJoursLocation;
                            System.out.printf("\nMontant de la location              %d$", sousTotalLocation);
                        }else if(choixOptionGrandeurVoiture.equals(PETIT_G)){
                            System.out.printf("%d$", LOCATION_HYBRIDE_GRAND);
                            sousTotalLocation = LOCATION_HYBRIDE_PETIT * choixJoursLocation;
                            System.out.printf("\nMontant de la location              %d$", sousTotalLocation);
                        }
                    }else if((choixOptionTypeVoiture.equals(PETIT_E))){
                        if(choixOptionGrandeurVoiture.equals(PETIT_P)){
                            System.out.printf("%d$", LOCATION_ELECTRIQUE_PETIT);
                            sousTotalLocation = LOCATION_HYBRIDE_PETIT * choixJoursLocation;
                            System.out.printf("\nMontant de l'assurance             %d$", sousTotalLocation);
                        }else if(choixOptionGrandeurVoiture.equals(PETIT_I)){
                            System.out.printf("%d$", LOCATION_ELECTRIQUE_INTERMEDIAIRE);
                            sousTotalLocation = LOCATION_HYBRIDE_PETIT * choixJoursLocation;
                            System.out.printf("\nMontant de l'assurance             %d$", sousTotalLocation);
                        }else if(choixOptionGrandeurVoiture.equals(PETIT_G)){
                            System.out.printf("%d$", LOCATION_ELECTRIQUE_GRAND);
                            sousTotalLocation = LOCATION_HYBRIDE_PETIT * choixJoursLocation;
                            System.out.printf("\nMontant de l'assurance             %d$", sousTotalLocation);
                        }
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