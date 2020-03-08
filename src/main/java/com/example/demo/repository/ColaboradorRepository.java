package com.example.demo.repository;

import com.example.demo.model.entity.Colaborador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    Colaborador findByCpf(final String cpf);

    @Query("SELECT c FROM Colaborador c "
            + "WHERE 1 = 1 "
            + "AND (:nomeCompleto IS NULL OR :nomeCompleto = '' OR UPPER (c.nomeCompleto) LIKE CONCAT ('%',UPPER(:nomeCompleto),'%')) "
            + "AND (:cpf IS NULL OR :cpf = '' OR c.cpf = :cpf) "
            + "AND (:sexoId IS NULL OR c.sexo.id = :sexoId) "
            + "AND (:cargoId IS NULL OR c.cargo.id = :cargoId) ")
    Page<Colaborador> findByFilter(
            final String nomeCompleto,
            final String cpf,
            final Long sexoId,
            final Long cargoId,
            Pageable pageable);

}
