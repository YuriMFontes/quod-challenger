package org.quod.project.repository;

import org.quod.project.model.ResultadoValidacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoValidacaoRepository extends JpaRepository<ResultadoValidacao, Long> {
    // Aqui você pode adicionar consultas personalizadas, se necessário
}
