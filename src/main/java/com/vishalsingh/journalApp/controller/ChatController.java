package com.vishalsingh.journalApp.controller;

import com.vishalsingh.journalApp.Api.responce.ChatResponce;
import com.vishalsingh.journalApp.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;
    @GetMapping
    public String infor(){
        ChatResponce response = chatService.chatInfo("Narendra_Modi");//.getQuery().getPages().values().iterator().next();
        String extract = null;
        if (response.getQuery() != null && response.getQuery().getPages() != null && !response.getQuery().getPages().isEmpty()) {
            ChatResponce.Page firstPage = response.getQuery().getPages().values().iterator().next();
            extract = firstPage.getExtract();
            //return extract;
        }

        System.out.println(extract);
        return extract;
    }

}
