package tech.wetech.flexmodel.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author cjbi
 */
class PatternMatchUtilsTest {

  @Test
  void testMatch() {
    Assertions.assertTrue(PatternMatchUtils.simpleMatch("/api/hello/**", "/api/hello/world"));
    Assertions.assertTrue(PatternMatchUtils.simpleMatch("/api/hello/**", "/api/hello/world/zhangsan"));
    Assertions.assertTrue(PatternMatchUtils.simpleMatch("/api/hello/*", "/api/hello/world"));
    Assertions.assertTrue(PatternMatchUtils.simpleMatch("/api/hello/*/lisi", "/api/hello/world/lisi"));
    Assertions.assertTrue(PatternMatchUtils.simpleMatch("/api/*.jpg", "/api/sys_icon.jpg"));
  }

}
