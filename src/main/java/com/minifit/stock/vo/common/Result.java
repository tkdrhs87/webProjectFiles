package com.minifit.stock.vo.common;

public class Result {

  private Boolean result; // -- 성공 : true, 실패 : false
  private String content; // -- 알람창 내용
  private Object value; // -- 결과값

  public Result() {}

  public Result(Boolean result) {
    this.result = result;
  }

  public Result(Boolean result, String content) {
    this(result);
    this.content = content;
  }

  public Result(Boolean result, String content, Object value) {
    this(result, content);
    this.value = value;
  }

  public Boolean getResult() {
    return result;
  }

  public void setResult(Boolean result) {
    this.result = result;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }
}
