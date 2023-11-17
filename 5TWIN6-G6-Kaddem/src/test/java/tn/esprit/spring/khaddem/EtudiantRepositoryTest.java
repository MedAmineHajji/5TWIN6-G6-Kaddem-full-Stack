package tn.esprit.spring.khaddem;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.spring.khaddem.entities.Etudiant;
import tn.esprit.spring.khaddem.entities.Option;
import tn.esprit.spring.khaddem.repositories.EtudiantRepository;
import tn.esprit.spring.khaddem.services.EtudiantServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class EtudiantRepositoryTest {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private EtudiantServiceImpl etudiantService;

    //this is a testing unit for adding a new Etudiant
    @Test
    public void a() {
        Etudiant newEtudiant = new Etudiant();
        newEtudiant.setPrenomE("Dja");
        newEtudiant.setNomE("Hajji");
        newEtudiant.setOp(Option.INFINI);

        Etudiant addedEtudiant = etudiantRepository.save(newEtudiant);

        assertEquals("Dja", addedEtudiant.getPrenomE());
        assertEquals("Hajji", addedEtudiant.getNomE());
        assertEquals(Option.INFINI, addedEtudiant.getOp());
    }

    //this is a testing unit for retrieving an Etudiant
    @Test
    public void b() {
        Etudiant newEtudiant = new Etudiant();
        newEtudiant.setPrenomE("Dja");
        newEtudiant.setNomE("Hajji");
        newEtudiant.setOp(Option.INFINI);

        Etudiant addedEtudiant = etudiantRepository.save(newEtudiant);

        Etudiant retrievedEtudiant = etudiantRepository.findById(addedEtudiant.getIdEtudiant()).orElse(null);

        assertNotNull(retrievedEtudiant);
        assertEquals("Dja", retrievedEtudiant.getPrenomE());
        assertEquals("Hajji", retrievedEtudiant.getNomE());
        assertEquals(Option.INFINI, retrievedEtudiant.getOp());
    }

    //This is a testing unit for updating an Etudiant
    @Test
    public void c() {
        Etudiant newEtudiant = new Etudiant();
        newEtudiant.setPrenomE("Dja");
        newEtudiant.setNomE("Hajji");
        newEtudiant.setOp(Option.INFINI);

        Etudiant addedEtudiant = etudiantRepository.save(newEtudiant);
        Etudiant updateEtudiant = etudiantRepository.findById(addedEtudiant.getIdEtudiant()).orElse(null);

        updateEtudiant.setPrenomE("Dja updated");
        updateEtudiant.setNomE("Hajji updated");

        Etudiant modifiedEtudiant = etudiantRepository.save(updateEtudiant);

        Etudiant retrievedEtudiant = etudiantRepository.findById(modifiedEtudiant.getIdEtudiant()).orElse(null);

        assertNotNull(retrievedEtudiant);
        assertEquals("Dja updated", retrievedEtudiant.getPrenomE());
        assertEquals("Hajji updated", retrievedEtudiant.getNomE());
        assertEquals(Option.INFINI, retrievedEtudiant.getOp());
    }

    //This is a testing unit for deleting an Etudiant
    @Test
    public void d() {
        Etudiant etudiant = new Etudiant();
        etudiant.setPrenomE("John");
        etudiant.setNomE("Doe");
        etudiant.setOp(Option.INFINI);

        Etudiant addedEtudiant = etudiantRepository.save(etudiant);

        etudiantRepository.deleteById(addedEtudiant.getIdEtudiant());

        assertFalse(etudiantRepository.existsById(addedEtudiant.getIdEtudiant()));
    }

}