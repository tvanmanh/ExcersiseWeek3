package com.example.tranvanmanh.week3_excersise;

/**
 * Created by tranvanmanh on 3/15/2018.
 */
import java.util.List;

public class Profile {
    private List<Result> results = null;
    private Integer page;
    private Integer total_results;
    private Dates dates;
    private Integer total_pages;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalResults() {
        return total_results;
    }

    public void setTotalResults(Integer totalResults) {
        this.total_results = totalResults;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public Integer getTotalPages() {
        return total_pages;
    }

    public void setTotalPages(Integer totalPages) {
        this.total_pages = totalPages;
    }
}
