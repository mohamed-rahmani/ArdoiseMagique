import ardoise.PointPlan;

public class MethodeException {

    public static boolean sontColineaires(PointPlan p1, PointPlan p2) {
        return (p1.getAbscisse()*(p2.getOrdonnee()-p1.getOrdonnee()) == p2.getAbscisse()*(p1.getOrdonnee()-p2.getOrdonnee()));
    }

    public static boolean sontColineaires(PointPlan p1, PointPlan p2, PointPlan p3) {
        return (p1.getAbscisse()*(p2.getOrdonnee()-p3.getOrdonnee())+p2.getAbscisse()*(p3.getOrdonnee()-p1.getOrdonnee())+p3.getAbscisse()*(p1.getOrdonnee()-p2.getOrdonnee()) == 0);
    }
    public static boolean toitSurLeCorps(Chapeaux toit, Quadrilateres corps) {
        int nb_elt = 0;
        for(PointPlan point : toit.getPoints()){
            if(corps.getPoints().contains(point)) {
                nb_elt += 1;
            }
        }
        return nb_elt == 2;
    }

    public static boolean sontConnectes(Chapeaux c1, Chapeaux c2, Chapeaux c3, Chapeaux c4) {
        if (c1.getPoint3().equals(c2.getPoint1()) || c2.getPoint3().equals(c3.getPoint1()) || c3.getPoint3().equals(c4.getPoint1()) || c4.getPoint3().equals(c1.getPoint1())) {
            return true;
        }
        return false;
    }
}