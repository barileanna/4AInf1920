package it.itis.cuneo;

import java.util.Random;

/**
 * Created by inf.barilea1810 on 24/10/2019.
 */
public class EccezioneRandom{

    public void randomException () throws Exception{
        Random random = new Random();
        int cont = 0;

        while(cont!=5) {
            int n = 2;
            int x = random.nextInt(n);

            if (x == 1) {
                cont++;
            }
        }
        throw new Exception("Cinque numeri uno inseriti");
    }

    public static void main(String[] args) {
        EccezioneRandom em = new EccezioneRandom();

        try{
            em.randomException();
        }
        catch (Exception ex){
            System.out.println("catch (Exception ex)");
            ex.printStackTrace();
        }
        finally {
            System.out.println("Ne esco sempre bene!");
        }
    }
}
