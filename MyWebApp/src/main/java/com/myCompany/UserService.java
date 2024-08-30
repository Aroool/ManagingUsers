package com.myCompany;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired private UserRepository repo;

    public List<UsedDTO> listAll(){
        return (List<UsedDTO>) repo.findAll();
    }

    public void save(UsedDTO user) {
        repo.save(user);
    }

    public UsedDTO get(Long id) throws UserNotFoundException {
        Optional<UsedDTO> result = repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("Could not find any user with ID: " + id);
    }

    public void delete(Long id) throws UserNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0)
            throw new UserNotFoundException("Could not find any user with ID: " + id);
        repo.deleteById(id);
    }

}
