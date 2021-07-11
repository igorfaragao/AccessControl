package com.dio.AccessControl.Repository;

import com.dio.AccessControl.model.JornadaTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JornadaTrabalhoRepository extends JpaRepository<JornadaTrabalho, Long> {



}
