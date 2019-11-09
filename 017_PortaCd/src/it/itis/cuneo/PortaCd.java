package it.itis.cuneo;

public class PortaCd {

    private static final int N_PROGRAMMI = 3;
    private Cd[] vCd;
    private int cntCd;

    public PortaCd() {
        vCd = new Cd[N_PROGRAMMI];
        cntCd = 0;
    }

    public void setProgramma(Cd cd, int posizione){
        vCd[posizione]=new Cd(cd);
    }

    public String getProgramma(int posizione){
        return vCd[posizione].toString();
    }

    public void setvCd(Cd[] vCd) {
        this.vCd = vCd;
    }

    public Cd[] getvCd() {
        return vCd;
    }

    public void setCntCd(int cntCd) {
        this.cntCd = cntCd;
    }

    public int getN() {
        return cntCd;
    }

    public void addCd(Cd cd) throws PortaCdPienoException {
        if (cntCd + 1 > N_PROGRAMMI) {
            throw new PortaCdPienoException(1, "Troppi programmi!!!");
        }
        else {
            vCd[cntCd] = cd;
            cntCd++;
        }
    }

    public void killCd(int posizione) {
        vCd[posizione] = null;
        cntCd--;
    }

    public int cercaCdPerTitolo(String cd){
        int i=0;
        boolean trovato=false;
        while(i< cntCd && trovato==false){
            if(vCd[i].getTitolo().equals(cd)){
                trovato=true;
            }
            i++;
        }
        if(trovato==false) {
            i=-1;
        }
        return i;
    }

    @Override
    public String toString() {
        return "Contenitore{" + "Cd 1:"+ vCd[1].getTitolo()+
                "\nCd 2:" + vCd[2].getTitolo()+
                "\nCd 3:" + vCd[3].getTitolo()+ '}';
    }

    public int confrontaCollezione(PortaCd portaCd){
        int conta;
        conta = Math.min(cntCd, portaCd.getN());
        int cProgrammiComuni=0;
        int i=0;
        int c=0;

        for(i=0;i<cntCd;i++) {
            for(c=0;c<conta;c++){
                if(vCd[i].equals(portaCd.vCd[c])){
                    cProgrammiComuni++;
                }
            }
        }
        return cProgrammiComuni;
    }


    public static void main(String[] args) {
        PortaCd portaCdUno = new PortaCd();
        PortaCd portaCdDue = new PortaCd();
        Cd cdUno = new Cd("Magmamemoria","Levante","43.10",14);
        Cd cdDue = new Cd("EveryDay Life", "Coldplay", "44.23", 19);
        Cd cdTre = new Cd("Greatest Hits", "Blink 182", "53.41", 18);


        try {
            portaCdUno.addCd(cdUno);
            portaCdUno.addCd(cdDue);
            portaCdUno.addCd(cdTre);
            portaCdDue.addCd(cdDue);
            portaCdDue.addCd(cdTre);
        } catch (PortaCdPienoException e) {
            e.printStackTrace();
            System.err.println(e.toString());
        }

        int x = portaCdUno.cercaCdPerTitolo("EveryDay Life");
        System.out.println("Il cd si trova in posizione "+x+" della collezione uno");

        System.out.println("Contenitore UNO: ");
        for(int i=0; i<portaCdUno.getN();i++)
        {
            System.out.println(portaCdUno.vCd[i].toString());
        }

        System.out.println("Contenitore DUE: ");
        for(int i=0; i<portaCdDue.getN();i++)
        {
            System.out.println(portaCdDue.vCd[i].toString());
        }

        System.out.println("Ci sono "+portaCdUno.confrontaCollezione(portaCdDue)+" cd uguali nelle due collezioni");
    }
}
