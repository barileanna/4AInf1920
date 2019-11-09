package it.itis.cuneo;

public class Contenitore {

    private static final int N_PROGRAMMI = 3;
    private Programma[] vProgrammi;
    private int cntProgrammi;

    public Contenitore() {
        vProgrammi = new Programma[N_PROGRAMMI];
        cntProgrammi = 0;
    }

    public void setProgramma(Programma programma, int posizione){
        vProgrammi[posizione]=new Programma(programma);
    }

    public String getProgramma(int posizione){
        return vProgrammi[posizione].toString();
    }

    public void setvProgrammi(Programma[] vProgrammi) {
        this.vProgrammi = vProgrammi;
    }

    public Programma[] getvProgrammi() {
        return vProgrammi;
    }

    public void setCntProgrammi(int cntProgrammi) {
        this.cntProgrammi = cntProgrammi;
    }

    public int getN() {
        return cntProgrammi;
    }

    public void addProgramm(Programma programma) throws ContenitorePienoException {
        if (cntProgrammi + 1 > N_PROGRAMMI) {
            throw new ContenitorePienoException(1, "Troppi programmi!!!");
        }
        else {
            vProgrammi[cntProgrammi] = programma;
            cntProgrammi++;
        }
    }

    public void killProgramma(int posizione) {
        vProgrammi[posizione] = null;
        cntProgrammi--;
    }

    public int cercaProgrammaPerDenominazione(String programma){
        int i=0;
        boolean trovato=false;
        while(i<cntProgrammi && trovato==false){
            if(vProgrammi[i].getDenominazione().equals(programma)){
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
        return "Contenitore{" + "Programma 1:"+ vProgrammi[1].getDenominazione()+
                "\nProgramma 2:" + vProgrammi[2].getDenominazione()+
                "\nProgramma 3:" + vProgrammi[3].getDenominazione()+ '}';
    }

    public int confrontaContenitore(Contenitore contenitore){
        int conta;
        conta = Math.min(cntProgrammi, contenitore.getN());
        int cProgrammiComuni=0;
        int i=0;
        int c=0;

        for(i=0;i<conta;i++) {
            for(c=0;c<conta;c++){
                if(vProgrammi[i].equals(contenitore.vProgrammi[c])){
                    cProgrammiComuni++;
                }
            }
        }
        return cProgrammiComuni;
    }


    public static void main(String[] args) {
        Contenitore contenitore1 = new Contenitore();
        Contenitore contenitore2 = new Contenitore();
        Programma programmaUno = new Programma("Intellij","IDEA","11.0","Windows", 2012);
        Programma programmaDue = new Programma("LiveCode", " ", "9.5.0", "Windows", 1993);
        Programma programmaTre = new Programma("CodeBlock", " ", "9.5.0", "Windows", 1990);


        try {
            contenitore1.addProgramm(programmaDue);
            contenitore1.addProgramm(programmaUno);
            contenitore1.addProgramm(programmaTre);
            contenitore2.addProgramm(programmaUno);
            contenitore2.addProgramm(programmaDue);
        } catch (ContenitorePienoException e) {
            e.printStackTrace();
            System.err.println(e.toString());
        }

        System.out.println("Contenitore UNO: ");
        for(int i=0; i<contenitore1.getN();i++)
        {
            System.out.println(contenitore1.vProgrammi[i].toString());
        }

        System.out.println("Contenitore DUE: ");
        for(int i=0; i<contenitore1.getN();i++)
        {
            System.out.println(contenitore1.vProgrammi[i].toString());
        }

        System.out.println("Ci sono "+contenitore1.confrontaContenitore(contenitore2)+" programmi uguali");
    }
}
