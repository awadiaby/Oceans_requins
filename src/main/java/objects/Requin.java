package objects;

import java.util.Random;

public class Requin extends Thread {

    static final int CycloVieRequin = 1;
    static final int Capacité_Pilotes = 5;
    private int Status_Vie_Req;
    private Zone[][] ocean;
    private int requinsmort=0;
    private int Poisson_requin=0;
    int positionI = 0;
    int positionJ = 0;



    int id = 0;
    static int NEXT_ID = 1;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Requin(Zone[][] ocean){
        this.Status_Vie_Req = CycloVieRequin;
        this.ocean = ocean;
        this.Poisson_requin=Poisson_requin;

    }

    public Zone[][] getOcean() {
        return ocean;
    }

    public void setOcean(Zone[][] ocean) {
        this.ocean = ocean;
    }

    public int getRequinsmort() {
        return requinsmort;
    }

    public void setRequinsmort(int requinsmort) {
        this.requinsmort = requinsmort;
    }

    public int getPositionI() {
        return positionI;
    }

    public void setPositionI(int positionI) {
        this.positionI = positionI;
    }

    public int getPositionJ() {
        return positionJ;
    }

    public void setPositionJ(int positionJ) {
        this.positionJ = positionJ;
    }

    /**
     * Attacher les Poissons au requin
     */
    void attacherPP (int t) {
        Poisson_requin += t;
    }

    /**
     * Dattacher les Poissons au requin
     */
    void dattacherPP(int t) {
        Poisson_requin -= t;
    }

    /**
     * Capacite de poisson PP au requin
     */
    public static int getCapacité_Pilotes() {
        return Capacité_Pilotes;
    }

    /**
     * Status de vie du Requin
     */
    public int getStatus_Vie_Req() {
        return Status_Vie_Req;
    }

    public void setStatus_Vie_Req(int status_Vie_Req) {
        Status_Vie_Req = status_Vie_Req;
    }

    public int getPoisson_requin() {
        return Poisson_requin;
    }

    public void setPoisson_requin(int poisson_requin) {
        Poisson_requin = poisson_requin;
    }

    synchronized void RequinAttachePP(Zone zone){
        int Place_pour_PP=0;
        if( Poisson_requin<Capacité_Pilotes){
            Place_pour_PP = Capacité_Pilotes - Poisson_requin ;
        }
        if(zone.getNb_poisson_pilotes_zone() >= Place_pour_PP){
            Poisson_requin=Poisson_requin+Place_pour_PP;
            zone.setNb_poisson_pilotes_zone(zone.getNb_poisson_pilotes_zone()-Place_pour_PP);
        }else{
            Poisson_requin=Poisson_requin+ zone.getNb_poisson_pilotes_zone();

            zone.setNb_poisson_pilotes_zone(zone.getNb_poisson_pilotes_zone()-zone.getNb_poisson_pilotes_zone());
        }

    }
    synchronized void entrerPP(){

        if(Poisson_requin==Capacité_Pilotes){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            Poisson_requin++;
        }

    }


    public void run() {

        boolean stop=false;
        while (!stop) {

            /**Deplacement du requin**/

            Random r = new Random();
            int siteArrIdi = r.nextInt(ocean.length);
            int siteArrIdj = r.nextInt(ocean.length);

            if(this.Status_Vie_Req>0){
                this.ocean[siteArrIdi][siteArrIdj].entrerReq(this);
                Status_Vie_Req=Status_Vie_Req-1;
                this.ocean[siteArrIdi][siteArrIdj].manger_sardines(this);
                try { Thread.sleep(1000);
                } catch(InterruptedException e) {}

                this.RequinAttachePP(ocean[siteArrIdi][siteArrIdj]);
                this.ocean[siteArrIdi][siteArrIdj].SortirZone(this);}

            else if(this.Status_Vie_Req==0){
                requinsmort++;
                if(requinsmort==5){
                    stop=true;

                }
            }else{

            }

        }

    }
}

