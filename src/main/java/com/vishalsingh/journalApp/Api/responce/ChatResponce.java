package com.vishalsingh.journalApp.Api.responce;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class ChatResponce {

    private Query query;
    public String getFirstPageExtract() {
        if (query != null && query.getPages() != null && !query.getPages().isEmpty()) {
            Page firstPage = query.getPages().values().iterator().next();
            return firstPage.getExtract();
        }
        return null;
    }


    @Data
    public static class Query {
        private List<Normalized> normalized;
        private Map<String, Page> pages;
    }

    @Data
    public static class Normalized {
        private String from;
        private String to;
    }

    @Data
    public static class Page {
        private int pageid;
        private int ns;
        private String title;
        private String extract;
    }
}
