package com.vishalsingh.journalApp.controller;

import com.vishalsingh.journalApp.Api.responce.ChatResponce;
import com.vishalsingh.journalApp.entity.ChatEntity;
import com.vishalsingh.journalApp.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;
    @GetMapping
    public String infor(@RequestParam String topic){
        ChatResponce response = chatService.chatInfo(topic);//.getQuery().getPages().values().iterator().next();
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
