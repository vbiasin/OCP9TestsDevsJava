package com.dummy.myerp.business.impl.manager;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.Date;
import com.dummy.myerp.business.contrat.BusinessProxy;
import com.dummy.myerp.business.impl.TransactionManager;
import com.dummy.myerp.consumer.dao.contrat.ComptabiliteDao;
import com.dummy.myerp.consumer.dao.contrat.DaoProxy;
import com.dummy.myerp.model.bean.comptabilite.*;
import com.dummy.myerp.technical.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.dummy.myerp.technical.exception.FunctionalException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.TransactionStatus;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ComptabiliteManagerImplTest {

    private  EcritureComptable vEcritureComptable;
    private ComptabiliteManagerImpl managerUnit = new ComptabiliteManagerImpl();

    @Mock
    DaoProxy dao;

    @Mock
    ComptabiliteDao comptabiliteDao;

    @Mock
    BusinessProxy businessProxy;

    @Mock
    TransactionManager transactionManager;

    @Mock
    ComptabiliteManagerImpl manager;

    @Mock
    TransactionStatus vTS;



    @BeforeEach
    public void setup() {
        manager = new ComptabiliteManagerImpl();
        lenient().when(dao.getComptabiliteDao()).thenReturn(comptabiliteDao);
        ComptabiliteManagerImpl.configure(businessProxy, dao, transactionManager);

        vEcritureComptable = new EcritureComptable();
        JournalComptable pJournal = new JournalComptable("AC", "Achat");
        vEcritureComptable.setJournal(pJournal);
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.setReference("AC-2022/00001");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                null, new BigDecimal(453), null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                null, null, new BigDecimal(453)));
    }


