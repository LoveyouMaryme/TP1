
/**
 * Ce programme permet de gérer la location des véhicules hybrides et électriques tel que demandé par le client.
 * 
 * On peut : 
 *  1. Afficher l'inventaire des voitures 
 *  2. Louer une voiture en fonction de son type, de sa taille et de sa disponibilité
 *  3. Créer une facture tout en prennant en compte les calculs business spécifés par le client
 *  4. Regarder le nombre de voitures louées
 *  5. Sortir du programme
 *
 * @author Love-Mary Victor (CJ490809)
 * @version : 18 Février, 2025
 * @github : https://github.com/LoveyouMaryme/TP1/blame/master/FacturationRoulonsVehiculesVerts.java
 * @code_permanent : VICL12599701
 */

// Importing LocalDateTime and DateTimeFormatter 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FacturationRoulonsVehiculesVerts
{
    public static void main(String [] args)

    {
        // Déclaration de constantes //
        //Messages affichés
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
        final String MESSAGE_RABAIS_LOCATION = "Rabais sur le prix de la location";
        final String MESSAGE_MONTANT_LOCATION_SOUS_TOTAL = "Montant de la location";
        final String MESSAGE_MONTANT_ASSURANCE = "Montant de l'assurance";
        final String MESSAGE_NOMBRE_VEHICULE_INVENTAIRE = "Nombre de véhicules disponibles dans l'inventaire";
        final String MESSAGE_NOMBRE_VEHICULE_LOUEE = "Nombre de véhicules loués par type et par catégorie";
        final String MESSAGE_SOUS_TOTAL = "Sous-total";
        final String MESSAGE_MONTANT_TPS = "Montant TPS";
        final String MESSAGE_MONTANT_TVQ = "Montant TVQ";
        final String MESSAGE_MONTANT_TOTAL = "Montant Total";
        final String MESSAGE_REMERCIEMENT = "Merci pour votre confiance!";

        // Prix des assurances et des locations
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

        // Choix de l'utilisateur
        final char VEHICULE_HYBRIDE = 'h'; 
        final char VEHICULE_ELECTRIQUE = 'e';
        final char VEHICULE_PETIT = 'p';
        final char VEHICULE_INTERMEDIAIRE = 'i';
        final char VEHICULE_GRAND = 'g';

        final int MAXJOURSLOCATION = 30;
        final int MINJOURSLOCATION = 0;

        final char ASSURANCE_OUI = 'o';
        final char ASSURANCE_NON = 'n';

        final char CARTE_DEBIT = 'd';
        final char CARTE_CREDIT = 'c';

        final char VISA_CARTE_CREDIT = 'v';
        final char MC_CARTE_CREDIT = 'm';

        // Formatter les dates
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:MM:SS");

        // Taxes et Rabais
        final float PERCENTAGE_TPS = 0.05f;
        final float PERCENTAGE_TVQ = 0.09975f;
        final float POURCENTAGE_RABAIS_LOCATION = 0.20f;

        // Déclaration de variables //

        // Inventaire des voitures
        int voituresLouesHybridesPetites = 0;
        int voituresRestantesHybridesPetites = 12;
        int voituresLouesHybridesIntermediaires = 0;
        int voituresRestantesHybridesIntermediaires = 10;
        int voituresLouesHybridesGrandes = 3;
        int voituresRestantesHybridesGrandes = 0;
        int voituresLouesElectriquesPetites = 0;
        int voituresRestantesElectriquesPetites = 11;
        int voituresLouesElectriquesIntermediaires = 0;
        int voituresRestantesElectriquesIntermediaires = 9;
        int voituresLouesElectriquesGrandes = 0;
        int voituresRestantesElectriquesGrandes = 5;

        int nombreVoituresChoisiesRestantes;

        // Choix du client
        char choixOptionTypeVoiture;
        char choixOptionTypeVoitureMin;
        char choixOptionGrandeurVoiture;
        byte choixOption;
        int choixJoursLocation;
        char choixAssurance;
        boolean isPressed = false;

        //Information du client
        String prenomLocataire;
        String nomLocataire;
        String telephoneLocataire;
        String permisConduiteLocataire;
        char modePaiement;
        char typeCarteCredit;
        String numeroCarteCredit;

        //Information sur la facture   
        LocalDateTime now = LocalDateTime.now();
        String dateNowFormate = now.format(FORMATTER);
        String dateLocationFormate = now.plusHours(3).format(FORMATTER);
        String dateRetourFormate;

        int nombreFacture = 0;

        float montantLocationChoisie = 0.0f;
        float montantRabaisLocation = 0.0f;
        float prixAssurance = 0.0f;
        float prixAssuranceFoisJours;
        float sousTotalLocation = 0.0f;
        float sousTotalLocationAvecAssurance;
        float montantTps;
        float montantTvq;
        float montantTotal;

        // Affichage de résultat //
        System.out.println(ENCADRE_TITRE);
        System.out.println(MESSAGE_BIENVENUE);
        System.out.println(ENCADRE_TITRE + "\n");

        do {  

            //Afficher le menu initial
            System.out.println("\n" + MESSAGE_MENU_CHOIX);
            System.out.printf("%s\n%s\n%s\n%s\n", CHOIX_UN, CHOIX_DEUX, CHOIX_TROIS, CHOIX_QUATRE);
            System.out.print("\n\nEntrez votre choix : ");
            choixOption = Clavier.lireByte();

            while(choixOption <= 0 || choixOption >= 5) {
                System.out.println("\nEntrée invalide !\n");
                System.out.println("\n" + MESSAGE_MENU_CHOIX);
                System.out.printf("%s\n%s\n%s\n%s\n", CHOIX_UN, CHOIX_DEUX, CHOIX_TROIS, CHOIX_QUATRE);
                System.out.print("\nEntrez votre choix : ");
                choixOption = Clavier.lireByteLn();

            }

            //Afficher les différents choix du menu
            switch(choixOption){
                    // Afficher l'inventaire des voitures disponibles
                case 1:
                    System.out.println("\n" + ENCADRE_SOUS_TIRE);
                    System.out.println(NOM_ENTREPRISE);
                    System.out.println("Adresse :       " + ADRESSE_ENTREPRISE);
                    System.out.println("Téléphone :     " + TELEPHONE_ENTREPRISE);
                    System.out.println("Date et Heure : " + dateNowFormate );
                    System.out.println(ENCADRE_SOUS_TIRE);

                    System.out.println("\n" + MESSAGE_NOMBRE_VEHICULE_INVENTAIRE);
                    System.out.println("*************************************************");
                    System.out.println("Grandeur          Hybride      Électrique");
                    System.out.println("****************************************");            
                    System.out.printf("Petit %15d %15d", voituresRestantesHybridesPetites, voituresRestantesElectriquesPetites);
                    System.out.printf("\nIntermédiaire %7d %15d", voituresRestantesHybridesIntermediaires, voituresRestantesElectriquesIntermediaires);
                    System.out.printf("\nGrand %15d %15d\n\n", voituresRestantesHybridesGrandes, voituresRestantesElectriquesGrandes);
                    System.out.println(ENCADRE_SOUS_TIRE);
                    break;

                    // Louer une voiture selon sa taille, son type, sa disponibilité et valider les modalités de paiement
                case 2:

                    //Choix du type de véhicule à louer et gestion des erreurs
                    System.out.println("\nEntrez le type du véhicule à louer");
                    System.out.print("(H ou h pour Hybride, et E ou e pour Électrique) :     ");
                    choixOptionTypeVoiture = Character.toLowerCase(Clavier.lireCharLn());

                    while(  choixOptionTypeVoiture != VEHICULE_HYBRIDE && choixOptionTypeVoiture != VEHICULE_ELECTRIQUE){
                        System.out.println("\nEntrée invalide !\n");
                        System.out.println("Entrez le type du véhicule à louer");
                        System.out.print("(H ou h pour Hybride, et E ou e pour Électrique) :    ");
                        choixOptionTypeVoiture = Character.toLowerCase(Clavier.lireCharLn());

                    }

                    // Choix de la grandeur du véhicule à louet et gestion des erreurs
                    System.out.println("\nEntrez la grandeur du véhicule à louer");
                    System.out.print("(P ou p pour Petit, I ou i pour Intermédiaire, et G ou g pour Grand) :    ");
                    choixOptionGrandeurVoiture = Character.toLowerCase(Clavier.lireCharLn());

                    while(choixOptionGrandeurVoiture != VEHICULE_PETIT   && 
                    choixOptionGrandeurVoiture != VEHICULE_INTERMEDIAIRE && 
                    choixOptionGrandeurVoiture != VEHICULE_GRAND ){
                        System.out.println("\nEntrée invalide !\n");
                        System.out.println("Entrez la grandeur du véhicule à louer");
                        System.out.print("(P ou p pour Petit, I ou i pour Intermédiaire, et G ou g pour Grand) :     ");
                        choixOptionGrandeurVoiture = Character.toLowerCase(Clavier.lireCharLn());
                    }

                    System.out.println("");

                    //Gestion de choix du véhicule et gestion de l'inventaire

                    if(choixOptionTypeVoiture == VEHICULE_HYBRIDE){
                        if(choixOptionGrandeurVoiture == VEHICULE_PETIT){
                            nombreVoituresChoisiesRestantes = voituresRestantesHybridesPetites;
                            if(nombreVoituresChoisiesRestantes > 0){
                                voituresLouesHybridesPetites++;
                                voituresRestantesHybridesPetites--;}
                        }else if(choixOptionGrandeurVoiture == VEHICULE_INTERMEDIAIRE ){
                            nombreVoituresChoisiesRestantes = voituresRestantesHybridesIntermediaires;
                            if(nombreVoituresChoisiesRestantes > 0){
                                voituresLouesHybridesIntermediaires++;
                                voituresRestantesHybridesIntermediaires--;}
                        }else{
                            nombreVoituresChoisiesRestantes = voituresRestantesHybridesGrandes;
                            if(nombreVoituresChoisiesRestantes > 0){
                                voituresLouesHybridesGrandes++;
                                voituresRestantesHybridesGrandes--;}
                        }
                    }else{
                        if(choixOptionGrandeurVoiture == VEHICULE_PETIT){
                            nombreVoituresChoisiesRestantes = voituresRestantesElectriquesPetites;
                            if(nombreVoituresChoisiesRestantes > 0){
                                voituresLouesElectriquesPetites++;
                                voituresRestantesElectriquesPetites--;}
                        }else if(choixOptionGrandeurVoiture == VEHICULE_INTERMEDIAIRE ){
                            nombreVoituresChoisiesRestantes = voituresRestantesElectriquesIntermediaires;
                            if(nombreVoituresChoisiesRestantes > 0){
                                voituresLouesElectriquesIntermediaires++;
                                voituresRestantesElectriquesIntermediaires--;}
                        }else{
                            nombreVoituresChoisiesRestantes = voituresRestantesElectriquesGrandes;
                            if(nombreVoituresChoisiesRestantes > 0){
                                voituresLouesElectriquesGrandes++;
                                voituresRestantesElectriquesGrandes--;}
                        }
                    }

                    // Retour au menu si voiture choisie n'est pas disponible
                    if(nombreVoituresChoisiesRestantes != 0){
                        System.out.println(nombreVoituresChoisiesRestantes + " véhicules de ce type et de cette grandeur sont disponibles !\n");
                    }else{
                        System.out.print("Aucun véhicule de ce type et de cette grandeur n'est disponible !");
                        break;
                    }

                    // Choix du nombre de jour et gestion des erreurs si inférieur à 0 ou supérieur à 30
                    System.out.println("Entrez le nombre de jours de location");
                    System.out.print("(supérieur à 0 et inférieur ou égal à 30) :    ");
                    choixJoursLocation = Clavier.lireInt();

                    while(choixJoursLocation <= MINJOURSLOCATION || choixJoursLocation >= MAXJOURSLOCATION){
                        System.out.println("\nEntrée invalide !\n");
                        System.out.println("Entrez le nombre de jours de location");
                        System.out.print("(supérieur à 0 et inférieur ou égal à 30) :    ");
                        choixJoursLocation = Clavier.lireInt();

                    }

                    //Entrer les informations du client
                    System.out.print("\nEntrez le prénom du locataire :    ");
                    prenomLocataire = Clavier.lireString();
                    System.out.print("\nEntrez le nom du locataire :     ");
                    nomLocataire = Clavier.lireString();
                    System.out.print("\nEntrez le numéro de téléphone du locataire :    ");
                    telephoneLocataire = Clavier.lireString();
                    System.out.print("\nEntrez le numéro de permis de conduire du locataire :     ");
                    permisConduiteLocataire = Clavier.lireString();

                    //Information des cartes de paiement et gestion des erreurs
                    System.out.println("\nEntrez le mode de paiement");
                    System.out.print("(D ou d pour Débit, C ou c pour Crédit): ");
                    modePaiement = Character.toLowerCase(Clavier.lireCharLn());

                    while( modePaiement != CARTE_DEBIT && modePaiement != CARTE_CREDIT){
                        System.out.println("\nEntrée invalide !\n");
                        System.out.println("Entrez le mode de paiement");
                        System.out.print("(D ou d pour Débit, C ou c pour Crédit):    ");
                        modePaiement = Character.toLowerCase(Clavier.lireCharLn());

                    }

                    if(modePaiement==CARTE_CREDIT){
                        System.out.println("\nEntrez le type de la carte de crédit");
                        System.out.print("(V ou v pour Visa, et M ou m pour MasterCard): ");
                        typeCarteCredit = Character.toLowerCase(Clavier.lireCharLn());

                        while( typeCarteCredit != VISA_CARTE_CREDIT &&  typeCarteCredit != MC_CARTE_CREDIT){
                            System.out.println("\nEntrée invalide !\n");
                            System.out.println("\nEntrez le type de la carte de crédit");
                            System.out.print("(V ou v pour Visa, et M ou m pour MasterCard): ");
                            typeCarteCredit = Character.toLowerCase(Clavier.lireCharLn());

                        } 

                        System.out.print("\nEntrez le numéro de la carte de crédit :");
                        numeroCarteCredit = Clavier.lireString();
                    }

                    //Choix des assurances et gestion des erreurs
                    System.out.println("\nDésirez-vous prendre l'assurance");
                    System.out.print("(O ou o pour Oui, N ou n pour Non) ? :    ");
                    choixAssurance = Character.toLowerCase(Clavier.lireCharLn());

                    while( choixAssurance != ASSURANCE_OUI && choixAssurance != ASSURANCE_NON){
                        System.out.println("\nEntrée invalide !\n");
                        System.out.println("Désirez-vous prendre l'assurance");
                        System.out.print("(O ou o pour Oui, N ou n pour Non) ? :    ");
                        choixAssurance = Character.toLowerCase(Clavier.lireCharLn());
                    }

                    //Écriture de la facture pour le client
                    //Information du client
                    System.out.println("\n" + ENCADRE_SOUS_TIRE);
                    System.out.println(NOM_ENTREPRISE);
                    System.out.println("Téléphone :     " + TELEPHONE_ENTREPRISE);
                    System.out.println("Adresse :       " + ADRESSE_ENTREPRISE);
                    System.out.println("Date et Heure : " + dateNowFormate);
                    nombreFacture++;
                    System.out.println("Facture No :    " + nombreFacture);
                    System.out.println(ENCADRE_SOUS_TIRE);

                    System.out.println("\nPrénom et nom : " +  prenomLocataire + " " + nomLocataire);
                    System.out.println("Téléphone : " + telephoneLocataire);
                    System.out.println("Permis de conduire : " + permisConduiteLocataire);

                    // Information de la voiture louée
                    System.out.print("\nType de véhicule : ");
                    if(choixOptionTypeVoiture == VEHICULE_HYBRIDE){
                        System.out.println("Hybride");
                    }else{
                        System.out.println("Électrique");
                    }
                    System.out.print("Grandeur du véhicule : ");
                    if(choixOptionGrandeurVoiture == VEHICULE_PETIT){
                        System.out.println("Petit");
                    }else if(choixOptionGrandeurVoiture == VEHICULE_INTERMEDIAIRE){
                        System.out.println("Intermédiaire");
                    }else{
                        System.out.println("Grand");
                    }

                    // Dates de début et de retour du location
                    System.out.println("\nNombre de jours de location : " + choixJoursLocation);
                    System.out.println("Date de location : " + dateLocationFormate);

                    dateRetourFormate = now.plusHours(3).plusDays(choixJoursLocation).format(FORMATTER);
                    System.out.println("Date de retour   : " +  dateRetourFormate); 

                    // Mode de paiement
                    System.out.print("\nMode de paiement : ");
                    if(modePaiement == CARTE_DEBIT){
                        System.out.println("Débit");
                    }else{
                        System.out.println("Crédit");
                    }

                    // Prix de la location de la voiture en tenant en compte des assurances et des rabais
                    System.out.print("\nPrix de la location par jour       ");
                    if(choixOptionTypeVoiture == VEHICULE_HYBRIDE){
                        if(choixOptionGrandeurVoiture == VEHICULE_PETIT){
                            System.out.printf("%.2f$", LOCATION_HYBRIDE_PETIT);
                            montantLocationChoisie = LOCATION_HYBRIDE_PETIT;                          
                        }else if(choixOptionGrandeurVoiture == VEHICULE_INTERMEDIAIRE){
                            System.out.printf("%.2f$", LOCATION_HYBRIDE_INTERMEDIAIRE);
                            montantLocationChoisie = LOCATION_HYBRIDE_INTERMEDIAIRE;                          
                        }else if(choixOptionGrandeurVoiture == VEHICULE_GRAND){
                            System.out.printf("%.2f$", LOCATION_HYBRIDE_GRAND);
                            montantLocationChoisie = LOCATION_HYBRIDE_GRAND;                          
                        }
                    }else if((choixOptionTypeVoiture == VEHICULE_ELECTRIQUE)){
                        if(choixOptionGrandeurVoiture == VEHICULE_PETIT){
                            System.out.printf("%.2f$", LOCATION_ELECTRIQUE_PETIT);
                            montantLocationChoisie = LOCATION_ELECTRIQUE_PETIT;
                            sousTotalLocation = LOCATION_ELECTRIQUE_PETIT * choixJoursLocation;
                        }else if(choixOptionGrandeurVoiture == VEHICULE_INTERMEDIAIRE){
                            System.out.printf("%.2f$", LOCATION_ELECTRIQUE_INTERMEDIAIRE);
                            montantLocationChoisie = LOCATION_ELECTRIQUE_INTERMEDIAIRE;
                        }else if(choixOptionGrandeurVoiture == VEHICULE_GRAND){
                            System.out.printf("%.2f$", LOCATION_ELECTRIQUE_GRAND);
                            montantLocationChoisie = LOCATION_ELECTRIQUE_GRAND;
                        }
                    }
                    System.out.print("\nPrix de l'assurance par jour       ");
                    switch(choixAssurance){

                        case 'o': 
                            if(choixOptionTypeVoiture == VEHICULE_HYBRIDE){
                                if(choixOptionGrandeurVoiture == VEHICULE_PETIT){
                                    System.out.printf("%.2f$", ASSURANCE_HYBRIDE_PETIT);  
                                    prixAssurance = ASSURANCE_HYBRIDE_PETIT;
                                }else if(choixOptionGrandeurVoiture == VEHICULE_INTERMEDIAIRE){
                                    System.out.printf("%.2f$", ASSURANCE_HYBRIDE_INTERMEDIAIRE);   
                                    prixAssurance = ASSURANCE_HYBRIDE_INTERMEDIAIRE;
                                }else if(choixOptionGrandeurVoiture == VEHICULE_GRAND){
                                    System.out.printf("%.2f$", ASSURANCE_HYBRIDE_GRAND); 
                                    prixAssurance = ASSURANCE_HYBRIDE_GRAND;
                                }
                            }else if((choixOptionTypeVoiture == VEHICULE_ELECTRIQUE)){
                                if(choixOptionGrandeurVoiture == VEHICULE_PETIT){
                                    System.out.printf("%.2f$", ASSURANCE_ELECTRIQUE_PETIT);
                                    prixAssurance = ASSURANCE_ELECTRIQUE_PETIT;
                                }else if(choixOptionGrandeurVoiture == VEHICULE_INTERMEDIAIRE){
                                    System.out.printf("%.2f$", ASSURANCE_ELECTRIQUE_INTERMEDIAIRE);
                                    prixAssurance = ASSURANCE_ELECTRIQUE_INTERMEDIAIRE;
                                }else if(choixOptionGrandeurVoiture == VEHICULE_GRAND){
                                    System.out.printf("%.2f$", ASSURANCE_ELECTRIQUE_GRAND);
                                    prixAssurance = ASSURANCE_ELECTRIQUE_GRAND;
                                }
                            }
                            break;
                        case 'n':
                            prixAssurance = 0;
                            System.out.printf("%.2f$", prixAssurance);
                            break;
                    }

                    if(choixJoursLocation > 15){
                        montantRabaisLocation = montantLocationChoisie * POURCENTAGE_RABAIS_LOCATION;
                        sousTotalLocation = ( montantLocationChoisie * choixJoursLocation ) - ( montantRabaisLocation * choixJoursLocation); 
                        System.out.printf("\n%-34s %.2f$", MESSAGE_RABAIS_LOCATION, montantRabaisLocation);
                    }else{
                        sousTotalLocation = montantLocationChoisie * choixJoursLocation;
                    }

                    //Affichage des informations de la facture
                    System.out.printf("\n\n%-34s %.2f$", MESSAGE_MONTANT_LOCATION_SOUS_TOTAL, sousTotalLocation);
                    prixAssuranceFoisJours = prixAssurance*choixJoursLocation;
                    System.out.printf("\n%-34s %.2f$", MESSAGE_MONTANT_ASSURANCE, prixAssuranceFoisJours);
                    sousTotalLocationAvecAssurance = sousTotalLocation + prixAssuranceFoisJours;
                    System.out.printf("\n\n%-34s %.2f$", MESSAGE_SOUS_TOTAL, sousTotalLocationAvecAssurance);
                    montantTps = sousTotalLocationAvecAssurance*PERCENTAGE_TPS;
                    System.out.printf("\n%-34s %.2f$", MESSAGE_MONTANT_TPS, montantTps);
                    montantTvq = sousTotalLocationAvecAssurance*PERCENTAGE_TVQ;
                    System.out.printf("\n%-34s %.2f$", MESSAGE_MONTANT_TVQ, montantTvq);
                    System.out.printf("\n%-34s %.2f$", MESSAGE_MONTANT_TOTAL, (sousTotalLocationAvecAssurance + montantTps + montantTvq));

                    System.out.println("\n" + ENCADRE_SOUS_TIRE);
                    System.out.println(MESSAGE_REMERCIEMENT);                            
                    break;

                    //Afficher les voitures louées
                case 3:
                    System.out.println("\n" + ENCADRE_SOUS_TIRE);
                    System.out.println(NOM_ENTREPRISE);
                    System.out.println("Adresse :       " + ADRESSE_ENTREPRISE);
                    System.out.println("Téléphone :     " + TELEPHONE_ENTREPRISE);
                    System.out.println("Date et Heure : " + dateNowFormate );
                    System.out.println("\n" + ENCADRE_SOUS_TIRE);

                    System.out.println("\n" + MESSAGE_NOMBRE_VEHICULE_INVENTAIRE);
                    System.out.println("*************************************************");
                    System.out.println("Grandeur          Hybride      Électrique");
                    System.out.println("****************************************");            
                    System.out.printf("Petit %15d %15d", voituresLouesHybridesPetites, voituresLouesElectriquesPetites);
                    System.out.printf("\nIntermédiaire %7d %15d", voituresLouesHybridesIntermediaires, voituresLouesElectriquesIntermediaires);
                    System.out.printf("\nGrand %15d %15d\n\n", voituresLouesHybridesGrandes, voituresLouesElectriquesGrandes);
                    System.out.println(ENCADRE_SOUS_TIRE);
                    break;

                    // Quitter le programme
                case 4:
                    System.out.println("\n\nMerci et à la prochaine !");
                    System.exit(0);

            } 
            //Revenir au menu principal
            //watermark This is Love's work and no one else's. I cried too much on this.
            System.out.println("\n\nAppuyer sur <ENTREE> pour réafficher le menu...");
            Clavier.lireFinLigne();
            isPressed = true;

        }while(isPressed);
    }
}