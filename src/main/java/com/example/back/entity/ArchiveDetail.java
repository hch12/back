package com.example.back.entity;

import java.util.List;

public class ArchiveDetail {
    private Archive archive= null;
    private List<Indicator> indicators;
    private List<String> uniqueNames;
    public ArchiveDetail(Archive archive,List<Indicator> indicators,List<String> uniqueNames){
        this.archive = archive;
        this.indicators = indicators;
        this.uniqueNames = uniqueNames;
    }

    public ArchiveDetail(List<Indicator> indicators,List<String> uniqueNames){
        this.indicators = indicators;
        this.uniqueNames = uniqueNames;
    }

    public Archive getArchive() {
        return archive;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }

    public List<Indicator> getIndicators() {
        return indicators;
    }

    public void setIndicators(List<Indicator> indicators) {
        this.indicators = indicators;
    }

    public List<String> getUniqueNames() {
        return uniqueNames;
    }

    public void setUniqueNames(List<String> uniqueNames) {
        this.uniqueNames = uniqueNames;
    }
}
