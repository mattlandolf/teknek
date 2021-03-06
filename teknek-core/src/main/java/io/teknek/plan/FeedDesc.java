/*
Copyright 2013 Edward Capriolo, Matt Landolf, Lodwin Cueto

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package io.teknek.plan;

import java.util.Map;

public class FeedDesc {
  private String feedClass;
  @SuppressWarnings("rawtypes")
  private Map properties;
  
  public FeedDesc(){
    
  }

  public String getFeedClass() {
    return feedClass;
  }

  public void setFeedClass(String feedClass) {
    this.feedClass = feedClass;
  }

  public Map getProperties() {
    return properties;
  }

  public void setProperties(Map properties) {
    this.properties = properties;
  }
  
  public FeedDesc withFeedClass(String feedClass) {
    this.feedClass = feedClass;
    return this;
  }
  
  public FeedDesc withProperties(Map properties) {
    this.properties = properties;
    return this;
  }

  
}
