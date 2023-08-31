package com.lincros.apilancamentoitem.lancamento.infra;

import com.lincros.apilancamentoitem.lancamento.application.repository.LacamentoRepository;
import com.lincros.apilancamentoitem.lancamento.domain.entities.Lacamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class LacamentoInfraRepository implements LacamentoRepository {

    private final LacamentoSpringDataJPARepository lacamentoSpringDataJPARepository;
    @Override
    public Lacamento salvaLacamento(Lacamento lacamento) {
        log.info("[start] LacamentoInfraRepository - salvaLacamento ");
        lacamentoSpringDataJPARepository.save(lacamento);
        log.info("[finish] LacamentoInfraRepository - salvaLacamento ");
        return lacamento;
    }
}
