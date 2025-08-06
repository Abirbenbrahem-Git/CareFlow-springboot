package com.example.demo.Controller;

import com.example.demo.Entity.Bulletin;
import com.example.demo.Repository.BulletinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/bulletins")
public class BulletinController {

    @Autowired
    private BulletinRepository bulletinRepository;

    @PostMapping("/post")
    public Bulletin uploadBulletin(

            @RequestParam String reference,
            @RequestParam String nomadherent,
            @RequestParam String nommalade,
            @RequestParam Bulletin.TypeMalade typemalade,
            @RequestParam String adresse,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date datenaissance,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date datedepot,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date datesoin,
            @RequestParam Bulletin.EtatBulletin etat,
            @RequestParam MultipartFile fichier
    ) throws Exception {
        Bulletin bulletin = new Bulletin();
        bulletin.setReference(reference);
        bulletin.setNomadherent(nomadherent);
        bulletin.setNommalade(nommalade);
        bulletin.setTypemalade(typemalade);
        bulletin.setAdresse(adresse);
        bulletin.setDatenaissance(datenaissance);
        bulletin.setDatedepot(datedepot);
        bulletin.setDatesoin(datesoin);
        bulletin.setEtat(etat);
        bulletin.setFichier(fichier.getBytes());

        return bulletinRepository.save(bulletin);
    }


    @GetMapping("/all")
    public List<Bulletin> getAllBulletins() {
        return bulletinRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBulletin(@PathVariable Integer id) {
        if (bulletinRepository.existsById(id)) {
            bulletinRepository.deleteById(id);
            return "Bulletin avec ID " + id + " supprimé avec succès.";
        } else {
            return "Bulletin avec ID " + id + " introuvable.";
        }
    }

    @PutMapping("/update/{id}")
    public Bulletin updateBulletin(
            @PathVariable Integer id,
            @RequestParam String reference,
            @RequestParam String nomadherent,
            @RequestParam String nommalade,
            @RequestParam Bulletin.TypeMalade typemalade,
            @RequestParam String adresse,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date datenaissance,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date datedepot,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date datesoin,
            @RequestParam Bulletin.EtatBulletin etat,
            @RequestParam(required = false) MultipartFile fichier
    ) throws Exception {

        Bulletin bulletin = bulletinRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bulletin avec ID " + id + " introuvable."));

        bulletin.setReference(reference);
        bulletin.setNomadherent(nomadherent);
        bulletin.setNommalade(nommalade);
        bulletin.setTypemalade(typemalade);
        bulletin.setAdresse(adresse);
        bulletin.setDatenaissance(datenaissance);
        bulletin.setDatedepot(datedepot);
        bulletin.setDatesoin(datesoin);
        bulletin.setEtat(etat);
        if (fichier != null && !fichier.isEmpty()) {
            bulletin.setFichier(fichier.getBytes());
        }
        return bulletinRepository.save(bulletin);
    }

    @GetMapping("/find/{id}")
    public Bulletin getBulletinById(@PathVariable Integer id) {
        return bulletinRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bulletin avec ID " + id + " introuvable."));
    }



}
