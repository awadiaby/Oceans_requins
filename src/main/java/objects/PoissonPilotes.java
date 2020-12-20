package objects;

public class PoissonPilotes extends Thread {

    static final int CycloViePoissonP = 3;
    private int Status_Vie_PoissonP;
    private Zone zone_position;

    public PoissonPilotes(Zone zone_position){
        this.Status_Vie_PoissonP = CycloViePoissonP;
        this.zone_position = zone_position;
    }

    public void run() {

        this.zone_position.entrerPP(); //Entrer dans un zone

    }
}