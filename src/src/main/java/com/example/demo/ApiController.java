package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {
    private List<String> messages = new ArrayList<>();
    @GetMapping("messages")
    public List<String> getMessages() {
        return messages;
    }
    /* curl -X POST http://localhost:8080/messages -H 'Content-Type:
   text/plain' -d 'text' */
    @PostMapping("messages")
    public void addMessage(@RequestBody String text) {
        messages.add(text);
    }
    /*curl -X GET http://localhost:8080/messages -d 'text'*/
    @GetMapping("messages/{index}")
    public String getMessage(@PathVariable("index") Integer index) {
        return messages.get(index);
    }
    /*curl -X DELETE -H "Content-Type: application/json" http://localhost:8080/messages*/
    @DeleteMapping("messages/{index}")
    public void deleteText(@PathVariable("index") Integer index) {
        messages.remove((int) index);
    }
    /*curl -X PUT http://localhost:8080/messages*/
    @PutMapping("messages/{index}")
    public void updateMessage(
            @PathVariable("index") Integer i,
            @RequestBody String message) {
        messages.remove((int) i);
        messages.add(i, message);
    }
    /*curl -X GET COUNT http://localhost:8080/messages -d*/
    @GetMapping("messages")
    public Integer getMessageCount() {
        return messages.size();
    }
    /* curl -X POST CREATE http://localhost:8080/messages -H 'Content-Type:
    text/plain' -d 'text' */
    @PostMapping("messages/{index}")
    public void addMessageCreate(int i,String t) {
        messages.add(i,t);
    }
    /*curl -X GET SEARCH http://localhost:8080/messages -d*/
    @GetMapping("messages")
    public String getMessageSearch() {
        Integer s=messages.indexOf ("{text}");
        return messages.get(s);
    }
    /*curl -X GET DELETE http://localhost:8080/messages -d*/
    @GetMapping("messages")
    public void getMessageDelete() {
        while (messages.contains("{text}")){
            Integer s = messages.indexOf("{text}");
            messages.remove(s);
        }
    }
}