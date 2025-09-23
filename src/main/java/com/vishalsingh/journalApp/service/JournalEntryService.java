package com.vishalsingh.journalApp.service;

import com.vishalsingh.journalApp.entity.JournalEntry;
import com.vishalsingh.journalApp.entity.UserEntry;
import com.vishalsingh.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;

    @Transactional
    public void savenewEntry(JournalEntry JournalEntry,String username){
        UserEntry user = userService.findByUsername(username);
       JournalEntry journal=journalEntryRepository.save(JournalEntry);
       user.getJournalEntries().add(journal);
       userService.save(user);
    }

    public void saveEntry(JournalEntry JournalEntry){

        journalEntryRepository.save(JournalEntry);

    }
    
    public Optional<JournalEntry> findById(ObjectId myId){
        return journalEntryRepository.findById(myId);
    }

    public void deletById(ObjectId Id,String username){
        UserEntry user= userService.findByUsername(username);
        user.getJournalEntries().removeIf(x->x.getId().equals(Id));
        userService.save(user);
        journalEntryRepository.deleteById(Id);
    }
}
