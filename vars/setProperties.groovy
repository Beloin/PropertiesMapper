void call(Map m, path) {
  Set<Object> keys = m.keySet()
  String data = ""
  for (Object k : keys) {
    String value = (String) m.get(k)
    data += "${k}" + "=" + value + "\n"
  }
  writeFile(file: path, text: data)
}
