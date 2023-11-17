package tn.esprit.spring.khaddem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.khaddem.entities.Etudiant;
import tn.esprit.spring.khaddem.entities.Option;
import tn.esprit.spring.khaddem.repositories.EtudiantRepository;
import tn.esprit.spring.khaddem.services.EtudiantServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EtudiantServiceTest {

    @InjectMocks
    private EtudiantServiceImpl etudiantService;

    @Mock
    private EtudiantRepository etudiantRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddEtudiant() {
        // Arrange
        Etudiant newEtudiant = new Etudiant();
        newEtudiant.setPrenomE("Dja");
        newEtudiant.setNomE("Hajji");
        newEtudiant.setOp(Option.INFINI);
        when(etudiantRepository.save(newEtudiant)).thenReturn(newEtudiant);

        // Act
        Etudiant addedEtudiant = etudiantService.addEtudiant(newEtudiant);

        // Assert
        assertEquals("Dja", addedEtudiant.getPrenomE());
        assertEquals("Hajji", addedEtudiant.getNomE());
        assertEquals(Option.INFINI, addedEtudiant.getOp());
    }

    @Test
    public void testRetrieveEtudiant() {
        // Arrange
        Etudiant existingEtudiant = new Etudiant();
        existingEtudiant.setIdEtudiant(1);
        existingEtudiant.setPrenomE("Dja");
        existingEtudiant.setNomE("Hajji");
        existingEtudiant.setOp(Option.INFINI);
        when(etudiantRepository.findById(1)).thenReturn(java.util.Optional.of(existingEtudiant));

        // Act
        Etudiant retrievedEtudiant = etudiantService.retrieveEtudiant(1);

        // Assert
        assertNotNull(retrievedEtudiant);
        assertEquals("Dja", retrievedEtudiant.getPrenomE());
        assertEquals("Hajji", retrievedEtudiant.getNomE());
        assertEquals(Option.INFINI, retrievedEtudiant.getOp());
    }

    @Test
    public void testUpdateEtudiant() {
        // Arrange
        Etudiant existingEtudiant = new Etudiant();
        existingEtudiant.setIdEtudiant(1);
        existingEtudiant.setPrenomE("Dja");
        existingEtudiant.setNomE("Hajji");
        existingEtudiant.setOp(Option.INFINI);

        // Act
        Etudiant modifiedEtudiant = etudiantService.updateEtudiant(existingEtudiant);

        // Assert
        assertNotNull(modifiedEtudiant);
        assertEquals("Dja", modifiedEtudiant.getPrenomE());
        assertEquals("Hajji", modifiedEtudiant.getNomE());
        assertEquals(Option.INFINI, modifiedEtudiant.getOp());
    }

    @Test
    public void testRemoveEtudiant() {
        // Arrange
        Etudiant existingEtudiant = new Etudiant();
        existingEtudiant.setIdEtudiant(1);
        existingEtudiant.setPrenomE("Dja");
        existingEtudiant.setNomE("Hajji");
        existingEtudiant.setOp(Option.INFINI);

        // Act
        etudiantService.removeEtudiant(1);

        // Assert
        // Make sure there is no unnecessary stubbing for etudiantRepository.findById(1).
    }

}
