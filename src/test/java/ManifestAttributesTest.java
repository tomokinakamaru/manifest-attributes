import static org.junit.jupiter.api.Assertions.assertThrows;

import com.github.tomokinakamaru.manifestattributes.ManifestAttributes;
import org.junit.jupiter.api.Test;

final class ManifestAttributesTest {

  @Test
  void success() {
    ManifestAttributes attrs = new ManifestAttributes(Test.class);
    assert attrs.get("Manifest-Version").equals("1.0");
  }

  @Test
  void fail() {
    assertThrows(RuntimeException.class, () -> new ManifestAttributes(ManifestAttributes.class));
  }
}
