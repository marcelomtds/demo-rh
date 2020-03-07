package com.example.demo.repository;

import com.example.demo.model.entity.Cargo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

    Cargo findByDescricao(final String descricao);

    @Query("SELECT c FROM Cargo c "
            + "WHERE 1 = 1 "
            + "AND (:descricao IS NULL OR :descricao = '' OR UPPER (c.descricao) LIKE CONCAT ('%',UPPER(:descricao),'%'))")
    Page<Cargo> findByFilter(
            final String descricao,
            Pageable pageable);

}
