package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 20/11/2019.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputOutputUtility {
    private static InputStreamReader r = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(r);


    public static String leggiNome(){
        String sc=null;

        try {
            sc=br.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sc;
    }


    public static int leggiNumero(){
        int s=0;
        try {
            s=Integer.parseInt(br.readLine());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return s;
    }

    public static boolean leggiBoolean(){
        boolean s=false;
        try {
            s=Boolean.parseBoolean(br.readLine());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return s;
    }


    public float leggiNumeroFloat() {
        //return Float.parseFloat(leggiString());
        float s=0;
        try {
            s=Float.parseFloat(br.readLine());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return s;
    }

    public static double leggiNumeroDouble(){
        double s=0;

        try {
            s=Double.parseDouble(br.readLine());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return s;
    }


    public static Date leggiData(){
        Date date = null;
        //Date formatteddate = null;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            date = df.parse(br.readLine());
            //formatteddate = df.format(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return date;
    }

    public static Date leggiDataOra(){
        Date date = null;
        //Date formatteddate = null;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh24:mi:ss");

        try {
            date = df.parse(br.readLine());
            //formatteddate = df.format(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return date;
    }
}