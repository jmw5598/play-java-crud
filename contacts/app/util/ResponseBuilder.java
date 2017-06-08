package util;

import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

// not really a builder
public class ResponseBuilder {
  public static JsonNode build(Object object, Boolean success) {
    Map<String, Object> payload = new HashMap<>();
    payload.put("payload", object);
    payload.put("success", success);
    return Json.toJson(payload);
  }
}
