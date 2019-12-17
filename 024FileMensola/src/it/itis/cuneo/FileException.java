package it.itis.cuneo;

/**
 * Created by inf.barilea1810 on 16/12/2019.
 */
public class FileException extends Exception {
    private String matter ="";

    public FileException(String matter) {
        this.matter = matter;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }
}
