package com.dummy.myerp.model.bean.comptabilite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class LigneEcritureComptableTest {

    private CompteComptable compte = new CompteComptable(251096,"GMAO");
    private LigneEcritureComptable ligne = new LigneEcritureComptable( compte, "MicroMaint",
            null,null);

    @Test
    public void testToStringOK()
    {
        Assertions.assertEquals(ligne.toString(), "LigneEcritureComptable{compteComptable=CompteComptable{numero=251096, libelle='GMAO'}, libelle='MicroMaint', debit=null, credit=null}");
    }

    @Test
    public void testToString()
    {

        Assertions.assertNotEquals(ligne.toString(), "ceci est une chaine de caractères !");
    }
}
