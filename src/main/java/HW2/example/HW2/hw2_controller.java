/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HW2.example.HW2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Landon
 */
@RestController
public class hw2_controller {

    @GetMapping("/quote")
    public Object getQuote() {
        String url = "https://api.agify.io?name=meelad";
        RestTemplate restTemplate = new RestTemplate();
        Object jSonQuote = restTemplate.getForObject(url, Object.class);

        //Print the whole response to console.
        String quote = restTemplate.getForObject(url, String.class);
        //Parse out the most important info from the response.
        JSONObject jo = new JSONObject(quote);
        System.out.println(jo.toString());
        String quoteAuthor = jo.getString("name");
        int age = jo.getInt("age"); 
        int count = jo.getInt("count");
        System.out.println(quoteAuthor);
        System.out.println(age);
        System.out.println(count);

        return jSonQuote;
    }
}
