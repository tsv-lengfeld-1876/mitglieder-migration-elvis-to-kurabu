package de.bimalo.migration.entity;

import java.util.Objects;
import java.util.Optional;
import lombok.NonNull;

public final class MappingResult<S, T> {

  private S source;
  private T target;
  private Exception cause;

  public MappingResult(@NonNull S source) {
    this.source = source;
    this.target = null;
  }

  public S getSource() {
    return source;
  }

  public Exception getException() {
    return cause;
  }

  public void addException(Exception cause) {
    if (Objects.nonNull(cause)) {
      this.cause = cause;
    }
  }

  public void setTarget(@NonNull T target) {
    this.target = target;
  }

  public Optional<T> getTarget() {
    return Optional.of(target);
  }

  public boolean failed() {
    return cause != null;
  }
}
