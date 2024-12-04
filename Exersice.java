import javax.swing.*;
import java.awt.*;

public class Exersice{
    int durasi;
    String nama;

    public Exersice(int durasi, String nama){
        this.durasi = durasi;
        this.nama = nama;
    }

    public int getDurasi(){
        return this.durasi;
    }

    public String getNama(){
        return this.nama;
    }

    public void setDurasi(int durasi){
        this.durasi = durasi;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    
}