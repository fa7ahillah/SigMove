import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Exersice{
    int durasi;
    String nama;
    ArrayList<String> steps;

    public Exersice(int durasi, String nama){
        this.durasi = durasi;
        this.nama = nama;
        this.steps = new ArrayList<String>();
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

    public String toString(){
        return this.durasi + " " + this.nama;
    }

    public ArrayList<String> getSteps(){
        return this.steps;
    }

    public void setSteps(ArrayList<String> steps){
        this.steps = steps;
    }

    public void addStep(String step){
        this.steps.add(step);
    }   

    public void tampilkanLangkah(){
        for (String step : this.steps) {
            System.out.println(step);
        }
    }

    //tester
    public static void main(String[] args) {
        Exersice exersice = new Exersice(10, "Latihan Lengan");
        exersice.addStep("Langkah 1");
        exersice.addStep("Langkah 2");
        exersice.addStep("Langkah 3");
        exersice.tampilkanLangkah();
    }
}