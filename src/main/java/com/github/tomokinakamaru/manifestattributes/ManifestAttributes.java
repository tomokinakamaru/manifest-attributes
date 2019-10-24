package com.github.tomokinakamaru.manifestattributes;

import java.io.IOException;
import java.net.URL;
import java.util.jar.Manifest;

public final class ManifestAttributes {

  private final Class<?> clazz;

  private final Manifest manifest;

  public ManifestAttributes(Class<?> clazz) {
    this.clazz = clazz;
    this.manifest = getManifest();
  }

  public String get(String key) {
    return manifest.getMainAttributes().getValue(key);
  }

  private Manifest getManifest() {
    try {
      return new Manifest(new URL(getManifestPath()).openStream());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private String getManifestPath() {
    String classPath = getClassPath();
    return classPath.substring(0, classPath.lastIndexOf("!") + 1) + "/META-INF/MANIFEST.MF";
  }

  private String getClassPath() {
    return clazz.getResource(clazz.getSimpleName() + ".class").toString();
  }
}
