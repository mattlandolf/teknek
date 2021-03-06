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
package io.teknek.feed;

import io.teknek.model.ITuple;

public abstract class FeedPartition {

  protected Feed feed;
  /**
   * This field uniquely identifies a partition of a feed. In could be critical
   * in cases where you wish client to re-bind to prospective feeds. 
   */
  private String partitionId;
  
  public FeedPartition(Feed feed, String partitionId){
    this.feed = feed;
    this.partitionId = partitionId;
  }
  
  public abstract void initialize();
  
  public abstract boolean next(ITuple t);
  
  public abstract void close();

  public String getPartitionId() {
    return partitionId;
  }
  
}