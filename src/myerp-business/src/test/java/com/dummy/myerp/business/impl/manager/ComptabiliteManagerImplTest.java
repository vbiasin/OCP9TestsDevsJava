package com.dummy.myerp.business.impl.manager;

import java.math.BigDecimal;
import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;
import com.dummy.myerp.technical.exception.FunctionalException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ComptabiliteManagerImplTest {



    private ComptabiliteManagerImpl manager= new ComptabiliteManagerImpl();


// ==================== TESTS UNITAIRES ====================

    @Test
    public void checkEcritureComptableUnitViolation() throws Exception {
        Assertions.assertThrows(FunctionalException .class, () -> {
            EcritureComptable vEcritureComptable;
            vEcritureComptable = new EcritureComptable();
            manager.checkEcritureComptableUnitViolation(vEcritureComptable);
        });

    }

    @Test
    public void checkEcritureComptableUnitViolationOK() throws Exception {
        Assertions.assertTrue(true);
        EcritureComptable vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Achat");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                "CallOf", new BigDecimal(123),
                null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
                "CallOf", null,
                new BigDecimal(123)));
        vEcritureComptable.setReference("AC-2022/00001");
        manager.checkEcritureComptableUnitViolation(vEcritureComptable);
    }

    @Test
    public void checkEcritureComptableUnitRG2() throws Exception {
        Assertions.assertThrows(FunctionalException.class, () -> {
            EcritureComptable vEcritureComptable;
            vEcritureComptable = new EcritureComptable();
            vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
            vEcritureComptable.setDate(new Date());
            vEcritureComptable.setLibelle("Libelle");
            vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, new BigDecimal(123),
                    null));
            vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
                    null, null,
                    new BigDecimal(1234)));
            manager.checkEcritureComptableUnitRG2(vEcritureComptable);
        });

    }

    @Test
    public void checkEcritureComptableUnitRG2OK() throws Exception {
        Assertions.assertTrue(true);
            EcritureComptable vEcritureComptable;
            vEcritureComptable = new EcritureComptable();
            vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
            vEcritureComptable.setDate(new Date());
            vEcritureComptable.setLibelle("Libelle");
            vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, new BigDecimal(123),
                    null));
            vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
                    null, null,
                    new BigDecimal(123)));
            manager.checkEcritureComptableUnitRG2(vEcritureComptable);


    }

    @Test
    public void checkEcritureComptableUnitRG3OK() throws Exception {
        Assertions.assertTrue(true);
            EcritureComptable vEcritureComptable;
            vEcritureComptable = new EcritureComptable();
            vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
            vEcritureComptable.setDate(new Date());
            vEcritureComptable.setLibelle("Libelle");
            vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, new BigDecimal(123),
                    null));
            vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, null,
                    new BigDecimal(123)));
            manager.checkEcritureComptableUnitRG3(vEcritureComptable);

    }

    @Test
    public void checkEcritureComptableUnitRG3() throws Exception {
        Assertions.assertThrows( FunctionalException.class, () -> {
            EcritureComptable vEcritureComptable;
            vEcritureComptable = new EcritureComptable();
            vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
            vEcritureComptable.setDate(new Date());
            vEcritureComptable.setLibelle("Libelle");
            vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, new BigDecimal(123),
                    null));
            vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, new BigDecimal(123),
                    null));
            manager.checkEcritureComptableUnitRG3(vEcritureComptable);
        });

    }

    @Test
    public void checkEcritureComptableUnitRG5() throws Exception {
        Assertions.assertThrows( FunctionalException.class, () -> {
            EcritureComptable vEcritureComptable;
            vEcritureComptable = new EcritureComptable();
            vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
            vEcritureComptable.setDate(new Date());
            vEcritureComptable.setLibelle("Libelle");
            vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, new BigDecimal(123),
                    null));
            vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, new BigDecimal(123),
                    null));
            vEcritureComptable.setReference("BC-2022/00001");
            manager.checkEcritureComptableUnitRG5(vEcritureComptable);
        });

    }

    @Test
    public void checkEcritureComptableUnitRG5OK() throws Exception {
        Assertions.assertTrue(true);
            EcritureComptable vEcritureComptable;
            vEcritureComptable = new EcritureComptable();
            vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
            vEcritureComptable.setDate(new Date());
            vEcritureComptable.setLibelle("Libelle");
            vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, new BigDecimal(123),
                    null));
            vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, new BigDecimal(123),
                    null));
            vEcritureComptable.setReference("AC-2022/00001");
            manager.checkEcritureComptableUnitRG5(vEcritureComptable);
    }

    @Test
    public void checkEcritureComptable() throws Exception {
           Assertions.assertThrows( FunctionalException.class, () -> {
            EcritureComptable vEcritureComptable;
            vEcritureComptable = new EcritureComptable();
            vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
            vEcritureComptable.setDate(new Date());
            vEcritureComptable.setLibelle("Libelle");
            vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, new BigDecimal(123),
                    null));
            vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, new BigDecimal(123),
                    null));
            vEcritureComptable.setReference("BC-2022/00001");
            manager.checkEcritureComptable(vEcritureComptable);
        });

    }

    @Test
    public void checkEcritureComptableOK() throws Exception {
        Assertions.assertTrue(true);
            EcritureComptable vEcritureComptable;
            vEcritureComptable = new EcritureComptable();
            vEcritureComptable.setId(1);
            vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
            vEcritureComptable.setDate(new Date());
            vEcritureComptable.setLibelle("Libelle");
            vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, new BigDecimal(123),
                    null));
            vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, null ,
                    new BigDecimal(123)));
            vEcritureComptable.setReference("AC-2022/12345");
            manager.checkEcritureComptable(vEcritureComptable);

    }

// ==================== TESTS INTEGRATION ====================

    @Mock
    EcritureComptable ecriture;

    @BeforeEach
    public void init() {
        ecriture = new EcritureComptable();
    }

    @Test
    public void checkEcritureComptableContext() throws Exception {
        ComptabiliteManagerImpl manager2 = new ComptabiliteManagerImpl();
        EcritureComptable ecritureExistante = new EcritureComptable();
        ecritureExistante.setId(2);
        ecritureExistante.setJournal(new JournalComptable("BC", "Banque"));
        ecritureExistante.setDate(new Date());
        ecritureExistante.setLibelle("Libelle");
        ecritureExistante.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
                null, new BigDecimal(123),
                null));
        ecritureExistante.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
                null, null ,
                new BigDecimal(123)));
        ecritureExistante.setReference("BC-2022/12345");
        ecriture.setId(1);
        ecriture.setJournal(new JournalComptable("AC", "Achat"));
        ecriture.setDate(new Date());
        ecriture.setLibelle("Libelle");
        ecriture.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                null, new BigDecimal(123),
                null));
        ecriture.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                null, null ,
                new BigDecimal(123)));
        ecriture.setReference("AC-2022/12345");
      /*  // GIVEN
        when(calculator.divide(1, 0)).thenThrow(new ArithmeticException());

        // WHEN
        assertThrows(IllegalArgumentException.class, () -> classUnderTest.calculate(
                new CalculationModel(CalculationType.DIVISION, 1, 0)));

        // THEN
        verify(calculator, times(1)).divide(1, 0);*/
        manager2.addReference(ecritureExistante);
        manager2.checkEcritureComptableContext(ecriture);

    }



}
