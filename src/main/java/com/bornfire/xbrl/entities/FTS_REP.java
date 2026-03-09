package com.bornfire.xbrl.entities;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FTS_REP extends JpaRepository<FTS_FILE,String>  {

}
