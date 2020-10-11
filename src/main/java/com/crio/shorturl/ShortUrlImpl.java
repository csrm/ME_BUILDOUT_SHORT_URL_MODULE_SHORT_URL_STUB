package com.crio.shorturl;

import java.util.HashMap;
import java.util.Random;

public class ShortUrlImpl implements ShortUrl {
    private HashMap<String,String> forwardMap;
    private HashMap<String,String> reverseMap;
    private HashMap<String,Integer> lookUp;
    //Constructor
    public ShortUrlImpl(){
        forwardMap = new HashMap<String,String>();
        reverseMap = new HashMap<String,String>();
        lookUp = new HashMap<String,Integer>();
    }
    //Forward Mapp from LongURL to ShortURL
    public String registerNewUrl(String longUrl){
        String shortUrl = (String)forwardMap.get(longUrl);
        if(shortUrl==null||shortUrl.isEmpty()) {
            shortUrl = "http://short.url/"+getRandomAlphaNumString();
            forwardMap.put(longUrl, shortUrl);
            reverseMap.put(shortUrl, longUrl);
            lookUp.put(longUrl,0);
        }
        return shortUrl;
    }
    //Reverse Map from ShortURL to LongURL
    public String registerNewUrl(String longUrl, String shortUrl){
        String s = (String)reverseMap.get(shortUrl);
        if(s==null || s.isEmpty()){
            reverseMap.put(shortUrl, longUrl);
            forwardMap.put(longUrl,shortUrl);
            lookUp.put(longUrl,0);
            return shortUrl;
        }
        else 
         return null;
    }
    //Get longURL from shortURL
    public String getUrl(String shortUrl){
      String longUrl = (String)reverseMap.get(shortUrl);
      if(longUrl!=null){
          Integer count = (Integer)lookUp.get(longUrl);
          count++;
          lookUp.put(longUrl,count);
         return longUrl;
      }
      return null;
    }
    //get the long URL hit count
    public Integer getHitCount(String longUrl){
       Integer count = (Integer)lookUp.get(longUrl);
       if(count==null)
         return 0;
       return count;
    }
    //delete the longURL & shortURL relation
    public String delete(String longUrl){
      String shortUrl = (String)forwardMap.get(longUrl);
      forwardMap.remove(longUrl);
      reverseMap.remove(shortUrl);
      return longUrl;
    }
    //Generate a random alphaNumeric string
    private String getRandomAlphaNumString(){
        Random rm = new Random();
        String alphaNum="";
        for(int i=1;i<10;i++){
            int select = rm.nextInt(3);
            switch(select){
                case 0: //Generate a number
                        int num1 = rm.nextInt(10);
                       // alphaNum.concat(Integer.toString(num1));
                       alphaNum = alphaNum + num1;
                        break;
                case 1: //Generate a Lowercase alphabet
                        int num2 = rm.nextInt(26);
                        char alpha2 = (char)(num2+97);
                        //alphaNum.concat(Character.toString(alpha2));
                        alphaNum = alphaNum + alpha2;
                        break;
                case 2: //Generate an Uppercase alphabet
                        int num3 = rm.nextInt(26);
                        char alpha3 = (char)(num3+65);
                        //alphaNum.concat(Character.toString(alpha3));
                        alphaNum = alphaNum + alpha3;
                        break;
            }
        }
        return alphaNum;
    }
}