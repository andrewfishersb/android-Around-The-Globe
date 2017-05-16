package com.fisher.andrew.aroundtheglobe;

/**
 * Created by andrewfisher on 5/16/17.
 */

public class Constants {

    //TOKENS and ACCESS KEYS
    public static final String TWITTER_CONSUMER_KEY = BuildConfig.TWITTER_CONSUMER_KEY;
    public static final String TWITTER_CONSUMER_SECRET = BuildConfig.TWITTER_CONSUMER_SECRET;
    public static final String TWITTER_TOKEN = BuildConfig.TWITTER_TOKEN;
    public static final String TWITTER_TOKEN_SECRET = BuildConfig.TWITTER_TOKEN_SECRET;


    //API Call Constants
    public static final String TWITTER_BASE_URL = "https://api.twitter.com/1.1/search/tweets.json?";//maybe needs the q=
    public static final String TWITTER_GEOCODE_QUERY_PARAMETER = "geocode";
    public static final String TWITTER_RADIUS_QUERY_PARAMETER = "10mi";
    public static final String TWITTER_COUNT_QUERY_PARAMETER = "count";
    public static final String TWITTER_FILTER_QUERY_PARAMETER = "filter";


}
