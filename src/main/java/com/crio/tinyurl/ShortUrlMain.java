package com.crio.tinyurl;

public class ShortUrlMain {

  public static void main(String[] args) {
    // FIXME Number of hits
    // FIXME hint for hashmap

    ShortUrl shortUrl = new ShortUrlImpl();
    String url = shortUrl.registerNewUrl("http://abc.com");
    String url1 = shortUrl.registerNewUrl("http://abc1.com");
    String url2 = shortUrl.registerNewUrl("http://abc2.com");
    String url3 = shortUrl.registerNewUrl("http://abc3.com");
    String url4 = shortUrl.registerNewUrl("http://abc2.com");
    System.out.println(url);
    System.out.println(url1);
    System.out.println(url2);
    System.out.println(url3);
    System.out.println(url4);

    String url5 = shortUrl.registerNewUrl("http://abc3.com", "http://tiny.url/test1");
    String url6 = shortUrl.registerNewUrl("http://abc2.com", "http://tiny.url/test2");

    System.out.println(url5);
    System.out.println(url6);

    assert(shortUrl.getUrl(url).equals("http://abc.com"));
    assert(shortUrl.getUrl(url2).equals(shortUrl.getUrl(url4)));
    assert(shortUrl.getUrl(url4).equals(shortUrl.getUrl(url6)));
    assert(shortUrl.getUrl(url5).equals("http://abc3.com"));

    //Another test to generate 50k urls
  }
}

