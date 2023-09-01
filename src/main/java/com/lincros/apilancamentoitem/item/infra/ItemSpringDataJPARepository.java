package com.lincros.apilancamentoitem.item.infra;

import com.lincros.apilancamentoitem.item.domain.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemSpringDataJPARepository extends JpaRepository<Item, UUID> {

}
