package com.myCompany;

import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <UsedDTO, Long> {
    public Long countById(Long id);

}
