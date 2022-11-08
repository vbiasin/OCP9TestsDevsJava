package com.dummy.myerp.model.bean.comptabilite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JournalComptableTest {

    private JournalComptable journal = new JournalComptable("CC","CompteCourrant");

    @Test
    public void testToStringOK()
    {
        Assertions.assertEquals(journal.toString(), "JournalComptable{code='CC', libelle='CompteCourrant'}");
    }

    @Test
    public void testToString()
    {

        Assertions.assertNotEquals(journal.toString(), "ceci est une chaine de caractères !");
    }

    @Test
    public void getByCodeOK(){
        List<JournalComptable> liste = new ArrayList<>();
        liste.add(journal);
        JournalComptable j = JournalComptable.getByCode(liste,"CC");
        Assertions.assertEquals(j,journal);
    }

    @Test
    public void getByCode(){
        List<JournalComptable> liste = new ArrayList<>();
        liste.add(journal);
        JournalComptable j = JournalComptable.getByCode(liste,"TTC");
        Assertions.assertNotEquals(j,journal);
    }

}
