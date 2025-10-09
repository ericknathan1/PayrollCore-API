package com.senac.erick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.erick.entity.FolhaPagamento;

@Repository
public interface FolhaPagamentoRepository extends JpaRepository<FolhaPagamento, Integer> {

}
