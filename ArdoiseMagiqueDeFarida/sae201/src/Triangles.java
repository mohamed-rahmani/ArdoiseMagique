
import java.util.ArrayList;
import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;

public class Triangles extends Forme {
    private PointPlan point1;
    private PointPlan point2;
    private PointPlan point3;
        
    public Triangles() {
        super();
    }

    public Triangles(PointPlan p1, PointPlan p2, PointPlan p3) throws ColineaireException {
        if (!MethodeException.sontColineaires(p1, p2, p3)) {
            throw new ColineaireException("Les points sont colinéaires, impossible de construire un triangle !");
        }
        this.point1 = p1;
        this.point2 = p2;
        this.point3 = p3;
        this.setNomForme("Triangle");
    }

    public ArrayList<PointPlan> getPoints() {
        ArrayList<PointPlan> s = new ArrayList<PointPlan>();
        s.add(this.point1);
        s.add(this.point2);
        s.add(this.point3);
        return s;  

    }

    public PointPlan getPoint1() {
        return this.point1;
    }

    public PointPlan getPoint2() {
        return this.point2;
    }

    public PointPlan getPoint3() {
        return this.point3;
    }

    public void setPoint1(PointPlan p) {
        this.point1 = p;
    }

    public void setPoint2(PointPlan p) {
        this.point2 = p;
    }

    public void setPoint3(PointPlan p) {
        this.point3 = p;
    }

    @Override
    public void deplacer(int x, int y) {
        int depx1 = this.point1.getAbscisse() + x;
        int depy1 = this.point1.getOrdonnee() + y;
        this.point1.setAbscisse(depx1);
        this.point1.setOrdonnee(depy1);

        int depx2 = this.point2.getAbscisse() + x;
        int depy2 = this.point2.getOrdonnee() + y;
        this.point2.setAbscisse(depx2);
        this.point2.setOrdonnee(depy2);

        int depx3 = this.point3.getAbscisse() + x;
        int depy3 = this.point3.getOrdonnee() + y;
        this.point3.setAbscisse(depx3);
        this.point3.setOrdonnee(depy3);

        this.dessiner();
    }

    @Override
    public ArrayList<Segment> dessiner() {
        ArrayList<Segment> segments = new ArrayList<Segment>();
        Segment s1 = new Segment(point1, point2);
        Segment s2 = new Segment(point2, point3);
        Segment s3 = new Segment(point1, point3);
        segments.add(s1);
        segments.add(s2);
        segments.add(s3);
        return segments;
    }

    @Override
    public String typeForme() {
        return "T";
    }

    public String toString() {
        return "[Point1" + this.getPoint1() + ", Point2" + this.getPoint2() + ", Point3" + this.getPoint3() + "]";
    }
}