// ==================== TESTS UNITAIRES ====================

    @Test
    public void checkEcritureComptableUnitViolation() throws Exception {
        assertThrows(FunctionalException .class, () -> {
            EcritureComptable vEcritureComptableUnit;
            vEcritureComptableUnit = new EcritureComptable();
            managerUnit.checkEcritureComptableUnitViolation(vEcritureComptableUnit);
        });

    }

    @Test
    public void checkEcritureComptableUnitViolationOK() throws Exception {
        Assertions.assertTrue(true);
        EcritureComptable vEcritureComptableUnit = new EcritureComptable();
        vEcritureComptableUnit.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptableUnit.setDate(new Date());
        vEcritureComptableUnit.setLibelle("Achat");
        vEcritureComptableUnit.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                "CallOf", new BigDecimal(123),
                null));
        vEcritureComptableUnit.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
                "CallOf", null,
                new BigDecimal(123)));
        managerUnit.checkEcritureComptableUnitViolation(vEcritureComptableUnit);
    }

    @Test
    public void checkEcritureComptableUnitRG2() throws Exception {
        assertThrows(FunctionalException.class, () -> {
            EcritureComptable vEcritureComptableUnit;
            vEcritureComptableUnit = new EcritureComptable();
            vEcritureComptableUnit.setJournal(new JournalComptable("AC", "Achat"));
            vEcritureComptableUnit.setDate(new Date());
            vEcritureComptableUnit.setLibelle("Libelle");
            vEcritureComptableUnit.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, new BigDecimal(123),
                    null));
            vEcritureComptableUnit.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
                    null, null,
                    new BigDecimal(1234)));
            managerUnit.checkEcritureComptableUnitRG2(vEcritureComptableUnit);
        });

    }

    @Test
    public void checkEcritureComptableUnitRG2OK() throws Exception {
        Assertions.assertTrue(true);
            EcritureComptable vEcritureComptableUnit;
            vEcritureComptableUnit = new EcritureComptable();
            vEcritureComptableUnit.setJournal(new JournalComptable("AC", "Achat"));
            vEcritureComptableUnit.setDate(new Date());
            vEcritureComptableUnit.setLibelle("Libelle");
            vEcritureComptableUnit.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, new BigDecimal(123),
                    null));
            vEcritureComptableUnit.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
                    null, null,
                    new BigDecimal(123)));
            managerUnit.checkEcritureComptableUnitRG2(vEcritureComptableUnit);


    }

    @Test
    public void checkEcritureComptableUnitRG3OK() throws Exception {
        Assertions.assertTrue(true);
            EcritureComptable vEcritureComptableUnit;
            vEcritureComptableUnit = new EcritureComptable();
            vEcritureComptableUnit.setJournal(new JournalComptable("AC", "Achat"));
            vEcritureComptableUnit.setDate(new Date());
            vEcritureComptableUnit.setLibelle("Libelle");
            vEcritureComptableUnit.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, new BigDecimal(123),
                    null));
            vEcritureComptableUnit.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, null,
                    new BigDecimal(123)));
            managerUnit.checkEcritureComptableUnitRG3(vEcritureComptableUnit);

    }

    @Test
    public void checkEcritureComptableUnitRG3() throws Exception {
        assertThrows( FunctionalException.class, () -> {
            EcritureComptable vEcritureComptableUnit;
            vEcritureComptableUnit = new EcritureComptable();
            vEcritureComptableUnit.setJournal(new JournalComptable("AC", "Achat"));
            vEcritureComptableUnit.setDate(new Date());
            vEcritureComptableUnit.setLibelle("Libelle");
            vEcritureComptableUnit.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, new BigDecimal(123),
                    null));
            vEcritureComptableUnit.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, new BigDecimal(123),
                    null));
            managerUnit.checkEcritureComptableUnitRG3(vEcritureComptableUnit);
        });

    }

    @Test
    public void checkEcritureComptableUnitRG5() throws Exception {
        assertThrows( FunctionalException.class, () -> {
            EcritureComptable vEcritureComptableUnit;
            vEcritureComptableUnit = new EcritureComptable();
            vEcritureComptableUnit.setJournal(new JournalComptable("AC", "Achat"));
            vEcritureComptableUnit.setDate(new Date());
            vEcritureComptableUnit.setLibelle("Libelle");
            vEcritureComptableUnit.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, new BigDecimal(123),
                    null));
            vEcritureComptableUnit.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, new BigDecimal(123),
                    null));
            vEcritureComptableUnit.setReference("BC-2022/00001");
            managerUnit.checkEcritureComptableUnitRG5(vEcritureComptableUnit);
        });

    }

    @Test
    public void checkEcritureComptableUnitRG5OK() throws Exception {
        Assertions.assertTrue(true);
            EcritureComptable vEcritureComptableUnit;
            vEcritureComptableUnit = new EcritureComptable();
            vEcritureComptableUnit.setJournal(new JournalComptable("AC", "Achat"));
            vEcritureComptableUnit.setDate(new Date());
            vEcritureComptableUnit.setLibelle("Libelle");
            vEcritureComptableUnit.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, new BigDecimal(123),
                    null));
            vEcritureComptableUnit.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                    null, new BigDecimal(123),
                    null));
            vEcritureComptableUnit.setReference("AC-2022/00001");
            managerUnit.checkEcritureComptableUnitRG5(vEcritureComptableUnit);
    }


