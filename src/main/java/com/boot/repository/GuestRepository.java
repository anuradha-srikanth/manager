package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long>{

}
