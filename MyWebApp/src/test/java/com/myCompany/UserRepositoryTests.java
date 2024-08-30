package com.myCompany;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo;

    @Test
    public void testAddNew(){
        UsedDTO user = new UsedDTO();
        user.setEmail("def@gmail.com");
        user.setPassword("efgh1234");
        user.setFirstName("Prashath");
        user.setLastName("FBI");

        UsedDTO savedUser = repo.save(user);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<UsedDTO> users = repo.findAll();
        assertThat(users).hasSizeGreaterThan(0);

        for (UsedDTO user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate(){
        Long userId = 1L;
        Optional<UsedDTO> optionalUsedDTO = repo.findById(userId);
        UsedDTO user =  optionalUsedDTO.get();
        user.setPassword("Hello2000");
        repo.save(user);

        UsedDTO updatedUser = repo.findById(userId).get();
        assertThat(updatedUser.getPassword()).isEqualTo("Hello2000");
    }

    @Test
    public void testGet(){
        Long userId = 2L;
        Optional<UsedDTO> optionalUsedDTO = repo.findById(userId);
        UsedDTO user =  optionalUsedDTO.get();

        assertThat(optionalUsedDTO).isPresent();
        System.out.println(optionalUsedDTO.get());
    }

    @Test
    public void testdelete(){
        Long userId = 2L;
        repo.deleteById(userId);
        Optional<UsedDTO> optionalUsedDTO = repo.findById(userId);
        assertThat(optionalUsedDTO).isNotPresent();

    }

}
