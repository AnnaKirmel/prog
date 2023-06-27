package org.example.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.Array;
import org.example.Weapon;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/weapon")
public class ControllerWeapon {
    public String fileName = "weapon.csv";
    private File file = new File(fileName);
    Array arrayColl = new Array();
        Weapon weapon = new Weapon();
        ArrayList<Weapon> arrayListWeapon = new ArrayList<>();

        public ControllerWeapon(Array arrayColl, Weapon weapon, ArrayList<Weapon> arrayListWeapon) {
            this.arrayColl = arrayColl;
            this.weapon = weapon;
            this.arrayListWeapon = arrayListWeapon;
        }

        public ControllerWeapon()  {
            arrayColl.readCSV(fileName);
        }


    @GetMapping("/all")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Weapon> getAllArray() {
        arrayColl.readCSV(fileName);
        return arrayColl.getWeapons();
    }


    @GetMapping("{id}")
    public Object getObject (@PathVariable int id) {
        Weapon weapon =  this.arrayColl.getI(id);
        if (weapon == null) {
            return new ResponseEntity<Weapon>(HttpStatus.NOT_FOUND);
        }
        else {
            arrayColl.readCSV(fileName);
            new ResponseEntity<Weapon>(HttpStatus.OK);
            return arrayColl.getI(id);
        }
    }
    @PostMapping("/plus")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Object addObject (@RequestBody Map<String, String> body) throws IOException {
        Weapon weapon = new Weapon(Integer.parseInt(body.get("id")), body.get("type"),
                body.get("name"), Double.parseDouble(body.get("range")), Long.parseLong(body.get("container")),
                Double.parseDouble(body.get("weight")),Double.parseDouble(body.get("speed")));
        int id = Integer.parseInt(body.get("id"));
        if (arrayColl.getI(id) != null) {
            return new ResponseEntity<Weapon>(HttpStatus.CONFLICT); }
        else {
            arrayColl.add(weapon);
            arrayColl.WriteCSV(fileName);
        }

        return weapon;
    }

    @DeleteMapping("/delete {id}")
    public ResponseEntity<Weapon> deleteObject (@PathVariable int id) throws IOException {
        Weapon weapon =  this.arrayColl.getI(id);
        if (weapon == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            arrayColl.remove_id(id);
            arrayColl.WriteCSV(fileName);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
    @GetMapping("/info")
    public  String MyWork(){
        new ResponseEntity<>(HttpStatus.ACCEPTED);
        return "Предметная область: Огнестрельное оружие\n"+
                "Выполнила: Кирмель Анна Александровна УВА-212\n"+
                "Вариант: 17\n";

    }
    @GetMapping("/Regression")
    @ResponseStatus(code = HttpStatus.OK)
    public Object RegressionAnalysis (){
            arrayColl.readCSV(fileName);
            boolean result = arrayColl.speedRegressionAnalysis();
            if(result){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            else {
                return new ResponseEntity<Weapon>(HttpStatus.OK);
            }
    }

    @GetMapping("/read")
    @ResponseStatus(code = HttpStatus.OK)
    public ArrayList<Weapon> readFile () {
        return arrayColl.readCSV(fileName);
    }
}

