package com.acme.newjob.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.acme.newjob.model.TokenUser;

public interface TokenUserRepository extends CrudRepository<TokenUser, Long> {
	List<TokenUser> findByUserName(String userName);
	TokenUser findById(long id);
}
