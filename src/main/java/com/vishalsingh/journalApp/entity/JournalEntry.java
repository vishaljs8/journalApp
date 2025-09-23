package com.vishalsingh.journalApp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "journal_entries")
@Data
@NoArgsConstructor
public class JournalEntry{
    @Id
    private ObjectId id;
    private String title;
    private String content;

//    public ObjectId getid(){
//        return id;
//    }
//    public void setid(ObjectId id){
//        this.id = id;
//    }
//    public String gettitle(){
//        return title;
//    }
//    public void settitle(String title){
//        this.title = title;
//    }
//    public String getcontent(){
//        return content;
//    }
//    public void setcontent(String content){
//        this.content = content;
//    }
}
