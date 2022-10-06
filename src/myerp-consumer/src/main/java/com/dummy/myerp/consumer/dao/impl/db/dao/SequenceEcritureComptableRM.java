package com.dummy.myerp.consumer.dao.impl.db.dao;
import com.dummy.myerp.model.bean.comptabilite.SequenceEcritureComptable;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SequenceEcritureComptableRM implements RowMapper<SequenceEcritureComptable> {

    @Override
    public SequenceEcritureComptable mapRow(ResultSet pRs, int pRowNum) throws SQLException {
        SequenceEcritureComptable vBean = new SequenceEcritureComptable();
        vBean.setCodeJournal(pRs.getString("journal_code"));
        vBean.setAnnee(pRs.getInt("annee"));
        vBean.setDerniereValeur(pRs.getInt("derniere_valeur"));
        return vBean;
    }
}


