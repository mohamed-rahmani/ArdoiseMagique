import java.util.ArrayList;
import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;

public class Quadrilateres extends Forme{
    private PointPlan point1;
    private PointPlan point2;
    private PointPlan point3;
    private PointPlan point4;

    public Quadrilateres() {
        super();
    }

    public Quadrilateres(PointPlan p1, PointPlan p2) throws ColineaireException {
        if (!MethodeException.sontColineaires(p1, p2)) {
            throw new ColineaireException("Les points sont colinéaires, impossible de former un quadrilatère !");
        }
        this.point1 = p1;
        this.point2 = p2;
        this.point3 = new PointPlan(point2.getAbscisse(), point1.getOrdonnee());
        this.point4 = new PointPlan(point1.getAbscisse(), point2.getOrdonnee());
        this.setNomForme("Quadrilatère");
    }

    public ArrayList<PointPlan> getPoints() {
        ArrayList<PointPlan> s = new ArrayList<PointPlan>();
        s.add(this.getPoint1());
        s.add(this.getPoint2());
        s.add(this.getPoint3());
        s.add(this.getPoint4());
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

    public PointPlan getPoint4() {
        return this.point4;
    }

    public void setPoint1(PointPlan p) {
        this.point1 = p;
    }

    public void setPoint2(PointPlan p) {
        this.point2 = p;
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

        this.dessiner();
    }

    @Override
    public ArrayList<Segment> dessiner() {
        ArrayList<Segment> segments = new ArrayList<Segment>();
            Segment s1 = new Segment(point1, point3);
            Segment s2 = new Segment(point2, point4);
            Segment s3 = new Segment(point2, point3);
            Segment s4 = new Segment(point1, point4);

            segments.add(s1);
            segments.add(s2);
            segments.add(s3);
            segments.add(s4);
            return segments;
    }
    @Override
    public String typeForme() {
        return "Q";
    }

    public String toString() {
        return "[Point1" + this.getPoint1() + ", Point2" + this.getPoint2() + ", Point3" + this.getPoint3() + ", Point4" + this.getPoint4() +"]";
    }
}