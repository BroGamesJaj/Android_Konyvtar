package hu.petrik.konyvtar;

public class Konyv {
    private String cim;
    private String szerzo;
    private Integer oldalak;
    private Integer ev;

    public Konyv(String cim, String szerzo, Integer oldalak, Integer ev) {
        this.cim = cim;
        this.szerzo = szerzo;
        this.oldalak = oldalak;
        this.ev = ev;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public void setSzerzo(String szerzo) {
        this.szerzo = szerzo;
    }

    public Integer getOldalak() {
        return oldalak;
    }

    public void setOldalak(Integer oldalak) {
        this.oldalak = oldalak;
    }

    public Integer getEv() {
        return ev;
    }

    public void setEv(Integer ev) {
        this.ev = ev;
    }
}
