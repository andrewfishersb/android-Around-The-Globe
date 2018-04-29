package com.fisher.andrew.aroundtheglobe.Utils;


import com.fisher.andrew.aroundtheglobe.BuildConfig;

public class Constants {

    //API Key
    public static final String FLICKR_API_KEY_RECEIVER = "api_key";
    public static final String FLICKR_API_KEY = BuildConfig.FLICKR_API_KEY;

    //BASE URL
    public static final String FLICKR_BASE_URL = "https://api.flickr.com/services/rest/?";


    //METHOD
    public static final String FLICKR_METHOD_QUERY_PARAMETER = "method";
    public static final String FLICKR_SEARCH_METHOD_QUERY_PARAMETER = "flickr.photos.search";

    //PRIVACY
    public static final String FLICKR_PRIVACY_FILTER_QUERY_PARAMETER = "privacy_filter";
    public static final String FLICKR_PRIVACY_SCOPE = "1"; //public only

    //LOCATION BASE QUERIES
    public static final String FLICKR_LATITUDE_QUERY_PARAMETER = "lat";
    public static final String FLICKR_LONGITUDE_QUERY_PARAMETER = "lon";
    public static final String FLICKR_DISTANCE_QUERY_PARAMETER = "accuracy";
    public static final String FLICKR_DISTANCE_TYPE = "11";


    //FORMAT
    public static final String FLICKR_FORMAT_PARAMETER = "format";
    public static final String FLICKR_FORMAT_TYPE = "json";
    public static final String FLICKR_RETURN_JSON_QUERY = "nojsoncallback";
    public static final String FLICKR_RETURN_JSON_TYPE = "1";

    //RETURN INFORMATION
    public static final String FLICKR_PER_PAGE_QUERY = "per_page";
    public static final String FLICKR_IMAGES_PER_PAGE = "50";//CHANGE TO 10 OR SOMETHING????
    public static final String FLICKR_PAGE_QUERY = "page";
    public static final String FLICKR_NUMBER_OF_PAGES = "1";

    //TYPE OF PHOTOS
    public static final String FLICKR_MEDIA_TYPE_QUERY = "media";
    public static final String FLICKR_MEDIA_TYPE = "photos";
    public static final String FLICKR_CONTENT_TYPE_QUERY = "content_type";
    public static final String FLICKR_CONTENT_TYPE = "4"; //4 (for photos and screenshots.) OR 1 (for photos only.)

    //SORT PHOTOS - MAY NOT USE IF I DONT LIKE THE RESULTS AS MUCH AS THE DEAFAULT
    public static final String FLICKR_SORT_TYPE_QUERY = "sort";
    public static final String FLICK_SORT_POPULAR = "interestingness-desc";


    //PARTS OF URL TO CREATE IMAGE URL
    //https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg
    public static final String FLICKR_IMAGE_BASE_URL = "https://farm";
    public static final String FLICKR_IMAGE_URL_DOT_COM = ".staticflickr.com";
    public static final String FLICKR_IMAGE_URL_FILE_FORMAT = ".jpg";




}
