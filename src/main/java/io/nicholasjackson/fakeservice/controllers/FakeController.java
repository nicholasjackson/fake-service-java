package io.nicholasjackson.fakeservice.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FakeController {

//  Response struct {
//	Name          string              `json:"name,omitempty"`
//	URI           string              `json:"uri,omitempty"` // Called URI by downstream
//	Type          string              `json:"type,omitempty"`
//	IPAddresses   []string            `json:"ip_addresses,omitempty"`
//	Path          []string            `json:"path,omitempty"` // Path received by upstream
//	StartTime     string              `json:"start_time,omitempty"`
//	EndTime       string              `json:"end_time,omitempty"`
//	Duration      string              `json:"duration,omitempty"`
//	Headers       map[string]string   `json:"headers,omitempty"`
//	Cookies       map[string]string   `json:"cookies,omitempty"`
//	Body          json.RawMessage     `json:"body,omitempty"`
//	UpstreamCalls map[string]Response `json:"upstream_calls,omitempty"`
//	Code          int                 `json:"code"`
//	Error         string              `json:"error,omitempty"`
//}

  @Autowired
  private Environment env;

  public class FakeResponse {
    private String name;
    private String uri;
    private int code;

    public String getName() {
      return this.name;
    }

    public String getURI() {
      return this.uri;
    }

    public int getCode() {
      return this.code;
    }

    public void setURI(String value){
      this.uri = value;
    }

    public void setName(String value) {
      this.name = value;
    }

    public void setCode(int value) {
      this.code = value;
    }
  }

  @RequestMapping(value = "/", produces = "application/json", method = RequestMethod.GET)
  @ResponseBody
  public FakeResponse handle(HttpServletRequest request) {
    FakeResponse fs = new FakeResponse();
    fs.setName(env.getProperty("NAME", "Fake Service"));
    fs.setURI(request.getRequestURI());
    fs.setCode(200);

    return fs;
  }
}
