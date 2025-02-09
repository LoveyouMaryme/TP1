
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
        final String MESSAGE_SOUS_TOTAL = "Sous-total";
        final String MESSAGE_MONTANT_TPS = "Montant TPS";
        final String MESSAGE_MONTANT_TVQ = "Montant TVQ";
        final String MESSAGE_MONTANT_TOTAL = "Montant Total";
        final String MESSAGE_REMERCIEMENT = "Merci pour votre confiance!";

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

        final String ASSURANCE_OUI = "o";
        final String ASSURANCE_NON = "n";

        final String PETIT_D = "d";
        final String PETIT_C = "c";

        final String VISA_CARTE_CREDIT = "v";
        final String MC_CARTE_CREDIT = "m";

        final float PERCENTAGE_TPS = 0.05f;
        final float PERCENTAGE_TVQ = 0.09975f;


        // Déclaration de variables
        byte choixOption;
        int voituresLouesHybridesPetites = 0;
        int voituresRestantesHybridesPetites = 12;
        int voituresLouesHybridesIntermediaires = 0;
        int voituresRestantesHybridesIntermediaires = 10;
        int voituresLouesHybridesGrandes = 0;
        int voituresRestantesHybridesGrandes = 0;
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
        float prixAssurance = 0.0f;
        float prixAssuranceFoisJours;
        float sousTotalLocation = 0.0f;
        float sousTotalLocationAvecAssurance;
        float montantTps;
        float montantTvq;
        float montantTotal;
        String typeCarteCredit;
        String numeroCarteCredit;
        int nombreVoituresChoisiesRestantes;


        // Affichage de résultat
        System.out.println(ENCADRE_TITRE);
        System.out.println(MESSAGE_BIENVENUE);
        System.out.println(ENCADRE_TITRE + "\n");

        do {  
            //Afficher le menu initial

            System.out.println(MESSAGE_MENU_CHOIX);
            System.out.printf("%s\n%s\n%s\n%s\n", CHOIX_UN, CHOIX_DEUX, CHOIX_TROIS, CHOIX_QUATRE);
            System.out.print("\nEntrez votre choix : ");
            choixOption = Clavier.lireByte();

            //Gérer les erreurs d'options  
            while(choixOption <= 0 || choixOption >= 5) {
                System.out.println("\nEntrée invalide !\n");
                System.out.println("\n" + MESSAGE_MENU_CHOIX);
                System.out.printf("%s\n%s\n%s\n%s\n", CHOIX_UN, CHOIX_DEUX, CHOIX_TROIS, CHOIX_QUATRE);
                System.out.print("\nEntrez votre choix : ");
                choixOption = Clavier.lireByte();

            }

            
            //Afficher les différents choix
            switch(choixOption){
                case 1:
                    System.out.println("\n" + ENCADRE_SOUS_TIRE);
                    System.out.println(NOM_ENTREPRISE);
                    System.out.println("Adresse :       " + ADRESSE_ENTREPRISE);
                    System.out.println("Téléphone :     " + TELEPHONE_ENTREPRISE);
                    System.out.println("Date et Heure : " + tempsFormate );
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
                case 2:
                    System.out.println("\nEntrez le type du véhicule à louer");
                    System.out.print("(H ou h pour Hybride, et E ou e pour Électrique) :     ");
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
                        System.out.print("(P ou p pour Petit, I ou i pour Intermédiaire, et G ou g pour Grand) :     ");
                        choixOptionGrandeurVoiture = Clavier.lireString().toLowerCase();
                    }

                    System.out.println("");

                    if(choixOptionTypeVoiture.equals(PETIT_H)){
                        if(choixOptionGrandeurVoiture.equals(PETIT_P)){
                            nombreVoituresChoisiesRestantes = voituresRestantesHybridesPetites;
                            voituresLouesHybridesPetites++;
                            voituresRestantesHybridesPetites--;
                        }else if(choixOptionGrandeurVoiture.equals(PETIT_I)){
                            nombreVoituresChoisiesRestantes = voituresRestantesHybridesIntermediaires;
                            voituresLouesHybridesIntermediaires++;
                            voituresRestantesHybridesIntermediaires--;
                        }else{
                            nombreVoituresChoisiesRestantes = voituresRestantesHybridesGrandes;
                            voituresLouesHybridesGrandes++;
                            voituresRestantesHybridesGrandes--;
                        }
                    }else{
                        if(choixOptionGrandeurVoiture.equals(PETIT_P)){
                            nombreVoituresChoisiesRestantes = voituresRestantesElectriquesPetites;
                            voituresLouesElectriquesPetites++;
                            voituresRestantesElectriquesPetites--;
                        }else if(choixOptionGrandeurVoiture.equals(PETIT_I)){
                            nombreVoituresChoisiesRestantes = voituresRestantesElectriquesIntermediaires;
                            voituresLouesElectriquesIntermediaires++;
                            voituresRestantesElectriquesIntermediaires--;
                        }else{
                            nombreVoituresChoisiesRestantes = voituresRestantesElectriquesGrandes;
                            voituresLouesElectriquesGrandes++;
                            voituresRestantesElectriquesGrandes--;
                        }
                    }

                    if(nombreVoituresChoisiesRestantes != 0){
                        System.out.println(nombreVoituresChoisiesRestantes + " véhicules de ce type et de cette grandeur sont disponibles !\n");
                    }else{
                        System.out.print("Aucun véhicule de ce type et de cette grandeur n'est disponible !");
                        break;
                    }

                    System.out.println("Entrez le nombre de jours de location");
                    System.out.print("(supérieur à 0 et inférieur ou égal à 30) :    ");
                    choixJoursLocation = Clavier.lireInt();

                    while(choixJoursLocation <= MINJOURSLOCATION|| choixJoursLocation >= MAXJOURSLOCATION){
                        System.out.println("\nEntrée invalide !\n");
                        System.out.println("Entrez le nombre de jours de location");
                        System.out.print("(supérieur à 0 et inférieur ou égal à 30) :    ");
                        choixJoursLocation = Clavier.lireInt();

                    }

                    System.out.print("\nEntrez le prénom du locataire :    ");
                    prenomLocataire = Clavier.lireString();
                    System.out.print("\nEntrez le nom du locataire :     ");
                    nomLocataire = Clavier.lireString();
                    System.out.print("\nEntrez le numéro de téléphone du locataire :    ");
                    telephoneLocataire = Clavier.lireString();
                    System.out.print("\nEntrez le numéro de permis de conduire du locataire :     ");
                    permisConduiteLocataire = Clavier.lireString();

                    System.out.println("\nEntrez le mode de paiement");
                    System.out.print("(D ou d pour Débit, C ou c pour Crédit): ");
                    modePaiement = Clavier.lireString().toLowerCase();

                    while( !modePaiement.equals(PETIT_D) && !modePaiement.equals(PETIT_C)){
                        System.out.println("\nEntrée invalide !\n");
                        System.out.println("Entrez le mode de paiement");
                        System.out.print("(D ou d pour Débit, C ou c pour Crédit):    ");
                        modePaiement = Clavier.lireString().toLowerCase();

                    }

                    if(modePaiement.equals(PETIT_C)){
                        System.out.println("\nEntrez le type de la carte de crédit");
                        System.out.print("(V ou v pour Visa, et M ou m pour MasterCard): ");
                        typeCarteCredit = Clavier.lireString().toLowerCase();

                        while( !typeCarteCredit.equals(VISA_CARTE_CREDIT) && !typeCarteCredit.equals(MC_CARTE_CREDIT)){
                            System.out.println("\nEntrée invalide !\n");
                            System.out.println("\nEntrez le type de la carte de crédit");
                            System.out.print("(V ou v pour Visa, et M ou m pour MasterCard): ");
                            typeCarteCredit = Clavier.lireString().toLowerCase();

                        } 

                        System.out.println("Entrez le numéro de la carte de crédit :");
                        numeroCarteCredit = Clavier.lireString().toLowerCase();
                    }

                    System.out.println("\nDésirez-vous prendre l'assurance");
                    System.out.print("(O ou o pour Oui, N ou n pour Non) ? :    ");
                    choixAssurance = Clavier.lireString().toLowerCase();

                    while( !choixAssurance.equals(ASSURANCE_OUI) && !choixAssurance.equals(ASSURANCE_NON)){
                        System.out.println("\nEntrée invalide !\n");
                        System.out.println("Désirez-vous prendre l'assurance");
                        System.out.print("(O ou o pour Oui, N ou n pour Non) ? :    ");
                        choixAssurance = Clavier.lireString().toLowerCase();
                    }

                    System.out.println("\n" + ENCADRE_SOUS_TIRE);
                    System.out.println(NOM_ENTREPRISE);
                    System.out.println("Adresse :       " + ADRESSE_ENTREPRISE);
                    System.out.println("Téléphone :     " + TELEPHONE_ENTREPRISE);
                    System.out.println("Date et Heure : " + tempsFormate );
                    nombreFacture++;
                    System.out.println("Facture No :    " + nombreFacture);
                    System.out.println(ENCADRE_SOUS_TIRE);

                    System.out.println("\nPrénom et nom : " +  prenomLocataire + " " + nomLocataire);
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
                    System.out.println("Date de retour   : " +  dateRetour); //rajouter 3 heures;

                    System.out.print("\nMode de paiement : ");
                    if(modePaiement.equals(PETIT_D)){
                        System.out.println("Débit");
                    }else{
                        System.out.println("Crédit");
                    }

                    System.out.print("\nPrix de la location par jour       ");
                    if(choixOptionTypeVoiture.equals(PETIT_H)){
                        if(choixOptionGrandeurVoiture.equals(PETIT_P)){
                            System.out.printf("%.2f$", LOCATION_HYBRIDE_PETIT);
                            sousTotalLocation = LOCATION_HYBRIDE_PETIT * choixJoursLocation;                            
                        }else if(choixOptionGrandeurVoiture.equals(PETIT_I)){
                            System.out.printf("%.2f$", LOCATION_HYBRIDE_INTERMEDIAIRE);
                            sousTotalLocation = LOCATION_HYBRIDE_INTERMEDIAIRE * choixJoursLocation;                            
                        }else if(choixOptionGrandeurVoiture.equals(PETIT_G)){
                            System.out.printf("%.2f$", LOCATION_HYBRIDE_GRAND);
                            sousTotalLocation = LOCATION_HYBRIDE_GRAND * choixJoursLocation;                            
                        }
                    }else if((choixOptionTypeVoiture.equals(PETIT_E))){
                        if(choixOptionGrandeurVoiture.equals(PETIT_P)){
                            System.out.printf("%.2f$", LOCATION_ELECTRIQUE_PETIT);
                            sousTotalLocation = LOCATION_ELECTRIQUE_PETIT * choixJoursLocation;
                        }else if(choixOptionGrandeurVoiture.equals(PETIT_I)){
                            System.out.printf("%.2f$", LOCATION_ELECTRIQUE_INTERMEDIAIRE);
                            sousTotalLocation = LOCATION_ELECTRIQUE_INTERMEDIAIRE * choixJoursLocation;
                        }else if(choixOptionGrandeurVoiture.equals(PETIT_G)){
                            System.out.printf("%.2f$", LOCATION_ELECTRIQUE_GRAND);
                            sousTotalLocation = LOCATION_ELECTRIQUE_GRAND * choixJoursLocation;
                        }
                    }
                    System.out.print("\nPrix de l'assurance par jour       ");
                    switch(choixAssurance){

                        case "o": 
                            if(choixOptionTypeVoiture.equals(PETIT_H)){
                                if(choixOptionGrandeurVoiture.equals(PETIT_P)){
                                    System.out.printf("%.2f$", ASSURANCE_HYBRIDE_PETIT);  
                                    prixAssurance = ASSURANCE_HYBRIDE_PETIT;
                                }else if(choixOptionGrandeurVoiture.equals(PETIT_I)){
                                    System.out.printf("%.2f$", ASSURANCE_HYBRIDE_INTERMEDIAIRE);   
                                    prixAssurance = ASSURANCE_HYBRIDE_INTERMEDIAIRE;
                                }else if(choixOptionGrandeurVoiture.equals(PETIT_G)){
                                    System.out.printf("%.2f$", ASSURANCE_HYBRIDE_GRAND); 
                                    prixAssurance = ASSURANCE_HYBRIDE_GRAND;
                                }
                            }else if((choixOptionTypeVoiture.equals(PETIT_E))){
                                if(choixOptionGrandeurVoiture.equals(PETIT_P)){
                                    System.out.printf("%.2f$", ASSURANCE_ELECTRIQUE_PETIT);
                                    prixAssurance = ASSURANCE_ELECTRIQUE_PETIT;
                                }else if(choixOptionGrandeurVoiture.equals(PETIT_I)){
                                    System.out.printf("%.2f$", ASSURANCE_ELECTRIQUE_INTERMEDIAIRE);
                                    prixAssurance = ASSURANCE_ELECTRIQUE_INTERMEDIAIRE;
                                }else if(choixOptionGrandeurVoiture.equals(PETIT_G)){
                                    System.out.printf("%.2f$", ASSURANCE_ELECTRIQUE_GRAND);
                                    prixAssurance = ASSURANCE_ELECTRIQUE_GRAND;
                                }
                            }
                            break;
                        case "n":
                            prixAssurance = 0;
                            break;
                    }

                    System.out.printf("\n\nMontant de la location              %.2f$", sousTotalLocation);
                    prixAssuranceFoisJours = prixAssurance*choixJoursLocation;
                    System.out.printf("\nMontant de l'assurance              %.2f$", prixAssuranceFoisJours);
                    sousTotalLocationAvecAssurance = sousTotalLocation + prixAssuranceFoisJours;
                    System.out.printf("\n\n%-20s  %.2f$", MESSAGE_SOUS_TOTAL, sousTotalLocationAvecAssurance);
                    montantTps = sousTotalLocationAvecAssurance*PERCENTAGE_TPS;
                    System.out.printf("\n%-20s  %.2f$", MESSAGE_MONTANT_TPS, montantTps);
                    montantTvq = sousTotalLocationAvecAssurance*PERCENTAGE_TVQ;
                    System.out.printf("\n%-20s  %.2f$", MESSAGE_MONTANT_TVQ, montantTvq);
                    System.out.printf("\n%-20s  %.2f$", MESSAGE_MONTANT_TOTAL, (sousTotalLocationAvecAssurance + montantTps + montantTvq));

                    System.out.println("\n" + ENCADRE_SOUS_TIRE);
                    System.out.println(MESSAGE_REMERCIEMENT);                            
                    break;
                case 3:
                    System.out.println("\n" + ENCADRE_SOUS_TIRE);
                    System.out.println(NOM_ENTREPRISE);
                    System.out.println("Adresse :       " + ADRESSE_ENTREPRISE);
                    System.out.println("Téléphone :     " + TELEPHONE_ENTREPRISE);
                    System.out.println("Date et Heure : " + tempsFormate );
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
                case 4:
                    System.out.println("\n\nMerci et à la prochaine !");
                    System.exit(0);

            } 
            // people can add a stupid letter here for nothing; what can I do
            System.out.println("\n\nAppuyer sur <ENTREE> pour réafficher le menu...");
            Clavier.lireFinLigne();
            isPressed = true;

        }while(isPressed = true);
    }
}