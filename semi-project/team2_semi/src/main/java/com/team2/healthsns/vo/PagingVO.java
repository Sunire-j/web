package com.team2.healthsns.vo;

import lombok.ToString;

//페이지정보, 검색어
@ToString
public class PagingVO {
    private int nowPage = 1;//현재페이지
    private int onePageRecord = 5;//한번에 표시할 레코드

    private int totalRecord;//총 레코드 수
    private int totalPage;//총 페이지 수
    private int offsetPoint = (nowPage - 1) * onePageRecord;//레코드 선택 시 시작위치

    //페이지 넘버링
    private int onePageCount = 5; //페이징 버튼 최대 갯수
    private int startPage = 1; //페이징 버튼 시작 숫자

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    //검색어
    private String searchKey;
    private String searchWord;

    public int getOnePageCount() {
        return onePageCount;
    }

    public void setOnePageCount(int onePageCount) {
        this.onePageCount = onePageCount;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }



    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;

        //해당 페이지 위치 계산
        offsetPoint = (nowPage - 1) * onePageRecord;

        //시작페이지 : 현재페이지 번호 바뀌면
        startPage = (nowPage-1)/onePageCount*onePageCount+1;
    }

    public int getOnePageRecord() {
        return onePageRecord;
    }

    public void setOnePageRecord(int onePageRecord) {
        this.onePageRecord = onePageRecord;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;

        this.setTotalPage((int) Math.ceil(totalRecord / (double) onePageRecord));

        //총 페이지 수
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getOffsetPoint() {
        return offsetPoint;
    }

    public void setOffsetPoint(int offsetPoint) {
        this.offsetPoint = offsetPoint;
    }
}
