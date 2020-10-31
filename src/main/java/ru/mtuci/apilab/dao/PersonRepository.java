package ru.mtuci.apilab.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mtuci.apilab.model.Person;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PersonRepository extends JpaRepository <Person,Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Person p WHERE p.id=:id")
    int delete(@Param("id") Long id );

}
