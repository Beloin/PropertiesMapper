Map getProperties(path) {
  def exists = fileExists path

  if (!exists) {
    // Write file
    def data = ""
    writeFile(file: path, text: data)
  }

  // Read as Properties 
  properties = new Properties()
  File propertiesFile = new File(path)
  properties.load(propertiesFile.newDataInputStream())
  Set<Object> keys = properties.keySet();

  def m = [:]
  // This loads properties
  for(Object k : keys) {
    String key = (String) k;
    String value = (String) properties.getProperty(key)
    m[key] = value
  }
  return m
}


void setProperties(Map m, path) {
  Set<Object> keys = m.keySet()
  String data = ""
  for (Object k : keys) {
    String value = (String) m.get(k)
    data += "${k}" + "=" + value + "\n"
  }
  writeFile(file: path, text: data)
}
