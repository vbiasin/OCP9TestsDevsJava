package com.dummy.myerp.model.bean.comptabilite;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompteComptableTest {

    private CompteComptable compte = new CompteComptable(251096,"GMAO");


    @Test
    public void testToStringOK()
    {
        Assertions.assertEquals(compte.toString(), "CompteComptable{numero=251096, libelle='GMAO'}");
    }

    @Test
    public void testToString()
    {

        Assertions.assertNotEquals(compte.toString(), "ceci est une chaine de caractères !");
    }

    @Test
    public void getByNumeroOK(){
        List<CompteComptable> liste = new ArrayList<CompteComptable>();
        liste.add(compte);
        CompteComptable c = CompteComptable.getByNumero(liste,251096);
        Assertions.assertEquals(c,compte);
    }

    @Test
    public void getByNumero(){
        List<CompteComptable> liste = new ArrayList<CompteComptable>();
        liste.add(compte);
        CompteComptable c = CompteComptable.getByNumero(liste,123456);
        Assertions.assertNotEquals(c,compte);
    }

}
