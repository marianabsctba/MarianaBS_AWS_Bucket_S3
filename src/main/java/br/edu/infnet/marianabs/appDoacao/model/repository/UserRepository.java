package br.edu.infnet.marianabs.appDoacao.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.marianabs.appDoacao.model.domain.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByEmail(String email);


}
