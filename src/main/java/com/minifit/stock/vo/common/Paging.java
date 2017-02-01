package com.minifit.stock.vo.common;

import org.apache.commons.lang3.StringUtils;

public class Paging {
  private String method; // -- 호출 메소드명
  private String pageHtml; // -- 페이지 html
  private int startNum; // -- limit 시작번호
  private int pageSize; // -- 페이지당 보여지는 게시글 수
  private int endNum; // -- limit 끝번호
  private int firstPageNo; // -- 첫번째 페이지 번호
  private int startPrevPageNo; // -- 현재 페이지 기준 시작 이전 페이지
  private int prevPageNo; // -- 이전 페이지 번호
  private int startPageNo; // -- 현재 페이지 기준 시작 페이지
  private int pageNo; // -- 현재 페이지
  private int endPageNo; // -- 현재 페이지 기준 마지막 페이지
  private int nextPageNo; // -- 다음 페이지
  private int fianlNextPageNo; // -- 현재 페이지 기준 마지막 다음 페이지
  private int finalPageNo; // -- 마지막 페이지 번호
  private int pageCount; // -- 보여지는 페이지 수
  private int totalCount; // -- 총 게시글수

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getPageHtml() {
    return pageHtml;
  }

  public void setPageHtml(String pageHtml) {
    this.pageHtml = pageHtml;
  }

  public int getStartNum() {
    return startNum;
  }

  public void setStartNum(int startNum) {
    this.startNum = startNum;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getEndNum() {
    return endNum;
  }

  public void setEndNum(int endNum) {
    this.endNum = endNum;
  }

  public int getFirstPageNo() {
    return firstPageNo;
  }

  public void setFirstPageNo(int firstPageNo) {
    this.firstPageNo = firstPageNo;
  }

  public int getStartPrevPageNo() {
    return startPrevPageNo;
  }

  public void setStartPrevPageNo(int startPrevPageNo) {
    this.startPrevPageNo = startPrevPageNo;
  }

  public int getPrevPageNo() {
    return prevPageNo;
  }

  public void setPrevPageNo(int prevPageNo) {
    this.prevPageNo = prevPageNo;
  }

  public int getStartPageNo() {
    return startPageNo;
  }

  public void setStartPageNo(int startPageNo) {
    this.startPageNo = startPageNo;
  }

  public int getPageNo() {
    return pageNo;
  }

  public void setPageNo(int pageNo) {
    this.pageNo = pageNo;
  }

  public int getEndPageNo() {
    return endPageNo;
  }

  public void setEndPageNo(int endPageNo) {
    this.endPageNo = endPageNo;
  }

  public int getNextPageNo() {
    return nextPageNo;
  }

  public void setNextPageNo(int nextPageNo) {
    this.nextPageNo = nextPageNo;
  }

  public int getFianlNextPageNo() {
    return fianlNextPageNo;
  }

  public void setFianlNextPageNo(int fianlNextPageNo) {
    this.fianlNextPageNo = fianlNextPageNo;
  }

  public int getFinalPageNo() {
    return finalPageNo;
  }

  public void setFinalPageNo(int finalPageNo) {
    this.finalPageNo = finalPageNo;
  }

  public int getPageCount() {
    return pageCount;
  }

  public void setPageCount(int pageCount) {
    this.pageCount = pageCount;
  }

  public int getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
    makePaging();
    pageHtml();
  }

  private void makePaging() {

    // -- 전체 글수가 없을 경우
    if (totalCount == 0) {
      return;
    }

    // -- 기본값 설정
    if (StringUtils.isEmpty(method)) {
      this.method = "goPage";
    }

    if (pageNo <= 0) {
      this.pageNo = 1;
    }

    if (pageSize == 0) {
      this.pageSize = 10;
    }

    if (pageCount == 0) {
      this.pageCount = 10;
    }

    if (firstPageNo == 0) {
      this.firstPageNo = 1;
    }

    int finalPage = (totalCount + (pageSize - 1)) / pageSize;
    if (pageNo > finalPage) {
      this.pageNo = finalPage;
    }

    int startPage = ((pageNo - 1) / pageCount) * pageCount + 1;
    int endPage = startPage + pageCount - 1;
    if (endPage > finalPage) {
      endPage = finalPage;
    }

    if (pageNo == 1) {
      this.prevPageNo = 1;
    } else {
      this.prevPageNo = pageNo - 1;
    }

    if (pageNo == finalPage) {
      this.nextPageNo = finalPage;
    } else {
      this.nextPageNo = pageNo + 1;
    }

    this.startPageNo = startPage;
    this.endPageNo = endPage;
    this.finalPageNo = finalPage;
    // MYSQL
    // this.startNum = (pageNo - 1) * pageSize;
    // this.endNum = this.startNum + pageSize - 1;

    // Oracle
    this.startNum = (pageNo - 1) * pageSize + 1;
    this.endNum = this.startNum + pageSize - 1;

    if (startPage == 1) {
      this.startPrevPageNo = 1;
    } else {
      this.startPrevPageNo = startPage - 1;
    }

    if (endPage == finalPage) {
      this.fianlNextPageNo = endPage;
    } else {
      this.fianlNextPageNo = endPage + 1;
    }
  }

  private void pageHtml() {
    StringBuilder html = new StringBuilder();

    html.append("<span class=\"button\" onclick=\"" + method + "(" + prevPageNo + "); \"></span>");

    for (int i = startPageNo; i <= endPageNo; i++) {
      if (i == pageNo) {
        html.append("<span class=\"on\">" + i + "</span>");
      } else {
        html.append("<span onclick=\"" + method + "(" + i + ")\" style=\"cursor:pointer\">" + i + "</span>");
      }
    }

    html.append("<span class=\"button\" onclick=\"" + method + "(" + nextPageNo + "); \"></span>");

    this.pageHtml = html.toString();
  }
}
