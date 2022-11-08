package com.dummy.myerp.model.bean.comptabilite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SequenceEcritureComptableTest {

    private SequenceEcritureComptable sequence = new SequenceEcritureComptable(2022, 12345, "CC");

    @Test
    public void testToStringOK()
    {
        Assertions.assertEquals(sequence.toString(), "SequenceEcritureComptable{annee=2022, derniereValeur=12345}");
    }

    @Test
    public void testToString()
    {

        Assertions.assertNotEquals(sequence.toString(), "ceci est une chaine de caractères !");
    }

}
