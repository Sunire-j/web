package com.team2.healthsns.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagingVO {
    private int nowPage = 1;
    private int onePageRecord = 10;
    private int totalRecord;
    private int totalPage;
    private int offsetPoint = (nowPage - 1) * onePageRecord;
    private int onePageCount = 5;
    private int startPage = 1;;
    private String searchKey;
    private String searchWord;
    private String category;
    private String postSort;

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
        offsetPoint = (nowPage - 1) * onePageRecord;
        startPage = (nowPage - 1) / onePageCount * onePageCount + 1;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
        this.setTotalPage((int) Math.ceil(totalRecord / (double) onePageRecord));
    }
}