package com.example.waterbillingsystem.Billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConsumerService {

    @Autowired
    private ConsumerRepository repo;


    public List<Consumer> listAll() {
        return (List<Consumer>) repo.findAll();

    }

    public void save (Consumer user) {

        repo.save(user);

    }

//    public Consumer get(Integer id) throws ConsumerNotFoundException{
//        Optional<Consumer> result = repo.findById(id);
//        if(result.isPresent()) {
//            return result.get();
//        }
//        throw new ConsumerNotFoundException("Could not find users with ID " + id);
//    }
//
//
//    public void delete(Integer id) throws ConsumerNotFoundException {
//
//        Long count = repo.countById(id);
//        if (count == 0 || count == null) {
//            throw new ConsumerNotFoundException("Could not find user with ID: " + id);
//        }
//
//        repo.deleteById(id);
//    }

}