// ==================== TESTS INTEGRATION ====================


	/*
	AddReference
	*/

    @Test
    public void testAddReference_GivenNew_ReturnNew() throws Exception {
        ZoneId zone = ZoneId.of("Europe/Paris");
        when(comptabiliteDao.getSequenceEcritureComptable(vEcritureComptable.getJournal().getCode(), vEcritureComptable.getDate().toInstant().atZone(zone).getYear()))
                .thenReturn(null);

        manager.addReference(vEcritureComptable);

        verify(dao, times(4)).getComptabiliteDao();
        verify(comptabiliteDao, times(1)).insertSequenceEcritureComptable(any());
    }

    @Test
    public void testAddReference_GivenExistingValue_ReturnUpdateValue() throws Exception {
        JournalComptable pJournal = new JournalComptable("AC", "Achat");
        SequenceEcritureComptable vSequenceEcritureComptable = new SequenceEcritureComptable(2022, 00001);
        ZoneId zone = ZoneId.of("Europe/Paris");
        when(comptabiliteDao.getSequenceEcritureComptable(vEcritureComptable.getJournal().getCode(), vEcritureComptable.getDate().toInstant().atZone(zone).getYear()))
                .thenReturn(vSequenceEcritureComptable);

        manager.addReference(vEcritureComptable);

        verify(dao, times(4)).getComptabiliteDao();
        verify(comptabiliteDao, times(1)).updateSequenceEcritureComptable(any());
    }

	/*
	checkEcritureComptable
	*/

    @Test
    public void testCheckEcritureComptable_GivenValidValue_ReturnValid() throws FunctionalException, NotFoundException {
        vEcritureComptable.setId(1);
        SequenceEcritureComptable sequenceEcritureComptable = new SequenceEcritureComptable(2022,1);

        when(comptabiliteDao.getEcritureComptableByRef("AC-2022/00001")).thenReturn(vEcritureComptable);
        lenient().when(comptabiliteDao.getSequenceEcritureComptable(anyString(),anyInt())).thenReturn(sequenceEcritureComptable);

        manager.checkEcritureComptable(vEcritureComptable);
    }



	/*
	checkEcritureComptableContext
	*/

    @Test
    public void testCheckEcritureComptableContextRG6_GivenNewRef_ReturnFunctionalError() throws NotFoundException {
        // id == null de base
        given(comptabiliteDao.getEcritureComptableByRef(anyString())).willReturn(vEcritureComptable);

        FunctionalException functionalException = assertThrows(FunctionalException.class,
                () -> manager.checkEcritureComptableContext(vEcritureComptable));

        Assertions.assertEquals(functionalException.getMessage(),"Une autre écriture comptable existe déjà avec la même référence.");
    }

    @Test
    public void testCheckEcritureComptableContextRG6_GivenExistingRef_ReturnFunctionalError() throws NotFoundException, FunctionalException {

        vEcritureComptable.setId(1);

        EcritureComptable testEcritureComptable = new EcritureComptable();
        testEcritureComptable.setId(2);

        when(comptabiliteDao.getEcritureComptableByRef(anyString())).thenReturn(testEcritureComptable);

        FunctionalException functionalException = assertThrows(FunctionalException.class,
                () -> manager.checkEcritureComptableContext(vEcritureComptable));

        Assertions.assertEquals(functionalException.getMessage(),"Une autre écriture comptable existe déjà avec la même référence.");
    }

	/*
	InsertEcritureComptable
	*/

    @Test
    public void testInsertEcritureComptableShouldCallTransactionManager() throws FunctionalException, NotFoundException {
        vTS = transactionManager.beginTransactionMyERP();
        vEcritureComptable.setId(1);
        SequenceEcritureComptable sequenceEcritureComptable = new SequenceEcritureComptable(2022,1);

        when(comptabiliteDao.getEcritureComptableByRef("AC-2022/00001")).thenReturn(vEcritureComptable);
        lenient().when(comptabiliteDao.getSequenceEcritureComptable(anyString(),anyInt())).thenReturn(sequenceEcritureComptable);

        manager.insertEcritureComptable(vEcritureComptable);

        verify(dao, times(2)).getComptabiliteDao();
        verify(transactionManager, times(1)).commitMyERP(vTS);
        verify(transactionManager, times(1)).rollbackMyERP(vTS);
    }

	/*
	UpdateEcritureComptable
	*/

    @Test
    public void testUpdateEcritureComptableShouldCallTransactionManager() throws NotFoundException, FunctionalException {
        vTS = transactionManager.beginTransactionMyERP();
        vEcritureComptable.setId(1);
        SequenceEcritureComptable sequenceEcritureComptable = new SequenceEcritureComptable(2022,1);

        when(comptabiliteDao.getEcritureComptableByRef("AC-2022/00001")).thenReturn(vEcritureComptable);
        lenient().when(comptabiliteDao.getSequenceEcritureComptable(anyString(),anyInt())).thenReturn(sequenceEcritureComptable);

        manager.updateEcritureComptable(vEcritureComptable);

        verify(dao, times(2)).getComptabiliteDao();
        verify(transactionManager, times(1)).commitMyERP(vTS);
        verify(transactionManager, times(1)).rollbackMyERP(vTS);
    }

    /*
    DeleteEcritureComptable
    */
    @Test
    public void testDeleteEcritureComptableShouldCallTransactionManager() {

        vTS = transactionManager.beginTransactionMyERP();
        vEcritureComptable.setId(1);

        manager.deleteEcritureComptable(vEcritureComptable.getId());
        verify(dao, times(1)).getComptabiliteDao();
        verify(transactionManager, times(1)).commitMyERP(vTS);
        verify(transactionManager, times(1)).rollbackMyERP(vTS);
    }

}
