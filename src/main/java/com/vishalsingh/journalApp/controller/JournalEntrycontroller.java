package com.vishalsingh.journalApp.controller;

import com.vishalsingh.journalApp.entity.JournalEntry;
import com.vishalsingh.journalApp.entity.UserEntry;
import com.vishalsingh.journalApp.service.JournalEntryService;
import com.vishalsingh.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalEntrycontroller {

    @Autowired
    private JournalEntryService JournalEntryService ;
    @Autowired
    private UserService UserService;

    @GetMapping
    public List<JournalEntry> getAll(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserEntry user = UserService.findByUsername(username);
        return user.getJournalEntries();
    }

    @PostMapping("/new")
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        JournalEntryService.savenewEntry(myEntry,username);
        return true;
    }

    @GetMapping("id/{myId}")
    public Optional<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
       UserEntry user= UserService.findByUsername(username);
        boolean myentry = user.getJournalEntries().stream().anyMatch(entry->entry.getId().equals(myId));
        if(myentry){
        return JournalEntryService.findById(myId);}
        return Optional.empty();
    }

    @DeleteMapping("id/{myId}")
    public boolean deletJournalEntryById(@PathVariable ObjectId myId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserEntry user= UserService.findByUsername(username);
        boolean myentry = user.getJournalEntries().stream().anyMatch(entry->entry.getId().equals(myId));
        if(myentry) {
            JournalEntryService.deletById(myId, username);
            return true;
        }
        return false;
    }

    @PutMapping("/id/{id}")
    public JournalEntry updatejournalEntryById(@PathVariable ObjectId id ,@RequestBody JournalEntry newEntry) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserEntry user = UserService.findByUsername(username);
        boolean myentry = user.getJournalEntries().stream().anyMatch(entry -> entry.getId().equals(id));
        if (myentry) {
            JournalEntry old = JournalEntryService.findById(id).orElse(null);
            if (old != null) {
                old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
                old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
            }
            JournalEntryService.saveEntry(old);
            return old;
        }
        return new JournalEntry();
    }

}
