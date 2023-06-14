/**
* Comment intgrer la librairie ardoise.jar dans votre projet Eclipse
 *
 * 1/ Crer un dossier libs dans votre projet Eclipse
 * Clic droit sur votre projet -> New -> Folder
 *
 * 2/ Copier ardoise.jar dans le dossier libs
 *
 * 3/ Déclarer ardoise.jar comme librairie externe pour votre projet
 * Clic droit sur ardoise.jar (dossier libs) -> Build Path -> Add to Build Path
 */



 /**
 * Importation des classes
 * PointPlan
 * Segment
 * Ardoise0 *
 * qui sont fournis dans la librairie ardoise.jar
 */

import ardoise.*;

/**
 * Classe TestProject
 * @author1 Mohamed
 * @author2 Vithurzen
 * @groupe Zeus
 * @version 1.0
 * @github_author1 https://github.com/mohamed-rahmani
 * @github_author2 https://github.com/vithurzen-vilvarajah
 *
 * Validation de l’ intgration de la librairie ardoise.jar au projet Java sur Eclipse et test de toute les classes du projet
 */

public class TestProject {

    public static void main(String []args ) throws ColineaireException, ToitPasSurLeCorpsException, PointsNonConnectesException{
        
        /* Ajout de l'ardoise */
        Ardoise ardoise = new Ardoise();

        /* Création du toit de la masion via la classe Triangles */
        PointPlan p1toit = new PointPlan(80, 140);
        PointPlan p2toit = new PointPlan(130, 100);
        PointPlan p3toit = new PointPlan(180, 140);

        Chapeaux toitmaison = new Chapeaux(p1toit, p2toit, p3toit);

        /* Création de la tour, du corps et de la porte de la maison via la classe Quadrilateres*/
        PointPlan p1corps = new PointPlan(80, 140);
        PointPlan p2corps = new PointPlan(180, 198);

        PointPlan p1tour = new PointPlan(9, 100);
        PointPlan p2tour= new PointPlan(20, 198);

        PointPlan p1porte = new PointPlan(120, 170);
        PointPlan p2porte = new PointPlan(140, 198);

        Quadrilateres corpsmaison = new Quadrilateres(p1corps, p2corps);
        Quadrilateres tour = new Quadrilateres(p1tour, p2tour);
        Quadrilateres portemaison = new Quadrilateres(p1porte, p2porte);

        ardoise.ajouterForme(tour);

        /* Première méthode : Ajout de la maison via la classe Maison */
        Maisons m = new Maisons(toitmaison, corpsmaison, portemaison);
        ardoise.ajouterForme(m);

        /* Deuxième méthode : Ajout de la maison via les classes Triangles et Quadrilatères
        ardoise.ajouterForme(corpsmaison);
        ardoise.ajouterForme(portemaison);
        ardoise.ajouterForme(toitmaison);

        */

        /* Ajout des 3 oiseaux via la classe Chapeaux*/
        PointPlan p1oiseau1 = new PointPlan(118, 13);
        PointPlan p2oiseau1 = new PointPlan(123, 20);
        PointPlan p3oiseau1 = new PointPlan(128, 13);

        PointPlan p1oiseau2 = new PointPlan(133, 30);
        PointPlan p2oiseau2 = new PointPlan(136, 32);
        PointPlan p3oiseau2 = new PointPlan(138, 30);

        PointPlan p1oiseau3 = new PointPlan(142, 14);
        PointPlan p2oiseau3 = new PointPlan(144, 17);
        PointPlan p3oiseau3 = new PointPlan(146, 14);

        Chapeaux oiseau1 = new Chapeaux(p1oiseau1, p2oiseau1, p3oiseau1);
        Chapeaux oiseau2 = new Chapeaux(p1oiseau2, p2oiseau2, p3oiseau2);
        Chapeaux oiseau3 = new Chapeaux(p1oiseau3, p2oiseau3, p3oiseau3);

        ardoise.ajouterForme(oiseau1);
        ardoise.ajouterForme(oiseau2);
        ardoise.ajouterForme(oiseau3);

        /*Deplacement de l'oiseau de 10 en abscisse et 2 en ordonnée
        oiseau1.deplacer(10, 20);
        */

        /* Ajout des 2 Montages via la classe Triangles */
        PointPlan p1montagne1 = new PointPlan(3, 14);
        PointPlan p2montagne1 = new PointPlan(43, 3);
        PointPlan p3montagne1 = new PointPlan(112, 14);

        PointPlan p1montagne2 = new PointPlan(152, 7);
        PointPlan p2montagne2 = new PointPlan(166, 3);
        PointPlan p3montagne2 = new PointPlan(172, 7);

        Triangles montagne1 = new Triangles(p1montagne1, p2montagne1, p3montagne1);
        Triangles montagne2 = new Triangles(p1montagne2, p2montagne2, p3montagne2);

        ardoise.ajouterForme(montagne1);
        ardoise.ajouterForme(montagne2);

        /* Ajout de l'étoile via la classe Etoile */
        PointPlan p1branche1 = new PointPlan(170, 52);
        PointPlan p2branche1 = new PointPlan(173, 45);
        PointPlan p3branche1 = new PointPlan(177, 52);

        PointPlan p2branche2 = new PointPlan(184, 57);
        PointPlan p3branche2 = new PointPlan(177, 60);

        PointPlan p2branche3 = new PointPlan(174, 66);
        PointPlan p3branche3 = new PointPlan(170, 60);

        PointPlan p2branche4 = new PointPlan(164, 57);
        PointPlan p3branche4 = new PointPlan(170, 52);

        Chapeaux branche1 = new Chapeaux(p1branche1, p2branche1, p3branche1);
        Chapeaux branche2 = new Chapeaux(p3branche1, p2branche2, p3branche2);
        Chapeaux branche3 = new Chapeaux(p3branche2, p2branche3, p3branche3);
        Chapeaux branche4 = new Chapeaux(p3branche3, p2branche4, p3branche4);

        Etoiles e = new Etoiles(branche1, branche2, branche3, branche4);

        ardoise.ajouterForme(e);

        /* Affichage de l'ardoise */
        ardoise.dessinerGraphique();
        }
 }