package objects;

public class Zone {

    static final int SARDINS_INIT = 10;
    private int nb_sardines_;
    private  boolean ilyarequin_;
    private String prenom_ ;
    private int col_ ;
    private int i_;
    private int j_;
    private int nb_poisson_pilotes_zone=0;
    private int id = 0;
    private Requin requinPresent;

    public Requin getRequinPresent() {
        return requinPresent;
    }

    public void setRequinPresent(Requin requinPresent) {
        this.requinPresent = requinPresent;
        this.ilyarequin_ = requinPresent != null;
    }

    /**
     * Creer objet type Zone(i,j)
     */

    //public Zone(String prenom) {
    public Zone(int i, int j) {
        this.nb_sardines_ = SARDINS_INIT;
        this.ilyarequin_=false;
        this.i_=i;  //Colonne
        this.j_=j;  //Ligne
        this.prenom_= String.valueOf(i)+String.valueOf(j);
        this.nb_poisson_pilotes_zone=nb_poisson_pilotes_zone;

        System.out.println("Zone (i,j)="+ Zone.this.i_ +"- "+ Zone.this.j_ +" Sardines ="+ nb_sardines_ + " Requin " + ilyarequin_ );
    }


    /*** Le requin entre à la zone***/

    synchronized void entrerReq(Requin requins){
        notifyAll();  //Infiquer les Poissones Pilotes qui a entre
        while(ilyarequin_==true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ilyarequin_=true;
        System.out.println("Requin: "+Thread.currentThread().getName() +" Entre à la zone - Site N° "+ Zone.this.prenom_+"  Sardines: "+ Zone.this.getNb_sardines_()+"Requin "+ilyarequin_ +" PP: "+ Zone.this.nb_poisson_pilotes_zone);


    }


    /*** Le requin mange les sardines de la zone***/
    public void manger_sardines(Requin requins){

        int Faim_Requin = (int) Math.floor(Math.random()*(1-10+1)+10);  //Values entier entre [1,10]
        if(nb_sardines_>0) {
            if (nb_sardines_ >= Faim_Requin) {
                System.out.println("Requin: "+Thread.currentThread().getName() +" mange "+Faim_Requin+ " sardines");
                nb_sardines_ = nb_sardines_ - Faim_Requin;
            } else {
                System.out.println("Requin: "+Thread.currentThread().getName() +" mange "+Faim_Requin+ " sardines");
                nb_sardines_ = nb_sardines_ - 1;
            }
        }else{System.out.println("Il n'y a pas de sardines");}

    }

    /*** Le requin sort à la zone***/

    synchronized void SortirZone(Requin requins){
        ilyarequin_=false;

        notifyAll();
        System.out.println("Requin: "+Thread.currentThread().getName() +" Sorte de la zone - Site N° "+ Zone.this.prenom_+" PP Attaches: "+requins.getPoisson_requin()+" STATUS ZONE Sardines restantes: "+ Zone.this.getNb_sardines_()+" Requin "+ilyarequin_+" PP: "+ Zone.this.nb_poisson_pilotes_zone+" Il change de zone");

    }


    /**Poisson Pilote entre dans un zone**/
    void entrerPP(){
        nb_poisson_pilotes_zone++;
        System.out.println("PP: "+Thread.currentThread().getName() +" Entre à la zone - Site N° "+ Zone.this.prenom_+" Sardines: "+ Zone.this.getNb_sardines_()+" Requin "+ilyarequin_+" PP: "+nb_poisson_pilotes_zone);

    }
    synchronized void sortir_PP_zone(PoissonPilotes pilote){
        nb_poisson_pilotes_zone--;
        System.out.println("PP: "+Thread.currentThread().getName() +" Sorte de la  zone - Site N° "+ Zone.this.prenom_+" PP_totales: "+ Zone.this.nb_poisson_pilotes_zone+" Requin "+ilyarequin_);

    }

    public int getNb_poisson_pilotes_zone() {
        return nb_poisson_pilotes_zone;
    }

    public void setNb_poisson_pilotes_zone(int nb_poisson_pilotes_zone) {
        this.nb_poisson_pilotes_zone = nb_poisson_pilotes_zone;
    }

    /*** Savoir s'il y a requin dans la Zone ***/
    public boolean isIlyarequin_() {
        return ilyarequin_;}

    /*** Savoir  quantité de sardines ***/
    public int getNb_sardines_() {
        return nb_sardines_; }

    /*** Ajouter sardines quantité de sardines ***/
    public void setNb_sardines_(int nb_sardines_) {
        this.nb_sardines_ = nb_sardines_; }

    /*** Savoir position i ***/
    public int getI_() {
        return i_;
    }

    /*** Chager position i ***/
    public void setI_(int i_) {
        this.i_ = i_;
    }

    /*** Savoir position j ***/
    public int getJ_() {
        return j_;
    }

    /*** Chager position j ***/
    public void setJ_(int j_) {
        this.j_ = j_;
    }

    /*** Savoir  quantité de PP dans la zone ***/
    public int getNb_PP_() {
        return nb_poisson_pilotes_zone; }

    /*** Ajouter PP quantité de sardines ***/
    public void setNb_PP_(int nb_poisson_pilotes_zone) {
        this.nb_poisson_pilotes_zone= nb_poisson_pilotes_zone; }

    public void setIlyarequin_(boolean ilyarequin_) {
        this.ilyarequin_ = ilyarequin_;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}