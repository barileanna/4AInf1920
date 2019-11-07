public class Container {
    private Programma[] array = new Programma[1024];

    public Container(int n) {
        int i;

        for (i = 0; i < n; i++) {
            array[i] = new Programma();
        }
    }

    public Programma getProgramma(int i) {
        return this.array[i];
    }

    public void setProgramma(int i, Programma programma) {
        this.array[i] = programma;
    }

    public void killProgramma(int i) {
        this.array[i] = null;
    }

    public int getN() {
        int i;
        int acc = 0;

        for (i = 0; i < 1024; i++) {
            if (this.array[i] != null) {
                acc++;
            }
        }
        return acc;
    }

    public int cercaProgrammaPerDenominazione(String denominazione) {
        int i = 0;

        while (i < 1025 && denominazione != array[i].getDenominazione()) {
            i++;
        }
        if (i == 1025) {
            i = -1;
        }
        return i;
    }

    public int confrontaContenitore(Container container) {
        int i;
        int acc = 0;

        for (i = 0; i < 1024; i++) {
            if (this.array[i] == container.array[i]) {
                acc++;
            }
        }
        return acc;
    }
}
