package com.lantoolblog.sample;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class StaticAnalysisTests {
  private static final String userId = "tester";

  @Disabled("Non-constant string as argument to 'info()' logging call")
  @Test
  void test01() {
    String userId = "tester";
    log.info("Processing user ID: " + userId); // 동적 문자열을 로그 메시지의 인자로 사용함
  }

  @DisplayName("Fewer arguments provided (1) than placeholders specified (2)")
  @Test
  void test02() {
    log.info("User {} logged in from {}", userId); // 인자가 누락됨
  }

  @DisplayName("Condition 'text != null' is always 'true'")
  @Test
  void test03() {
    String text = "hello";
    if (text != null) { // "항상 true입니다"
      System.out.println(text);
    }
  }
}
