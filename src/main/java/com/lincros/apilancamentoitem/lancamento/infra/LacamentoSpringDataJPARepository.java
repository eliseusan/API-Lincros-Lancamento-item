package com.lincros.apilancamentoitem.lancamento.infra;

import com.lincros.apilancamentoitem.lancamento.domain.entities.Lacamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LacamentoSpringDataJPARepository extends JpaRepository<Lacamento, UUID>{

}
