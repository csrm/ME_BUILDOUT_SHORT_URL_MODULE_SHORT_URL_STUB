package com.crio.tinyurl;

public interface ShortUrl {

  String registerNewUrl(String longUrl);

  String registerNewUrl(String longUrl, String tinyUrl);

  String getUrl(String shortUrl);

  Integer getHitCount(String longUrl);

  String delete(String longUrl);

}

