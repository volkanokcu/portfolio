package com.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.porfolio.domain.impl.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
