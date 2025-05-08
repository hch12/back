package com.example.back.entity;

import java.util.List;

public class Record {
    private Object records;
    private Integer total;

    public Record(Object records, Integer total) {
        this.records = records;
        this.total = total;
    }

    public Object getRecords() {
        return records;
    }

    public void setRecords(List<Object> records) {
        this.records = records;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
