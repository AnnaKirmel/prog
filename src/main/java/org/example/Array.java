package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Array {
    private ArrayList<Weapon> Weapons;
    public Array(ArrayList<Weapon> Weapons) {
        this.Weapons = Weapons;
    }

    public Array() {
        Weapons = new ArrayList<Weapon>();
    }

    public void setWeapon(ArrayList<Weapon> weapons) {
        Weapons = weapons;
    }

    public ArrayList<Weapon> getWeapons() {
        return Weapons;
    }
    public void add (Weapon newWeapon){
        Weapons.add(newWeapon);
    }

    public void removeFromWeapons(Weapon removeObj) {
        Weapons.remove(removeObj);
    }

    //delete for ID
    public void remove_id(int removeId) {
        for (int i = 0;i<Weapons.size();i++){
            if (Weapons.get(i).getId() == removeId) {
                Weapons.remove(i);
            }
            else {
                System.out.println("Current ID:"+ Weapons.get(i).getId()+"!="+removeId);
            }
        }
    }
    public Weapon getI(int index_get){
        for (Weapon test : Weapons){
            if(test.getId() == index_get){
                return test;
            }
        }
        return null;
    }
    /*@Override
    public String toString() {
        return "WeaponsCollection  {" +
                "Weapon=" + Weapons + '}';
    }
*/
    private Weapon getWeapon(String line)
    {
        String[] fields = line.split(",");
        return new Weapon(Integer.parseInt(fields[0]),fields[1],fields[2],Integer.parseInt(fields[3]),
                Integer.parseInt(fields[4]),Integer.parseInt(fields[5]),Integer.parseInt(fields[6]));
    }

    public void WriteCSV(String filename) throws IOException {
        String csv = "weapons.csv";
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(csv));
            for (Weapon weap : Weapons) {
                String id = String.valueOf(weap.getId());
                String type = weap.getType();
                String name = weap.getName();
                String range = String.valueOf(weap.getRange());
                String container = String.valueOf(weap.getContainer());
                String weight = String.valueOf(weap.getWeight());
                String speed = String.valueOf(weap.getSpeed());
                String Record = String.join(";", id, type, name, range, container, weight, speed);
                String[] record = Record.split(";");
                writer.writeNext(record);
            }
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    public ArrayList<Weapon> readCSV(String fileName){
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader("weapons.csv"));
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        List<String[]> mass = null;
        try{
            assert reader != null;
            mass =reader.readAll();
        } catch (IOException | CsvException e){
            e.printStackTrace();
        }
        assert mass !=null;
        for(String[] row : mass){
            Weapon weapon = new Weapon(Integer.parseInt(row[0]),row[1],row[2],Double.parseDouble(row[3]),Long.parseLong(row[4]),Double.parseDouble(row[5]),Double.parseDouble(row[6]));
            Weapons.add(weapon);
        }
        return null;
    }
    //регрессионный анализ
    public boolean speedRegressionAnalysis() {
        Weapon weapon = Weapons.get(0);
        double ratio = weapon.getSpeed() / (weapon.getContainer() * weapon.getWeight());

        for (int i = 1; i < Weapons.size(); i++) {
            weapon = Weapons.get(i);
            double dependence = weapon.getSpeed() / (weapon.getContainer() * weapon.getWeight());
            if (dependence != ratio) {
                return false;
            }
        }
        return true;
    }


}






