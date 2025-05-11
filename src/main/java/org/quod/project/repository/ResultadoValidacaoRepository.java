package org.quod.project.repository;

import org.quod.project.model.ResultadoValidacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoValidacaoRepository extends MongoRepository<ResultadoValidacao, String> {
}
