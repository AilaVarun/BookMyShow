package dev.varun.bookmyshow.repositories;

import dev.varun.bookmyshow.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show,Long> {


    /*
    JPA methods are called which are inbuild methods for basic uses
     */
}
