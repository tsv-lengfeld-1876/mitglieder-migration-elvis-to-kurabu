package de.bimalo.migration.entity.kurabu;

import io.quarkus.runtime.util.StringUtil;
import org.apache.camel.dataformat.bindy.Format;

public final class BooleanConverter implements Format<Boolean> {

  private static final String NEIN = "nein";
  private static final String JA = "ja";

  @Override
  public String format(Boolean object) throws Exception {
    if (object != null && Boolean.TRUE.equals(object)) {
      return JA;
    } else {
      return NEIN;
    }
  }

  @Override
  public Boolean parse(String string) throws Exception {
    if (StringUtil.isNullOrEmpty(string)) {
      throw new IllegalArgumentException("No value provided that can be converted to Boolean.");
    }
    return Boolean.valueOf(string);
  }
}
