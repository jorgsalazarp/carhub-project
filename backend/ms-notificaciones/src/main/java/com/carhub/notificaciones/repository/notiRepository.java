package com.carhub.notificaciones.repository;

import com.carhub.notificaciones.model.notiModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface notiRepository extends JpaRepository<notiModel, Long> {

}
