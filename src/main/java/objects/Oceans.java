package objects; /***
 * Partie 1 CSR - TP 5
 *  * Équipe:
 * -Karla ROSAS
 * -Awa DIABY
 */


import java.util.Random;

public class Oceans {

    static final int N = 3;
    static final int MAX_REQUINS = 5;
    static final int MAX_POISSON_PILOTES = 30;
    public static Zone[][] ocean = new Zone[N][N];
    private Requin[] requins = new Requin[MAX_REQUINS];
    private PoissonPilotes[] poissonpilotes = new PoissonPilotes[MAX_POISSON_PILOTES];
    private int ligne, colonne, nb_requins;




    public Oceans(){
        this.colonne = N;
        this.ligne = N;


        createZones();  //cree Zones
        Simulation();   //Lancer simulation
        VoirOcean();

    }

    /**Instanciation des zones ***/
    public void createZones() {

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    this.ocean[i][j] = new Zone(i, j);
                }

            }
        }
    /** Methode pour imprimer l'ocean**/
    public void VoirOcean() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                System.out.println("Zone ( "+ocean[i][j].getI_()+"_"+ocean[i][j].getJ_()+" ) "+"Sardines: "+ ocean[i][j].getNb_sardines_()+" Requins: "+ocean[i][j].isIlyarequin_());
            }

        }
    }

    /**Ajouter requins dans l'ocean **/
    public void Simulation() {
        /* Instanciation des zones */
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N ; j++) {
                this.ocean[i][j] = new Zone(i,j);
            }

        }


        /** Creation du requins **/
        for(int i = 0; i < MAX_REQUINS; i++) {
            requins[i] = new Requin(ocean);

        }

        /** Creation du poisson pilotes **/
        for(int i = 0; i < MAX_POISSON_PILOTES; i++) {
            Random r = new Random();

            int siteArrIdi = r.nextInt(ocean.length);
            int siteArrIdj = r.nextInt(ocean.length);

            poissonpilotes[i] = new PoissonPilotes(ocean[siteArrIdi][siteArrIdj]);
        }

        /** Start Thread Requins **/
        for(int i = 0; i < MAX_REQUINS; i++) {
            requins[i].start();
        }

        /** Start Thread poisson pilotes **/
        for(int i = 0; i < MAX_POISSON_PILOTES; i++) {
            poissonpilotes[i].start();
        }

        /**Join Thread Requins **/
        for(int i = 0; i < MAX_REQUINS; i++) {
            try {
                requins[i].join();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        /**Join Thread Requins **/
        for(int i = 0; i < MAX_POISSON_PILOTES; i++) {
            try {
                poissonpilotes[i].join();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    /**Obtenir quantité de requins du la zone **/
    public int getNb_requins() {
        return nb_requins;
    }

    /**Obtenir quantité de requins **/
    public void setNb_requins(int nb_requins) {
        this.nb_requins = nb_requins;
    }

    /**Obtenir status du la zone **/
    public void getStatus_Zone(int i, int j){

        System.out.println("Quantite de sardines dans"+ocean[i][j].getI_()+", "+ ocean[i][j].getJ_()+" = " +ocean[i][j].getNb_sardines_());
    }


    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }


    public static void main(String[] args) {


        Oceans ocean = new Oceans();
        //ocean.VoirOcean();
        //ocean.getStatus_Zone(0,3);

    }

}