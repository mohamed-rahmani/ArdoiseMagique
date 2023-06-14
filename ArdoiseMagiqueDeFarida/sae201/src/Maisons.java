import java.util.ArrayList;

import ardoise.Forme;
import ardoise.Segment;

public class Maisons extends Forme{
    private Chapeaux toit;
    private Quadrilateres corps;
    private Quadrilateres porte;

    public Maisons() {
        super();
    }

    public Maisons(Chapeaux t, Quadrilateres c, Quadrilateres p) throws ToitPasSurLeCorpsException {
        if (!MethodeException.toitSurLeCorps(t, p)) {
            throw new ToitPasSurLeCorpsException("Le toit n'est pas sur le corps de la maison !");
        }
        this.toit = t;
        this.corps = c;
        this.porte = p;
        this.setNomForme("Maison");
    }

    public Chapeaux getToit() {
        return this.toit;
    }

    public Quadrilateres getCorps() {
        return this.corps;
    }

    public Quadrilateres getPorte() {
        return this.porte;
    }
    
    public void setToit(Chapeaux t) {
        this.toit = t;
    }

    public void setCorps(Quadrilateres c) {
        this.corps = c;
    }

    public void setPorte(Quadrilateres p) {
        this.porte = p;
    }

    @Override
    public void deplacer(int x, int y) {

    }

    @Override
    public ArrayList<Segment> dessiner() {
        ArrayList<Segment> s1 = new ArrayList<Segment>(this.toit.dessiner());
        ArrayList<Segment> s2 = new ArrayList<Segment>(this.corps.dessiner());
        ArrayList<Segment> s3 = new ArrayList<Segment>(this.porte.dessiner());

        ArrayList<Segment> s = new ArrayList<Segment>();

        for(int i = 0; i<s1.size(); i++) {
            s.add(s1.get(i));
        }

        for(int i = 0; i<s2.size(); i++) {
            s.add(s2.get(i));
        }

        for(int i = 0; i<s3.size(); i++) {
            s.add(s3.get(i));
        }

        return s;
    }

    @Override
    public String typeForme() {
        return "GF";
    }

    public String toString() {
        return "Maison : [ Toit = " + this.getToit() + ", Corps = " + this.getCorps() + ", Porte = " + this.getPorte() + " ]";
    }
}
